package me.javadebug.simplespigot.block.queue;

import org.bukkit.block.Block;

public interface BlockQueue {

    void queue(Block block);

    void queue(Block... blocks);

    void execute();
}
