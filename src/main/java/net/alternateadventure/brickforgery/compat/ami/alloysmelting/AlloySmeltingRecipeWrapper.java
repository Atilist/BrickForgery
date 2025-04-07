package net.alternateadventure.brickforgery.compat.ami.alloysmelting;

import net.alternateadventure.brickforgery.wrappers.AlloySmeltingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AlloySmeltingRecipeWrapper implements RecipeWrapper {
    private final AlloySmeltingRecipe recipe;

    public AlloySmeltingRecipeWrapper(AlloySmeltingRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public List<?> getInputs() {
        return List.of(recipe.getInputs());
    }

    @Override
    public List<?> getOutputs() {
        return List.of(recipe.getOutput());
    }

    @Override
    public void drawInfo(@NotNull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {

    }

    @Override
    public void drawAnimations(@NotNull Minecraft minecraft, int recipeWidth, int recipeHeight) {

    }

    @Nullable
    @Override
    public ArrayList<Object> getTooltip(int mouseX, int mouseY) {
        return null;
    }

    @Override
    public boolean handleClick(@NotNull Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return false;
    }
}
