package net.alternateadventure.brickforgery.utils;

import net.minecraft.item.ItemStack;

public class TierAndByproductOutput {

    public TieredMachineRecipeData tieredMachineRecipeData;
    public ItemStack byproduct;
    public double byproductChance;

    public TierAndByproductOutput(TieredMachineRecipeData tieredMachineRecipeData, ItemStack byproduct, double byproductChance) {
        this.tieredMachineRecipeData = tieredMachineRecipeData;
        this.byproduct = byproduct;
        this.byproductChance = byproductChance;
    }
}
