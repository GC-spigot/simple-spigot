package me.javadebug.simplespigot.text.json;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.stream.JsonWriter;
import lombok.SneakyThrows;
import org.bukkit.ChatColor;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;


public class MessagePart implements JsonRepresentedObject, ConfigurationSerializable, Cloneable {

    static {
        ConfigurationSerialization.registerClass(MessagePart.class);
        ImmutableBiMap.Builder<ChatColor, String> builder = ImmutableBiMap.builder();
        for (ChatColor style : ChatColor.values()) {
            if (style.isFormat()) {
                Consumer<String> enterStyle = name -> builder.put(style, name);
                switch (style) {
                    case MAGIC:
                        enterStyle.accept("obfuscated");
                        break;
                    case UNDERLINE:
                        enterStyle.accept("underlined");
                        break;
                    default:
                        enterStyle.accept(style.name().toLowerCase());
                        break;
                }
            }
        }
        stylesToNames = builder.build();
    }

    private ChatColor color;
    private String insertionData;
    private List<ChatColor> styles;
    private String clickActionName;
    private String clickActionData;
    private String hoverActionName;
    private TextualComponent text;
    private JsonRepresentedObject hoverActionData;
    private List<JsonRepresentedObject> translationReplacements;

    static final BiMap<ChatColor, String> stylesToNames;

    MessagePart(TextualComponent text) {
        this.text = text;
        this.color = ChatColor.WHITE;
        this.styles = Lists.newArrayList();
        this.translationReplacements = Lists.newArrayList();
    }

    MessagePart() {
        this(null);
    }

    public ChatColor getColor() {
        return this.color;
    }

    public String getInsertionData() {
        return this.insertionData;
    }

    public List<ChatColor> getStyles() {
        return this.styles;
    }

    public String getClickActionName() {
        return this.clickActionName;
    }

    public String getClickActionData() {
        return this.clickActionData;
    }

    public String getHoverActionName() {
        return this.hoverActionName;
    }

    public TextualComponent getText() {
        return this.text;
    }

    public JsonRepresentedObject getHoverActionData() {
        return this.hoverActionData;
    }

    public List<JsonRepresentedObject> getTranslationReplacements() {
        return this.translationReplacements;
    }

    public boolean hasText() {
        return Objects.nonNull(this.text);
    }

    public void setColor(ChatColor color) {
        this.color = color;
    }

    public void setInsertionData(String insertionData) {
        this.insertionData = insertionData;
    }

    public void setStyles(List<ChatColor> styles) {
        this.styles = styles;
    }

    public void setClickActionName(String clickActionName) {
        this.clickActionName = clickActionName;
    }

    public void setClickActionData(String clickActionData) {
        this.clickActionData = clickActionData;
    }

    public void setHoverActionName(String hoverActionName) {
        this.hoverActionName = hoverActionName;
    }

    public void setText(TextualComponent text) {
        this.text = text;
    }

    public void setHoverActionData(JsonRepresentedObject hoverActionData) {
        this.hoverActionData = hoverActionData;
    }

    public void setTranslationReplacements(List<JsonRepresentedObject> translationReplacements) {
        this.translationReplacements = translationReplacements;
    }

    @Override
    public MessagePart clone() throws CloneNotSupportedException {
        MessagePart messagePart = (MessagePart) super.clone();
        messagePart.setStyles(Lists.newArrayList(this.styles));
        if (this.hoverActionData instanceof JsonString) {
            messagePart.setHoverActionData(new JsonString(((JsonString) this.hoverActionData).getValue()));
        } else if (this.hoverActionData instanceof JsonMessage) {
            messagePart.setHoverActionData(((JsonMessage) this.hoverActionData).clone());
        }
        messagePart.setTranslationReplacements(Lists.newArrayList(this.translationReplacements));
        return messagePart;

    }

    @SneakyThrows
    public void writeJson(JsonWriter json) {
        json.beginObject();
        this.text.writeJson(json);
        json.name("color").value(this.color.name().toLowerCase());
        for (ChatColor style : this.styles) {
            json.name(stylesToNames.get(style)).value(true);
        }
        if (this.clickActionName != null && this.clickActionData != null) {
            json.name("clickEvent")
                    .beginObject()
                    .name("action").value(this.clickActionName)
                    .name("value").value(this.clickActionData)
                    .endObject();
        }
        if (this.hoverActionName != null && this.hoverActionData != null) {
            json.name("hoverEvent")
                    .beginObject()
                    .name("action").value(this.hoverActionName)
                    .name("value");
            this.hoverActionData.writeJson(json);
            json.endObject();
        }
        if (this.insertionData != null) {
            json.name("insertion").value(this.insertionData);
        }
        if (this.translationReplacements.size() > 0 && TextualComponent.isTranslatableText(this.text)) {
            json.name("with").beginArray();
            for (JsonRepresentedObject obj : this.translationReplacements) {
                obj.writeJson(json);
            }
            json.endArray();
        }
        json.endObject();
    }

    public Map<String, Object> serialize() {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("text", this.text);
        map.put("styles", this.styles);
        map.put("color", this.color.getChar());
        map.put("hoverActionName", this.hoverActionName);
        map.put("hoverActionData", this.hoverActionData);
        map.put("clickActionName", this.clickActionName);
        map.put("clickActionData", this.clickActionData);
        map.put("insertion", this.insertionData);
        map.put("translationReplacements", this.translationReplacements);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static MessagePart deserialize(Map<String, Object> serialized) {
        MessagePart part = new MessagePart((TextualComponent) serialized.get("text"));
        part.setStyles((List<ChatColor>) serialized.get("styles"));
        part.setColor(ChatColor.getByChar(serialized.get("color").toString()));
        part.setHoverActionName((String) serialized.get("hoverActionName"));
        part.setHoverActionData((JsonRepresentedObject) serialized.get("hoverActionData"));
        part.setClickActionName((String) serialized.get("clickActionName"));
        part.setClickActionData((String) serialized.get("clickActionData"));
        part.setInsertionData((String) serialized.get("insertion"));
        part.setTranslationReplacements((List<JsonRepresentedObject>) serialized.get("translationReplacements"));
        return part;
    }
}