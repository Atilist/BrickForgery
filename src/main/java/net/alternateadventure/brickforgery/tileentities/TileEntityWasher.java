package net.alternateadventure.brickforgery.tileentities;

import net.alternateadventure.brickforgery.blocks.CrusherBase;
import net.alternateadventure.brickforgery.customrecipes.CrushingRecipeRegistry;
import net.alternateadventure.brickforgery.customrecipes.WashingRecipeRegistry;
import net.alternateadventure.brickforgery.utils.TierAndByproductOutput;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.io.CompoundTag;
import net.minecraft.util.io.ListTag;

import java.util.Random;

public class TileEntityWasher extends TileEntityBase implements InventoryBase {
    private Random random = new Random();
    private ItemInstance[] inventory = new ItemInstance[3];
    public int processingTime = 0;
    public int tier = 0;
    public boolean tierChecked = false;

    public TileEntityWasher() {
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
        return "Washer";
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

        this.processingTime = arg.getShort("ProcessingTime");
        this.tierChecked = arg.getBoolean("TierChecked");
        this.tier = arg.getInt("Tier");
    }

    public void writeIdentifyingData(CompoundTag arg) {
        super.writeIdentifyingData(arg);
        arg.put("ProcessingTime", (short)this.processingTime);
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
    public int getProcessingTimeDelta(int i) {
        return this.processingTime * i / 200;
    }

    @Override
    public void tick() {
        if (!tierChecked) checkTier();
        if (level.getTileMeta(x, y, z) != 1) return;
        if (level.getTileId(x, y + 1, z) != BlockBase.STILL_WATER.id && level.getTileId(x, y + 1, z) != BlockBase.FLOWING_WATER.id) return;

        boolean var2 = false;

        if (!this.level.isServerSide) {

            if (this.canAcceptRecipeOutput()) {
                ++this.processingTime;
                if (this.processingTime == 200) {
                    this.processingTime = 0;
                    this.craftRecipe();
                    var2 = true;
                }
            } else {
                this.processingTime = 0;
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
        if (blockBase instanceof CrusherBase)
        {
            tier = ((CrusherBase) blockBase).tier;
            tierChecked = true;
        }
    }

    private boolean canAcceptRecipeOutput() {
        if (this.inventory[0] == null) return false;
        TierAndByproductOutput washingOutput = WashingRecipeRegistry.getInstance().getResult(inventory[0].itemId);
        if (washingOutput == null) {
            return false;
        } else if (washingOutput.tieredMachineRecipeData.tierRequirement > tier) {
            return false;
        }
        if (!canAcceptByproduct(washingOutput.byproduct.copy())) return false;
        ItemInstance washedItem = washingOutput.tieredMachineRecipeData.output.copy();
        if (this.inventory[1] == null) {
            return true;
        } else if (!this.inventory[1].isDamageAndIDIdentical(washedItem)) {
            return false;
        } else {
            return this.inventory[1].count + washedItem.count < washedItem.getMaxStackSize();
        }

    }

    private boolean canAcceptByproduct(ItemInstance byproduct)
    {
        if (byproduct == null) return true;
        if (inventory[2] == null) return true;
        if (!inventory[2].isDamageAndIDIdentical(byproduct)) return false;
        if (byproduct.count + inventory[2].count > byproduct.getMaxStackSize()) return false;
        return true;
    }

    public void craftRecipe() {
        if (this.canAcceptRecipeOutput()) {
            TierAndByproductOutput washingOutput = WashingRecipeRegistry.getInstance().getResult(inventory[0].itemId);
            ItemInstance washedItem = washingOutput.tieredMachineRecipeData.output.copy();
            if (this.inventory[1] == null) {
                this.inventory[1] = washedItem;
            } else if (this.inventory[1].itemId == washedItem.itemId) {
                this.inventory[1].count += washedItem.count;
            }
            --this.inventory[0].count;
            if (this.inventory[0].count <= 0) {
                this.inventory[0] = null;
            }
            if (random.nextDouble(1.0) > washingOutput.byproductChance) return;
            ItemInstance byproduct = washingOutput.byproduct.copy();
            if (this.inventory[2] == null) {
                this.inventory[2] = byproduct;
            } else {
                this.inventory[2].count += byproduct.count;
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
}
