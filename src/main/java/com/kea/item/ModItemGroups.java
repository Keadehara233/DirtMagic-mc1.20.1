package com.kea.item;

import com.kea.DirtMagic;
import com.kea.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> DIRTMAGIC = register("dirtmagic");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(DirtMagic.MOD_ID,id));
    }

    public static void registerGroups(){
        Registry.register(Registries.ITEM_GROUP,
                DIRTMAGIC,ItemGroup.create(ItemGroup.Row.TOP,7).
                        displayName(Text.translatable("itemgroup.dirtmagic"))
                        .icon(() -> new ItemStack(ModItems.DIRT_INGOT))
                        .entries(((displayContext, entries) -> {
                            entries.add(ModItems.DIRT_INGOT);
                            entries.add(ModBlocks.DIRT_BLOCK);
                            entries.add(ModBlocks.DIRT_ORE);
                            entries.add(ModBlocks.DEEPSLATE_DIRT_ORE);
                            entries.add(ModItems.RAW_DIRT);
                            entries.add(ModItems.DIRT_PICKAXE);
                            entries.add(ModItems.DIRT_SWORD);
                            entries.add(ModItems.DIRT_AXE);
                            entries.add(ModItems.DIRT_SHOVEL);
                            entries.add(ModItems.DIRT_HOE);
                            entries.add(ModItems.DIRT_STICK);
                            entries.add(ModItems.DIRT_HELMET);
                            entries.add(ModItems.DIRT_CHESTPLATE);
                            entries.add(ModItems.DIRT_LEGGINGS);
                            entries.add(ModItems.DIRT_BOOTS);
                            entries.add(ModItems.MAGIC_DUST);
                            entries.add(ModItems.ENDER_MAGIC_DUST);
                            entries.add(ModBlocks.MAGIC_TRANSFORM_TABLE);
                            entries.add(ModItems.WAND_OF_DIRT);
                        })).build());
    }
}
