package net.alternateadventure.brickforgery.compat.ami.washing;

import net.alternateadventure.brickforgery.wrappers.WashingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeHandler;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class WashingRecipeHandler implements RecipeHandler<WashingRecipe> {

    @NotNull
    @Override
    public Class<WashingRecipe> getRecipeClass() {
        return WashingRecipe.class;
    }

    @NotNull
    @Override
    public String getRecipeCategoryUid() {
        return "washing";
    }

    @NotNull
    @Override
    public RecipeWrapper getRecipeWrapper(@NotNull WashingRecipe recipe) {
        return new WashingRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@NotNull WashingRecipe recipe) {
        return true;
    }
}
