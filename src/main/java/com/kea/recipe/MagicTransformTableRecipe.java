package com.kea.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public class MagicTransformTableRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final List<Ingredient> recipeItems;

    public MagicTransformTableRecipe(Identifier id, ItemStack output, List<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return recipeItems.isEmpty() ? DefaultedList.ofSize(1, Ingredient.EMPTY) : (DefaultedList<Ingredient>) recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient){
            return false;
        }
        return recipeItems.get(0).test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<MagicTransformTableRecipe>{
        public static final Type INSTANCE = new Type();
        public static final String ID = "magic_transform_table";
    }

    public static class Serializer implements RecipeSerializer<MagicTransformTableRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "magic_transform_table";

        @Override
        public MagicTransformTableRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json,"output"));
            JsonArray ingredients = JsonHelper.getArray(json,"ingredients");
            if (ingredients.isEmpty()) {
                throw new JsonSyntaxException("Recipe must have at least one ingredient");
            }
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1,Ingredient.EMPTY);
            for (int i = 0; i< inputs.size(); i++){
                inputs.set(i,Ingredient.fromJson(ingredients.get(i)));
            }
            return new MagicTransformTableRecipe(id,output,inputs);
        }

        @Override
        public MagicTransformTableRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1,Ingredient.EMPTY);
            for (int i = 0; i< inputs.size(); i++){
                inputs.set(i,Ingredient.fromPacket(buf));
            }
            ItemStack output = buf.readItemStack();
            return new MagicTransformTableRecipe(id,output,inputs);
        }

        @Override
        public void write(PacketByteBuf buf, MagicTransformTableRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient: recipe.getIngredients()){
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.getOutput(null));
        }

        public static class Type implements RecipeType<MagicTransformTableRecipe> {
            public static final String ID = "magic_transform_table";
            @Override
            public String toString() {
                return ID;
            }
        }
    }
}
