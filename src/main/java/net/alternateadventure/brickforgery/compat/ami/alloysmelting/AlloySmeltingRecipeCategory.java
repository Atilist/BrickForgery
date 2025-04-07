package net.alternateadventure.brickforgery.compat.ami.alloysmelting;

import net.glasslauncher.mods.alwaysmoreitems.api.gui.AMIDrawable;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.GuiItemStackGroup;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.RecipeLayout;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeCategory;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import net.glasslauncher.mods.alwaysmoreitems.gui.DrawableHelper;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

public class AlloySmeltingRecipeCategory implements RecipeCategory {

    @NotNull
    private final AMIDrawable background = DrawableHelper.createDrawable("/assets/brickforgery/stationapi/gui/alloysmelter.png", 8, 8, 160, 70);

    @NotNull
    @Override
    public String getUid() {
        return "alloy_smelting";
    }

    @NotNull
    @Override
    public String getTitle() {
        return "Alloy Smelting";
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
        for (int i = 0; i < recipeWrapper.getInputs().size(); i++) {
            guiItemStacks.init(i, true, xOffset + i * 18, yOffset);
        }
        for (int i = 0; i < recipeWrapper.getInputs().size(); i++) {
            guiItemStacks.setFromRecipe(i, recipeWrapper.getInputs().get(i));
        }
        guiItemStacks.init(3, false, 96 + xOffset, yOffset);
        guiItemStacks.setFromRecipe(3, recipeWrapper.getOutputs().get(0));
    }
}
