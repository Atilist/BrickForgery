package net.alternateadventure.brickforgery.interfaces;

import net.minecraft.item.ItemStack;

public interface BlockWithInput {

    boolean isValidInputSide(int side);

    int getInputSlotCount();

    ItemStack getItemFromInputSlot(int slot);

    void setInputItem(int slot, ItemStack ItemStack);

    void setInputItemCount(int slot, int count);

}
