package net.alternateadventure.brickforgery.mixin;

import net.alternateadventure.brickforgery.interfaces.BlockWithInput;
import net.alternateadventure.brickforgery.interfaces.BlockWithOutput;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityChest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(TileEntityChest.class)
@Unique
public class ChestAutomation implements BlockWithInput, BlockWithOutput {

    @Shadow private ItemInstance[] contents;

    @Override
    public boolean isValidInputSide(int side) {
        return true;
    }

    @Override
    public int getInputSlotCount() {
        return 27;
    }

    @Override
    public ItemInstance getItemFromInputSlot(int slot) {
        return contents[slot];
    }

    @Override
    public void setInputItem(int slot, ItemInstance itemInstance) {
        contents[slot] = itemInstance;
    }

    @Override
    public void setInputItemCount(int slot, int count) {
        contents[slot].count = count;
    }

    @Override
    public boolean isValidOutputSide(int side) {
        return true;
    }

    @Override
    public int getOutputSlotCount() {
        return 27;
    }

    @Override
    public ItemInstance getItemFromOutputSlot(int slot) {
        return contents[slot];
    }

    @Override
    public void clearOutput(int slot) {
        contents[slot] = null;
    }

    @Override
    public void setOutputItemCount(int slot, int count) {
        contents[slot].count = count;
    }
}
