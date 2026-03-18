package net.alternateadventure.brickforgery.compat.ami.brickforging;

import net.glasslauncher.mods.alwaysmoreitems.api.gui.AMIDrawable;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.GuiItemStackGroup;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.RecipeLayout;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeCategory;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import net.glasslauncher.mods.alwaysmoreitems.gui.DrawableHelper;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

public class BrickForgingRecipeCategory implements RecipeCategory {

    @NotNull
    private final AMIDrawable background = DrawableHelper.createDrawable("/assets/brickforgery/stationapi/gui/brick_forge.png", 8, 8, 160, 70);

    @NotNull
    @Override
    public String getUid() {
        return "brick_forging";
    }

    @NotNull
    @Override
    public String getTitle() {
        return "Brick Forging";
    }

    @NotNull
    @Override
    public AMIDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
    }

    @Override
    public void drawAnimations(Minecraft minecraft) {

    }

    @Override
    public void setRecipe(@NotNull RecipeLayout recipeLayout, @NotNull RecipeWrapper recipeWrapper) {
        GuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
        int xOffset = 11;
        int yOffset = 25;
        int inputSize = recipeWrapper.getInputs().size();
        for (int i = 0; i < inputSize; i++) {
            guiItemStacks.init(i, true, xOffset + 18 * (i % 3), yOffset - 18 + 18 * (i / 3));
            guiItemStacks.setFromRecipe(i, recipeWrapper.getInputs().get(i));
        }
        guiItemStacks.init(inputSize, false, 96 + xOffset, yOffset);
        guiItemStacks.setFromRecipe(inputSize, recipeWrapper.getOutputs().get(0));
    }
}
