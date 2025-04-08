package net.alternateadventure.brickforgery.wrappers;

import net.minecraft.item.ItemStack;

public class WashingRecipe {
    private final ItemStack input;
    private final ItemStack[] outputs;

    public WashingRecipe(ItemStack input, ItemStack[] outputs) {
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
