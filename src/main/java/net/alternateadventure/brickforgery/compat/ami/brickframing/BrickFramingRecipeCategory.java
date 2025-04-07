package net.alternateadventure.brickforgery.compat.ami.brickframing;

import net.glasslauncher.mods.alwaysmoreitems.api.gui.AMIDrawable;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.GuiItemStackGroup;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.RecipeLayout;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeCategory;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import net.glasslauncher.mods.alwaysmoreitems.gui.DrawableHelper;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

public class BrickFramingRecipeCategory implements RecipeCategory {

    @NotNull
    private final AMIDrawable background = DrawableHelper.createDrawable("/assets/brickforgery/stationapi/gui/brick_frame_crafter.png", 8, 8, 160, 70);

    @NotNull
    @Override
    public String getUid() {
        return "brick_framing";
    }

    @NotNull
    @Override
    public String getTitle() {
        return "Brick Framing";
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
        int xOffset = 17;
        int yOffset = 8;
        guiItemStacks.init(0, true, xOffset, yOffset);
        guiItemStacks.init(1, true, xOffset + 54, yOffset);
        guiItemStacks.init(2, true, xOffset + 36, yOffset + 18);
        guiItemStacks.init(3, true, xOffset + 72, yOffset + 18);
        guiItemStacks.init(4, true, xOffset + 54, yOffset + 36);
        for (int i = 0; i < recipeWrapper.getInputs().size(); i++) {
            guiItemStacks.setFromRecipe(i, recipeWrapper.getInputs().get(i));
        }
        guiItemStacks.init(5, false, xOffset + 108, yOffset);
        guiItemStacks.setFromRecipe(5, recipeWrapper.getOutputs().get(0));
    }
}
