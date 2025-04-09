package net.alternateadventure.brickforgery.blocks.entity;

import net.alternateadventure.brickforgery.blocks.MetalworkingStationBlockTemplate;
import net.alternateadventure.brickforgery.customrecipes.MetalworkingRecipeRegistry;
import net.alternateadventure.brickforgery.interfaces.BlockWithInput;
import net.alternateadventure.brickforgery.interfaces.BlockWithOutput;
import net.alternateadventure.brickforgery.utils.TieredMachineRecipeData;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

public class MetalworkingStationBlockEntity extends BlockEntity implements Inventory, BlockWithOutput, BlockWithInput {
    private ItemStack[] inventory = new ItemStack[2];
    public int metalworkingTime = 0;
    public int tier = 0;
    public boolean tierChecked = false;

    public MetalworkingStationBlockEntity() {
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
        return "MetalworkingStation";
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

        this.metalworkingTime = arg.getShort("MetalworkingTime");
        this.tierChecked = arg.getBoolean("TierChecked");
        this.tier = arg.getInt("Tier");
    }

    @Override
    public void writeNbt(NbtCompound arg) {
        super.writeNbt(arg);
        arg.putInt("MetalworkingTime", (short)this.metalworkingTime);
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
    public int getMetalworkingTimeDelta(int i) {
        return this.metalworkingTime * i / 200;
    }

    @Override
    public void tick() {
        if (!tierChecked) checkTier();
        if (world.getBlockMeta(x, y, z) != 1) return;

        boolean var2 = false;

        if (!this.world.isRemote) {

            if (this.canAcceptRecipeOutput()) {
                ++this.metalworkingTime;
                if (this.metalworkingTime == 200) {
                    this.metalworkingTime = 0;
                    this.craftRecipe();
                    var2 = true;
                }
            } else {
                this.metalworkingTime = 0;
            }
        }

        if (var2) {
            this.markDirty();
        }

    }

    public void checkTier()
    {
        if (world == null) return;
        Block blockBase = Block.BLOCKS[world.getBlockId(x, y, z)];
        if (blockBase == null) return;
        if (blockBase instanceof MetalworkingStationBlockTemplate)
        {
            tier = ((MetalworkingStationBlockTemplate) blockBase).tier;
            tierChecked = true;
        }
    }

    private boolean canAcceptRecipeOutput() {
        if (this.inventory[0] == null) return false;
        TieredMachineRecipeData metalworkingRecipeData = MetalworkingRecipeRegistry.getInstance().getResult(inventory[0].itemId);
        if (metalworkingRecipeData == null) {
            return false;
        } else if (metalworkingRecipeData.tierRequirement > tier) {
            return false;
        } else if (this.inventory[1] == null) {
            return true;
        } else if (!this.inventory[1].isItemEqual(metalworkingRecipeData.output)) {
            return false;
        } else if (this.inventory[1].count < this.getMaxCountPerStack() && this.inventory[1].count < this.inventory[1].getMaxCount()) {
            return true;
        } else {
            return this.inventory[1].count < metalworkingRecipeData.output.getMaxCount();
        }

    }

    public void craftRecipe() {
        if (this.canAcceptRecipeOutput()) {
            TieredMachineRecipeData metalworkingRecipeData = MetalworkingRecipeRegistry.getInstance().getResult(inventory[0].itemId);
            if (this.inventory[1] == null) {
                this.inventory[1] = metalworkingRecipeData.output.copy();
            } else if (this.inventory[1].itemId == metalworkingRecipeData.output.itemId) {
                ++this.inventory[1].count;
            }
            --this.inventory[0].count;
            if (this.inventory[0].count <= 0) {
                this.inventory[0] = null;
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
    public ItemStack getItemFromInputSlot(int slot) {
        return inventory[0];
    }

    @Override
    public void setInputItem(int slot, ItemStack ItemStack) {
        inventory[0] = ItemStack;
    }

    @Override
    public void setInputItemCount(int slot, int count) {
        inventory[0].count = count;
    }
}
