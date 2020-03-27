package me.hyfe.simplespigot.text.json;

import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.logging.Level;

import static me.hyfe.simplespigot.text.json.TextualComponent.rawText;

public class JsonMessage implements JsonRepresentedObject, Cloneable, Iterable<MessagePart>, ConfigurationSerializable {

    private static JsonParser _stringParser = new JsonParser();

    static {
        ConfigurationSerialization.registerClass(JsonMessage.class);
    }

    private List<MessagePart> messageParts;
    private String jsonString;
    private boolean dirty;

    public JsonMessage(String firstPartText) {
        this(rawText(firstPartText));
    }

    public JsonMessage(TextualComponent firstPartText) {
        messageParts = new ArrayList<MessagePart>();
        messageParts.add(new MessagePart(firstPartText));
        jsonString = null;
        dirty = false;
    }

    public JsonMessage() {
        this((TextualComponent) null);
    }

    @SuppressWarnings("unchecked")
    public static JsonMessage deserialize(Map<String, Object> serialized) {
        JsonMessage msg = new JsonMessage();
        msg.messageParts = (List<MessagePart>) serialized.get("messageParts");
        msg.jsonString = serialized.containsKey("JSON") ? serialized.get("JSON").toString() : null;
        msg.dirty = !serialized.containsKey("JSON");
        return msg;
    }

    public static JsonMessage deserialize(String json) {
        JsonObject serialized = _stringParser.parse(json).getAsJsonObject();
        JsonArray extra = serialized.getAsJsonArray("extra"); // Get the extra component
        JsonMessage returnVal = new JsonMessage();
        returnVal.messageParts.clear();
        for (JsonElement mPrt : extra) {
            MessagePart component = new MessagePart();
            JsonObject messagePart = mPrt.getAsJsonObject();
            for (Map.Entry<String, JsonElement> entry : messagePart.entrySet()) {
                if (TextualComponent.isTextKey(entry.getKey())) {
                    Map<String, Object> serializedMapForm = Maps.newHashMap();
                    serializedMapForm.put("key", entry.getKey());
                    if (entry.getValue().isJsonPrimitive()) {
                        serializedMapForm.put("value", entry.getValue().getAsString());
                    } else {
                        for (Map.Entry<String, JsonElement> compositeNestedElement : entry.getValue().getAsJsonObject().entrySet()) {
                            serializedMapForm.put("value." + compositeNestedElement.getKey(), compositeNestedElement.getValue().getAsString());
                        }
                    }
                    component.setText(TextualComponent.deserialize(serializedMapForm));
                } else if (MessagePart.stylesToNames.inverse().containsKey(entry.getKey())) {
                    if (entry.getValue().getAsBoolean()) {
                        component.getStyles().add(MessagePart.stylesToNames.inverse().get(entry.getKey()));
                    }
                } else if (entry.getKey().equals("color")) {
                    component.setColor(ChatColor.valueOf(entry.getValue().getAsString().toUpperCase()));
                } else if (entry.getKey().equals("clickEvent")) {
                    JsonObject object = entry.getValue().getAsJsonObject();
                    component.setClickActionName(object.get("action").getAsString());
                    component.setClickActionData(object.get("value").getAsString());
                } else if (entry.getKey().equals("hoverEvent")) {
                    JsonObject object = entry.getValue().getAsJsonObject();
                    component.setHoverActionName(object.get("action").getAsString());
                    if (object.get("value").isJsonPrimitive()) {
                        component.setHoverActionData(new JsonString(object.get("value").getAsString()));
                    } else {
                        component.setHoverActionData(deserialize(object.get("value").toString()));
                    }
                } else if (entry.getKey().equals("insertion")) {
                    component.setInsertionData(entry.getValue().getAsString());
                } else if (entry.getKey().equals("with")) {
                    for (JsonElement object : entry.getValue().getAsJsonArray()) {
                        if (object.isJsonPrimitive()) {
                            component.getTranslationReplacements().add(new JsonString(object.getAsString()));
                        } else {
                            component.getTranslationReplacements().add(deserialize(object.toString()));
                        }
                    }
                }
            }
            returnVal.messageParts.add(component);
        }
        return returnVal;
    }

    @Override
    public JsonMessage clone() throws CloneNotSupportedException {
        JsonMessage instance = (JsonMessage) super.clone();
        instance.messageParts = new ArrayList<>(messageParts.size());
        for (int i = 0; i < messageParts.size(); i++) {
            instance.messageParts.add(i, messageParts.get(i).clone());
        }
        instance.dirty = false;
        instance.jsonString = null;
        return instance;
    }

    public JsonMessage text(String text) {
        MessagePart latest = this.latest();
        latest.setText(rawText(text));
        this.dirty = true;
        return this;
    }

    public JsonMessage text(TextualComponent text) {
        MessagePart latest = latest();
        latest.setText(text);
        this.dirty = true;
        return this;
    }

    public JsonMessage color(ChatColor color) {
        this.latest().setColor(color);
        this.dirty = true;
        return this;
    }

    public JsonMessage style(ChatColor... styles) {
        for (ChatColor style : styles) {
            if (!style.isFormat()) {
                throw new IllegalArgumentException(style.name() + " is not a style");
            }
        }
        this.latest().getStyles().addAll(Arrays.asList(styles));
        this.dirty = true;
        return this;
    }

    public JsonMessage file(String path) {
        onClick("open_file", path);
        return this;
    }

    public JsonMessage link(String url) {
        onClick("open_url", url);
        return this;
    }

    public JsonMessage suggest(String command) {
        this.onClick("suggest_command", command);
        return this;
    }

    public JsonMessage insert(String command) {
        this.latest().setInsertionData(command);
        dirty = true;
        return this;
    }

    public JsonMessage command(String command) {
        onClick("run_command", command);
        return this;
    }

    public JsonMessage achievementTooltip(String name) {
        onHover("show_achievement", new JsonString("achievement." + name));
        return this;
    }

    public JsonMessage tooltip(String text) {
        onHover("show_text", new JsonString(text));
        return this;
    }

    public JsonMessage tooltip(final Iterable<String> lines) {
        tooltip(ArrayWrapper.toArray(lines, String.class));
        return this;
    }

    public JsonMessage tooltip(String... lines) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            builder.append(lines[i]);
            if (i != lines.length - 1) {
                builder.append('\n');
            }
        }
        tooltip(builder.toString());
        return this;
    }

    public JsonMessage formattedTooltip(JsonMessage text) {
        for (MessagePart component : text.messageParts) {
            if (component.getClickActionData() != null && component.getClickActionName() != null) {
                throw new IllegalArgumentException("The tooltip text cannot have click data.");
            } else if (component.getHoverActionData() != null && component.getHoverActionName() != null) {
                throw new IllegalArgumentException("The tooltip text cannot have a tooltip.");
            }
        }
        onHover("show_text", text);
        return this;
    }

    public JsonMessage formattedTooltip(JsonMessage... lines) {
        if (lines.length < 1) {
            onHover(null, null);
            return this;
        }
        JsonMessage result = new JsonMessage();
        result.messageParts.clear();
        for (int i = 0; i < lines.length; i++) {
            try {
                for (MessagePart component : lines[i]) {
                    if (component.getClickActionData() != null && component.getClickActionName() != null) {
                        throw new IllegalArgumentException("The tooltip text cannot have click data.");
                    } else if (component.getHoverActionData() != null && component.getHoverActionName() != null) {
                        throw new IllegalArgumentException("The tooltip text cannot have a tooltip.");
                    }
                    if (component.hasText()) {
                        result.messageParts.add(component.clone());
                    }
                }
                if (i != lines.length - 1) {
                    result.messageParts.add(new MessagePart(rawText("\n")));
                }
            } catch (CloneNotSupportedException e) {
                Bukkit.getLogger().log(Level.WARNING, "Failed to clone object", e);
                return this;
            }
        }
        return formattedTooltip(result.messageParts.isEmpty() ? null : result); // Throws NPE if size is 0, intended
    }

    public JsonMessage formattedTooltip(final Iterable<JsonMessage> lines) {
        return formattedTooltip(ArrayWrapper.toArray(lines, JsonMessage.class));
    }

    public JsonMessage translationReplacements(String... replacements) {
        for (String str : replacements) {
            this.latest().getTranslationReplacements().add(new JsonString(str));
        }
        dirty = true;

        return this;
    }

    public JsonMessage translationReplacements(final JsonMessage... replacements) {
        for (JsonMessage str : replacements) {
            this.latest().getTranslationReplacements().add(str);
        }
        dirty = true;
        return this;
    }

    public JsonMessage translationReplacements(final Iterable<JsonMessage> replacements) {
        return translationReplacements(ArrayWrapper.toArray(replacements, JsonMessage.class));
    }

    public JsonMessage then(String text) {
        return then(rawText(text));
    }

    public JsonMessage then(final TextualComponent text) {
        if (!latest().hasText()) {
            throw new IllegalStateException("previous message part has no text");
        }
        messageParts.add(new MessagePart(text));
        dirty = true;
        return this;
    }

    public JsonMessage then() {
        if (!latest().hasText()) {
            throw new IllegalStateException("previous message part has no text");
        }
        messageParts.add(new MessagePart());
        dirty = true;
        return this;
    }

    @Override
    public void writeJson(JsonWriter writer) throws IOException {
        if (messageParts.size() == 1) {
            latest().writeJson(writer);
        } else {
            writer.beginObject().name("text").value("").name("extra").beginArray();
            for (final MessagePart part : this) {
                part.writeJson(writer);
            }
            writer.endArray().endObject();
        }
    }

    public String toJSONString() {
        if (!dirty && jsonString != null) {
            return jsonString;
        }
        StringWriter string = new StringWriter();
        JsonWriter json = new JsonWriter(string);
        try {
            writeJson(json);
            json.close();
        } catch (IOException e) {
            throw new RuntimeException("invalid message");
        }
        jsonString = string.toString();
        dirty = false;
        return jsonString;
    }

    public void send(Player player) {
        send(player, toJSONString());
    }

    private void send(CommandSender sender, String jsonString) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(toOldMessageFormat());
            return;
        }
        Player player = (Player) sender;
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tellraw " + player.getName() + " " + jsonString);
    }

    public void send(CommandSender sender) {
        send(sender, toJSONString());
    }

    public void send(final Iterable<? extends CommandSender> senders) {
        String string = toJSONString();
        for (final CommandSender sender : senders) {
            send(sender, string);
        }
    }

    public String toOldMessageFormat() {
        StringBuilder result = new StringBuilder();
        for (MessagePart part : this) {
            result.append(part.getColor() == null ? "" : part.getColor());
            for (ChatColor formatSpecifier : part.getStyles()) {
                result.append(formatSpecifier);
            }
            result.append(part.getText());
        }
        return result.toString();
    }

    private MessagePart latest() {
        return messageParts.get(messageParts.size() - 1);
    }

    private void onClick(String name, String data) {
        final MessagePart latest = latest();
        latest.setClickActionName(name);
        latest.setClickActionData(data);
        dirty = true;
    }

    private void onHover(String name, final JsonRepresentedObject data) {
        final MessagePart latest = latest();
        latest.setHoverActionName(name);
        latest.setHoverActionData(data);
        dirty = true;
    }

    public Map<String, Object> serialize() {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("messageParts", messageParts);
        return map;
    }

    public Iterator<MessagePart> iterator() {
        return messageParts.iterator();
    }

}