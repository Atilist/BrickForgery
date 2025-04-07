package net.alternateadventure.brickforgery.mixin;

import net.alternateadventure.brickforgery.interfaces.BlockWithInput;
import net.alternateadventure.brickforgery.interfaces.BlockWithOutput;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(FurnaceBlockEntity.class)
@Unique
public class FurnaceAutomation implements BlockWithInput, BlockWithOutput {

    @Shadow
    private ItemStack[] inventory;

    @Override
    public boolean isValidInputSide(int side) {
        return true;
    }

    @Override
    public int getInputSlotCount() {
        return 1;
    }

    @Override
    public ItemStack getItemFromInputSlot(int slot) {
        return inventory[0];
    }

    @Override
    public void setInputItem(int slot, ItemStack itemInstance) {
        inventory[0] = itemInstance;
    }

    @Override
    public void setInputItemCount(int slot, int count) {
        inventory[0].count = count;
    }

    @Override
    public boolean isValidOutputSide(int side) {
        return true;
    }

    @Override
    public int getOutputSlotCount() {
        return 1;
    }

    @Override
    public ItemStack getItemFromOutputSlot(int slot) {
        return inventory[2];
    }

    @Override
    public void clearOutput(int slot) {
        inventory[2] = null;
    }

    @Override
    public void setOutputItemCount(int slot, int count) {
        inventory[2].count = count;
    }
}
