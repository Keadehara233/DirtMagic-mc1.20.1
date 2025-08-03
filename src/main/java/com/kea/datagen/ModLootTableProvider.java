package com.kea.datagen;

import com.kea.block.ModBlocks;
import com.kea.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.DIRT_ORE,oreDrops(ModBlocks.DIRT_ORE,ModItems.RAW_DIRT));
        addDrop(ModBlocks.DEEPSLATE_DIRT_ORE,oreDrops(ModBlocks.DEEPSLATE_DIRT_ORE,ModItems.RAW_DIRT));
        addDrop(ModBlocks.DIRT_BLOCK);
        addDrop(ModBlocks.MAGIC_TRANSFORM_TABLE);
    }
}
