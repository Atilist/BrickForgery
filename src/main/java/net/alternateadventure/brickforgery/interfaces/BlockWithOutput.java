package net.alternateadventure.brickforgery.interfaces;

import net.minecraft.item.ItemStack;

public interface BlockWithOutput {

    boolean isValidOutputSide(int side);

    int getOutputSlotCount();

    ItemStack getItemFromOutputSlot(int slot);

    void clearOutput(int slot);

    void setOutputItemCount(int slot, int count);

}
