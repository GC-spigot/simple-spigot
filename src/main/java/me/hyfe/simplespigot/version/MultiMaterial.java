package me.hyfe.simplespigot.version;

import com.google.common.collect.Sets;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public enum MultiMaterial {

    ACACIA_BOAT(Entry.of("BOAT_ACACIA")),
    ACACIA_BUTTON(Entry.of("WOOD_BUTTON")),
    ACACIA_DOOR(),
    ACACIA_FENCE(),
    ACACIA_FENCE_GATE(),
    ACACIA_LEAVES(Entry.of("LEAVES_2")),
    ACACIA_LOG(Entry.of("LOG_2")),
    ACACIA_PLANKS(Entry.of("WOOD", 4)),
    ACACIA_PRESSURE_PLATE(Entry.of("WOOD_PLATE")),
    ACACIA_SAPLING(Entry.of("SAPLING", 4)),
    ACACIA_SIGN(Entry.of("SIGN")),
    ACACIA_SLAB(Entry.of("WOOD_STEP", 4)),
    ACACIA_STAIRS(),
    ACACIA_TRAPDOOR(Entry.of("TRAP_DOOR")),
    ACACIA_WALL_SIGN(Entry.of("WALL_SIGN")),
    ACACIA_WOOD(Entry.of("LOG_2")),
    ACTIVATOR_RAIL(),
    AIR(),
    ALLIUM(),
    ANCIENT_DEBRIS(),
    ANDESITE(Entry.of("STONE", 5)),
    ANDESITE_SLAB(Entry.of("STONE")),
    ANDESITE_STAIRS(Entry.of("STONE")),
    ANDESITE_WALL(Entry.of("COBBLESTONE_WALL"), Entry.of("COBBLE_WALL")),
    ANVIL(),
    APPLE(),
    ARMOR_STAND(),
    ARROW(),
    ATTACHED_MELON_STEM(Entry.of("MELON_STEM", 7)),
    ATTACHED_PUMPKIN_STEM(Entry.of("PUMPKIN_STEM", 7)),
    AZURE_BLUET(Entry.of("RED_ROSE", 3)),
    BAKED_POTATO(),
    BAMBOO(),
    BAMBOO_SAPLING(),
    BARREL(),
    BARRIER(),
    BASALT(),
    BAT_SPAWN_EGG(Entry.of("MONSTER_EGG", 65)),
    BEACON(),
    BEDROCK(),
    BEEF(Entry.of("RAW_BEEF")),
    BEEHIVE(),
    BEETROOT(),
    BEETROOTS(),
    BEETROOT_SEEDS(),
    BEETROOT_SOUP(),
    BEE_NEST(),
    BEE_SPAWN_EGG(),
    BELL(),
    BIRCH_BOAT(),
    BIRCH_BUTTON(Entry.of("WOOD_BUTTON")),
    BIRCH_DOOR(),
    BIRCH_FENCE(),
    BIRCH_FENCE_GATE(),
    BIRCH_LEAVES(Entry.of("LEAVES", 2)),
    BIRCH_LOG(Entry.of("LOG", 2)),
    BIRCH_PLANKS(Entry.of("WOOD", 2)),
    BIRCH_PRESSURE_PLATE(Entry.of("WOOD_PLATE")),
    BIRCH_SAPLING(Entry.of("SAPLING", 2)),
    BIRCH_SIGN(Entry.of("SIGN")),
    BIRCH_SLAB(Entry.of("WOOD_STEP", 2)),
    BIRCH_STAIRS(Entry.of("BIRCH_WOOD_STAIRS")),
    BIRCH_TRAPDOOR(Entry.of("TRAP_DOOR")),
    BIRCH_WALL_SIGN(Entry.of("WALL_SIGN")),
    BIRCH_WOOD(Entry.of("WOOD", 2)),
    BLACKSTONE(),
    BLACKSTONE_SLAB(),
    BLACKSTONE_STAIRS(),
    BLACKSTONE_WALL(),
    BLACK_BANNER(Entry.of("BANNER")),
    BLACK_BED(Entry.of("BED")),
    BLACK_CARPET(Entry.of("CARPET", 15)),
    BLACK_CONCRETE(Entry.of("CONCRETE", 15)),
    BLACK_CONCRETE_POWDER(),
    BLACK_DYE(Entry.of("INK_SACK")),
    BLACK_GLAZED_TERRACOTTA(),
    BLACK_SHULKER_BOX(),
    BLACK_STAINED_GLASS(Entry.of("STAINED_GLASS", 15)),
    BLACK_STAINED_GLASS_PANE(Entry.of("STAINED_GLASS_PANE", 15)),
    BLACK_TERRACOTTA(Entry.of("STAINED_CLAY", 15)),
    BLACK_WALL_BANNER(Entry.of("WALL_BANNER")),
    BLACK_WOOL(Entry.of("WOOL", 15)),
    BLAST_FURNACE(Entry.of("FURNACE")),
    BLAZE_POWDER(),
    BLAZE_ROD(),
    BLAZE_SPAWN_EGG(Entry.of("MONSTER_EGG", 61)),
    BLUE_BANNER(Entry.of("BANNER", 11)),
    BLUE_BED(Entry.of("BED")),
    BLUE_CARPET(Entry.of("CARPET", 11)),
    BLUE_CONCRETE(Entry.of("CONCRETE", 11)),
    BLUE_CONCRETE_POWDER(Entry.of("CONCRETE_POWDER", 11)),
    BLUE_DYE(),
    BLUE_GLAZED_TERRACOTTA(),
    BLUE_ICE(Entry.of("PACKED_ICE")),
    BLUE_ORCHID(Entry.of("RED_ROSE", 1)),
    BLUE_SHULKER_BOX(),
    BLUE_STAINED_GLASS(Entry.of("STAINED_GLASS", 11)),
    BLUE_STAINED_GLASS_PANE(Entry.of("STAINED_GLASS_PANE", 3)),
    BLUE_TERRACOTTA(Entry.of("STAINED_CLAY", 11)),
    BLUE_WALL_BANNER(Entry.of("WALL_BANNER", 11)),
    BLUE_WOOL(Entry.of("WOOL", 11)),
    BONE(),
    BONE_BLOCK(),
    BONE_MEAL(Entry.of("INK_SACK", 15)),
    BOOK(),
    BOOKSHELF(),
    BOW(),
    BOWL(),
    BRAIN_CORAL(),
    BRAIN_CORAL_BLOCK(),
    BRAIN_CORAL_FAN(),
    BRAIN_CORAL_WALL_FAN(),
    BREAD(),
    BREWING_STAND(),
    BRICK(Entry.of("CLAY_BRICK")),
    BRICKS(Entry.of("BRICK")),
    BRICK_SLAB(Entry.of("STEP", 4, 12)),
    BRICK_STAIRS(Entry.of("BRICK_STAIRS", 0, 1, 2, 3)),
    BRICK_WALL(), // TODO: Confused about this, you said it used to be cobble wall, but cobblestone wall still exists?
    BROWN_BANNER(Entry.of("BANNER", 3)),
    BROWN_BED(Entry.of("BED")),
    BROWN_CARPET(Entry.of("CARPET", 12)),
    BROWN_CONCRETE(),
    BROWN_CONCRETE_POWDER(),
    BROWN_DYE(Entry.of("INK_SACK", 3)),
    BROWN_GLAZED_TERRACOTTA(),
    BROWN_MUSHROOM(),
    BROWN_MUSHROOM_BLOCK(Entry.of("HUGE_MUSHROOM_1", 0, 14)),
    BROWN_SHULKER_BOX(),
    BROWN_STAINED_GLASS(Entry.of("STAINED_GLASS", 12)),
    BROWN_STAINED_GLASS_PANE(Entry.of("STAINED_GLASS_PANE", 12)),
    BROWN_TERRACOTTA(Entry.of("STAINED_CLAY", 12)),
    BROWN_WALL_BANNER(Entry.of("WALL_BANNER", 3)),
    BROWN_WOOL(Entry.of("WOOL", 12)),
    BUBBLE_COLUMN(),
    BUBBLE_CORAL(),
    BUBBLE_CORAL_BLOCK(),
    BUBBLE_CORAL_FAN(),
    BUBBLE_CORAL_WALL_FAN(),
    BUCKET(),
    CACTUS(),
    CAKE(Entry.of("CAKE"), Entry.of("CAKE_BLOCK")), // TODO: Wasn't sure, but I did this coz it's both.
    CAMPFIRE(),
    CARROT(Entry.of("CARROT", 0, 1, 2, 3, 4, 5, 6, 7)),
    CARROTS(Entry.of("CARROT_ITEM")),
    CARROT_ON_A_STICK(Entry.of("CARROT_STICK")),
    CARTOGRAPHY_TABLE(),
    CARVED_PUMPKIN(Entry.of("PUMPKIN", 0, 1, 2, 3)),
    CAT_SPAWN_EGG(), // TODO: Was in old multi material, but cat spawn eggs don't exist pre 1.13?
    CAULDRON(Entry.of("CAULDRON"), Entry.of("CAULDRON_ITEM")),
    CAVE_AIR(), // TODO: Was in old multi material, but cat spawn eggs don't exist pre 1.13?
    CAVE_SPIDER_SPAWN_EGG(Entry.of("MONSTER_EGG", 59)),
    CHAIN(),
    CHAINMAIL_BOOTS(),
    CHAINMAIL_CHESTPLATE(),
    CHAINMAIL_HELMET(),
    CHAINMAIL_LEGGINGS(),
    CHAIN_COMMAND_BLOCK(),
    CHARCOAL(),
    CHEST(),
    CHEST_MINECART(Entry.of("STORAGE_MINECART")),
    CHICKEN(),
    CHICKEN_SPAWN_EGG(Entry.of("MONSTER_EGG", 93)),
    CHIPPED_ANVIL(),
    CHISELED_NETHER_BRICKS(),
    CHISELED_POLISHED_BLACKSTONE(),
    CHISELED_QUARTZ_BLOCK(),
    CHISELED_RED_SANDSTONE(),
    CHISELED_SANDSTONE(),
    CHISELED_STONE_BRICKS(),
    CHORUS_FLOWER(),
    CHORUS_FRUIT(),
    CHORUS_PLANT(),
    CLAY(),
    CLAY_BALL(),
    CLOCK(Entry.of("WATCH")),
    COAL(),
    COAL_BLOCK(),
    COAL_ORE(),
    COARSE_DIRT(),
    COBBLESTONE(),
    COBBLESTONE_SLAB(),
    COBBLESTONE_STAIRS(),
    COBBLESTONE_WALL(),
    COBWEB(),
    COCOA(),
    COCOA_BEANS(),
    COD(),
    COD_BUCKET(),
    COD_SPAWN_EGG(),
    COMMAND_BLOCK(),
    COMMAND_BLOCK_MINECART,
    COMPARATOR(),
    COMPASS(),
    COMPOSTER(),
    CONDUIT(),
    COOKED_BEEF(),
    COOKED_CHICKEN(),
    COOKED_COD(),
    COOKED_MUTTON(),
    COOKED_PORKCHOP(),
    COOKED_RABBIT(),
    COOKED_SALMON(),
    COOKIE(),
    CORNFLOWER(),
    COW_SPAWN_EGG(Entry.of("MONSTER_EGG", 92)),
    CRACKED_NETHER_BRICKS(),
    CRACKED_POLISHED_BLACKSTONE_BRICKS(),
    CRACKED_STONE_BRICKS(),
    CRAFTING_TABLE(),
    CREEPER_BANNER_PATTERN(),
    CREEPER_HEAD(),
    CREEPER_SPAWN_EGG(Entry.of("MONSTER_EGG", 50)),
    CREEPER_WALL_HEAD(),
    CRIMSON_BUTTON(),
    CRIMSON_DOOR(),
    CRIMSON_FENCE(),
    CRIMSON_FENCE_GATE(),
    CRIMSON_FUNGUS(),
    CRIMSON_HYPHAE(),
    CRIMSON_NYLIUM(),
    CRIMSON_PLANKS(),
    CRIMSON_PRESSURE_PLATE(),
    CRIMSON_ROOTS(),
    CRIMSON_SIGN(),
    CRIMSON_SLAB(),
    CRIMSON_STAIRS(),
    CRIMSON_STEM(),
    CRIMSON_TRAPDOOR(),
    CRIMSON_WALL_SIGN(),
    CROSSBOW(),
    CRYING_OBSIDIAN(),
    CUT_RED_SANDSTONE(),
    CUT_RED_SANDSTONE_SLAB(),
    CUT_SANDSTONE(),
    CUT_SANDSTONE_SLAB(),
    CYAN_BANNER(),
    CYAN_BED(),
    CYAN_CARPET(),
    CYAN_CONCRETE(),
    CYAN_CONCRETE_POWDER(),
    CYAN_DYE(),
    CYAN_GLAZED_TERRACOTTA(),
    CYAN_SHULKER_BOX(),
    CYAN_STAINED_GLASS(),
    CYAN_STAINED_GLASS_PANE(),
    CYAN_TERRACOTTA(),
    CYAN_WALL_BANNER(),
    CYAN_WOOL(),
    DAMAGED_ANVIL(),
    DANDELION(),
    DARK_OAK_BOAT(),
    DARK_OAK_BUTTON(),
    DARK_OAK_DOOR(),
    DARK_OAK_FENCE(),
    DARK_OAK_FENCE_GATE(),
    DARK_OAK_LEAVES(),
    DARK_OAK_LOG(),
    DARK_OAK_PLANKS(),
    DARK_OAK_PRESSURE_PLATE(),
    DARK_OAK_SAPLING(),
    DARK_OAK_SIGN(),
    DARK_OAK_SLAB(),
    DARK_OAK_STAIRS(),
    DARK_OAK_TRAPDOOR(),
    DARK_OAK_WALL_SIGN(),
    DARK_OAK_WOOD(),
    DARK_PRISMARINE(),
    DARK_PRISMARINE_SLAB(),
    DARK_PRISMARINE_STAIRS(),
    DAYLIGHT_DETECTOR(),
    DEAD_BRAIN_CORAL(),
    DEAD_BRAIN_CORAL_BLOCK(),
    DEAD_BRAIN_CORAL_FAN(),
    DEAD_BRAIN_CORAL_WALL_FAN(),
    DEAD_BUBBLE_CORAL(),
    DEAD_BUBBLE_CORAL_BLOCK(),
    DEAD_BUBBLE_CORAL_FAN(),
    DEAD_BUBBLE_CORAL_WALL_FAN(),
    DEAD_BUSH(),
    DEAD_FIRE_CORAL(),
    DEAD_FIRE_CORAL_BLOCK(),
    DEAD_FIRE_CORAL_FAN(),
    DEAD_FIRE_CORAL_WALL_FAN(),
    DEAD_HORN_CORAL(),
    DEAD_HORN_CORAL_BLOCK(),
    DEAD_HORN_CORAL_FAN(),
    DEAD_HORN_CORAL_WALL_FAN(),
    DEAD_TUBE_CORAL(),
    DEAD_TUBE_CORAL_BLOCK(),
    DEAD_TUBE_CORAL_FAN(),
    DEAD_TUBE_CORAL_WALL_FAN(),
    DEBUG_STICK(),
    DETECTOR_RAIL(),
    DIAMOND(),
    DIAMOND_AXE(),
    DIAMOND_BLOCK(),
    DIAMOND_BOOTS(),
    DIAMOND_CHESTPLATE(),
    DIAMOND_HELMET(),
    DIAMOND_HOE(),
    DIAMOND_HORSE_ARMOR(),
    DIAMOND_LEGGINGS(),
    DIAMOND_ORE(),
    DIAMOND_PICKAXE(),
    DIAMOND_SHOVEL(),
    DIAMOND_SWORD(),
    DIORITE(),
    DIORITE_SLAB(),
    DIORITE_STAIRS(),
    DIORITE_WALL(),
    DIRT(),
    DISPENSER(),
    DOLPHIN_SPAWN_EGG(),
    DONKEY_SPAWN_EGG(),
    DRAGON_BREATH(),
    DRAGON_EGG(),
    DRAGON_HEAD(),
    DRAGON_WALL_HEAD(),
    DRIED_KELP(),
    DRIED_KELP_BLOCK(),
    DROPPER(),
    DROWNED_SPAWN_EGG(),
    EGG(),
    ELDER_GUARDIAN_SPAWN_EGG(),
    ELYTRA(),
    EMERALD(),
    EMERALD_BLOCK(),
    EMERALD_ORE(),
    ENCHANTED_BOOK(),
    ENCHANTED_GOLDEN_APPLE(),
    ENCHANTING_TABLE(),
    ENDERMAN_SPAWN_EGG(Entry.of("MONSTER_EGG", 58)),
    ENDERMITE_SPAWN_EGG(Entry.of("MONSTER_EGG", 67)),
    ENDER_CHEST(),
    ENDER_EYE(),
    ENDER_PEARL(),
    END_CRYSTAL(),
    END_GATEWAY(),
    END_PORTAL(),
    END_PORTAL_FRAME(),
    END_ROD(),
    END_STONE(),
    END_STONE_BRICKS(),
    END_STONE_BRICK_SLAB(),
    END_STONE_BRICK_STAIRS(),
    END_STONE_BRICK_WALL(),
    EVOKER_SPAWN_EGG(),
    EXPERIENCE_BOTTLE(Entry.of("EXP_BOTTLE")),
    FARMLAND(),
    FEATHER(),
    FERMENTED_SPIDER_EYE(),
    FERN(),
    FILLED_MAP(),
    FIRE(),
    FIREWORK_ROCKET(),
    FIREWORK_STAR(),
    FIRE_CHARGE(),
    FIRE_CORAL(),
    FIRE_CORAL_BLOCK(),
    FIRE_CORAL_FAN(),
    FIRE_CORAL_WALL_FAN(),
    FISHING_ROD(),
    FLETCHING_TABLE(),
    FLINT(),
    FLINT_AND_STEEL(),
    FLOWER_BANNER_PATTERN(),
    FLOWER_POT(),
    FOX_SPAWN_EGG(),
    FROSTED_ICE(),
    FURNACE(),
    FURNACE_MINECART(Entry.of("POWERED_MINECART")),
    GHAST_SPAWN_EGG(Entry.of("MONSTER_EGG", 56)),
    GHAST_TEAR(),
    GILDED_BLACKSTONE(),
    GLASS(),
    GLASS_BOTTLE(),
    GLASS_PANE(),
    GLISTERING_MELON_SLICE(),
    GLOBE_BANNER_PATTERN(),
    GLOWSTONE(),
    GLOWSTONE_DUST(),
    GOLDEN_APPLE(),
    GOLDEN_AXE(),
    GOLDEN_BOOTS(),
    GOLDEN_CARROT(),
    GOLDEN_CHESTPLATE(),
    GOLDEN_HELMET(),
    GOLDEN_HOE(),
    GOLDEN_HORSE_ARMOR(),
    GOLDEN_LEGGINGS(),
    GOLDEN_PICKAXE(),
    GOLDEN_SHOVEL(),
    GOLDEN_SWORD(),
    GOLD_BLOCK(),
    GOLD_INGOT(),
    GOLD_NUGGET(),
    GOLD_ORE(),
    GRANITE(),
    GRANITE_SLAB(),
    GRANITE_STAIRS(),
    GRANITE_WALL(),
    GRASS(),
    GRASS_BLOCK(),
    GRASS_PATH(),
    GRAVEL(),
    GRAY_BANNER(),
    GRAY_BED(),
    GRAY_CARPET(),
    GRAY_CONCRETE(),
    GRAY_CONCRETE_POWDER(),
    GRAY_DYE(),
    GRAY_GLAZED_TERRACOTTA(),
    GRAY_SHULKER_BOX(),
    GRAY_STAINED_GLASS(),
    GRAY_STAINED_GLASS_PANE(),
    GRAY_TERRACOTTA(),
    GRAY_WALL_BANNER(),
    GRAY_WOOL(),
    GREEN_BANNER(),
    GREEN_BED(),
    GREEN_CARPET(),
    GREEN_CONCRETE(),
    GREEN_CONCRETE_POWDER(),
    GREEN_DYE(),
    GREEN_GLAZED_TERRACOTTA(),
    GREEN_SHULKER_BOX(),
    GREEN_STAINED_GLASS(),
    GREEN_STAINED_GLASS_PANE(),
    GREEN_TERRACOTTA(),
    GREEN_WALL_BANNER(),
    GREEN_WOOL(),
    GRINDSTONE(),
    GUARDIAN_SPAWN_EGG(Entry.of("MONSTER_EGG", 68)),
    GUNPOWDER(),
    HAY_BLOCK(),
    HEART_OF_THE_SEA(),
    HEAVY_WEIGHTED_PRESSURE_PLATE(),
    HOGLIN_SPAWN_EGG(),
    HONEYCOMB(),
    HONEYCOMB_BLOCK(),
    HONEY_BLOCK(),
    HONEY_BOTTLE(),
    HOPPER(),
    HOPPER_MINECART(),
    HORN_CORAL(),
    HORN_CORAL_BLOCK(),
    HORN_CORAL_FAN(),
    HORN_CORAL_WALL_FAN(),
    HORSE_SPAWN_EGG(Entry.of("MONSTER_EGG", 100)),
    HUSK_SPAWN_EGG(),
    ICE(),
    INFESTED_CHISELED_STONE_BRICKS(),
    INFESTED_COBBLESTONE(),
    INFESTED_CRACKED_STONE_BRICKS(),
    INFESTED_MOSSY_STONE_BRICKS(),
    INFESTED_STONE(),
    INFESTED_STONE_BRICKS(),
    INK_SAC(),
    IRON_AXE(),
    IRON_BARS(),
    IRON_BLOCK(),
    IRON_BOOTS(),
    IRON_CHESTPLATE(),
    IRON_DOOR(),
    IRON_HELMET(),
    IRON_HOE(),
    IRON_HORSE_ARMOR(),
    IRON_INGOT(),
    IRON_LEGGINGS(),
    IRON_NUGGET(),
    IRON_ORE(),
    IRON_PICKAXE(),
    IRON_SHOVEL(),
    IRON_SWORD(),
    IRON_TRAPDOOR(),
    ITEM_FRAME(),
    JACK_O_LANTERN(),
    JIGSAW(),
    JUKEBOX(),
    JUNGLE_BOAT(),
    JUNGLE_BUTTON(),
    JUNGLE_DOOR(),
    JUNGLE_FENCE(),
    JUNGLE_FENCE_GATE(),
    JUNGLE_LEAVES(),
    JUNGLE_LOG(),
    JUNGLE_PLANKS(),
    JUNGLE_PRESSURE_PLATE(),
    JUNGLE_SAPLING(),
    JUNGLE_SIGN(),
    JUNGLE_SLAB(),
    JUNGLE_STAIRS(),
    JUNGLE_TRAPDOOR(),
    JUNGLE_WALL_SIGN(),
    JUNGLE_WOOD(),
    KELP(),
    KELP_PLANT(),
    KNOWLEDGE_BOOK(),
    LADDER(),
    LANTERN(),
    LAPIS_BLOCK(),
    LAPIS_LAZULI(),
    LAPIS_ORE(),
    LARGE_FERN(),
    LAVA(),
    LAVA_BUCKET(),
    LEAD(),
    LEATHER(),
    LEATHER_BOOTS(),
    LEATHER_CHESTPLATE(),
    LEATHER_HELMET(),
    LEATHER_HORSE_ARMOR(),
    LEATHER_LEGGINGS(),
    LECTERN(),
    LEVER(),
    LIGHT_BLUE_BANNER(),
    LIGHT_BLUE_BED(),
    LIGHT_BLUE_CARPET(),
    LIGHT_BLUE_CONCRETE(),
    LIGHT_BLUE_CONCRETE_POWDER(),
    LIGHT_BLUE_DYE(),
    LIGHT_BLUE_GLAZED_TERRACOTTA(),
    LIGHT_BLUE_SHULKER_BOX(),
    LIGHT_BLUE_STAINED_GLASS(),
    LIGHT_BLUE_STAINED_GLASS_PANE(),
    LIGHT_BLUE_TERRACOTTA(),
    LIGHT_BLUE_WALL_BANNER(),
    LIGHT_BLUE_WOOL(),
    LIGHT_GRAY_BANNER(),
    LIGHT_GRAY_BED(),
    LIGHT_GRAY_CARPET(),
    LIGHT_GRAY_CONCRETE(),
    LIGHT_GRAY_CONCRETE_POWDER(),
    LIGHT_GRAY_DYE(),
    LIGHT_GRAY_GLAZED_TERRACOTTA(),
    LIGHT_GRAY_SHULKER_BOX(),
    LIGHT_GRAY_STAINED_GLASS(),
    LIGHT_GRAY_STAINED_GLASS_PANE(),
    LIGHT_GRAY_TERRACOTTA(),
    LIGHT_GRAY_WALL_BANNER(),
    LIGHT_GRAY_WOOL(),
    LIGHT_WEIGHTED_PRESSURE_PLATE(),
    LILAC(),
    LILY_OF_THE_VALLEY(),
    LILY_PAD(),
    LIME_BANNER(),
    LIME_BED(),
    LIME_CARPET(),
    LIME_CONCRETE(),
    LIME_CONCRETE_POWDER(),
    LIME_DYE(),
    LIME_GLAZED_TERRACOTTA(),
    LIME_SHULKER_BOX(),
    LIME_STAINED_GLASS(),
    LIME_STAINED_GLASS_PANE(Entry.of("STAINED_GLASS_PANE", 5)),
    LIME_TERRACOTTA(),
    LIME_WALL_BANNER(),
    LIME_WOOL(),
    LINGERING_POTION(),
    LLAMA_SPAWN_EGG(),
    LODESTONE(),
    LOOM(),
    MAGENTA_BANNER(),
    MAGENTA_BED(),
    MAGENTA_CARPET(),
    MAGENTA_CONCRETE(),
    MAGENTA_CONCRETE_POWDER(),
    MAGENTA_DYE(),
    MAGENTA_GLAZED_TERRACOTTA(),
    MAGENTA_SHULKER_BOX(),
    MAGENTA_STAINED_GLASS(),
    MAGENTA_STAINED_GLASS_PANE(),
    MAGENTA_TERRACOTTA(),
    MAGENTA_WALL_BANNER(),
    MAGENTA_WOOL(),
    MAGMA_BLOCK(),
    MAGMA_CREAM(),
    MAGMA_CUBE_SPAWN_EGG(Entry.of("MONSTER_EGG", 62)),
    MAP(),
    MELON(),
    MELON_SEEDS(),
    MELON_SLICE(),
    MELON_STEM(),
    MILK_BUCKET(),
    MINECART(),
    MOJANG_BANNER_PATTERN(),
    MOOSHROOM_SPAWN_EGG(Entry.of("MONSTER_EGG", 96)),
    MOSSY_COBBLESTONE(),
    MOSSY_COBBLESTONE_SLAB(),
    MOSSY_COBBLESTONE_STAIRS(),
    MOSSY_COBBLESTONE_WALL(),
    MOSSY_STONE_BRICKS(),
    MOSSY_STONE_BRICK_SLAB(),
    MOSSY_STONE_BRICK_STAIRS(),
    MOSSY_STONE_BRICK_WALL(),
    MOVING_PISTON(),
    MULE_SPAWN_EGG(),
    MUSHROOM_STEM(),
    MUSHROOM_STEW(),
    MUSIC_DISC_11(),
    MUSIC_DISC_13(),
    MUSIC_DISC_BLOCKS(),
    MUSIC_DISC_CAT(),
    MUSIC_DISC_CHIRP(),
    MUSIC_DISC_FAR(),
    MUSIC_DISC_MALL(),
    MUSIC_DISC_MELLOHI(),
    MUSIC_DISC_PIGSTEP(),
    MUSIC_DISC_STAL(),
    MUSIC_DISC_STRAD(),
    MUSIC_DISC_WAIT(),
    MUSIC_DISC_WARD(),
    MUTTON(),
    MYCELIUM(),
    NAME_TAG(),
    NAUTILUS_SHELL(),
    NETHERITE_AXE(),
    NETHERITE_BLOCK(),
    NETHERITE_BOOTS(),
    NETHERITE_CHESTPLATE(),
    NETHERITE_HELMET(),
    NETHERITE_HOE(),
    NETHERITE_INGOT(),
    NETHERITE_LEGGINGS(),
    NETHERITE_PICKAXE(),
    NETHERITE_SCRAP(),
    NETHERITE_SHOVEL(),
    NETHERITE_SWORD(),
    NETHERRACK(),
    NETHER_BRICK(),
    NETHER_BRICKS(),
    NETHER_BRICK_FENCE(),
    NETHER_BRICK_SLAB(),
    NETHER_BRICK_STAIRS(),
    NETHER_BRICK_WALL(),
    NETHER_GOLD_ORE(),
    NETHER_PORTAL(),
    NETHER_QUARTZ_ORE(),
    NETHER_SPROUTS(),
    NETHER_STAR(),
    NETHER_WART(),
    NETHER_WART_BLOCK(),
    NOTE_BLOCK(),
    OAK_BOAT(),
    OAK_BUTTON(),
    OAK_DOOR(),
    OAK_FENCE(),
    OAK_FENCE_GATE(),
    OAK_LEAVES(),
    OAK_LOG(),
    OAK_PLANKS(),
    OAK_PRESSURE_PLATE(),
    OAK_SAPLING(),
    OAK_SIGN(),
    OAK_SLAB(),
    OAK_STAIRS(),
    OAK_TRAPDOOR(),
    OAK_WALL_SIGN(),
    OAK_WOOD(),
    OBSERVER(),
    OBSIDIAN(),
    OCELOT_SPAWN_EGG(Entry.of("MONSTER_EGG", 98)),
    ORANGE_BANNER(),
    ORANGE_BED(),
    ORANGE_CARPET(),
    ORANGE_CONCRETE(),
    ORANGE_CONCRETE_POWDER(),
    ORANGE_DYE(),
    ORANGE_GLAZED_TERRACOTTA(),
    ORANGE_SHULKER_BOX(),
    ORANGE_STAINED_GLASS(),
    ORANGE_STAINED_GLASS_PANE(),
    ORANGE_TERRACOTTA(),
    ORANGE_TULIP(),
    ORANGE_WALL_BANNER(),
    ORANGE_WOOL(),
    OXEYE_DAISY(),
    PACKED_ICE(),
    PAINTING(),
    PANDA_SPAWN_EGG(),
    PAPER(),
    PARROT_SPAWN_EGG(),
    PEONY(),
    PETRIFIED_OAK_SLAB(),
    PHANTOM_MEMBRANE(),
    PHANTOM_SPAWN_EGG(),
    PIGLIN_BANNER_PATTERN(),
    PIGLIN_SPAWN_EGG(Entry.of("MONSTER_EGG", 57)),
    PIG_SPAWN_EGG(Entry.of("MONSTER_EGG", 90)),
    PILLAGER_SPAWN_EGG(),
    PINK_BANNER(),
    PINK_BED(),
    PINK_CARPET(),
    PINK_CONCRETE(),
    PINK_CONCRETE_POWDER(),
    PINK_DYE(),
    PINK_GLAZED_TERRACOTTA(),
    PINK_SHULKER_BOX(),
    PINK_STAINED_GLASS(),
    PINK_STAINED_GLASS_PANE(),
    PINK_TERRACOTTA(),
    PINK_TULIP(),
    PINK_WALL_BANNER(),
    PINK_WOOL(),
    PISTON(),
    PISTON_HEAD(),
    PLAYER_HEAD(),
    PLAYER_WALL_HEAD(),
    PODZOL(),
    POISONOUS_POTATO(),
    POLAR_BEAR_SPAWN_EGG(),
    POLISHED_ANDESITE(),
    POLISHED_ANDESITE_SLAB(),
    POLISHED_ANDESITE_STAIRS(),
    POLISHED_BASALT(),
    POLISHED_BLACKSTONE(),
    POLISHED_BLACKSTONE_BRICKS(),
    POLISHED_BLACKSTONE_BRICK_SLAB(),
    POLISHED_BLACKSTONE_BRICK_STAIRS(),
    POLISHED_BLACKSTONE_BRICK_WALL(),
    POLISHED_BLACKSTONE_BUTTON(),
    POLISHED_BLACKSTONE_PRESSURE_PLATE(),
    POLISHED_BLACKSTONE_SLAB(),
    POLISHED_BLACKSTONE_STAIRS(),
    POLISHED_BLACKSTONE_WALL(),
    POLISHED_DIORITE(),
    POLISHED_DIORITE_SLAB(),
    POLISHED_DIORITE_STAIRS(),
    POLISHED_GRANITE(),
    POLISHED_GRANITE_SLAB(),
    POLISHED_GRANITE_STAIRS(),
    POPPED_CHORUS_FRUIT(),
    POPPY(),
    PORKCHOP(),
    POTATO(),
    POTATOES(),
    POTION(),
    POTTED_ACACIA_SAPLING(),
    POTTED_ALLIUM(),
    POTTED_AZURE_BLUET(),
    POTTED_BAMBOO(),
    POTTED_BIRCH_SAPLING(),
    POTTED_BLUE_ORCHID(),
    POTTED_BROWN_MUSHROOM(),
    POTTED_CACTUS(),
    POTTED_CORNFLOWER(),
    POTTED_CRIMSON_FUNGUS(),
    POTTED_CRIMSON_ROOTS(),
    POTTED_DANDELION(),
    POTTED_DARK_OAK_SAPLING(),
    POTTED_DEAD_BUSH(),
    POTTED_FERN(),
    POTTED_JUNGLE_SAPLING(),
    POTTED_LILY_OF_THE_VALLEY(),
    POTTED_OAK_SAPLING(),
    POTTED_ORANGE_TULIP(),
    POTTED_OXEYE_DAISY(),
    POTTED_PINK_TULIP(),
    POTTED_POPPY(),
    POTTED_RED_MUSHROOM(),
    POTTED_RED_TULIP(),
    POTTED_SPRUCE_SAPLING(),
    POTTED_WARPED_FUNGUS(),
    POTTED_WARPED_ROOTS(),
    POTTED_WHITE_TULIP(),
    POTTED_WITHER_ROSE(),
    POWERED_RAIL(),
    PRISMARINE(),
    PRISMARINE_BRICKS(),
    PRISMARINE_BRICK_SLAB(),
    PRISMARINE_BRICK_STAIRS(),
    PRISMARINE_CRYSTALS(),
    PRISMARINE_SHARD(),
    PRISMARINE_SLAB(),
    PRISMARINE_STAIRS(),
    PRISMARINE_WALL(),
    PUFFERFISH(),
    PUFFERFISH_BUCKET(),
    PUFFERFISH_SPAWN_EGG(),
    PUMPKIN(),
    PUMPKIN_PIE(),
    PUMPKIN_SEEDS(),
    PUMPKIN_STEM(),
    PURPLE_BANNER(),
    PURPLE_BED(),
    PURPLE_CARPET(),
    PURPLE_CONCRETE(),
    PURPLE_CONCRETE_POWDER(),
    PURPLE_DYE(),
    PURPLE_GLAZED_TERRACOTTA(),
    PURPLE_SHULKER_BOX(),
    PURPLE_STAINED_GLASS(),
    PURPLE_STAINED_GLASS_PANE(),
    PURPLE_TERRACOTTA(),
    PURPLE_WALL_BANNER(),
    PURPLE_WOOL(),
    PURPUR_BLOCK(),
    PURPUR_PILLAR(),
    PURPUR_SLAB(),
    PURPUR_STAIRS(),
    QUARTZ(),
    QUARTZ_BLOCK(),
    QUARTZ_BRICKS(),
    QUARTZ_PILLAR(),
    QUARTZ_SLAB(),
    QUARTZ_STAIRS(),
    RABBIT(),
    RABBIT_FOOT(),
    RABBIT_HIDE(),
    RABBIT_SPAWN_EGG(Entry.of("MONSTER_EGG", 101)),
    RABBIT_STEW(),
    RAIL(),
    RAVAGER_SPAWN_EGG(),
    REDSTONE(),
    REDSTONE_BLOCK(),
    REDSTONE_LAMP(),
    REDSTONE_ORE(),
    REDSTONE_TORCH(),
    REDSTONE_WALL_TORCH(),
    REDSTONE_WIRE(),
    RED_BANNER(),
    RED_BED(),
    RED_CARPET(),
    RED_CONCRETE(),
    RED_CONCRETE_POWDER(),
    RED_DYE(),
    RED_GLAZED_TERRACOTTA(),
    RED_MUSHROOM(),
    RED_MUSHROOM_BLOCK(),
    RED_NETHER_BRICKS(),
    RED_NETHER_BRICK_SLAB(),
    RED_NETHER_BRICK_STAIRS(),
    RED_NETHER_BRICK_WALL(),
    RED_SAND(),
    RED_SANDSTONE(),
    RED_SANDSTONE_SLAB(),
    RED_SANDSTONE_STAIRS(),
    RED_SANDSTONE_WALL(),
    RED_SHULKER_BOX(),
    RED_STAINED_GLASS(),
    RED_STAINED_GLASS_PANE(),
    RED_TERRACOTTA(),
    RED_TULIP(),
    RED_WALL_BANNER(),
    RED_WOOL(),
    REPEATER(),
    REPEATING_COMMAND_BLOCK(),
    RESPAWN_ANCHOR(),
    ROSE_BUSH(),
    ROTTEN_FLESH(),
    SADDLE(),
    SALMON(),
    SALMON_BUCKET(),
    SALMON_SPAWN_EGG(),
    SAND(),
    SANDSTONE(),
    SANDSTONE_SLAB(),
    SANDSTONE_STAIRS(),
    SANDSTONE_WALL(),
    SCAFFOLDING(),
    SCUTE(),
    SEAGRASS(),
    SEA_LANTERN(),
    SEA_PICKLE(),
    SHEARS(),
    SHEEP_SPAWN_EGG(Entry.of("MONSTER_EGG", 91)),
    SHIELD(),
    SHROOMLIGHT(),
    SHULKER_BOX(),
    SHULKER_SHELL(),
    SHULKER_SPAWN_EGG(),
    SILVERFISH_SPAWN_EGG(Entry.of("MONSTER_EGG", 60)),
    SKELETON_HORSE_SPAWN_EGG(),
    SKELETON_SKULL(),
    SKELETON_SPAWN_EGG(Entry.of("MONSTER_EGG", 51)),
    SKELETON_WALL_SKULL(),
    SKULL_BANNER_PATTERN(),
    SLIME_BALL(),
    SLIME_BLOCK(),
    SLIME_SPAWN_EGG(Entry.of("MONSTER_EGG", 55)),
    SMITHING_TABLE(),
    SMOKER(),
    SMOOTH_QUARTZ(),
    SMOOTH_QUARTZ_SLAB(),
    SMOOTH_QUARTZ_STAIRS(),
    SMOOTH_RED_SANDSTONE(),
    SMOOTH_RED_SANDSTONE_SLAB(),
    SMOOTH_RED_SANDSTONE_STAIRS(),
    SMOOTH_SANDSTONE(),
    SMOOTH_SANDSTONE_SLAB(),
    SMOOTH_SANDSTONE_STAIRS(),
    SMOOTH_STONE(),
    SMOOTH_STONE_SLAB(),
    SNOW(),
    SNOWBALL(),
    SNOW_BLOCK(),
    SOUL_CAMPFIRE(),
    SOUL_FIRE(),
    SOUL_LANTERN(),
    SOUL_SAND(),
    SOUL_SOIL(),
    SOUL_TORCH(),
    SOUL_WALL_TORCH(),
    SPAWNER(),
    SPECTRAL_ARROW(),
    SPIDER_EYE(),
    SPIDER_SPAWN_EGG(Entry.of("MONSTER_EGG", 52)),
    SPLASH_POTION(),
    SPONGE(),
    SPRUCE_BOAT(),
    SPRUCE_BUTTON(),
    SPRUCE_DOOR(),
    SPRUCE_FENCE(),
    SPRUCE_FENCE_GATE(),
    SPRUCE_LEAVES(),
    SPRUCE_LOG(),
    SPRUCE_PLANKS(),
    SPRUCE_PRESSURE_PLATE(),
    SPRUCE_SAPLING(),
    SPRUCE_SIGN(),
    SPRUCE_SLAB(),
    SPRUCE_STAIRS(),
    SPRUCE_TRAPDOOR(),
    SPRUCE_WALL_SIGN(),
    SPRUCE_WOOD(),
    SQUID_SPAWN_EGG(Entry.of("MONSTER_EGG", 94)),
    STICK(),
    STICKY_PISTON(),
    STONE(),
    STONECUTTER(),
    STONE_AXE(),
    STONE_BRICKS(),
    STONE_BRICK_SLAB(),
    STONE_BRICK_STAIRS(),
    STONE_BRICK_WALL(),
    STONE_BUTTON(),
    STONE_HOE(),
    STONE_PICKAXE(),
    STONE_PRESSURE_PLATE(),
    STONE_SHOVEL(),
    STONE_SLAB(),
    STONE_STAIRS(),
    STONE_SWORD(),
    STRAY_SPAWN_EGG(),
    STRIDER_SPAWN_EGG(),
    STRING(),
    STRIPPED_ACACIA_LOG(),
    STRIPPED_ACACIA_WOOD(),
    STRIPPED_BIRCH_LOG(),
    STRIPPED_BIRCH_WOOD(),
    STRIPPED_CRIMSON_HYPHAE(),
    STRIPPED_CRIMSON_STEM(),
    STRIPPED_DARK_OAK_LOG(),
    STRIPPED_DARK_OAK_WOOD(),
    STRIPPED_JUNGLE_LOG(),
    STRIPPED_JUNGLE_WOOD(),
    STRIPPED_OAK_LOG(),
    STRIPPED_OAK_WOOD(),
    STRIPPED_SPRUCE_LOG(),
    STRIPPED_SPRUCE_WOOD(),
    STRIPPED_WARPED_HYPHAE(),
    STRIPPED_WARPED_STEM(),
    STRUCTURE_BLOCK(),
    STRUCTURE_VOID(),
    SUGAR(),
    SUGAR_CANE(),
    SUNFLOWER(),
    SUSPICIOUS_STEW(),
    SWEET_BERRIES(),
    SWEET_BERRY_BUSH(),
    TALL_GRASS(),
    TALL_SEAGRASS(),
    TARGET(),
    TERRACOTTA(),
    TIPPED_ARROW(),
    TNT(),
    TNT_MINECART(),
    TORCH(),
    TOTEM_OF_UNDYING(),
    TRADER_LLAMA_SPAWN_EGG(),
    TRAPPED_CHEST(),
    TRIDENT(),
    TRIPWIRE(),
    TRIPWIRE_HOOK(),
    TROPICAL_FISH(),
    TROPICAL_FISH_BUCKET(),
    TROPICAL_FISH_SPAWN_EGG(),
    TUBE_CORAL(),
    TUBE_CORAL_BLOCK(),
    TUBE_CORAL_FAN(),
    TUBE_CORAL_WALL_FAN(),
    TURTLE_EGG(),
    TURTLE_HELMET(),
    TURTLE_SPAWN_EGG(),
    TWISTING_VINES(),
    TWISTING_VINES_PLANT(),
    VEX_SPAWN_EGG(),
    VILLAGER_SPAWN_EGG(Entry.of("MONSTER_EGG", 120)),
    VINDICATOR_SPAWN_EGG(),
    VINE(),
    VOID_AIR(),
    WALL_TORCH(),
    WANDERING_TRADER_SPAWN_EGG(),
    WARPED_BUTTON(),
    WARPED_DOOR(),
    WARPED_FENCE(),
    WARPED_FENCE_GATE(),
    WARPED_FUNGUS(),
    WARPED_FUNGUS_ON_A_STICK(),
    WARPED_HYPHAE(),
    WARPED_NYLIUM(),
    WARPED_PLANKS(),
    WARPED_PRESSURE_PLATE(),
    WARPED_ROOTS(),
    WARPED_SIGN(),
    WARPED_SLAB(),
    WARPED_STAIRS(),
    WARPED_STEM(),
    WARPED_TRAPDOOR(),
    WARPED_WALL_SIGN(),
    WARPED_WART_BLOCK(),
    WATER(),
    WATER_BUCKET(),
    WEEPING_VINES(),
    WEEPING_VINES_PLANT(),
    WET_SPONGE(),
    WHEAT(),
    WHEAT_SEEDS(),
    WHITE_BANNER(),
    WHITE_BED(),
    WHITE_CARPET(),
    WHITE_CONCRETE(),
    WHITE_CONCRETE_POWDER(),
    WHITE_DYE(),
    WHITE_GLAZED_TERRACOTTA(),
    WHITE_SHULKER_BOX(),
    WHITE_STAINED_GLASS(),
    WHITE_STAINED_GLASS_PANE(Entry.of("STAINED_GLASS_PANE")),
    WHITE_TERRACOTTA(),
    WHITE_TULIP(),
    WHITE_WALL_BANNER(),
    WHITE_WOOL(Entry.of("WOOL")),
    WITCH_SPAWN_EGG(Entry.of("MONSTER_EGG", 66)),
    WITHER_ROSE(),
    WITHER_SKELETON_SKULL(),
    WITHER_SKELETON_SPAWN_EGG(),
    WITHER_SKELETON_WALL_SKULL(),
    WOLF_SPAWN_EGG(Entry.of("MONSTER_EGG", 95)),
    WOODEN_AXE(),
    WOODEN_HOE(),
    WOODEN_PICKAXE(),
    WOODEN_SHOVEL(),
    WOODEN_SWORD(Entry.of("WOOD_SWORD")),
    WRITABLE_BOOK(Entry.of("BOOK_AND_QUILL")),
    WRITTEN_BOOK(),
    YELLOW_BANNER(),
    YELLOW_BED(),
    YELLOW_CARPET(),
    YELLOW_CONCRETE(),
    YELLOW_CONCRETE_POWDER(),
    YELLOW_DYE(),
    YELLOW_GLAZED_TERRACOTTA(),
    YELLOW_SHULKER_BOX(),
    YELLOW_STAINED_GLASS(),
    YELLOW_STAINED_GLASS_PANE(),
    YELLOW_TERRACOTTA(),
    YELLOW_WALL_BANNER(),
    YELLOW_WOOL(),
    ZOGLIN_SPAWN_EGG(),
    ZOMBIE_HEAD(),
    ZOMBIE_HORSE_SPAWN_EGG(),
    ZOMBIE_SPAWN_EGG(Entry.of("MONSTER_EGG", 54)),
    ZOMBIE_VILLAGER_SPAWN_EGG(),
    ZOMBIE_WALL_HEAD(),
    ZOMBIFIED_PIGLIN_SPAWN_EGG(),
    NULL();

    private final Set<Entry> entries;

    MultiMaterial(Entry... entries) {
        this.entries = Sets.newHashSet(entries);
    }

    public static MultiMaterial parse(String name) {
        return parse(name, 0);
    }

    public static MultiMaterial parse(String name, int data) {
        if (data > 0) {
            return find(name, data);
        }
        try {
            return valueOf(name);
        } catch (Exception ex) {
            return find(name, data);
        }
    }

    private static MultiMaterial find(String name, int data) {
        for (MultiMaterial multiMaterial : values()) {
            for (Entry entry : multiMaterial.entries) {
                if (entry.matches(name, data)) {
                    return multiMaterial;
                }
            }
        }
        return NULL;
    }

    public static ItemStack parseItem(String field) {
        if (field == null) {
            return null;
        }
        String[] splitField = field.split(":");
        MultiMaterial multiMaterial = parse(splitField[0].toUpperCase(), splitField.length > 1 ? Integer.parseInt(splitField[1]) : 0);
        String material = multiMaterial.equals(NULL) ? splitField[0].toUpperCase() : multiMaterial.getMaterial().toString();
        int data = multiMaterial.equals(NULL) ? 0 : multiMaterial.getData(material);
        return multiMaterial.getSafeItem(material, 1, data);
    }

    public Material getSafeMaterial(String material) {
        Material safeMaterial = Material.getMaterial(material);
        if (safeMaterial != null) {
            return safeMaterial;
        }
        Material unsafeMaterial = Material.getMaterial(this.toString());
        if (unsafeMaterial == null) {
            for (Entry entry : this.entries) {
                Material wrappedMaterial = Material.getMaterial(entry.name);
                if (wrappedMaterial != null) {
                    return wrappedMaterial;
                }
            }
        }
        return unsafeMaterial == null ? Material.DIRT : unsafeMaterial;
    }

    public Material getMaterial() {
        Material material = Material.getMaterial(this.toString());
        if (material == null) {
            for (Entry entry : this.entries) {
                Material wrappedMaterial = Material.getMaterial(entry.name);
                if (wrappedMaterial != null) {
                    return wrappedMaterial;
                }
            }
        }
        return material == null ? Material.DIRT : material;
    }

    public int getData(String material) {
        for (Entry entry : this.entries) {
            if (entry.name.equalsIgnoreCase(material)) {
                return entry.data.toArray(new Integer[0])[0];
            }
        }
        return 0;
    }

    public ItemStack getSafeItem(String material, int amount, int data) {
        return new ItemStack(this.getSafeMaterial(material), amount, (byte) data);
    }

    public ItemStack getItem(int amount, int data) {
        return new ItemStack(this.getMaterial(), amount, (byte) data);
    }

    public static class Entry {
        private final String name;
        private final Set<Integer> data;

        public Entry(String name, Set<Integer> data) {
            this.name = name;
            this.data = data;
        }

        public static Entry of(String name, Integer... datas) {
            return new Entry(name, Sets.newHashSet(datas));
        }

        public static Entry of(String name) {
            return new Entry(name, Sets.newHashSet(0));
        }

        public boolean matches(String name, int data) {
            return this.name.equalsIgnoreCase(name) && this.data.contains(data);
        }
    }
}
