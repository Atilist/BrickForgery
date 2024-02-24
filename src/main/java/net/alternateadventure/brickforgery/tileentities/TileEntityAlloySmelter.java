package net.alternateadventure.brickforgery.tileentities;

import net.alternateadventure.brickforgery.blocks.AlloySmelter;
import net.alternateadventure.brickforgery.customrecipes.AlloySmeltingRecipeRegistry;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.interfaces.BlockWithInput;
import net.alternateadventure.brickforgery.interfaces.BlockWithOutput;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.io.CompoundTag;
import net.minecraft.util.io.ListTag;
import net.modificationstation.stationapi.api.util.math.Direction;

public class TileEntityAlloySmelter extends TileEntityBase implements InventoryBase, BlockWithOutput, BlockWithInput {
    private ItemInstance[] inventory = new ItemInstance[5];
    public int burnTime = 0;
    public int fuelTime = 0;
    public int cookTime = 0;

    public TileEntityAlloySmelter() {
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
        return "AlloySmelter";
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

        this.burnTime = arg.getShort("BurnTime");
        this.cookTime = arg.getShort("CookTime");
        this.fuelTime = this.getFuelTime();
    }

    public void writeIdentifyingData(CompoundTag arg) {
        super.writeIdentifyingData(arg);
        arg.put("BurnTime", (short)this.burnTime);
        arg.put("CookTime", (short)this.cookTime);
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

    public void tick() {
        boolean var1 = this.burnTime > 0;
        boolean var2 = false;
        if (this.burnTime > 0) {
            --this.burnTime;
        }

        if (!this.level.isServerSide) {
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
                AlloySmelter.updateAlloySmelterState(this.burnTime > 0, this.level, this.x, this.y, this.z);
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
            ItemInstance var1 = AlloySmeltingRecipeRegistry.getInstance().getResult(inventory[0], inventory[3], inventory[4]);
            if (var1 == null) {
                return false;
            } else if (this.inventory[2] == null) {
                return true;
            } else if (!this.inventory[2].isDamageAndIDIdentical(var1)) {
                return false;
            } else if (this.inventory[2].count < this.getMaxItemCount() && this.inventory[2].count < this.inventory[2].getMaxStackSize()) {
                return true;
            } else {
                return this.inventory[2].count < var1.getMaxStackSize();
            }
        }
    }

    public void craftRecipe() {
        if (this.canAcceptRecipeOutput()) {
            ItemInstance var1 = AlloySmeltingRecipeRegistry.getInstance().getResult(inventory[0], inventory[3], inventory[4]);
            if (this.inventory[2] == null) {
                this.inventory[2] = var1.copy();
            } else if (this.inventory[2].itemId == var1.itemId) {
                ++this.inventory[2].count;
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
        if (level == null) return 0;
        if (level.getTileId(x, y - 1, z) == BlockListener.heatPillarStoked.id) return 100;
        return 0;
    }

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
        return inventory[2];
    }

    @Override
    public void clearOutput(int slot) {
        inventory[2] = null;
    }

    @Override
    public void setOutputItemCount(int slot, int count) {
        inventory[2].count = count;
    }

    @Override
    public boolean isValidInputSide(int side) {
        return true;
    }

    @Override
    public int getInputSlotCount() {
        return 3;
    }

    @Override
    public ItemInstance getItemFromInputSlot(int slot) {
        if (slot == 0) return inventory[0];
        else if (slot == 1) return inventory[3];
        else if (slot == 2) return inventory[4];
        return null;
    }

    @Override
    public void setInputItem(int slot, ItemInstance itemInstance) {
        if (slot == 0) inventory[0] = itemInstance;
        else if (slot == 1) inventory[3] = itemInstance;
        else if (slot == 2) inventory[4] = itemInstance;
    }

    @Override
    public void setInputItemCount(int slot, int count) {
        if (slot == 0) inventory[0].count = count;
        else if (slot == 1) inventory[3].count = count;
        else if (slot == 2) inventory[4].count = count;
    }



    /* TODO: Update and restore GregTech functionality
    @Override
    public SlotType[] getAcceptedTypes(Direction side) {
        return switch (side) {
            case DOWN:
            case UP:
                yield new SlotType[] {SlotType.INPUT};
            case EAST:
            case WEST:
            case NORTH:
            case SOUTH:
                yield new SlotType[] {SlotType.OUTPUT};
        };
    }

    @Override
    public SlotType[] getAcceptedTypes() {
        return new SlotType[] {SlotType.INPUT, SlotType.OUTPUT};
    }

    @Override
    public int getInventorySize(SlotType type) {
        if (type == SlotType.INPUT) return 3;
        if (type == SlotType.OUTPUT) return 1;
        return 0;
    }

    @Override
    public ItemInstance getInventoryItem(SlotType type, int slot) {
        if (isInvalidType(type)) return null;
        if (type == SlotType.OUTPUT && slot != 0) return null;
        if (type == SlotType.INPUT && slot > 2) return null;
        return getInventoryItem(getTranslatedSlot(type, slot));
    }

    @Override
    public ItemInstance takeInventoryItem(SlotType type, int slot, int count) {
        if (isInvalidType(type)) return null;
        if (type == SlotType.OUTPUT && slot != 0) return null;
        if (type == SlotType.INPUT && slot > 2) return null;
        return takeInventoryItem(getTranslatedSlot(type, slot), count);
    }

    @Override
    public void setInventoryItem(SlotType type, int slot, ItemInstance itemInstance) {
        if (isInvalidType(type)) return;
        if (type == SlotType.OUTPUT && slot != 0) return;
        if (type == SlotType.INPUT && slot > 2) return;
        setInventoryItem(getTranslatedSlot(type, slot), itemInstance);
    }

    private static boolean isInvalidType(SlotType type) {
        return type != SlotType.INPUT && type != SlotType.OUTPUT;
    }

    private static int getTranslatedSlot(SlotType type, int slot) {
        switch (slot) {
            case 0:
                break;
            case 1:
                slot = 3;
                break;
            case 2:
                slot = 4;
                break;
        }
        return switch (type) {
            case INPUT:
                yield slot;
            case OUTPUT:
                yield 2;
            default:
                yield -1;
        };
    }

     */
}
