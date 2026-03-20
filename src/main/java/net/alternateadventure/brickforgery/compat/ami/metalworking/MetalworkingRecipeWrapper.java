package net.alternateadventure.brickforgery.compat.ami.metalworking;

import net.alternateadventure.brickforgery.wrappers.MetalworkingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MetalworkingRecipeWrapper implements RecipeWrapper {
    private final MetalworkingRecipe recipe;

    public MetalworkingRecipeWrapper(MetalworkingRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public List<?> getInputs() {
        return List.of(recipe.input());
    }

    @Override
    public List<?> getOutputs() {
        return List.of(recipe.output());
    }

    @Override
    public void drawInfo(@NotNull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {

    }

    @Override
    public void drawAnimations(@NotNull Minecraft minecraft, int recipeWidth, int recipeHeight) {
        minecraft.textRenderer.draw("Machine tier: " + recipe.tier().getName(), 5, 81, 0x7F7F7F);
        minecraft.textRenderer.draw("Machine tier: " + recipe.tier().getColourCode() + recipe.tier().getName(), 4, 80, 0x000000);
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
