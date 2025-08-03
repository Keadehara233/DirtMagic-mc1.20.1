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
        translationBuilder.add(ModItems.DIRT_PICKAXE,"泥土镐");
        translationBuilder.add(ModItems.DIRT_SWORD,"泥土剑");
        translationBuilder.add(ModItems.DIRT_AXE,"泥土斧");
        translationBuilder.add(ModItems.DIRT_SHOVEL,"泥土铲");
        translationBuilder.add(ModItems.DIRT_HOE,"泥土锄");
        translationBuilder.add(ModItems.DIRT_STICK,"泥土棍");
        translationBuilder.add(ModItems.DIRT_HELMET,"泥土头盔");
        translationBuilder.add(ModItems.DIRT_CHESTPLATE,"泥土胸甲");
        translationBuilder.add(ModItems.DIRT_LEGGINGS,"泥土护腿");
        translationBuilder.add(ModItems.DIRT_BOOTS,"泥土靴子");
        translationBuilder.add(ModItems.MAGIC_DUST,"魔法粉尘");
        translationBuilder.add(ModItems.ENDER_MAGIC_DUST,"末影魔法粉尘");
        translationBuilder.add(ModItems.WAND_OF_DIRT,"泥土法杖");

        translationBuilder.add(ModBlocks.DIRT_ORE,"泥土矿石");
        translationBuilder.add(ModBlocks.DEEPSLATE_DIRT_ORE,"深层泥土矿石");
        translationBuilder.add(ModBlocks.DIRT_BLOCK,"泥土块");
        translationBuilder.add(ModBlocks.MAGIC_TRANSFORM_TABLE,"魔力转化台");

        translationBuilder.add(ModItemGroups.DIRTMAGIC,"泥土魔法");
    }
}
