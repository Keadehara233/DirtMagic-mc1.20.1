package com.kea.block;

import com.kea.DirtMagic;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block DIRT_ORE = register("dirt_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));

    public static final Block DEEPSLATE_DIRT_ORE = register("deepslate_dirt_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)));

    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK,new Identifier(DirtMagic.MOD_ID,id), block);
    }
    public static void registerBlockItems(String id,Block block){
        Registry.register(Registries.ITEM,new Identifier(DirtMagic.MOD_ID,id),
                new BlockItem(block,new Item.Settings()));
    }

    public static void registerModBlocks(){

    }
}
