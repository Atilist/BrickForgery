package net.alternateadventure.brickforgery.compat.ami.slicing;

import net.alternateadventure.brickforgery.wrappers.SlicingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeHandler;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class SlicingRecipeHandler implements RecipeHandler<SlicingRecipe> {

    @NotNull
    @Override
    public Class<SlicingRecipe> getRecipeClass() {
        return SlicingRecipe.class;
    }

    @NotNull
    @Override
    public String getRecipeCategoryUid() {
        return "slicing";
    }

    @NotNull
    @Override
    public RecipeWrapper getRecipeWrapper(@NotNull SlicingRecipe recipe) {
        return new SlicingRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@NotNull SlicingRecipe recipe) {
        return true;
    }
}
