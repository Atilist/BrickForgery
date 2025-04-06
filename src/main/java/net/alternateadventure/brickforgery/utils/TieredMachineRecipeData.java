package net.alternateadventure.brickforgery.utils;

import net.minecraft.item.ItemStack;

public class TieredMachineRecipeData
{

    public int tierRequirement;
    public ItemStack output;

    public TieredMachineRecipeData(int tierRequirement, ItemStack output)
    {
        this.tierRequirement = tierRequirement;
        this.output = output;
    }
}
