package com.kea.datagen;

import com.kea.block.ModBlocks;
import com.kea.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

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
    }
}
