package me.javadebug.simplespigot.block;

import org.bukkit.block.Block;

public interface BlockQueue {

    void queue(Block block);

    void queue(Block... blocks);
}
