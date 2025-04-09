package net.alternateadventure.brickforgery.mixin;

import net.alternateadventure.brickforgery.interfaces.BlockWithInput;
import net.alternateadventure.brickforgery.interfaces.BlockWithOutput;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ChestBlockEntity.class)
@Unique
public class ChestAutomationMixin implements BlockWithInput, BlockWithOutput {

    @Shadow private ItemStack[] inventory;

    @Override
    public boolean isValidInputSide(int side) {
        return true;
    }

    @Override
    public int getInputSlotCount() {
        return 27;
    }

    @Override
    public ItemStack getItemFromInputSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public void setInputItem(int slot, ItemStack itemInstance) {
        inventory[slot] = itemInstance;
    }

    @Override
    public void setInputItemCount(int slot, int count) {
        inventory[slot].count = count;
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
    public ItemStack getItemFromOutputSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public void clearOutput(int slot) {
        inventory[slot] = null;
    }

    @Override
    public void setOutputItemCount(int slot, int count) {
        inventory[slot].count = count;
    }
}
