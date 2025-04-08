package net.alternateadventure.brickforgery.wrappers;

import net.minecraft.item.ItemStack;

public class SlicingRecipe {
    private final ItemStack input;
    private final ItemStack output;

    public SlicingRecipe(ItemStack input, ItemStack output) {
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
