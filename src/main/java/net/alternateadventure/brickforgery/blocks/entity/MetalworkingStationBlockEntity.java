package net.alternateadventure.brickforgery.blocks.entity;

import net.alternateadventure.brickforgery.blocks.MetalworkingStationBlockTemplate;
import net.alternateadventure.brickforgery.registry.machine.MetalworkingRecipeRegistry;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.alternateadventure.brickforgery.utils.TieredMachineRecipeData;
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

public class MetalworkingStationBlockEntity extends BlockEntity implements Inventory, ItemHandler {
    private ItemStack[] inventory = new ItemStack[2];
    public int metalworkingTime = 0;
    public TierEnum tier;
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

        this.metalworkingTime = arg.getInt("MetalworkingTime");
        this.tierChecked = arg.getBoolean("TierChecked");
        this.tier = TierEnum.values()[arg.getInt("Tier")];
    }

    @Override
    public void writeNbt(NbtCompound arg) {
        super.writeNbt(arg);
        arg.putInt("MetalworkingTime", (short)this.metalworkingTime);
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
        } else if (metalworkingRecipeData.tierRequirement.ordinal() > tier.ordinal()) {
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
    public boolean canExtractItem(@Nullable Direction direction) {
        return direction == Direction.DOWN;
    }

    @Override
    public ItemStack extractItem(int slot, int amount, @Nullable Direction direction) {
        ItemStack slotItem = inventory[1];
        if (slotItem == null) {
            return null;
        }
        if (slotItem.count <= amount) {
            inventory[1] = null;
            return slotItem;
        } else {
            slotItem.count = amount;
            inventory[1].count -= amount;
        }
        return null;
    }

    @Override
    public boolean canInsertItem(@Nullable Direction direction) {
        return direction == Direction.UP;
    }

    @Override
    public ItemStack insertItem(ItemStack itemStack, int i, @Nullable Direction direction) {
        ItemStack existingStack = inventory[i];
        if (existingStack == null) {
            inventory[i] = itemStack;
            return null;
        } else {
            int totalCount = existingStack.count + itemStack.count;
            if (totalCount < itemStack.getMaxCount()) {
                inventory[i].count = totalCount;
                return null;
            } else {
                itemStack.count = totalCount - itemStack.getMaxCount();
                inventory[i].count = itemStack.getMaxCount();
                return itemStack;
            }
        }
    }

    @Override
    public ItemStack insertItem(ItemStack itemStack, @Nullable Direction direction) {
        return insertItem(itemStack, 0, direction);
    }

    @Override
    public ItemStack getItem(int i, @Nullable Direction direction) {
        if (direction == Direction.DOWN) {
            return inventory[1];
        }
        return null;
    }

    @Override
    public boolean setItem(ItemStack itemStack, int i, @Nullable Direction direction) {
        if (i >= inventory.length) {
            return false;
        }
        inventory[i] = itemStack;
        return true;
    }

    @Override
    public int getItemSlots(@Nullable Direction direction) {
        if (direction == Direction.DOWN || direction == Direction.UP) {
            return 1;
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
