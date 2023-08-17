package net.alternateadventure.brickforgery.tileentities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kozibrodka.wolves.recipe.MillingRecipeRegistry;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.io.CompoundTag;
import net.minecraft.util.io.ListTag;

public class TileEntityImprovedMillstone extends TileEntityBase implements InventoryBase {
    private ItemInstance[] inventory = new ItemInstance[6];
    public int millingTime = 0;

    public TileEntityImprovedMillstone() {
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

        for (int var3 = 0; var3 < var2.size(); ++var3) {
            CompoundTag var4 = (CompoundTag) var2.get(var3);
            byte var5 = var4.getByte("Slot");
            if (var5 >= 0 && var5 < this.inventory.length) {
                this.inventory[var5] = new ItemInstance(var4);
            }
        }

        this.millingTime = arg.getShort("MillingTime");
    }

    public void writeIdentifyingData(CompoundTag arg) {
        super.writeIdentifyingData(arg);
        arg.put("MillingTime", (short) this.millingTime);
        ListTag var2 = new ListTag();

        for (int var3 = 0; var3 < this.inventory.length; ++var3) {
            if (this.inventory[var3] != null) {
                CompoundTag var4 = new CompoundTag();
                var4.put("Slot", (byte) var3);
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
    public int getMillingTimeDelta(int i) {
        return this.millingTime * i / 200;
    }

    public void tick() {
        if (level.getTileMeta(x, y, z) != 1) return;

        boolean var2 = false;

        if (!this.level.isServerSide) {
            ++this.millingTime;
            if (this.millingTime == 200) {
                for (int index = 0; index < 3; index++) {
                    this.millingTime = 0;
                    this.craftRecipe(index);
                    var2 = true;
                }
            }
        }

        if (var2) {
            this.markDirty();
        }

    }

    private boolean canAcceptRecipeOutput(int index) {
        if (this.inventory[index * 2] == null) return false;
        ItemInstance output = MillingRecipeRegistry.getInstance().getResult(inventory[index * 2].itemId);
        if (output == null) return false;
        ItemInstance outputCopy = output.copy();
        if (this.inventory[index * 2 + 1] == null) {
            return true;
        } else if (!this.inventory[index * 2 + 1].isDamageAndIDIdentical(outputCopy)) {
            return false;
        } else {
            return this.inventory[index * 2 + 1].count + outputCopy.count <= outputCopy.getMaxStackSize();
        }

    }

    public void craftRecipe(int index) {
        if (this.canAcceptRecipeOutput(index)) {
            ItemInstance output = MillingRecipeRegistry.getInstance().getResult(inventory[index * 2].itemId);
            if (output == null) return;
            ItemInstance outputCopy = output.copy();
            if (this.inventory[index * 2 + 1] == null) {
                this.inventory[index * 2 + 1] = outputCopy.copy();
            } else if (this.inventory[index * 2 + 1].itemId == outputCopy.itemId) {
                this.inventory[index * 2 + 1].count += outputCopy.count;
            }
            --this.inventory[index * 2].count;
            if (this.inventory[index * 2].count <= 0) {
                this.inventory[index * 2] = null;
            }
        }
    }

    @Override
    public boolean canPlayerUse(PlayerBase arg) {
        if (this.level.getTileEntity(this.x, this.y, this.z) != this) {
            return false;
        } else {
            return !(arg.squaredDistanceTo((double) this.x + 0.5D, (double) this.y + 0.5D, (double) this.z + 0.5D) > 64.0D);
        }
    }
}
