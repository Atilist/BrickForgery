package net.alternateadventure.brickforgery.blocks.entity;

import net.alternateadventure.brickforgery.blocks.BrickForgeBlock;
import net.alternateadventure.brickforgery.registry.machine.BrickForgingRecipeRegistry;
import net.alternateadventure.brickforgery.registry.machine.records.ComparableIdMeta;
import net.alternateadventure.brickforgery.registry.machine.records.IdMetaCount;
import net.alternateadventure.brickforgery.registry.machine.records.OutputAndInputs;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.danygames2014.nyalib.item.block.ItemHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.modificationstation.stationapi.api.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class BrickForgeBlockEntity extends BlockEntity implements Inventory, ItemHandler {
    private static final int OUTPUT_SLOT = 9;

    private ItemStack[] inventory = new ItemStack[10];
    private ItemStack outputCache;
    public int forgeTime = 0;
    public TierEnum tier;
    public boolean tierChecked = false;

    @Override
    public void tick() {
        if (!tierChecked) checkTier();
        if (world.getBlockMeta(x, y, z) < 6) return;
        boolean var2 = false;
        if (!this.world.isRemote) {
            if (this.canCraftRecipe()) {
                ++this.forgeTime;
                if (this.forgeTime == 200) {
                    this.forgeTime = 0;
                    this.craftRecipe();
                    var2 = true;
                }
            } else {
                this.forgeTime = 0;
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
        if (blockBase instanceof BrickForgeBlock) {
            tier = ((BrickForgeBlock) blockBase).tier;
            tierChecked = true;
        }
    }

    private boolean canCraftRecipe() {
        // Check space availability in advance
        if (inventory[OUTPUT_SLOT] != null && inventory[OUTPUT_SLOT].count == inventory[OUTPUT_SLOT].getMaxCount()) return false;
        // Count full slots
        int fullSlots = 0;
        for (int i = 0; i < OUTPUT_SLOT; i++) {
            if (inventory[i] != null) {
                fullSlots++;
            }
        }
        if (fullSlots == 0) return false;
        // Convert full slots into correct data-structures
        ComparableIdMeta[] inputs = new ComparableIdMeta[fullSlots];
        IdMetaCount[] completeInputs = new IdMetaCount[fullSlots];
        int validInputIndex = 0;
        for (int i = 0; i < OUTPUT_SLOT; i++) {
            if (inventory[i] != null) {
                inputs[validInputIndex] = new ComparableIdMeta(inventory[i].itemId, inventory[i].getDamage());
                completeInputs[validInputIndex] = new IdMetaCount(inventory[i].itemId, inventory[i].getDamage(), inventory[i].count);
                validInputIndex++;
            }
        }
        // Feed inputs into registry
        OutputAndInputs result = BrickForgingRecipeRegistry.getInstance().getResult(inputs);
        // Verify recipe validity
        if (result == null) return false;
        if (result.minimumTier().ordinal() > tier.ordinal()) return false;
        // Check if there are enough ingredients
        IdMetaCount[] references = result.inputs();
        Arrays.sort(references);
        Arrays.sort(completeInputs);
        for (int i = 0; i < references.length; i++) {
            int referenceCount = references[i].count();
            int completeCount = completeInputs[i].count();
            if (completeCount < referenceCount) return false;
        }
        // Check if there is output space
        ItemStack outputItem = result.output().copy();
        outputCache = outputItem;
        if (inventory[OUTPUT_SLOT] != null) {
            if (!inventory[OUTPUT_SLOT].isItemEqual(outputItem)) {
                outputCache = null;
                return false;
            }
            int totalCount = inventory[OUTPUT_SLOT].count + outputItem.count;
            if (totalCount > outputItem.getMaxCount()) {
                outputCache = null;
                return false;
            }
            outputItem.count = totalCount;
        }
        inventory[OUTPUT_SLOT] = outputItem;
        return true;
    }

    public void craftRecipe() {
        if (outputCache == null) {
            return;
        }
        if (inventory[OUTPUT_SLOT] != null) {
            outputCache.count = inventory[OUTPUT_SLOT].count + outputCache.count;
        }
        inventory[OUTPUT_SLOT] = outputCache;
        outputCache = null;
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
            } else {
                var3 = this.inventory[i].split(j);
                if (this.inventory[i].count == 0) {
                    this.inventory[i] = null;
                }
            }
            return var3;
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

        for(int var3 = 0; var3 < var2.size(); ++var3) {
            NbtCompound var4 = (NbtCompound)var2.get(var3);
            byte var5 = var4.getByte("Slot");
            if (var5 >= 0 && var5 < this.inventory.length) {
                this.inventory[var5] = new ItemStack(var4);
            }
        }

        this.forgeTime = arg.getInt("ForgeTime");
        this.tierChecked = arg.getBoolean("TierChecked");
        this.tier = TierEnum.values()[arg.getInt("Tier")];
    }

    @Override
    public void writeNbt(NbtCompound arg) {
        super.writeNbt(arg);
        arg.putInt("ForgeTime", (short)this.forgeTime);
        arg.putBoolean("TierChecked", tierChecked);
        arg.putInt("Tier", tier.ordinal());
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

    @Override
    public boolean canPlayerUse(PlayerEntity arg) {
        if (this.world.getBlockEntity(this.x, this.y, this.z) != this) {
            return false;
        } else {
            return !(arg.getSquaredDistance((double)this.x + 0.5D, (double)this.y + 0.5D, (double)this.z + 0.5D) > 64.0D);
        }
    }

    @Environment(EnvType.CLIENT)
    public int getForgeTimeDelta(int scale) {
        return this.forgeTime * scale / 200;
    }

    @Override
    public boolean canExtractItem(@Nullable Direction direction) {
        return direction == Direction.DOWN;
    }

    @Override
    public ItemStack extractItem(int slot, int amount, @Nullable Direction direction) {
        ItemStack slotItem = inventory[OUTPUT_SLOT];
        if (slotItem == null) {
            return null;
        }
        if (slotItem.count <= amount) {
            inventory[OUTPUT_SLOT] = null;
            return slotItem;
        } else {
            slotItem.count = amount;
            inventory[OUTPUT_SLOT].count -= amount;
        }
        return null;
    }

    @Override
    public boolean canInsertItem(@Nullable Direction direction) {
        return direction == Direction.UP;
    }

    @Override
    public ItemStack insertItem(ItemStack itemStack, int slot, @Nullable Direction direction) {
        ItemStack existingStack = inventory[slot];
        if (existingStack == null) {
            inventory[slot] = itemStack;
            return null;
        } else {
            int totalCount = existingStack.count + itemStack.count;
            if (totalCount < itemStack.getMaxCount()) {
                inventory[slot].count = totalCount;
                return null;
            } else {
                itemStack.count = totalCount - itemStack.getMaxCount();
                inventory[slot].count = itemStack.getMaxCount();
                return itemStack;
            }
        }
    }

    @Override
    public ItemStack insertItem(ItemStack itemStack, @Nullable Direction direction) {
        ItemStack leftovers = itemStack;
        for (int i = 0; i < OUTPUT_SLOT; i++) {
            if (leftovers == null) return null;
            leftovers = insertItem(leftovers, i, direction);
        }
        return leftovers;
    }

    @Override
    public ItemStack getItem(int slot, @Nullable Direction direction) {
        if (direction == Direction.DOWN) {
            return inventory[OUTPUT_SLOT];
        }
        return inventory[slot];
    }

    @Override
    public boolean setItem(ItemStack itemStack, int slot, @Nullable Direction direction) {
        if (slot >= inventory.length) {
            return false;
        }
        inventory[slot] = itemStack;
        return true;
    }

    @Override
    public int getItemSlots(@Nullable Direction direction) {
        if (direction == Direction.DOWN) {
            return 1;
        } else if (direction == Direction.UP) {
            return 9;
        }
        return 0;
    }

    @Override
    public ItemStack[] getInventory(@Nullable Direction direction) {
        return inventory;
    }

    @Override
    public boolean canConnectItem(Direction direction) {
        return direction == Direction.DOWN || direction == Direction.UP;
    }
}
