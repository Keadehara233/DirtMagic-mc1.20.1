package com.kea.item;

import com.kea.DirtMagic;
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
                        })).build());
    }
}
