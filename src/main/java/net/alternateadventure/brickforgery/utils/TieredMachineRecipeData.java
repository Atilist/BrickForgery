package net.alternateadventure.brickforgery.utils;

import net.minecraft.item.ItemInstance;

public class TieredMachineRecipeData
{

    public int tierRequirement;
    public ItemInstance output;

    public TieredMachineRecipeData(int tierRequirement, ItemInstance output)
    {
        this.tierRequirement = tierRequirement;
        this.output = output;
    }
}
