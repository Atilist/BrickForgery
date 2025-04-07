package net.alternateadventure.brickforgery.compat.ami.crushing;

import net.alternateadventure.brickforgery.wrappers.CrushingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeHandler;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class CrushingRecipeHandler implements RecipeHandler<CrushingRecipe> {

    @NotNull
    @Override
    public Class<CrushingRecipe> getRecipeClass() {
        return CrushingRecipe.class;
    }

    @NotNull
    @Override
    public String getRecipeCategoryUid() {
        return "crushing";
    }

    @NotNull
    @Override
    public RecipeWrapper getRecipeWrapper(@NotNull CrushingRecipe recipe) {
        return new CrushingRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@NotNull CrushingRecipe recipe) {
        return true;
    }
}
