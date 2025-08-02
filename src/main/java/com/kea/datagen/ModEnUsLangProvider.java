package com.kea.datagen;

import com.kea.block.ModBlocks;
import com.kea.item.ModItemGroups;
import com.kea.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModEnUsLangProvider extends FabricLanguageProvider {
    public ModEnUsLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput,"en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.DIRT_INGOT,"Dirt Ingot");
        translationBuilder.add(ModItems.RAW_DIRT,"Raw Dirt");
        translationBuilder.add(ModItems.DIRT_PICKAXE,"Dirt Pickaxe");
        translationBuilder.add(ModItems.DIRT_SWORD,"Dirt Sword");
        translationBuilder.add(ModItems.DIRT_AXE,"Dirt Axe");
        translationBuilder.add(ModItems.DIRT_SHOVEL,"Dirt Shovel");
        translationBuilder.add(ModItems.DIRT_HOE,"Dirt Hoe");
        translationBuilder.add(ModItems.DIRT_STICK,"Dirt Stick");
        translationBuilder.add(ModItems.DIRT_HELMET,"Dirt Helmet");
        translationBuilder.add(ModItems.DIRT_CHESTPLATE,"Dirt Chestplate");
        translationBuilder.add(ModItems.DIRT_LEGGINGS,"Dirt Leggings");
        translationBuilder.add(ModItems.DIRT_BOOTS,"Dirt Boots");
        translationBuilder.add(ModItems.WAND_OF_DIRT,"Wand of Dirt");

        translationBuilder.add(ModBlocks.DIRT_ORE,"Dirt Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_DIRT_ORE,"Deepslate Dirt Ore");
        translationBuilder.add(ModBlocks.DIRT_BLOCK,"Dirt Block");

        translationBuilder.add(ModItemGroups.DIRTMAGIC,"Dirt Magic");
    }
}
