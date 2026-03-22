package net.alternateadventure.brickforgery.blocks.entity;

import net.alternateadventure.brickforgery.blocks.AlloySmelterBlock;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.registry.machine.AlloySmeltingRecipeRegistry;
import net.danygames2014.nyalib.item.block.ItemHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.modificationstation.stationapi.api.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class AlloySmelterBlockEntity extends BlockEntity implements Inventory, ItemHandler {
    private static final int OUTPUT_SLOT = 2;

    private ItemStack[] inventory = new ItemStack[5];
    public int burnTime = 0;
    public int fuelTime = 0;
    public int cookTime = 0;

    public AlloySmelterBlockEntity() {
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
        return "AlloySmelter";
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

        this.burnTime = arg.getShort("BurnTime");
        this.cookTime = arg.getShort("CookTime");
        this.fuelTime = this.getFuelTime();
    }

    @Override
    public void writeNbt(NbtCompound arg) {
        super.writeNbt(arg);
        arg.putInt("BurnTime", (short)this.burnTime);
        arg.putInt("CookTime", (short)this.cookTime);
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
    public int getCookTimeDelta(int i) {
        return this.cookTime * i / 200;
    }

    @Environment(EnvType.CLIENT)
    public int getFuelTimeDelta(int i) {
        if (this.fuelTime == 0) {
            this.fuelTime = 200;
        }

        return this.burnTime * i / this.fuelTime;
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    @Override
    public void tick() {
        boolean var1 = this.burnTime > 0;
        boolean var2 = false;
        if (this.burnTime > 0) {
            --this.burnTime;
        }

        if (!this.world.isRemote) {
            if (this.burnTime == 0 && this.canAcceptRecipeOutput()) {
                this.fuelTime = this.burnTime = this.getFuelTime();
                if (this.burnTime > 0) {
                    var2 = true;
                    if (this.inventory[1] != null) {
                        --this.inventory[1].count;
                        if (this.inventory[1].count == 0) {
                            this.inventory[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canAcceptRecipeOutput()) {
                ++this.cookTime;
                if (this.cookTime == 200) {
                    this.cookTime = 0;
                    this.craftRecipe();
                    var2 = true;
                }
            } else {
                this.cookTime = 0;
            }

            if (var1 != this.burnTime > 0) {
                var2 = true;
                AlloySmelterBlock.updateAlloySmelterState(this.burnTime > 0, this.world, this.x, this.y, this.z);
            }
        }

        if (var2) {
            this.markDirty();
        }

    }

    private boolean canAcceptRecipeOutput() {
        if (this.inventory[0] == null) {
            return false;
        } else {
            ItemStack var1 = AlloySmeltingRecipeRegistry.getInstance().getResult(inventory[0], inventory[3], inventory[4]);
            if (var1 == null) {
                return false;
            } else if (this.inventory[OUTPUT_SLOT] == null) {
                return true;
            } else if (!this.inventory[OUTPUT_SLOT].isItemEqual(var1)) {
                return false;
            } else if (this.inventory[OUTPUT_SLOT].count < this.getMaxCountPerStack() && this.inventory[2].count < this.inventory[2].getMaxCount()) {
                return true;
            } else {
                return this.inventory[OUTPUT_SLOT].count < var1.getMaxCount();
            }
        }
    }

    public void craftRecipe() {
        if (this.canAcceptRecipeOutput()) {
            ItemStack var1 = AlloySmeltingRecipeRegistry.getInstance().getResult(inventory[0], inventory[3], inventory[4]);
            if (this.inventory[OUTPUT_SLOT] == null) {
                this.inventory[OUTPUT_SLOT] = var1.copy();
            } else if (this.inventory[OUTPUT_SLOT].itemId == var1.itemId) {
                ++this.inventory[OUTPUT_SLOT].count;
            }
            --this.inventory[0].count;
            if (this.inventory[0].count <= 0) {
                this.inventory[0] = null;
            }
            --this.inventory[3].count;
            if (this.inventory[3].count <= 0) {
                this.inventory[3] = null;
            }
            --this.inventory[4].count;
            if (this.inventory[4].count <= 0) {
                this.inventory[4] = null;
            }
        }
    }

    private int getFuelTime() {
        if (world == null) return 0;
        if (world.getBlockId(x, y - 1, z) == BlockListener.heatPillarStoked.id) return 100;
        return 0;
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
            if (!existingStack.isItemEqual(itemStack)) return itemStack;
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
