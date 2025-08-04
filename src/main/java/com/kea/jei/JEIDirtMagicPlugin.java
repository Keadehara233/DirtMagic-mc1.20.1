package com.kea.jei;

import com.kea.DirtMagic;
import com.kea.block.ModBlocks;
import com.kea.recipe.MagicTransformTableRecipe;
import com.kea.screen.MagicTransformTableScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class JEIDirtMagicPlugin implements IModPlugin {
    public static final RecipeType<MagicTransformTableRecipe> MAGIC_TRANSFORM_TYPE =
            RecipeType.create(DirtMagic.MOD_ID, MagicTransformTableRecipe.Type.ID, MagicTransformTableRecipe.class);

    @Override
    public @NotNull Identifier getPluginUid() {
        return new Identifier(DirtMagic.MOD_ID,"dirtmagic");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new MagicTransformTableCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(MinecraftClient.getInstance().world).getRecipeManager();
        List<MagicTransformTableRecipe> recipes = manager.listAllOfType(MagicTransformTableRecipe.Type.INSTANCE);

        for (MagicTransformTableRecipe recipe : recipes) {
            if (recipe.getIngredients().isEmpty()) {
                DirtMagic.LOGGER.warn("Invalid recipe with no ingredients: {}", recipe.getId());
            }
        }

        registration.addRecipes(MAGIC_TRANSFORM_TYPE, recipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(
                new ItemStack(ModBlocks.MAGIC_TRANSFORM_TABLE),
                MAGIC_TRANSFORM_TYPE
        );
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(
                MagicTransformTableScreen.class,
                75, 38,
                26, 8,
                MAGIC_TRANSFORM_TYPE
        );
    }
}
