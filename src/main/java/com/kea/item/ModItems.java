package com.kea.item;

import com.kea.DirtMagic;
import com.kea.item.wands.DirtWand;
import com.kea.trinkets.AnkletOfWind;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DIRT_INGOT = registerItems("dirt_ingot",new Item(new Item.Settings()));

    public static final Item RAW_DIRT = registerItems("raw_dirt",new Item(new Item.Settings()));

    public static final Item DIRT_STICK = registerItems("dirt_stick",new Item(new Item.Settings()));

    public static final Item DIRT_SWORD = registerItems("dirt_sword",
            new SwordItem(ModToolMaterials.DIRT,3,-2.4f,new Item.Settings()));

    public static final Item DIRT_PICKAXE = registerItems("dirt_pickaxe",
            new PickaxeItem(ModToolMaterials.DIRT,1,-2.8f,new Item.Settings()));

    public static final Item DIRT_AXE = registerItems("dirt_axe",
            new AxeItem(ModToolMaterials.DIRT,6,-3.1f,new Item.Settings()));

    public static final Item DIRT_SHOVEL = registerItems("dirt_shovel",
            new ShovelItem(ModToolMaterials.DIRT,1.5f,-3f,new Item.Settings()));

    public static final Item DIRT_HOE = registerItems("dirt_hoe",
            new HoeItem(ModToolMaterials.DIRT,-1,-2f,new Item.Settings()));

    public static final Item DIRT_HELMET = registerItems("dirt_helmet",
            new ArmorItem(ModArmorMaterials.DIRT,ArmorItem.Type.HELMET,new Item.Settings()));

    public static final Item DIRT_CHESTPLATE = registerItems("dirt_chestplate",
            new ArmorItem(ModArmorMaterials.DIRT,ArmorItem.Type.CHESTPLATE,new Item.Settings()));

    public static final Item DIRT_LEGGINGS = registerItems("dirt_leggings",
            new ArmorItem(ModArmorMaterials.DIRT,ArmorItem.Type.LEGGINGS,new Item.Settings()));

    public static final Item DIRT_BOOTS = registerItems("dirt_boots",
            new ArmorItem(ModArmorMaterials.DIRT,ArmorItem.Type.BOOTS,new Item.Settings()));

    public static final Item MAGIC_DUST = registerItems("magic_dust",new Item(new Item.Settings()));

    public static final Item ENDER_MAGIC_DUST = registerItems("ender_magic_dust",new Item(new Item.Settings()));

    public static final Item WAND_OF_DIRT = registerItems("wand_of_dirt",
            new DirtWand(new Item.Settings().maxCount(1)));

    public static final Item ANKLET_OF_WIND = registerItems("anklet_of_wind",
            new AnkletOfWind(new Item.Settings().maxCount(1)));

    public static Item registerItems(String id,Item item) {
        return Registry.register(Registries.ITEM,RegistryKey.of(Registries.ITEM.getKey(),
                new Identifier(DirtMagic.MOD_ID,id)),item);
    }

    public static Item register(String id, Item item) {
        return register(new Identifier(id), item);
    }

    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    private static void ItemGroup(FabricItemGroupEntries entries){
        entries.add(DIRT_INGOT);
    }

    public static void registerItems(){
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.DIRTMAGIC).register(ModItems::ItemGroup);
    }
}
