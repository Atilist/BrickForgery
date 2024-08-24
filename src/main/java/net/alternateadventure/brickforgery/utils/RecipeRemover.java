package net.alternateadventure.brickforgery.utils;

import net.minecraft.block.BlockBase;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeRegistry;
import net.minecraft.recipe.SmeltingRecipeRegistry;

import java.util.List;
import java.util.Map;

public class RecipeRemover {
    @SuppressWarnings({"unchecked"})
    public static void removeRecipe(ItemBase item, int meta, boolean onlyRemoveFirst) {
        List<Recipe> recipes = RecipeRegistry.getInstance().getRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            Recipe recipe = recipes.get(i);
            if (recipe.getOutput().itemId == item.id) {
                //noinspection SimplifiableConditionalExpression
                if ((meta == -1) ? true : (recipe.getOutput().getDamage() == meta)) {
                    recipes.remove(i);
                    i--;
                    if (onlyRemoveFirst) {
                        return;
                    }
                }
            }
        }
    }

    public static void removeRecipe(ItemBase item, boolean onlyRemoveFirst) {
        removeRecipe(item, -1, onlyRemoveFirst);
    }

    public static void removeRecipe(ItemBase item) {
        removeRecipe(item, -1, false);
    }

    @SuppressWarnings({"unchecked"})
    public static void removeSmeltingRecipe(int id) {
        Map<Integer, ItemInstance> recipes = SmeltingRecipeRegistry.getInstance().getRecipes();
        recipes.remove(id);
    }

    public static void removeRecipe(BlockBase block) {
        List<Recipe> recipes = RecipeRegistry.getInstance().getRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            Recipe recipe = recipes.get(i);
            if (recipe.getOutput().itemId == block.id) {
                recipes.remove(i);
                i--;
            }
        }
    }
}
