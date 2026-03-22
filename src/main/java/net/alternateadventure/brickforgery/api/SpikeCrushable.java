package net.alternateadventure.brickforgery.api;

import net.minecraft.item.ItemStack;

public interface SpikeCrushable {

    ItemStack crushingOutput();

    int requiredDistance();

}
