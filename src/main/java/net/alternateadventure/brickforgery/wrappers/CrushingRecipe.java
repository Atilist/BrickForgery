package net.alternateadventure.brickforgery.wrappers;

import net.minecraft.item.ItemStack;

public class CrushingRecipe {
    private final ItemStack input;
    private final ItemStack[] outputs;

    public CrushingRecipe(ItemStack input, ItemStack[] outputs) {
        this.input = input;
        this.outputs = outputs;
    }

    public ItemStack getInput() {
        return input;
    }

    public ItemStack[] getOutputs() {
        return outputs;
    }
}
