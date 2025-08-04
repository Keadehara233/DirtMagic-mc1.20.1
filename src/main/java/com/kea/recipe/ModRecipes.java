package com.kea.recipe;

import com.kea.DirtMagic;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registries.RECIPE_SERIALIZER,
                new Identifier(DirtMagic.MOD_ID,MagicTransformTableRecipe.Serializer.ID),
                MagicTransformTableRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE,
                new Identifier(DirtMagic.MOD_ID,MagicTransformTableRecipe.Type.ID),
                MagicTransformTableRecipe.Type.INSTANCE);
    }
}
