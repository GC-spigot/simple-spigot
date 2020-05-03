package me.hyfe.simplespigot.version;

import me.hyfe.simplespigot.service.tuple.ImmutablePair;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public enum MultiMaterial {

    ACACIA_BOAT("BOAT_ACACIA"),
    ACACIA_BUTTON("WOOD_BUTTON"),
    ACACIA_DOOR,
    ACACIA_FENCE,
    ACACIA_FENCE_GATE,
    ACACIA_LEAVES("LEAVES_2"),
    ACACIA_LOG("LOG_2"),
    ACACIA_PLANKS("WOOD", 4),
    ACACIA_PRESSURE_PLATE("WOOD_PLATE"),
    ACACIA_SAPLING("SAPLING", 4),
    ACACIA_SIGN("SIGN"),
    ACACIA_SLAB("WOOD_STEP", 4),
    ACACIA_STAIRS,
    ACACIA_TRAPDOOR("TRAP_DOOR"),
    ACACIA_WALL_SIGN("WALL_SIGN"),
    ACACIA_WOOD("LOG_2"),
    ACTIVATOR_RAIL,
    AIR,
    ALLIUM,
    ANDESITE("STONE", 5),
    ANDESITE_SLAB("STONE"),
    ANDESITE_STAIRS("STONE"),
    ANDESITE_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    ANVIL,
    APPLE,
    ARMOR_STAND,
    ARROW,
    ATTACHED_MELON_STEM("MELON_STEM", 7),
    ATTACHED_PUMPKIN_STEM("PUMPKIN_STEM", 7),
    AZURE_BLUET("RED_ROSE", 3),
    BAKED_POTATO,
    BAMBOO,
    BAMBOO_SAPLING,
    BARREL,
    BARRIER,
    BAT_SPAWN_EGG("MONSTER_EGG", 65),
    BEACON,
    BEDROCK,
    BEEF("RAW_BEEF"),
    BEETROOT,
    BEETROOTS,
    BEETROOT_SEEDS,
    BEETROOT_SOUP,
    BELL,
    BIRCH_BOAT,
    BIRCH_BUTTON("WOOD_BUTTON"),
    BIRCH_DOOR,
    BIRCH_FENCE,
    BIRCH_FENCE_GATE,
    BIRCH_LEAVES("LEAVES", 2),
    BIRCH_LOG("LOG", 2),
    BIRCH_PLANKS("WOOD", 2),
    BIRCH_PRESSURE_PLATE("WOOD_PLATE"),
    BIRCH_SAPLING("SAPLING", 2),
    BIRCH_SLAB("WOOD_STEP", 2),
    BIRCH_SIGN("SIGN"),
    BIRCH_STAIRS("BIRCH_WOOD_STAIRS"),
    BIRCH_TRAPDOOR("TRAP_DOOR"),
    BIRCH_WALL_SIGN("WALL_SIGN"),
    BIRCH_WOOD("WOOD", 2),
    BLACK_BANNER("BANNER"),
    BLACK_BED("BED"),
    BLACK_CARPET("CARPET", 15),
    BLACK_CONCRETE("CONCRETE", 15),
    BLACK_CONCRETE_POWDER,
    BLACK_DYE("INK_SACK", "INK_SACK"),
    BLACK_GLAZED_TERRACOTTA,
    BLACK_SHULKER_BOX,
    BLACK_STAINED_GLASS("STAINED_GLASS", 15),
    BLACK_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 15),
    BLACK_TERRACOTTA("STAINED_CLAY", 15),
    BLACK_WALL_BANNER("WALL_BANNER"),
    BLACK_WOOL("WOOL", 15),
    BLAST_FURNACE("FURNACE"),
    BLAZE_POWDER,
    BLAZE_ROD,
    BLAZE_SPAWN_EGG("MONSTER_EGG", 61),
    BLUE_BANNER("BANNER", 11),
    BLUE_BED("BED"),
    BLUE_CARPET("CARPET", 11),
    BLUE_CONCRETE("CONCRETE", 11),
    BLUE_CONCRETE_POWDER("CONCRETE_POWDER", 11),
    BLUE_DYE,
    BLUE_GLAZED_TERRACOTTA,
    BLUE_ICE("PACKED_ICE"),
    BLUE_ORCHID("RED_ROSE", 1),
    BLUE_SHULKER_BOX,
    BLUE_STAINED_GLASS("STAINED_GLASS", 11),
    BLUE_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 11),
    BLUE_TERRACOTTA("STAINED_CLAY", 11),
    BLUE_WALL_BANNER("WALL_BANNER", 11),
    BLUE_WOOL("WOOL", 11),
    BONE,
    BONE_BLOCK,
    BONE_MEAL("INK_SACK", 15),
    BOOK,
    BOOKSHELF,
    BOW,
    BOWL,
    BRAIN_CORAL_WALL_FAN,
    BRAIN_CORAL,
    BRAIN_CORAL_BLOCK,
    BRAIN_CORAL_FAN,
    BREAD,
    BREWING_STAND,
    BRICK("CLAY_BRICK"),
    BRICKS("BRICK"),
    BRICK_SLAB("STEP", 4),
    BRICK_STAIRS,
    BRICK_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    BROWN_BANNER("BANNER", 3),
    BROWN_BED("BED"),
    BROWN_CARPET("CARPET", 12),
    BROWN_CONCRETE,
    BROWN_CONCRETE_POWDER,
    BROWN_DYE("COCO_BEANS", "INK_SACK", 3),
    BROWN_GLAZED_TERRACOTTA,
    BROWN_MUSHROOM,
    BROWN_MUSHROOM_BLOCK("BROWN_MUSHROOM"),
    BROWN_SHULKER_BOX,
    BROWN_STAINED_GLASS("STAINED_GLASS", 12),
    BROWN_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 12),
    BROWN_TERRACOTTA("STAINED_CLAY", 12),
    BROWN_WALL_BANNER("WALL_BANNER", 3),
    BROWN_WOOL("WOOL", 12),
    BUBBLE_COLUMN,
    BUBBLE_CORAL,
    BUBBLE_CORAL_BLOCK,
    BUBBLE_CORAL_FAN,
    BUBBLE_CORAL_WALL_FAN,
    BUCKET,
    CACTUS,
    CAKE("CAKE_BLOCK"),
    CAMPFIRE("TORCH"),
    CARROT("CARROT"),
    CARROTS("CARROT_ITEM"),
    CARROT_ON_A_STICK("CARROT_STICK"),
    CARTOGRAPHY_TABLE,
    CARVED_PUMPKIN("PUMPKIN"),
    CAT_SPAWN_EGG("MONSTER_EGG"),
    CAULDRON,
    CAVE_AIR("AIR"),
    CAVE_SPIDER_SPAWN_EGG("MONSTER_EGG", 59),
    CHAINMAIL_BOOTS,
    CHAINMAIL_CHESTPLATE,
    CHAINMAIL_HELMET,
    CHAINMAIL_LEGGINGS,
    CHAIN_COMMAND_BLOCK("COMMAND_CHAIN"),
    CHARCOAL("COAL", 1),
    CHEST,
    CHEST_MINECART("STORAGE_MINECART"),
    CHICKEN("RAW_CHICKEN"),
    CHICKEN_SPAWN_EGG("MONSTER_EGG", 93),
    CHIPPED_ANVIL("ANVIL", 1),
    CHISELED_QUARTZ_BLOCK("QUARTZ_BLOCK", 1),
    CHISELED_RED_SANDSTONE("RED_SANDSTONE", 1),
    CHISELED_SANDSTONE("SANDSTONE", 1),
    CHISELED_STONE_BRICKS("SMOOTH_BRICK", 3),
    CHORUS_FLOWER,
    CHORUS_FRUIT,
    CHORUS_PLANT,
    CLAY,
    CLAY_BALL,
    CLOCK("WATCH"),
    COAL,
    COAL_BLOCK,
    COAL_ORE,
    COARSE_DIRT("DIRT", 1),
    COBBLESTONE,
    COBBLESTONE_SLAB("STEP", 3),
    COBBLESTONE_STAIRS,
    COBBLESTONE_WALL("COBBLE_WALL"),
    COBWEB("WEB"),
    COCOA("COCOA", 11),
    COCOA_BEANS("INK_SACK", 3),
    COD("RAW_FISH"),
    COD_BUCKET("BUCKET"),
    COD_SPAWN_EGG("MONSTER_EGG"),
    COMMAND_BLOCK("COMMAND"),
    COMMAND_BLOCK_MINECART("COMMAND_MINECART"),
    COMPARATOR("REDSTONE_COMPARATOR"),
    COMPASS,
    COMPOSTER,
    CONDUIT,
    COOKED_BEEF,
    COOKED_CHICKEN,
    COOKED_COD("COOKED_FISH"),
    COOKED_MUTTON,
    COOKED_PORKCHOP("GRILLED_PORK"),
    COOKED_RABBIT,
    COOKED_SALMON("COOKED_FISH", 1),
    COOKIE,
    CORNFLOWER,
    COW_SPAWN_EGG("MONSTER_EGG", 92),
    CRACKED_STONE_BRICKS("SMOOTH_BRICK", 2),
    CRAFTING_TABLE("WORKBENCH"),
    CREEPER_BANNER_PATTERN,
    CREEPER_HEAD("SKULL_ITEM", 4),
    CREEPER_SPAWN_EGG("MONSTER_EGG", 50),
    CREEPER_WALL_HEAD("SKULL"),
    CROSSBOW("BOW"),
    CUT_RED_SANDSTONE("STONE"),
    CUT_RED_SANDSTONE_SLAB("STONE"),
    CUT_SANDSTONE("STONE"),
    CUT_SANDSTONE_SLAB("STONE"),
    CYAN_BANNER("BANNER", 6),
    CYAN_BED("BED"),
    CYAN_CARPET("CARPET", 9),
    CYAN_CONCRETE("CONCRETE", 9),
    CYAN_CONCRETE_POWDER("CONCRETE_POWDER", 9),
    CYAN_DYE("INK_SACK", 6),
    CYAN_GLAZED_TERRACOTTA,
    CYAN_SHULKER_BOX,
    CYAN_STAINED_GLASS("STAINED_GLASS", 9),
    CYAN_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 9),
    CYAN_TERRACOTTA("STAINED_CLAY", 9),
    CYAN_WALL_BANNER("WALL_BANNER"),
    CYAN_WOOL("WOOL", 9),
    DAMAGED_ANVIL("ANVIL", 2),
    DANDELION("YELLOW_FLOWER"),
    DARK_OAK_BOAT("BOAT_DARK_OAK"),
    DARK_OAK_BUTTON("WOOD_BUTTON"),
    DARK_OAK_DOOR,
    DARK_OAK_FENCE,
    DARK_OAK_FENCE_GATE,
    DARK_OAK_LEAVES("LEAVES_2", 1),
    DARK_OAK_LOG("LOG_2", 1),
    DARK_OAK_PLANKS("WOOD", 5),
    DARK_OAK_PRESSURE_PLATE("WOOD_PLATE"),
    DARK_OAK_SAPLING("SAPLING", 5),
    DARK_OAK_SIGN("SIGN"),
    DARK_OAK_SLAB("WOOD_STEP"),
    DARK_OAK_STAIRS,
    DARK_OAK_TRAPDOOR("TRAP_DOOR"),
    DARK_OAK_WALL_SIGN("WALL_SIGN"),
    DARK_OAK_WOOD("LOG_2", 1),
    DARK_PRISMARINE("PRISMARINE", 2),
    DARK_PRISMARINE_SLAB("PRISMARINE"),
    DARK_PRISMARINE_STAIRS("PRISMARINE"),
    DAYLIGHT_DETECTOR,
    DEAD_BRAIN_CORAL,
    DEAD_BRAIN_CORAL_BLOCK,
    DEAD_BRAIN_CORAL_FAN,
    DEAD_BRAIN_CORAL_WALL_FAN,
    DEAD_BUBBLE_CORAL_BLOCK,
    DEAD_BUBBLE_CORAL,
    DEAD_BUBBLE_CORAL_FAN,
    DEAD_BUBBLE_CORAL_WALL_FAN,
    DEAD_BUSH,
    DEAD_FIRE_CORAL,
    DEAD_FIRE_CORAL_FAN,
    DEAD_FIRE_CORAL_WALL_FAN,
    DEAD_HORN_CORAL,
    DEAD_HORN_CORAL_FAN,
    DEAD_HORN_CORAL_WALL_FAN,
    DEAD_TUBE_CORAL,
    DEAD_TUBE_CORAL_FAN,
    DEAD_TUBE_CORAL_WALL_FAN,
    DEAD_FIRE_CORAL_BLOCK,
    DEAD_HORN_CORAL_BLOCK,
    DEAD_TUBE_CORAL_BLOCK,
    DEBUG_STICK("STICK"),
    DETECTOR_RAIL,
    DIAMOND,
    DIAMOND_AXE,
    DIAMOND_BLOCK,
    DIAMOND_BOOTS,
    DIAMOND_CHESTPLATE,
    DIAMOND_HELMET,
    DIAMOND_HOE,
    DIAMOND_HORSE_ARMOR("DIAMOND_BARDING"),
    DIAMOND_LEGGINGS,
    DIAMOND_ORE,
    DIAMOND_PICKAXE,
    DIAMOND_SHOVEL("DIAMOND_SPADE"),
    DIAMOND_SWORD,
    DIORITE("STONE", 3),
    DIORITE_SLAB("STONE"),
    DIORITE_STAIRS("STONE"),
    DIORITE_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    DIRT,
    DISPENSER,
    DOLPHIN_SPAWN_EGG("MONSTER_EGG"),
    DONKEY_SPAWN_EGG("MONSTER_EGG"),
    DRAGON_BREATH("DRAGONS_BREATH"),
    DRAGON_EGG,
    DRAGON_HEAD("SKULL", 5),
    DRAGON_WALL_HEAD("SKULL"),
    DRIED_KELP,
    DRIED_KELP_BLOCK,
    DROPPER,
    DROWNED_SPAWN_EGG("MONSTER_EGG"),
    EGG,
    ELDER_GUARDIAN_SPAWN_EGG("MONSTER_EGG", 4),
    ELYTRA,
    EMERALD,
    EMERALD_BLOCK,
    EMERALD_ORE,
    ENCHANTED_BOOK,
    ENCHANTED_GOLDEN_APPLE("GOLDEN_APPLE", 1),
    ENCHANTING_TABLE("ENCHANTMENT_TABLE"),
    ENDERMAN_SPAWN_EGG("MONSTER_EGG", 58),
    ENDERMITE_SPAWN_EGG("MONSTER_EGG", 67),
    ENDER_CHEST,
    ENDER_EYE("EYE_OF_ENDER"),
    ENDER_PEARL,
    END_CRYSTAL,
    END_GATEWAY,
    END_PORTAL("ENDER_PORTAL"),
    END_PORTAL_FRAME("ENDER_PORTAL_FRAME"),
    END_ROD,
    END_STONE("ENDER_STONE"),
    END_STONE_BRICKS("END_BRICKS"),
    END_STONE_BRICK_SLAB("END_BRICKS"),
    END_STONE_BRICK_STAIRS("END_BRICKS"),
    END_STONE_BRICK_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    EVOKER_SPAWN_EGG("MONSTER_EGG"),
    EXPERIENCE_BOTTLE("EXP_BOTTLE"),
    FARMLAND("SOIL"),
    FEATHER,
    FERMENTED_SPIDER_EYE,
    FERN("LONG_GRASS", 2),
    FILLED_MAP("MAP"),
    FIRE,
    FIREWORK_ROCKET("FIREWORK"),
    FIREWORK_STAR("FIREWORK_CHARGE"),
    FIRE_CHARGE("FIREBALL"),
    FIRE_CORAL,
    FIRE_CORAL_BLOCK,
    FIRE_CORAL_FAN,
    FIRE_CORAL_WALL_FAN,
    FISHING_ROD,
    FLETCHING_TABLE,
    FLINT,
    FLINT_AND_STEEL,
    FLOWER_BANNER_PATTERN,
    FLOWER_POT,
    FOX_SPAWN_EGG("MONSTER_EGG"),
    FROSTED_ICE,
    FURNACE,
    FURNACE_MINECART("POWERED_MINECART"),
    GHAST_SPAWN_EGG("MONSTER_EGG", 56),
    GHAST_TEAR,
    GLASS,
    GLASS_BOTTLE,
    GLASS_PANE("THIN_GLASS"),
    GLISTERING_MELON_SLICE("SPECKLED_MELON"),
    GLOBE_BANNER_PATTERN,
    GLOWSTONE,
    GLOWSTONE_DUST,
    GOLDEN_APPLE,
    GOLDEN_AXE("GOLD_AXE"),
    GOLDEN_BOOTS("GOLD_BOOTS"),
    GOLDEN_CARROT,
    GOLDEN_CHESTPLATE("GOLD_CHESTPLATE"),
    GOLDEN_HELMET("GOLD_HELMET"),
    GOLDEN_HOE("GOLD_HOE"),
    GOLDEN_HORSE_ARMOR("GOLD_BARDING"),
    GOLDEN_LEGGINGS("GOLD_LEGGINGS"),
    GOLDEN_PICKAXE("GOLD_PICKAXE"),
    GOLDEN_SHOVEL("GOLD_SPADE"),
    GOLDEN_SWORD("GOLD_SWORD"),
    GOLD_BLOCK,
    GOLD_INGOT,
    GOLD_NUGGET,
    GOLD_ORE,
    GRANITE("STONE", 1),
    GRANITE_SLAB("STONE"),
    GRANITE_STAIRS("STONE"),
    GRANITE_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
        GRASS,
    GRASS_BLOCK("GRASS"),
    GRASS_PATH,
    GRAVEL,
    GRAY_BANNER("BANNER", 8),
    GRAY_BED("BED"),
    GRAY_CARPET("CARPET", 7),
    GRAY_CONCRETE("CONCRETE", 7),
    GRAY_CONCRETE_POWDER("CONCRETE_POWDER", 7),
    GRAY_DYE("INK_SACK", 8),
    GRAY_GLAZED_TERRACOTTA,
    GRAY_SHULKER_BOX,
    GRAY_STAINED_GLASS("STAINED_GLASS", 7),
    GRAY_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 7),
    GRAY_TERRACOTTA("STAINED_CLAY", 7),
    GRAY_WALL_BANNER("WALL_BANNER"),
    GRAY_WOOL("WOOL", 7),
    GREEN_BANNER("BANNER", 2),
    GREEN_BED("BED"),
    GREEN_CARPET("CARPET", 13),
    GREEN_CONCRETE("CONCRETE", 13),
    GREEN_CONCRETE_POWDER("CONCRETE_POWDER", 13),
    GREEN_DYE("CACTUS_GREEN", "INK_SACK", 2),
    GREEN_GLAZED_TERRACOTTA,
    GREEN_SHULKER_BOX,
    GREEN_STAINED_GLASS("STAINED_GLASS", 13),
    GREEN_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 13),
    GREEN_TERRACOTTA("STAINED_CLAY", 13),
    GREEN_WALL_BANNER("WALL_BANNER"),
    GREEN_WOOL("WOOL", 13),
    GRINDSTONE("STONE"),
    GUARDIAN_SPAWN_EGG("MONSTER_EGG", 68),
    GUNPOWDER("SULPHUR"),
    HAY_BLOCK,
    HEART_OF_THE_SEA,
    HEAVY_WEIGHTED_PRESSURE_PLATE("IRON_PLATE"),
    HOPPER,
    HOPPER_MINECART,
    HORN_CORAL,
    HORN_CORAL_BLOCK,
    HORN_CORAL_FAN,
    HORN_CORAL_WALL_FAN,
    HORSE_SPAWN_EGG("MONSTER_EGG", 100),
    HUSK_SPAWN_EGG("MONSTER_EGG", 23),
    ICE,
    INFESTED_CHISELED_STONE_BRICKS("MONSTER_EGGS", 5),
    INFESTED_COBBLESTONE("MONSTER_EGGS", 1),
    INFESTED_CRACKED_STONE_BRICKS("MONSTER_EGGS", 4),
    INFESTED_MOSSY_STONE_BRICKS("MONSTER_EGGS", 3),
    INFESTED_STONE("MONSTER_EGGS"),
    INFESTED_STONE_BRICKS("MONSTER_EGGS", 2),
    INK_SAC("INK_SACK"),
    IRON_AXE,
    IRON_BARS("IRON_FENCE"),
    IRON_BLOCK,
    IRON_BOOTS,
    IRON_CHESTPLATE,
    IRON_DOOR,
    IRON_HELMET,
    IRON_HOE,
    IRON_HORSE_ARMOR("IRON_BARDING"),
    IRON_INGOT,
    IRON_LEGGINGS,
    IRON_NUGGET,
    IRON_ORE,
    IRON_PICKAXE,
    IRON_SHOVEL("IRON_SPADE"),
    IRON_SWORD,
    IRON_TRAPDOOR,
    ITEM_FRAME,
    JACK_O_LANTERN,
    JIGSAW,
    JUKEBOX,
    JUNGLE_BOAT("BOAT_JUNGLE"),
    JUNGLE_BUTTON("WOOD_BUTTON"),
    JUNGLE_DOOR,
    JUNGLE_FENCE,
    JUNGLE_FENCE_GATE,
    JUNGLE_LEAVES("LEAVES", 3),
    JUNGLE_LOG("LOG", 3),
    JUNGLE_PLANKS("WOOD", 3),
    JUNGLE_PRESSURE_PLATE("WOOD_PLATE"),
    JUNGLE_SAPLING("SAPLING", 3),
    JUNGLE_SIGN("SIGN"),
    JUNGLE_SLAB("WOOD_STEP", 3),
    JUNGLE_STAIRS("JUNGLE_WOOD_STAIRS"),
    JUNGLE_TRAPDOOR("TRAP_DOOR"),
    JUNGLE_WALL_SIGN("WALL_SIGN"),
    JUNGLE_WOOD("LOG", 3),
    KELP,
    KELP_PLANT,
    KNOWLEDGE_BOOK,
    LADDER,
    LANTERN("TORCH"),
    LAPIS_BLOCK,
    LAPIS_LAZULI("INK_SACK", 4),
    LAPIS_ORE,
    LARGE_FERN("DOUBLE_PLANT", 3),
    LAVA,
    LAVA_BUCKET,
    LEAD("LEASH"),
    LEATHER,
    LEATHER_BOOTS,
    LEATHER_CHESTPLATE,
    LEATHER_HELMET,
    LEATHER_HORSE_ARMOR,
    LEATHER_LEGGINGS,
    LECTERN,
    LEVER,
    LIGHT_BLUE_BANNER("BANNER", 12),
    LIGHT_BLUE_BED("BED"),
    LIGHT_BLUE_CARPET("CARPET", 3),
    LIGHT_BLUE_CONCRETE("CONCRETE", 3),
    LIGHT_BLUE_CONCRETE_POWDER("CONCRETE_POWDER", 3),
    LIGHT_BLUE_DYE("INK_SACK", 12),
    LIGHT_BLUE_GLAZED_TERRACOTTA,
    LIGHT_BLUE_SHULKER_BOX,
    LIGHT_BLUE_STAINED_GLASS("STAINED_GLASS", 3),
    LIGHT_BLUE_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 3),
    LIGHT_BLUE_TERRACOTTA("STAINED_CLAY", 3),
    LIGHT_BLUE_WALL_BANNER("BANNER"),
    LIGHT_BLUE_WOOL("WOOL", 3),
    LIGHT_GRAY_BANNER("BANNER", 7),
    LIGHT_GRAY_BED("BED"),
    LIGHT_GRAY_CARPET("CARPET", 8),
    LIGHT_GRAY_CONCRETE("CONCRETE", 8),
    LIGHT_GRAY_CONCRETE_POWDER("CONCRETE_POWDER", 8),
    LIGHT_GRAY_DYE("INK_SACK", 7),
    LIGHT_GRAY_GLAZED_TERRACOTTA("SILVER_GLAZED_TERRACOTTA"),
    LIGHT_GRAY_SHULKER_BOX("SILVER_SHULKER_BOX"),
    LIGHT_GRAY_STAINED_GLASS("STAINED_GLASS", 8),
    LIGHT_GRAY_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 8),
    LIGHT_GRAY_TERRACOTTA("STAINED_CLAY", 8),
    LIGHT_GRAY_WALL_BANNER("WALL_BANNER"),
    LIGHT_GRAY_WOOL("WOOL", 8),
    LIGHT_WEIGHTED_PRESSURE_PLATE("GOLD_PLATE"),
    LILAC("DOUBLE_PLANT", 1),
    LILY_OF_THE_VALLEY,
    LILY_PAD("WATER_LILY"),
    LIME_BANNER("BANNER", 10),
    LIME_BED("BED"),
    LIME_CARPET("CARPET", 5),
    LIME_CONCRETE("CONCRETE", 5),
    LIME_CONCRETE_POWDER("CONCRETE_POWDER", 5),
    LIME_DYE("INK_SACK", 10),
    LIME_GLAZED_TERRACOTTA,
    LIME_SHULKER_BOX,
    LIME_STAINED_GLASS("STAINED_GLASS", 5),
    LIME_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 5),
    LIME_TERRACOTTA("STAINED_CLAY", 5),
    LIME_WALL_BANNER("WALL_BANNER"),
    LIME_WOOL("WOOL", 5),
    LINGERING_POTION,
    LLAMA_SPAWN_EGG("MONSTER_EGG"),
    LOOM,
    MAGENTA_BANNER("BANNER", 13),
    MAGENTA_BED("BED"),
    MAGENTA_CARPET("CARPET", 2),
    MAGENTA_CONCRETE("CONCRETE", 2),
    MAGENTA_CONCRETE_POWDER("CONCRETE_POWDER", 2),
    MAGENTA_DYE("INK_SACK", 13),
    MAGENTA_GLAZED_TERRACOTTA,
    MAGENTA_SHULKER_BOX,
    MAGENTA_STAINED_GLASS("STAINED_GLASS", 2),
    MAGENTA_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 2),
    MAGENTA_TERRACOTTA("STAINED_CLAY", 2),
    MAGENTA_WALL_BANNER("WALL_BANNER"),
    MAGENTA_WOOL("WOOL", 2),
    MAGMA_BLOCK("MAGMA", 62),
    MAGMA_CREAM,
    MAGMA_CUBE_SPAWN_EGG("MONSTER_EGG"),
    MAP,
    MELON("MELON_BLOCK"),
    MELON_SEEDS,
    MELON_SLICE("MELON"),
    MELON_STEM,
    MILK_BUCKET,
    MINECART,
    MOJANG_BANNER_PATTERN,
    MOOSHROOM_SPAWN_EGG("MONSTER_EGG", 96),
    MOSSY_COBBLESTONE,
    MOSSY_COBBLESTONE_SLAB("MOSSY_COBBLESTONE"),
    MOSSY_COBBLESTONE_STAIRS("MOSSY_COBBLESTONE"),
    MOSSY_COBBLESTONE_WALL("COBBLE_WALL", 1),
    MOSSY_STONE_BRICKS("SMOOTH_BRICK", 1),
    MOSSY_STONE_BRICK_SLAB("MOSSY_COBBLESTONE"),
    MOSSY_STONE_BRICK_STAIRS("MOSSY_COBBLESTONE"),
    MOSSY_STONE_BRICK_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    MOVING_PISTON("PISTON_MOVING_PIECE"),
    MULE_SPAWN_EGG("MONSTER_EGG"),
    MUSHROOM_STEM("BROWN_MUSHROOM"),
    MUSHROOM_STEW("MUSHROOM_SOUP"),
    MUSIC_DISC_11("GOLD_RECORD"),
    MUSIC_DISC_13("GREEN_RECORD"),
    MUSIC_DISC_BLOCKS("RECORD_3"),
    MUSIC_DISC_CAT("RECORD_4"),
    MUSIC_DISC_CHIRP("RECORD_5"),
    MUSIC_DISC_FAR("RECORD_6"),
    MUSIC_DISC_MALL("RECORD_7"),
    MUSIC_DISC_MELLOHI("RECORD_8"),
    MUSIC_DISC_STAL("RECORD_9"),
    MUSIC_DISC_STRAD("RECORD_10"),
    MUSIC_DISC_WAIT("RECORD_11"),
    MUSIC_DISC_WARD("RECORD_12"),
    MUTTON,
    MYCELIUM("MYCEL"),
    NAME_TAG,
    NAUTILUS_SHELL,
    NETHERRACK,
    NETHER_BRICK,
    NETHER_BRICKS("NETHER_BRICK"),
    NETHER_BRICK_FENCE("NETHER_FENCE"),
    NETHER_BRICK_SLAB("STEP", 6),
    NETHER_BRICK_STAIRS,
    NETHER_BRICK_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    NETHER_PORTAL("PORTAL"),
    NETHER_QUARTZ_ORE("QUARTZ_ORE"),
    NETHER_STAR,
    NETHER_WART("NETHER_STALK"),
    NETHER_WART_BLOCK,
    NOTE_BLOCK,
    OAK_BOAT("BOAT"),
    OAK_BUTTON("WOOD_BUTTON"),
    OAK_DOOR("WOOD_DOOR"),
    OAK_FENCE("FENCE"),
    OAK_FENCE_GATE("FENCE_GATE"),
    OAK_LEAVES("LEAVES"),
    OAK_LOG("LOG", 0),
    OAK_PLANKS("WOOD"),
    OAK_PRESSURE_PLATE("WOOD_PLATE"),
    OAK_SAPLING("SAPLING"),
    OAK_SIGN("SIGN"),
    OAK_SLAB("WOOD_STEP"),
    OAK_STAIRS("WOOD_STAIRS"),
    OAK_TRAPDOOR("TRAP_DOOR"),
    OAK_WALL_SIGN("WALL_SIGN"),
    OAK_WOOD("LOG"),
    OBSERVER,
    OBSIDIAN,
    OCELOT_SPAWN_EGG("RECORD_12", 98),
    ORANGE_BANNER("BANNER", 14),
    ORANGE_BED("BED"),
    ORANGE_CARPET("CARPET", 1),
    ORANGE_CONCRETE("CONCRETE", 1),
    ORANGE_CONCRETE_POWDER("CONCRETE_POWDER", 1),
    ORANGE_DYE("INK_SACK", 14),
    ORANGE_GLAZED_TERRACOTTA,
    ORANGE_SHULKER_BOX,
    ORANGE_STAINED_GLASS("STAINED_GLASS", 1),
    ORANGE_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 1),
    ORANGE_TERRACOTTA("STAINED_CLAY", 1),
    ORANGE_TULIP("RED_ROSE", 5),
    ORANGE_WALL_BANNER("WALL_BANNER"),
    ORANGE_WOOL("WOOL", 1),
    OXEYE_DAISY("RED_ROSE", 8),
    PACKED_ICE,
    PAINTING,
    PANDA_SPAWN_EGG("MONSTER_EGG"),
    PAPER,
    PARROT_SPAWN_EGG("MONSTER_EGG"),
    PEONY("DOUBLE_PLANT", 5),
    PETRIFIED_OAK_SLAB,
    PHANTOM_MEMBRANE,
    PHANTOM_SPAWN_EGG("MONSTER_EGG"),
    PIG_SPAWN_EGG("MONSTER_EGG", 90),
    PILLAGER_SPAWN_EGG("MONSTER_EGG"),
    PINK_BANNER("BANNER", 9),
    PINK_BED("BED"),
    PINK_CARPET("CARPET", 6),
    PINK_CONCRETE("CONCRETE", 6),
    PINK_CONCRETE_POWDER("CONCRETE_POWDER", 6),
    PINK_DYE("INK_SACK", 9),
    PINK_GLAZED_TERRACOTTA,
    PINK_SHULKER_BOX,
    PINK_STAINED_GLASS("STAINED_GLASS", 6),
    PINK_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 6),
    PINK_TERRACOTTA("STAINED_CLAY", 6),
    PINK_TULIP("RED_ROSE", 7),
    PINK_WALL_BANNER("WALL_BANNER"),
    PINK_WOOL("WOOL", 6),
    PISTON("PISTON_BASE"),
    PISTON_HEAD("PISTON_EXTENSION"),
    PLAYER_HEAD("SKULL_ITEM", 3),
    PLAYER_WALL_HEAD("SKULL"),
    PODZOL("DIRT", 2),
    POISONOUS_POTATO,
    POLAR_BEAR_SPAWN_EGG("MONSTER_EGG"),
    POLISHED_ANDESITE("STONE", 6),
    POLISHED_ANDESITE_SLAB("STONE", 6),
    POLISHED_ANDESITE_STAIRS("STONE", 6),
    POLISHED_DIORITE("STONE", 4),
    POLISHED_DIORITE_SLAB("STONE", 4),
    POLISHED_DIORITE_STAIRS("STONE", 4),
    POLISHED_GRANITE("STONE", 2),
    POLISHED_GRANITE_SLAB("STONE", 2),
    POLISHED_GRANITE_STAIRS("STONE", 2),
    POPPED_CHORUS_FRUIT("CHORUS_FRUIT_POPPED"),
    POPPY("RED_ROSE"),
    PORKCHOP("PORK"),
    POTATO("POTATO_ITEM"),
    POTATOES("POTATO"),
    POTION,
    POTTED_ACACIA_SAPLING("FLOWER_POT"),
    POTTED_ALLIUM("FLOWER_POT"),
    POTTED_AZURE_BLUET("FLOWER_POT"),
    POTTED_BAMBOO("FLOWER_POT"),
    POTTED_BIRCH_SAPLING("FLOWER_POT"),
    POTTED_BLUE_ORCHID("FLOWER_POT"),
    POTTED_BROWN_MUSHROOM("FLOWER_POT"),
    POTTED_CACTUS("FLOWER_POT"),
    POTTED_CORNFLOWER("FLOWER_POT"),
    POTTED_DANDELION("FLOWER_POT"),
    POTTED_DARK_OAK_SAPLING("FLOWER_POT"),
    POTTED_DEAD_BUSH("FLOWER_POT"),
    POTTED_FERN("FLOWER_POT"),
    POTTED_JUNGLE_SAPLING("FLOWER_POT"),
    POTTED_LILY_OF_THE_VALLEY("FLOWER_POT"),
    POTTED_OAK_SAPLING("FLOWER_POT"),
    POTTED_ORANGE_TULIP("FLOWER_POT"),
    POTTED_OXEYE_DAISY("FLOWER_POT"),
    POTTED_PINK_TULIP("FLOWER_POT"),
    POTTED_POPPY("FLOWER_POT"),
    POTTED_RED_MUSHROOM("FLOWER_POT"),
    POTTED_RED_TULIP("FLOWER_POT"),
    POTTED_SPRUCE_SAPLING("FLOWER_POT"),
    POTTED_WHITE_TULIP("FLOWER_POT"),
    POTTED_WITHER_ROSE("FLOWER_POT"),
    POWERED_RAIL,
    PRISMARINE,
    PRISMARINE_BRICKS("PRISMARINE", 1),
    PRISMARINE_BRICK_SLAB("PRISMARINE", 1),
    PRISMARINE_BRICK_STAIRS("PRISMARINE", 1),
    PRISMARINE_CRYSTALS,
    PRISMARINE_SHARD,
    PRISMARINE_SLAB("PRISMARINE", 1),
    PRISMARINE_STAIRS("PRISMARINE", 1),
    PRISMARINE_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    PUFFERFISH("RAW_FISH", 3),
    PUFFERFISH_BUCKET("BUCKET"),
    PUFFERFISH_SPAWN_EGG("MONSTER_EGG"),
    PUMPKIN,
    PUMPKIN_PIE,
    PUMPKIN_SEEDS,
    PUMPKIN_STEM,
    PURPLE_BANNER("BANNER", 5),
    PURPLE_BED("BED"),
    PURPLE_CARPET("CARPET", 10),
    PURPLE_CONCRETE("CONCRETE", 10),
    PURPLE_CONCRETE_POWDER("CONCRETE_POWDER", 10),
    PURPLE_DYE("INK_SACK", 5),
    PURPLE_GLAZED_TERRACOTTA,
    PURPLE_SHULKER_BOX,
    PURPLE_STAINED_GLASS("STAINED_GLASS", 10),
    PURPLE_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 10),
    PURPLE_TERRACOTTA("STAINED_CLAY", 10),
    PURPLE_WALL_BANNER("WALL_BANNER"),
    PURPLE_WOOL("WOOL", 10),
    PURPUR_BLOCK,
    PURPUR_PILLAR,
    PURPUR_SLAB,
    PURPUR_STAIRS,
    QUARTZ,
    QUARTZ_BLOCK,
    QUARTZ_PILLAR("QUARTZ_BLOCK", 2),
    QUARTZ_SLAB("STEP", 7),
    QUARTZ_STAIRS,
    RABBIT,
    RABBIT_FOOT,
    RABBIT_HIDE,
    RABBIT_SPAWN_EGG("MONSTER_EGG", 101),
    RABBIT_STEW,
    RAIL("RAILS"),
    RAVAGER_SPAWN_EGG("MONSTER_EGG"),
    REDSTONE,
    REDSTONE_BLOCK,
    REDSTONE_LAMP("REDSTONE_LAMP_OFF"),
    REDSTONE_ORE,
    REDSTONE_TORCH("REDSTONE_TORCH_ON"),
    REDSTONE_WALL_TORCH("REDSTONE_TORCH_ON", 1),
    REDSTONE_WIRE,
    RED_BANNER("BANNER", 1),
    RED_BED("BED"),
    RED_CARPET("CARPET", 14),
    RED_CONCRETE("CONCRETE", 14),
    RED_CONCRETE_POWDER("CONCRETE_POWDER", 14),
    RED_DYE("ROSE_RED", "INK_SACK", 1),
    RED_GLAZED_TERRACOTTA,
    RED_MUSHROOM,
    RED_MUSHROOM_BLOCK("RED_MUSHROOM"),
    RED_NETHER_BRICKS("RED_NETHER_BRICK"),
    RED_NETHER_BRICK_SLAB("NETHER_BRICK"),
    RED_NETHER_BRICK_STAIRS("NETHER_BRICK"),
    RED_NETHER_BRICK_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    RED_SAND("SAND", 1),
    RED_SANDSTONE,
    RED_SANDSTONE_SLAB("STONE_SLAB2"),
    RED_SANDSTONE_STAIRS,
    RED_SANDSTONE_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    RED_SHULKER_BOX,
    RED_STAINED_GLASS("STAINED_GLASS", 14),
    RED_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 14),
    RED_TERRACOTTA("STAINED_CLAY", 14),
    RED_TULIP("RED_ROSE", 4),
    RED_WALL_BANNER("WALL_BANNER"),
    RED_WOOL("WOOL", 14),
    REPEATER("DIODE"),
    REPEATING_COMMAND_BLOCK("COMMAND_REPEATING"),
    ROSE_BUSH("DOUBLE_PLANT", 4),
    ROTTEN_FLESH,
    SADDLE,
    SALMON("RAW_FISH", 1),
    SALMON_BUCKET("BUCKET"),
    SALMON_SPAWN_EGG("MONSTER_EGG"),
    SAND,
    SANDSTONE,
    SANDSTONE_SLAB("STEP", 1),
    SANDSTONE_STAIRS,
    SANDSTONE_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    SCAFFOLDING,
    SCUTE,
    SEAGRASS("LONG_GRASS"),
    SEA_LANTERN,
    SEA_PICKLE,
    SHEARS,
    SHEEP_SPAWN_EGG("MONSTER_EGG", 91),
    SHIELD,
    SHULKER_BOX("PURPLE_SHULKER_BOX"),
    SHULKER_SHELL,
    SHULKER_SPAWN_EGG("MONSTER_EGG"),
    SIGN,
    SILVERFISH_SPAWN_EGG("MONSTER_EGG"),
    SKELETON_HORSE_SPAWN_EGG("MONSTER_EGG", 28),
    SKELETON_SKULL("SKULL_ITEM"),
    SKELETON_SPAWN_EGG("MONSTER_EGG", 51),
    SKELETON_WALL_SKULL("SKULL"),
    SKULL_BANNER_PATTERN,
    SLIME_BALL,
    SLIME_BLOCK,
    SLIME_SPAWN_EGG("MONSTER_EGG", 55),
    SMITHING_TABLE,
    SMOKER,
    SMOOTH_QUARTZ("QUARTZ_BLOCK"),
    SMOOTH_QUARTZ_SLAB("QUARTZ_BLOCK"),
    SMOOTH_QUARTZ_STAIRS("QUARTZ_STAIRS"),
    SMOOTH_RED_SANDSTONE("RED_SANDSTONE", 2),
    SMOOTH_RED_SANDSTONE_SLAB("RED_SANDSTONE", 2),
    SMOOTH_RED_SANDSTONE_STAIRS("RED_SANDSTONE", 2),
    SMOOTH_SANDSTONE("SANDSTONE", 2),
    SMOOTH_SANDSTONE_SLAB("SANDSTONE", 2),
    SMOOTH_SANDSTONE_STAIRS("SANDSTONE", 2),
    SMOOTH_STONE("SMOOTH_BRICK"),
    SMOOTH_STONE_SLAB("STONE"),
    SNOW,
    SNOWBALL("SNOW_BALL"),
    SNOW_BLOCK,
    SOUL_SAND,
    SPAWNER("MOB_SPAWNER"),
    SPECTRAL_ARROW,
    SPIDER_EYE,
    SPIDER_SPAWN_EGG("MONSTER_EGG", 52),
    SPLASH_POTION,
    SPONGE,
    SPRUCE_BOAT("BOAT_SPRUCE"),
    SPRUCE_BUTTON("WOOD_BUTTON"),
    SPRUCE_DOOR,
    SPRUCE_FENCE,
    SPRUCE_FENCE_GATE,
    SPRUCE_LEAVES("LEAVES", 1),
    SPRUCE_LOG("LOG", 1),
    SPRUCE_PLANKS("WOOD", 1),
    SPRUCE_PRESSURE_PLATE("WOOD_PLATE"),
    SPRUCE_SAPLING("SAPLING", 1),
    SPRUCE_SIGN("SIGN"),
    SPRUCE_SLAB("WOOD_STEP", 1),
    SPRUCE_STAIRS("SPRUCE_WOOD_STAIRS"),
    SPRUCE_TRAPDOOR("TRAP_DOOR"),
    SPRUCE_WALL_SIGN("WALL_SIGN"),
    SPRUCE_WOOD("LOG", 1),
    SQUID_SPAWN_EGG("MONSTER_EGG", 94),
    STICK,
    STICKY_PISTON("PISTON_STICKY_BASE"),
    STONE,
    STONECUTTER("STONE"),
    STONE_AXE,
    STONE_BRICKS("SMOOTH_BRICK"),
    STONE_BRICK_SLAB("STEP", 5),
    STONE_BRICK_STAIRS("SMOOTH_STAIRS"),
    STONE_BRICK_WALL("COBBLESTONE_WALL", "COBBLE_WALL"),
    STONE_BUTTON,
    STONE_HOE,
    STONE_PICKAXE,
    STONE_PRESSURE_PLATE("STONE_PLATE"),
    STONE_SHOVEL("STONE_SPADE"),
    STONE_SLAB("STEP"),
    STONE_STAIRS("COBBLESTONE_STAIRS "),
    STONE_SWORD,
    STRAY_SPAWN_EGG("MONSTER_EGG"),
    STRING,
    STRIPPED_ACACIA_LOG("WOOD "),
    STRIPPED_ACACIA_WOOD("WOOD"),
    STRIPPED_BIRCH_LOG("WOOD"),
    STRIPPED_BIRCH_WOOD("WOOD"),
    STRIPPED_DARK_OAK_LOG("WOOD"),
    STRIPPED_DARK_OAK_WOOD("WOOD"),
    STRIPPED_JUNGLE_LOG("WOOD"),
    STRIPPED_JUNGLE_WOOD("WOOD"),
    STRIPPED_OAK_LOG("WOOD"),
    STRIPPED_OAK_WOOD("WOOD"),
    STRIPPED_SPRUCE_LOG("WOOD"),
    STRIPPED_SPRUCE_WOOD("WOOD"),
    STRUCTURE_BLOCK,
    STRUCTURE_VOID,
    SUGAR,
    SUGAR_CANE,
    SUNFLOWER("DOUBLE_PLANT"),
    SUSPICIOUS_STEW,
    SWEET_BERRIES,
    SWEET_BERRY_BUSH,
    TALL_GRASS("DOUBLE_PLANT", 2),
    TALL_SEAGRASS("TALL_GRASS"),
    TERRACOTTA("HARD_CLAY"),
    TIPPED_ARROW,
    TNT,
    TNT_MINECART("EXPLOSIVE_MINECART"),
    TORCH,
    TOTEM_OF_UNDYING("TOTEM"),
    TRADER_LLAMA_SPAWN_EGG("MONSTER_EGG"),
    TRAPPED_CHEST,
    TRIDENT,
    TRIPWIRE,
    TRIPWIRE_HOOK,
    TROPICAL_FISH("RAW_FISH"),
    TROPICAL_FISH_BUCKET("BUCKET"),
    TROPICAL_FISH_SPAWN_EGG("MONSTER_EGG"),
    TUBE_CORAL,
    TUBE_CORAL_BLOCK,
    TUBE_CORAL_FAN,
    TUBE_CORAL_WALL_FAN,
    TURTLE_EGG("MONSTER_EGG"),
    TURTLE_HELMET("LEATHER_HELMET"),
    TURTLE_SPAWN_EGG("MONSTER_EGG"),
    VEX_SPAWN_EGG("MONSTER_EGG"),
    VILLAGER_SPAWN_EGG("MONSTER_EGG", 120),
    VINDICATOR_SPAWN_EGG("MONSTER_EGG", 26),
    VINE,
    VOID_AIR("AIR"),
    WALL_SIGN,
    WALL_TORCH("TORCH", 1),
    WANDERING_TRADER_SPAWN_EGG("MONSTER_EGG"),
    WATER,
    WATER_BUCKET,
    WET_SPONGE("SPONGE", 1),
    WHEAT("CROPS", 7, "WHEAT"),
    WHEAT_SEEDS("SEEDS"),
    WHITE_BANNER("BANNER", 15),
    WHITE_BED("BED"),
    WHITE_CARPET("CARPET"),
    WHITE_CONCRETE("CONCRETE"),
    WHITE_CONCRETE_POWDER("CONCRETE_POWDER"),
    WHITE_DYE("BONE_MEAL", "INK_SACK", 15),
    WHITE_GLAZED_TERRACOTTA,
    WHITE_SHULKER_BOX,
    WHITE_STAINED_GLASS("STAINED_GLASS"),
    WHITE_STAINED_GLASS_PANE("STAINED_GLASS_PANE"),
    WHITE_TERRACOTTA("STAINED_CLAY"),
    WHITE_TULIP("RED_ROSE", 6),
    WHITE_WALL_BANNER("WALL_BANNER"),
    WHITE_WOOL("WOOL"),
    WITCH_SPAWN_EGG("MONSTER_EGG", 66),
    WITHER_ROSE,
    WITHER_SKELETON_SKULL("SKULL_ITEM", 1),
    WITHER_SKELETON_SPAWN_EGG("MONSTER_EGG", 5),
    WITHER_SKELETON_WALL_SKULL("SKULL", 1),
    WOLF_SPAWN_EGG("MONSTER_EGG", 95),
    WOODEN_AXE("WOOD_AXE"),
    WOODEN_HOE("WOOD_HOE"),
    WOODEN_PICKAXE("WOOD_PICKAXE"),
    WOODEN_SHOVEL("WOOD_SPADE"),
    WOODEN_SWORD("WOOD_SWORD"),
    WRITABLE_BOOK("BOOK_AND_QUILL"),
    WRITTEN_BOOK,
    YELLOW_BANNER("BANNER", 11),
    YELLOW_BED("BED"),
    YELLOW_CARPET("CARPET", 4),
    YELLOW_CONCRETE("CONCRETE", 4),
    YELLOW_CONCRETE_POWDER("CONCRETE_POWDER", 4),
    YELLOW_DYE("DANDELION_YELLOW", "INK_SACK", 11),
    YELLOW_GLAZED_TERRACOTTA,
    YELLOW_SHULKER_BOX,
    YELLOW_STAINED_GLASS("STAINED_GLASS", 4),
    YELLOW_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 4),
    YELLOW_TERRACOTTA("STAINED_CLAY", 4),
    YELLOW_WALL_BANNER("WALL_BANNER"),
    YELLOW_WOOL("WOOL", 4),
    ZOMBIE_HEAD("SKULL_ITEM", 2),
    ZOMBIE_HORSE_SPAWN_EGG("MONSTER_EGG", 29),
    ZOMBIE_PIGMAN_SPAWN_EGG("MONSTER_EGG", 57),
    ZOMBIE_SPAWN_EGG("MONSTER_EGG", 54),
    ZOMBIE_VILLAGER_SPAWN_EGG("MONSTER_EGG", 27),
    ZOMBIE_WALL_HEAD("SKULL");

    private static final MaterialVersion version = Objects.nonNull(Material.getMaterial("GREEN_DYE")) ? MaterialVersion.v1_14 : Objects.nonNull(Material.getMaterial("WHITE_WOOL"))
            ? MaterialVersion.v1_13 : MaterialVersion.v1_12;

    private String newMaterial;
    private final String oldMaterial;
    private byte oldData;
    private String oldMaterial2;

    MultiMaterial() {
        this.oldMaterial = this.toString();
    }

    MultiMaterial(String oldMaterial) {
        this.oldMaterial = oldMaterial;
    }

    MultiMaterial(String oldMaterial, int oldData) {
        this.oldMaterial = oldMaterial;
        this.oldData = (byte) oldData;
    }

    MultiMaterial(String newMaterial, String oldMaterial) {
        this.newMaterial = newMaterial;
        this.oldMaterial = oldMaterial;
    }

    MultiMaterial(String newMaterial, String oldMaterial, int oldData) {
        this.newMaterial = newMaterial;
        this.oldMaterial = oldMaterial;
        this.oldData = (byte) oldData;
    }

    MultiMaterial(String oldMaterial, int oldData, String oldMaterial2) {
        this.oldMaterial = oldMaterial;
        this.oldData = (byte) oldData;
        this.oldMaterial2 = oldMaterial2;
    }

    public static ItemStack itemFrom(String item) {
        if (item == null) {
            return null;
        }
        String[] itemArray = item.split(":");
        byte data = itemArray.length > 1 ? Byte.valueOf(itemArray[1]) : 0;
        MultiMaterial multiMaterial = fromString(itemArray[0].toUpperCase(), data);
        return multiMaterial == null ? DIRT.getItem() : multiMaterial.getItem(1, data);
    }

    public static MultiMaterial fromString(String string) {
        return fromString(string, 0);
    }

    public static MultiMaterial fromString(String string, int data) {
        if (data != 0) {
            return search(string, data);
        }
        try {
            return valueOf(string);
        } catch (Exception e) {
            return search(string, data);
        }
    }

    private static MultiMaterial search(String string, int data) {
        for (MultiMaterial multiMaterial : values()) {
            if ((multiMaterial.getOldMaterial().equalsIgnoreCase(string) && multiMaterial.getData() == data) || (multiMaterial.getOldMaterial2() != null && multiMaterial.getOldMaterial2().equalsIgnoreCase(string))) {
                return multiMaterial;
            }
        }
        return null;
    }

    public static ImmutablePair<MultiMaterial, Byte> splitString(String string) {
        String[] split = string.split(":");
        byte data = split.length > 1 ? Byte.parseByte(split[1]) : 0;
        MultiMaterial multiMaterial = MultiMaterial.fromString(split[0], data);
        return new ImmutablePair<>(multiMaterial, data);
    }

    public static String toSplittableString(Material material, byte data) {
        return material.toString().toLowerCase().concat(":").concat(Byte.toString(data));
    }

    public static String toSplittableString(ItemStack itemStack) {
        return toSplittableString(itemStack.getType(), itemStack.getData().getData());
    }

    public String getOldMaterial() {
        return this.oldMaterial;
    }

    public String getOldMaterial2() {
        return this.oldMaterial2;
    }

    public Material getMaterial() {
        Material material = Material.getMaterial(version.equals(MaterialVersion.v1_14) ? this.toString() : version.equals(MaterialVersion.v1_13) ? this.newMaterial : this.oldMaterial);
        if (material == null) {
            material = Material.getMaterial(this.toString());
        }
        if (material == null) {
            material = Material.getMaterial(this.oldMaterial);
        }
        if (material == null) {
            material = Material.getMaterial(this.newMaterial);
        }
        if (material == null) {
            material = Material.DIRT;
        }
        return material;
    }

    public ImmutablePair<Material, Boolean> getItemMaterial() {
        boolean changed = false;
        Material material = Material.getMaterial(version.equals(MaterialVersion.v1_14) ? this.toString() : version.equals(MaterialVersion.v1_13) ? this.newMaterial : this.oldMaterial);
        if (material != null && material.isBlock()) {
            material = Material.getMaterial(this.oldMaterial2);
            changed = true;
        }
        if (material == null) {
            material = Material.getMaterial(this.toString());
        }
        if (material == null) {
            material = Material.getMaterial(this.oldMaterial);
            if (material != null && material.isBlock()) {
                material = Material.getMaterial(this.oldMaterial2);
                changed = true;
            }
        }
        if (material == null) {
            material = Material.getMaterial(this.newMaterial);
        }
        if (material == null) {
            material = Material.DIRT;
        }
        return ImmutablePair.of(material, changed);
    }

    public int getData() {
        return this.oldData;
    }

    public ItemStack getItem() {
        return this.getItem(1);
    }

    public ItemStack getItem(int amount) {
        return this.getItem(amount, 0);
    }

    public ItemStack getItem(int amount, int data) {
        ImmutablePair<Material, Boolean> pair = this.getItemMaterial();
        return version.equals(MaterialVersion.v1_12) ? new ItemStack(pair.getKey(), amount, pair.getValue() ? 0 : data == 0 ? oldData : (byte) data) : new ItemStack(pair.getKey());
    }

    private enum MaterialVersion {
        v1_14, v1_13, v1_12
    }
}
