package net.alternateadventure.brickforgery.interfaces;

import net.minecraft.item.ItemInstance;

public interface BlockWithOutput {

    boolean isValidOutputSide(int side);

    int getOutputSlotCount();

    ItemInstance getItemFromOutputSlot(int slot);

    void clearOutput(int slot);

    void setOutputItemCount(int slot, int count);

}
