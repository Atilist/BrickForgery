package net.alternateadventure.brickforgery.compat.ami.crushing;

import net.glasslauncher.mods.alwaysmoreitems.api.gui.AMIDrawable;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.GuiItemStackGroup;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.RecipeLayout;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeCategory;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import net.glasslauncher.mods.alwaysmoreitems.gui.DrawableHelper;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

public class CrushingRecipeCategory implements RecipeCategory {

    @NotNull
    private final AMIDrawable background = DrawableHelper.createDrawable("/assets/brickforgery/stationapi/gui/crusher.png", 8, 8, 160, 70);

    @NotNull
    @Override
    public String getUid() {
        return "crushing";
    }

    @NotNull
    @Override
    public String getTitle() {
        return "Crushing";
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
        int yOffset = 26;
        guiItemStacks.init(0, true, 36 + xOffset, yOffset);
        guiItemStacks.setFromRecipe(0, recipeWrapper.getInputs().get(0));
        guiItemStacks.init(2, false, 96 + xOffset, yOffset);
        guiItemStacks.setFromRecipe(2, recipeWrapper.getOutputs().get(0));
        if (recipeWrapper.getOutputs().size() > 1) {
            guiItemStacks.init(3, false, 96 + xOffset, yOffset + 26);
            guiItemStacks.setFromRecipe(3, recipeWrapper.getOutputs().get(1));
        }
    }
}

