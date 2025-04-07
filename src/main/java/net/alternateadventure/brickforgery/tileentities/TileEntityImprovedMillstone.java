package net.alternateadventure.brickforgery.tileentities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kozibrodka.wolves.recipe.MillingRecipeRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

public class TileEntityImprovedMillstone extends BlockEntity implements Inventory {
    private ItemStack[] inventory = new ItemStack[6];
    public int millingTime = 0;

    public TileEntityImprovedMillstone() {
    }

    @Override
    public int size() {
        return this.inventory.length;
    }

    @Override
    public ItemStack getStack(int i) {
        return this.inventory[i];
    }

    @Override
    public ItemStack removeStack(int i, int j) {
        if (this.inventory[i] != null) {
            ItemStack var3;
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

    @Override
    public void setStack(int i, ItemStack arg) {
        this.inventory[i] = arg;
        if (arg != null && arg.count > this.getMaxCountPerStack()) {
            arg.count = this.getMaxCountPerStack();
        }

    }

    @Override
    public String getName() {
        return "Slicer";
    }

    @Override
    public void readNbt(NbtCompound arg) {
        super.readNbt(arg);
        NbtList var2 = arg.getList("Items");
        this.inventory = new ItemStack[this.size()];

        for (int var3 = 0; var3 < var2.size(); ++var3) {
            NbtCompound var4 = (NbtCompound) var2.get(var3);
            byte var5 = var4.getByte("Slot");
            if (var5 >= 0 && var5 < this.inventory.length) {
                this.inventory[var5] = new ItemStack(var4);
            }
        }

        this.millingTime = arg.getShort("MillingTime");
    }

    @Override
    public void writeNbt(NbtCompound arg) {
        super.writeNbt(arg);
        arg.putShort("MillingTime", (short) this.millingTime);
        NbtList var2 = new NbtList();

        for (int var3 = 0; var3 < this.inventory.length; ++var3) {
            if (this.inventory[var3] != null) {
                NbtCompound var4 = new NbtCompound();
                var4.putByte("Slot", (byte) var3);
                this.inventory[var3].writeNbt(var4);
                var2.add(var4);
            }
        }

        arg.put("Items", var2);
    }

    @Override
    public int getMaxCountPerStack() {
        return 64;
    }

    @Environment(EnvType.CLIENT)
    public int getMillingTimeDelta(int i) {
        return this.millingTime * i / 200;
    }

    @Override
    public void tick() {
        if (world.getBlockMeta(x, y, z) != 1) return;

        boolean var2 = false;

        if (!this.world.isRemote) {
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
        ItemStack output = MillingRecipeRegistry.getInstance().getResult(inventory[index * 2].itemId);
        if (output == null) return false;
        ItemStack outputCopy = output.copy();
        if (this.inventory[index * 2 + 1] == null) {
            return true;
        } else if (!this.inventory[index * 2 + 1].isItemEqual(outputCopy)) {
            return false;
        } else {
            return this.inventory[index * 2 + 1].count + outputCopy.count <= outputCopy.getMaxCount();
        }

    }

    public void craftRecipe(int index) {
        if (this.canAcceptRecipeOutput(index)) {
            ItemStack output = MillingRecipeRegistry.getInstance().getResult(inventory[index * 2].itemId);
            if (output == null) return;
            ItemStack outputCopy = output.copy();
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
    public boolean canPlayerUse(PlayerEntity arg) {
        if (this.world.getBlockEntity(this.x, this.y, this.z) != this) {
            return false;
        } else {
            return !(arg.getSquaredDistance((double) this.x + 0.5D, (double) this.y + 0.5D, (double) this.z + 0.5D) > 64.0D);
        }
    }
}
