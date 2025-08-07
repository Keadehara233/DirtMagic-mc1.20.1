package com.kea.tag;

import com.kea.DirtMagic;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> ACCESSORIES = of("accessories");

    private static TagKey<Item> of(String id){
        return TagKey.of(RegistryKeys.ITEM,new Identifier(DirtMagic.MOD_ID,id));
    }
}
