package net.alternateadventure.brickforgery.utils;

import net.minecraft.item.ItemInstance;

public class TierAndByproductOutput {

    public TieredMachineRecipeData tieredMachineRecipeData;
    public ItemInstance byproduct;

    public TierAndByproductOutput(TieredMachineRecipeData tieredMachineRecipeData, ItemInstance byproduct)
    {
        this.tieredMachineRecipeData = tieredMachineRecipeData;
        this.byproduct = byproduct;
    }
}
