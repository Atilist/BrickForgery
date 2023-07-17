package net.alternateadventure.brickforgery.tileentities;

import net.alternateadventure.brickforgery.blocks.SlicerBase;
import net.alternateadventure.brickforgery.customrecipes.SlicingRecipeRegistry;
import net.alternateadventure.brickforgery.interfaces.BlockWithInput;
import net.alternateadventure.brickforgery.interfaces.BlockWithOutput;
import net.alternateadventure.brickforgery.utils.TieredMachineRecipeData;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.io.CompoundTag;
import net.minecraft.util.io.ListTag;

public class TileEntitySlicer extends TileEntityBase implements InventoryBase, BlockWithOutput, BlockWithInput {
    private ItemInstance[] inventory = new ItemInstance[2];
    public int sliceTime = 0;
    public int tier = 0;
    public boolean tierChecked = false;

    public TileEntitySlicer() {
    }

    public int getInventorySize() {
        return this.inventory.length;
    }

    public ItemInstance getInventoryItem(int i) {
        return this.inventory[i];
    }

    public ItemInstance takeInventoryItem(int i, int j) {
        if (this.inventory[i] != null) {
            ItemInstance var3;
            if (this.inventory[i].count <= j) {
                var3 = this.inventory[i];
                this.inventory[i] = null;
                return var3;
            } else {
                var3 = this.inventory[i].split(j);
                if (this.inventory[i].count == 0) {
                    this.inventory[i] = null;
                }

                return var3;
            }
        } else {
            return null;
        }
    }

    public void setInventoryItem(int i, ItemInstance arg) {
        this.inventory[i] = arg;
        if (arg != null && arg.count > this.getMaxItemCount()) {
            arg.count = this.getMaxItemCount();
        }

    }

    public String getContainerName() {
        return "Slicer";
    }

    public void readIdentifyingData(CompoundTag arg) {
        super.readIdentifyingData(arg);
        ListTag var2 = arg.getListTag("Items");
        this.inventory = new ItemInstance[this.getInventorySize()];

        for(int var3 = 0; var3 < var2.size(); ++var3) {
            CompoundTag var4 = (CompoundTag)var2.get(var3);
            byte var5 = var4.getByte("Slot");
            if (var5 >= 0 && var5 < this.inventory.length) {
                this.inventory[var5] = new ItemInstance(var4);
            }
        }

        this.sliceTime = arg.getShort("SliceTime");
        this.tierChecked = arg.getBoolean("TierChecked");
        this.tier = arg.getInt("Tier");
    }

    public void writeIdentifyingData(CompoundTag arg) {
        super.writeIdentifyingData(arg);
        arg.put("SliceTime", (short)this.sliceTime);
        arg.put("TierChecked", tierChecked);
        arg.put("Tier", tier);
        ListTag var2 = new ListTag();

        for(int var3 = 0; var3 < this.inventory.length; ++var3) {
            if (this.inventory[var3] != null) {
                CompoundTag var4 = new CompoundTag();
                var4.put("Slot", (byte)var3);
                this.inventory[var3].toTag(var4);
                var2.add(var4);
            }
        }

        arg.put("Items", var2);
    }

    public int getMaxItemCount() {
        return 64;
    }

    @Environment(EnvType.CLIENT)
    public int getSliceTimeDelta(int i) {
        return this.sliceTime * i / 200;
    }

    public void tick() {
        if (!tierChecked) checkTier();
        if (level.getTileMeta(x, y, z) != 1) return;

        boolean var2 = false;

        if (!this.level.isServerSide) {

            if (this.canAcceptRecipeOutput()) {
                ++this.sliceTime;
                if (this.sliceTime == 200) {
                    this.sliceTime = 0;
                    this.craftRecipe();
                    var2 = true;
                }
            } else {
                this.sliceTime = 0;
            }
        }

        if (var2) {
            this.markDirty();
        }

    }

    public void checkTier()
    {
        if (level == null) return;
        BlockBase blockBase = BlockBase.BY_ID[level.getTileId(x, y, z)];
        if (blockBase == null) return;
        if (blockBase instanceof SlicerBase)
        {
            tier = ((SlicerBase) blockBase).tier;
            tierChecked = true;
        }
    }

    private boolean canAcceptRecipeOutput() {
        if (this.inventory[0] == null) return false;
            TieredMachineRecipeData slicingRecipeData = SlicingRecipeRegistry.getInstance().getResult(inventory[0].itemId);
            if (slicingRecipeData == null) {
                return false;
            } else if (slicingRecipeData.tierRequirement > tier) {
                return false;
            } else if (this.inventory[1] == null) {
                return true;
            } else if (!this.inventory[1].isDamageAndIDIdentical(slicingRecipeData.output)) {
                return false;
            } else if (this.inventory[1].count < this.getMaxItemCount() && this.inventory[1].count < this.inventory[1].getMaxStackSize()) {
                return true;
            } else {
                return this.inventory[1].count < slicingRecipeData.output.getMaxStackSize();
            }

    }

    public void craftRecipe() {
        if (this.canAcceptRecipeOutput()) {
            TieredMachineRecipeData slicingRecipeData = SlicingRecipeRegistry.getInstance().getResult(inventory[0].itemId);
            if (this.inventory[1] == null) {
                this.inventory[1] = slicingRecipeData.output.copy();
            } else if (this.inventory[1].itemId == slicingRecipeData.output.itemId) {
                ++this.inventory[1].count;
            }
            --this.inventory[0].count;
            if (this.inventory[0].count <= 0) {
                this.inventory[0] = null;
            }
        }
    }

    @Override
    public boolean canPlayerUse(PlayerBase arg) {
        if (this.level.getTileEntity(this.x, this.y, this.z) != this) {
            return false;
        } else {
            return !(arg.squaredDistanceTo((double)this.x + 0.5D, (double)this.y + 0.5D, (double)this.z + 0.5D) > 64.0D);
        }
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
        return inventory[1];
    }

    @Override
    public void clearOutput(int slot) {
        inventory[1] = null;
    }

    @Override
    public void setOutputItemCount(int slot, int count) {
        inventory[1].count = count;
    }

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
}
