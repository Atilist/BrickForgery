package net.alternateadventure.brickforgery.tileentities;

import net.alternateadventure.brickforgery.blocks.CrusherBase;
import net.alternateadventure.brickforgery.customrecipes.WashingRecipeRegistry;
import net.alternateadventure.brickforgery.utils.TierAndByproductOutput;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

import java.util.Random;

public class TileEntityWasher extends BlockEntity implements Inventory {
    private final Random random = new Random();
    private ItemStack[] inventory = new ItemStack[3];
    public int processingTime = 0;
    public int tier = 0;
    public boolean tierChecked = false;

    public TileEntityWasher() {
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
        return "Washer";
    }

    @Override
    public void readNbt(NbtCompound arg) {
        super.readNbt(arg);
        NbtList var2 = arg.getList("Items");
        this.inventory = new ItemStack[this.size()];

        for(int var3 = 0; var3 < var2.size(); ++var3) {
            NbtCompound var4 = (NbtCompound)var2.get(var3);
            byte var5 = var4.getByte("Slot");
            if (var5 >= 0 && var5 < this.inventory.length) {
                this.inventory[var5] = new ItemStack(var4);
            }
        }

        this.processingTime = arg.getShort("ProcessingTime");
        this.tierChecked = arg.getBoolean("TierChecked");
        this.tier = arg.getInt("Tier");
    }

    @Override
    public void writeNbt(NbtCompound arg) {
        super.writeNbt(arg);
        arg.putShort("ProcessingTime", (short)this.processingTime);
        arg.putBoolean("TierChecked", tierChecked);
        arg.putInt("Tier", tier);
        NbtList var2 = new NbtList();

        for(int var3 = 0; var3 < this.inventory.length; ++var3) {
            if (this.inventory[var3] != null) {
                NbtCompound var4 = new NbtCompound();
                var4.putByte("Slot", (byte)var3);
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
    public int getProcessingTimeDelta(int i) {
        return this.processingTime * i / 200;
    }

    @Override
    public void tick() {
        if (!tierChecked) checkTier();
        if (world.getBlockMeta(x, y, z) != 1) return;
        if (world.getBlockId(x, y + 1, z) != Block.WATER.id && world.getBlockId(x, y + 1, z) != Block.FLOWING_WATER.id) return;

        boolean var2 = false;

        if (!this.world.isRemote) {

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

    public void checkTier() {
        if (world == null) return;
        Block blockBase = Block.BLOCKS[world.getBlockId(x, y, z)];
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
        ItemStack washedItem = washingOutput.tieredMachineRecipeData.output.copy();
        if (this.inventory[1] == null) {
            return true;
        } else if (!this.inventory[1].isItemEqual(washedItem)) {
            return false;
        } else {
            return this.inventory[1].count + washedItem.count < washedItem.getMaxCount();
        }

    }

    private boolean canAcceptByproduct(ItemStack byproduct) {
        if (byproduct == null) return true;
        if (inventory[2] == null) return true;
        if (!inventory[2].isItemEqual(byproduct)) return false;
        if (byproduct.count + inventory[2].count > byproduct.getMaxCount()) return false;
        return true;
    }

    public void craftRecipe() {
        if (this.canAcceptRecipeOutput()) {
            TierAndByproductOutput washingOutput = WashingRecipeRegistry.getInstance().getResult(inventory[0].itemId);
            ItemStack washedItem = washingOutput.tieredMachineRecipeData.output.copy();
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
            ItemStack byproduct = washingOutput.byproduct.copy();
            if (this.inventory[2] == null) {
                this.inventory[2] = byproduct;
            } else {
                this.inventory[2].count += byproduct.count;
            }
        }
    }

    @Override
    public boolean canPlayerUse(PlayerEntity arg) {
        if (this.world.getBlockEntity(this.x, this.y, this.z) != this) {
            return false;
        } else {
            return !(arg.getSquaredDistance((double)this.x + 0.5D, (double)this.y + 0.5D, (double)this.z + 0.5D) > 64.0D);
        }
    }
}
