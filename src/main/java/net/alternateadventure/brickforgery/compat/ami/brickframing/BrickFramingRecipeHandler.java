package net.alternateadventure.brickforgery.compat.ami.brickframing;

import net.alternateadventure.brickforgery.wrappers.BrickFramingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeHandler;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class BrickFramingRecipeHandler implements RecipeHandler<BrickFramingRecipe> {

    @NotNull
    @Override
    public Class<BrickFramingRecipe> getRecipeClass() {
        return BrickFramingRecipe.class;
    }

    @NotNull
    @Override
    public String getRecipeCategoryUid() {
        return "brick_framing";
    }

    @NotNull
    @Override
    public RecipeWrapper getRecipeWrapper(@NotNull BrickFramingRecipe recipe) {
        return new BrickFramingRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@NotNull BrickFramingRecipe recipe) {
        return true;
    }
}
