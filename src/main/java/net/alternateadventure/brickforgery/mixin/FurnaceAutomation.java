package net.alternateadventure.brickforgery.mixin;

import net.alternateadventure.brickforgery.interfaces.BlockWithInput;
import net.alternateadventure.brickforgery.interfaces.BlockWithOutput;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityFurnace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(TileEntityFurnace.class)
@Unique
public class FurnaceAutomation implements BlockWithInput, BlockWithOutput {

    @Shadow
    private ItemInstance[] inventory;

    @Override
    public boolean isValidInputSide(int side) {
        return true;
    }

    @Override
    public int getInputSlotCount() {
        return 1;
    }

    @Override
    public ItemInstance getItemFromInputSlot(int slot) {
        return inventory[0];
    }

    @Override
    public void setInputItem(int slot, ItemInstance itemInstance) {
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
    public ItemInstance getItemFromOutputSlot(int slot) {
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
