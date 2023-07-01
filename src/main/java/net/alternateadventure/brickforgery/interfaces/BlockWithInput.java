package net.alternateadventure.brickforgery.interfaces;

import net.minecraft.item.ItemInstance;

public interface BlockWithInput {

    boolean isValidInputSide(int side);

    int getInputSlotCount();

    ItemInstance getItemFromInputSlot(int slot);

    void setInputItem(int slot, ItemInstance itemInstance);

    void setInputItemCount(int slot, int count);

}
