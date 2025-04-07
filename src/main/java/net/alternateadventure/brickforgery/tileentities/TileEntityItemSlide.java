package net.alternateadventure.brickforgery.tileentities;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.interfaces.BlockWithInput;
import net.alternateadventure.brickforgery.interfaces.BlockWithOutput;
import net.alternateadventure.brickforgery.utils.ValueConverter;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class TileEntityItemSlide extends BlockEntity {

    public int inputCycle;
    public int outputCycle;
    public int timer;

    @Override
    public void tick() {
        timer++;
        if (timer >= 5)
        {
            moveItems();
            timer = 0;
            inputCycle++;
        }
    }

    public void moveItems() {
        int[] coordinateOffsets = ValueConverter.rotationToCoordinateOffset(world.getBlockMeta(x, y, z));

        BlockEntity inputMachine = world.getBlockEntity(x - coordinateOffsets[0], y, z - coordinateOffsets[1]);

        int range = 1;
        for (; range <= 4; range++) {
            if (world.getBlockId(x + range * coordinateOffsets[0], y, z + range * coordinateOffsets[1]) != BlockListener.itemElevatorChain.id && world.getBlockMeta(x + range * coordinateOffsets[0], y, z + range * coordinateOffsets[1]) != world.getBlockMeta(x, y, z)) break;
        }

        BlockEntity outputMachine = world.getBlockEntity(x + range * coordinateOffsets[0], y, z + range * coordinateOffsets[1]);

        if (inputMachine == null) return;
        if (outputMachine == null) return;
        if (!(inputMachine instanceof BlockWithOutput)) return;
        if (!(outputMachine instanceof BlockWithInput)) return;
        if (!((BlockWithOutput) inputMachine).isValidOutputSide(world.getBlockMeta(x, y, z))) return;
        if (!((BlockWithInput) outputMachine).isValidInputSide(world.getBlockMeta(x, y, z))) return;
        if (!(inputCycle < ((BlockWithOutput) inputMachine).getOutputSlotCount())) inputCycle = 0;
        if (!(outputCycle < ((BlockWithInput) outputMachine).getInputSlotCount())) outputCycle = 0;

        ItemStack transferItem = ((BlockWithOutput) inputMachine).getItemFromOutputSlot(inputCycle);
        ItemStack destinationItem = ((BlockWithInput) outputMachine).getItemFromInputSlot(outputCycle);

        if (transferItem == null) return;
        if (destinationItem == null)
        {
            insertIntoEmptyMachine(transferItem, inputMachine, outputMachine);
            return;
        }
        else if (destinationItem.isItemEqual(transferItem) && destinationItem.count < destinationItem.getMaxCount())
        {
            insertIntoPartiallyFilledMachine(transferItem, destinationItem, inputMachine, outputMachine);
            return;
        }
        outputCycle++;
    }

    public void insertIntoEmptyMachine(ItemStack transferItem, BlockEntity inputMachine, BlockEntity outputMachine) {
        ((BlockWithInput) outputMachine).setInputItem(outputCycle, transferItem);
        ((BlockWithOutput) inputMachine).clearOutput(inputCycle);
    }

    public void insertIntoPartiallyFilledMachine(ItemStack transferItem, ItemStack destinationItem, BlockEntity inputMachine, BlockEntity outputMachine) {
        int totalItems = transferItem.count + destinationItem.count;
        if (totalItems <= destinationItem.getMaxCount())
        {
            ((BlockWithInput) outputMachine).setInputItemCount(outputCycle, totalItems);
            ((BlockWithOutput) inputMachine).clearOutput(inputCycle);
        }
        else
        {
            ((BlockWithInput) outputMachine).setInputItemCount(outputCycle, destinationItem.getMaxCount());
            ((BlockWithOutput) inputMachine).setOutputItemCount(inputCycle, totalItems - destinationItem.getMaxCount());
        }
    }

    @Override
    public void readNbt(NbtCompound compoundTag) {
        super.readNbt(compoundTag);
        inputCycle = compoundTag.getInt("InputCycle");
        outputCycle = compoundTag.getInt("OutputCycle");
        timer = compoundTag.getInt("Timer");
    }

    @Override
    public void writeNbt(NbtCompound compoundTag) {
        super.writeNbt(compoundTag);
        compoundTag.putInt("InputCycle", inputCycle);
        compoundTag.putInt("OutputCycle", outputCycle);
        compoundTag.putInt("Timer", timer);
    }
}