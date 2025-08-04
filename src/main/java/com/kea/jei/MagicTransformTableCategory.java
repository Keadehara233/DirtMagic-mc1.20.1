package com.kea.jei;

import com.kea.DirtMagic;
import com.kea.block.ModBlocks;
import com.kea.recipe.MagicTransformTableRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class MagicTransformTableCategory implements IRecipeCategory<MagicTransformTableRecipe> {
    public static final Identifier TEXTURE =
            new Identifier(DirtMagic.MOD_ID, "textures/gui/magic_transform_table_gui.png");
    private final IDrawable background;
    private final IDrawable animatedArrow;
    private final IDrawable icon;

    public MagicTransformTableCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 40, 20, 96, 43);
        this.animatedArrow = helper.drawableBuilder(TEXTURE, 176, 0, 26, 8)
                .buildAnimated(57, IDrawableAnimated.StartDirection.LEFT, false);
        this.icon = helper.createDrawableItemStack(new ItemStack(ModBlocks.MAGIC_TRANSFORM_TABLE));
    }

    @Override
    public @NotNull RecipeType<MagicTransformTableRecipe> getRecipeType() {
        return JEIDirtMagicPlugin.MAGIC_TRANSFORM_TYPE;
    }

    @Override
    public @NotNull Text getTitle() {
        return Text.literal("魔力转化");
    }

    @Override
    public void draw(MagicTransformTableRecipe recipe, IRecipeSlotsView recipeSlotsView,
                     DrawContext guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
        animatedArrow.draw(guiGraphics, 35, 18);
        Text displayText = Text.literal("2 秒").formatted(Formatting.DARK_GRAY);
        int textX = 76; int textY = 36;

        guiGraphics.drawText(
                MinecraftClient.getInstance().textRenderer,
                displayText, textX, textY, 0xFFFFFF, false
        );
    }

    @Override
    public int getWidth() {
        return 96;
    }

    @Override
    public int getHeight() {
        return 43;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MagicTransformTableRecipe recipe, IFocusGroup focuses) {
        if (recipe.getIngredients().isEmpty()) {
            DirtMagic.LOGGER.error("Recipe has no ingredients: {}", recipe.getId());
            return;
        }

        builder.addSlot(RecipeIngredientRole.INPUT, 16, 15).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 64, 15).addItemStack(recipe.getOutput(null));
    }
}
