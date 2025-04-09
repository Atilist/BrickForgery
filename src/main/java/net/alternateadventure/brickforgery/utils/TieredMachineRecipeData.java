package net.alternateadventure.brickforgery.utils;

import net.minecraft.item.ItemStack;

public class TieredMachineRecipeData {

    public TierEnum tierRequirement;
    public ItemStack output;

    public TieredMachineRecipeData(TierEnum tierRequirement, ItemStack output) {
        this.tierRequirement = tierRequirement;
        this.output = output;
    }
}
