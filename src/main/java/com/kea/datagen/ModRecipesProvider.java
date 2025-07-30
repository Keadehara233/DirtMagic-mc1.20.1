package com.kea.datagen;

import com.kea.DirtMagic;
import com.kea.block.ModBlocks;
import com.kea.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesProvider extends FabricRecipeProvider {
    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    public static final List<ItemConvertible>
            DIRT_ORES = List.of(ModItems.RAW_DIRT, ModBlocks.DIRT_ORE,ModBlocks.DEEPSLATE_DIRT_ORE);

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerSmelting(consumer,DIRT_ORES,RecipeCategory.MISC,ModItems.DIRT_INGOT,
                0.7f,200,"dirt_ingot");
        offerBlasting(consumer,DIRT_ORES,RecipeCategory.MISC,ModItems.DIRT_INGOT,
                0.7f,100,"dirt_ingot");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_STICK,4)
                .pattern("W").pattern("W")
                .input('W', ModItems.DIRT_INGOT)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier(DirtMagic.MOD_ID,"dirt_stick"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_AXE,1)
                .pattern("WW ").pattern("WR ").pattern(" R ")
                .input('W',ModItems.DIRT_INGOT).input('R',ModItems.DIRT_STICK)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier(DirtMagic.MOD_ID,"dirt_axe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_SWORD,1)
                .pattern(" W ").pattern(" W ").pattern(" R ")
                .input('W',ModItems.DIRT_INGOT).input('R',ModItems.DIRT_STICK)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier(DirtMagic.MOD_ID,"dirt_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_PICKAXE,1)
                .pattern("WWW").pattern(" R ").pattern(" R ")
                .input('W',ModItems.DIRT_INGOT).input('R',ModItems.DIRT_STICK)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier(DirtMagic.MOD_ID,"dirt_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_SHOVEL,1)
                .pattern(" W ").pattern(" R ").pattern(" R ")
                .input('W',ModItems.DIRT_INGOT).input('R',ModItems.DIRT_STICK)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier(DirtMagic.MOD_ID,"dirt_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_HOE,1)
                .pattern("WW ").pattern(" R ").pattern(" R ")
                .input('W',ModItems.DIRT_INGOT).input('R',ModItems.DIRT_STICK)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier(DirtMagic.MOD_ID,"dirt_hoe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_HELMET,1)
                .pattern("WWW").pattern("W W").pattern("   ")
                .input('W',ModItems.DIRT_INGOT)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier("dirt_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_CHESTPLATE,1)
                .pattern("W W").pattern("WWW").pattern("WWW")
                .input('W',ModItems.DIRT_INGOT)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier("dirt_chestplate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_LEGGINGS,1)
                .pattern("WWW").pattern("W W").pattern("W W")
                .input('W',ModItems.DIRT_INGOT)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier("dirt_leggings"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_BOOTS,1)
                .pattern("   ").pattern("W W").pattern("W W")
                .input('W',ModItems.DIRT_INGOT)
                .criterion(hasItem(ModItems.DIRT_INGOT),conditionsFromItem(ModItems.DIRT_INGOT))
                .offerTo(consumer,new Identifier("dirt_boots"));
    }
}
