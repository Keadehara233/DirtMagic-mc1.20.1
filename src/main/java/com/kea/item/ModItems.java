package com.kea.item;

import com.kea.DirtMagic;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DIRT_INGOT = registerItems("dirt_ingot",new Item(new Item.Settings()));

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
