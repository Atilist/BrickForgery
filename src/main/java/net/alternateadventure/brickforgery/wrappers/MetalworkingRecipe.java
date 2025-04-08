package net.alternateadventure.brickforgery.wrappers;

import net.minecraft.item.ItemStack;

public class MetalworkingRecipe {
    private final ItemStack input;
    private final ItemStack output;

    public MetalworkingRecipe(ItemStack input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    public ItemStack getInput() {
        return input;
    }

    public ItemStack getOutput() {
        return output;
    }
}
