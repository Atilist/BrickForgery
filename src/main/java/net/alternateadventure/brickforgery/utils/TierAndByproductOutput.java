package net.alternateadventure.brickforgery.utils;

import net.minecraft.item.ItemInstance;

public class TierAndByproductOutput {

    public TieredMachineRecipeData tieredMachineRecipeData;
    public ItemInstance byproduct;
    public double byproductChance;

    public TierAndByproductOutput(TieredMachineRecipeData tieredMachineRecipeData, ItemInstance byproduct, double byproductChance)
    {
        this.tieredMachineRecipeData = tieredMachineRecipeData;
        this.byproduct = byproduct;
        this.byproductChance = byproductChance;
    }
}
