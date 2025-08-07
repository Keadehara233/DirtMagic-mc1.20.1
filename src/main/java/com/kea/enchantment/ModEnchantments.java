package com.kea.enchantment;

import com.kea.DirtMagic;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static Enchantment FROST = Registry.register(Registries.ENCHANTMENT,
            new Identifier(DirtMagic.MOD_ID,"frost"),new FrostEnchantment());

    public static void registerModEnchantments(){

    }
}
