package net.alternateadventure.brickforgery.compat.ami.brickforging;

import net.alternateadventure.brickforgery.wrappers.BrickForgingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeHandler;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class BrickForgingRecipeHandler implements RecipeHandler<BrickForgingRecipe> {

    @NotNull
    @Override
    public Class<BrickForgingRecipe> getRecipeClass() {
        return BrickForgingRecipe.class;
    }

    @NotNull
    @Override
    public String getRecipeCategoryUid() {
        return "brick_forging";
    }

    @NotNull
    @Override
    public RecipeWrapper getRecipeWrapper(@NotNull BrickForgingRecipe recipe) {
        return new BrickForgingRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@NotNull BrickForgingRecipe recipe) {
        return true;
    }
}

