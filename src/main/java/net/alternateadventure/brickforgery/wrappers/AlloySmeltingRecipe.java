package net.alternateadventure.brickforgery.wrappers;

import net.minecraft.item.ItemStack;

public class AlloySmeltingRecipe {
    private final ItemStack[] inputs;
    private final ItemStack output;

    public AlloySmeltingRecipe(ItemStack[] inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    public ItemStack[] getInputs() {
        return inputs;
    }

    public ItemStack getOutput() {
        return output;
    }
}
