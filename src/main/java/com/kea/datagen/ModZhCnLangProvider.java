package com.kea.datagen;

import com.kea.block.ModBlocks;
import com.kea.item.ModItemGroups;
import com.kea.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModZhCnLangProvider extends FabricLanguageProvider {
    public ModZhCnLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput,"zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.DIRT_INGOT,"泥土锭");
        translationBuilder.add(ModItems.RAW_DIRT,"泥土矿");

        translationBuilder.add(ModBlocks.DIRT_ORE,"泥土矿石");
        translationBuilder.add(ModBlocks.DEEPSLATE_DIRT_ORE,"深层泥土矿石");

        translationBuilder.add(ModItemGroups.DIRTMAGIC,"泥土魔法");
    }
}
