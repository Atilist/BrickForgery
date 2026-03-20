package net.alternateadventure.brickforgery.compat.ami.brickforging;

import net.alternateadventure.brickforgery.wrappers.BrickForgingRecipe;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BrickForgingRecipeWrapper implements RecipeWrapper {
    private final BrickForgingRecipe recipe;

    public BrickForgingRecipeWrapper(BrickForgingRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public List<?> getInputs() {
        return recipe.inputs();
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

