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

        translationBuilder.add(ModBlocks.DIRT_ORE,"Dirt Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_DIRT_ORE,"Deepslate Dirt Ore");

        translationBuilder.add(ModItemGroups.DIRTMAGIC,"Dirt Magic");
    }
}
