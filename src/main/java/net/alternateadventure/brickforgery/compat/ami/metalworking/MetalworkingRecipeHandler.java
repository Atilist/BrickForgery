package net.alternateadventure.brickforgery.compat.ami.metalworking;

import net.alternateadventure.brickforgery.wrappers.MetalworkingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeHandler;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class MetalworkingRecipeHandler implements RecipeHandler<MetalworkingRecipe> {

    @NotNull
    @Override
    public Class<MetalworkingRecipe> getRecipeClass() {
        return MetalworkingRecipe.class;
    }

    @NotNull
    @Override
    public String getRecipeCategoryUid() {
        return "metalworking";
    }

    @NotNull
    @Override
    public RecipeWrapper getRecipeWrapper(@NotNull MetalworkingRecipe recipe) {
        return new MetalworkingRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@NotNull MetalworkingRecipe recipe) {
        return true;
    }
}
