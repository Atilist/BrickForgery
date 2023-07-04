package net.alternateadventure.brickforgery.tileentities;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.interfaces.BlockWithInput;
import net.alternateadventure.brickforgery.interfaces.BlockWithOutput;
import net.alternateadventure.brickforgery.utils.ValueConverter;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.io.CompoundTag;

public class TileEntityItemSlide extends TileEntityBase {

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

    public void moveItems()
    {
        int[] coordinateOffsets = ValueConverter.rotationToCoordinateOffset(level.getTileMeta(x, y, z));

        TileEntityBase inputMachine = level.getTileEntity(x - coordinateOffsets[0], y, z - coordinateOffsets[1]);

        int range = 1;
        for (; range <= 4; range++) {
            if (level.getTileId(x + range * coordinateOffsets[0], y, z + range * coordinateOffsets[1]) != BlockListener.itemElevatorChain.id && level.getTileMeta(x + range * coordinateOffsets[0], y, z + range * coordinateOffsets[1]) != level.getTileMeta(x, y, z)) break;
        }

        TileEntityBase outputMachine = level.getTileEntity(x + range * coordinateOffsets[0], y, z + range * coordinateOffsets[1]);

        if (inputMachine == null) return;
        if (outputMachine == null) return;
        if (!(inputMachine instanceof BlockWithOutput)) return;
        if (!(outputMachine instanceof BlockWithInput)) return;
        if (!((BlockWithOutput) inputMachine).isValidOutputSide(level.getTileMeta(x, y, z))) return;
        if (!((BlockWithInput) outputMachine).isValidInputSide(level.getTileMeta(x, y, z))) return;
        if (!(inputCycle < ((BlockWithOutput) inputMachine).getOutputSlotCount())) inputCycle = 0;
        if (!(outputCycle < ((BlockWithInput) outputMachine).getInputSlotCount())) outputCycle = 0;

        ItemInstance transferItem = ((BlockWithOutput) inputMachine).getItemFromOutputSlot(inputCycle);
        ItemInstance destinationItem = ((BlockWithInput) outputMachine).getItemFromInputSlot(outputCycle);

        if (transferItem == null) return;
        if (destinationItem == null)
        {
            insertIntoEmptyMachine(transferItem, inputMachine, outputMachine);
            return;
        }
        else if (destinationItem.isDamageAndIDIdentical(transferItem) && destinationItem.count < destinationItem.getMaxStackSize())
        {
            insertIntoPartiallyFilledMachine(transferItem, destinationItem, inputMachine, outputMachine);
            return;
        }
        outputCycle++;
    }

    public void insertIntoEmptyMachine(ItemInstance transferItem, TileEntityBase inputMachine, TileEntityBase outputMachine)
    {
        ((BlockWithInput) outputMachine).setInputItem(outputCycle, transferItem);
        ((BlockWithOutput) inputMachine).clearOutput(inputCycle);
    }

    public void insertIntoPartiallyFilledMachine(ItemInstance transferItem, ItemInstance destinationItem, TileEntityBase inputMachine, TileEntityBase outputMachine)
    {
        int totalItems = transferItem.count + destinationItem.count;
        if (totalItems <= destinationItem.getMaxStackSize())
        {
            ((BlockWithInput) outputMachine).setInputItemCount(outputCycle, totalItems);
            ((BlockWithOutput) inputMachine).clearOutput(inputCycle);
        }
        else
        {
            ((BlockWithInput) outputMachine).setInputItemCount(outputCycle, destinationItem.getMaxStackSize());
            ((BlockWithOutput) inputMachine).setOutputItemCount(inputCycle, totalItems - destinationItem.getMaxStackSize());
        }
    }

    public void readIdentifyingData(CompoundTag compoundTag) {
        super.readIdentifyingData(compoundTag);
        inputCycle = compoundTag.getInt("InputCycle");
        outputCycle = compoundTag.getInt("OutputCycle");
        timer = compoundTag.getInt("Timer");
    }

    public void writeIdentifyingData(CompoundTag compoundTag) {
        super.writeIdentifyingData(compoundTag);
        compoundTag.put("InputCycle", inputCycle);
        compoundTag.put("OutputCycle", outputCycle);
        compoundTag.put("Timer", timer);
    }
}