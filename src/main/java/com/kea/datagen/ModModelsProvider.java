package com.kea.datagen;

import com.kea.block.ModBlocks;
import com.kea.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIRT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_DIRT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIRT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_TRANSFORM_TABLE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DIRT_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_DIRT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_MAGIC_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANKLET_OF_WIND,Models.GENERATED);

        itemModelGenerator.register(ModItems.DIRT_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRT_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRT_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WAND_OF_DIRT, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIRT_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIRT_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIRT_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIRT_BOOTS);
    }
}
