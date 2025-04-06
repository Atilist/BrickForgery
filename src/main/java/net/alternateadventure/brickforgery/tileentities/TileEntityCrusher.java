package net.alternateadventure.brickforgery.tileentities;

import net.alternateadventure.brickforgery.blocks.CrusherBase;
import net.alternateadventure.brickforgery.customrecipes.CrushingRecipeRegistry;
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

public class TileEntityCrusher extends BlockEntity implements Inventory {
    private final Random random = new Random();
    private ItemStack[] inventory = new ItemStack[3];
    public int crushingTime = 0;
    public int tier = 0;
    public boolean tierChecked = false;

    public TileEntityCrusher() {
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
        return "Crusher";
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

        this.crushingTime = arg.getShort("CrushingTime");
        this.tierChecked = arg.getBoolean("TierChecked");
        this.tier = arg.getInt("Tier");
    }

    @Override
    public void writeNbt(NbtCompound arg) {
        super.writeNbt(arg);
        arg.putShort("CrushingTime", (short)this.crushingTime);
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
    public int getCrushingTimeDelta(int i) {
        return this.crushingTime * i / 200;
    }

    @Override
    public void tick() {
        if (!tierChecked) checkTier();
        if (world.getBlockMeta(x, y, z) != 1) return;

        boolean var2 = false;

        if (!this.world.isRemote) {

            if (this.canAcceptRecipeOutput()) {
                ++this.crushingTime;
                if (this.crushingTime == 200) {
                    this.crushingTime = 0;
                    this.craftRecipe();
                    var2 = true;
                }
            } else {
                this.crushingTime = 0;
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
        TierAndByproductOutput crushingOutput = CrushingRecipeRegistry.getInstance().getResult(inventory[0].itemId);
        if (crushingOutput == null) {
            return false;
        } else if (crushingOutput.tieredMachineRecipeData.tierRequirement > tier) {
            return false;
        }
        if (!canAcceptByproduct(crushingOutput.byproduct.copy())) return false;
        ItemStack crushedItem = crushingOutput.tieredMachineRecipeData.output.copy();
        if (this.inventory[1] == null) {
            return true;
        } else if (!this.inventory[1].isItemEqual(crushedItem)) {
            return false;
        } else {
            return this.inventory[1].count + crushedItem.count < crushedItem.getMaxCount();
        }

    }

    private boolean canAcceptByproduct(ItemStack byproduct) {
        if (byproduct == null) return true;
        if (inventory[2] == null) return true;
        if (!inventory[2].isItemEqual(byproduct)) return false;
        return byproduct.count + inventory[2].count <= byproduct.getMaxCount();
    }

    public void craftRecipe() {
        if (this.canAcceptRecipeOutput()) {
            TierAndByproductOutput crushingOutput = CrushingRecipeRegistry.getInstance().getResult(inventory[0].itemId);
            ItemStack crushedItem = crushingOutput.tieredMachineRecipeData.output.copy();
            if (this.inventory[1] == null) {
                this.inventory[1] = crushedItem;
            } else if (this.inventory[1].itemId == crushedItem.itemId) {
                this.inventory[1].count += crushedItem.count;
            }
            --this.inventory[0].count;
            if (this.inventory[0].count <= 0) {
                this.inventory[0] = null;
            }
            if (random.nextDouble(1.0) > crushingOutput.byproductChance) return;
            ItemStack byproduct = crushingOutput.byproduct.copy();
            if (this.inventory[2] == null)
            {
                this.inventory[2] = byproduct;
            }
            else
            {
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
