package net.alternateadventure.brickforgery.compat.ami.alloysmelting;

import net.alternateadventure.brickforgery.wrappers.AlloySmeltingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeHandler;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class AlloySmeltingRecipeHandler implements RecipeHandler<AlloySmeltingRecipe> {

    @NotNull
    @Override
    public Class<AlloySmeltingRecipe> getRecipeClass() {
        return AlloySmeltingRecipe.class;
    }

    @NotNull
    @Override
    public String getRecipeCategoryUid() {
        return "alloy_smelting";
    }

    @NotNull
    @Override
    public RecipeWrapper getRecipeWrapper(@NotNull AlloySmeltingRecipe recipe) {
        return new AlloySmeltingRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@NotNull AlloySmeltingRecipe recipe) {
        return true;
    }
}
