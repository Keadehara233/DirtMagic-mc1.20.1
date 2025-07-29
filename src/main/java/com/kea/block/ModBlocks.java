package com.kea.block;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
    public static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, id, block);
    }
}
