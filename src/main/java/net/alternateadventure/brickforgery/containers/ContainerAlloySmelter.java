package net.alternateadventure.brickforgery.containers;

import net.alternateadventure.brickforgery.tileentities.TileEntityAlloySmelter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.container.ContainerBase;
import net.minecraft.container.ContainerListener;
import net.minecraft.container.slot.FurnaceOutput;
import net.minecraft.container.slot.Slot;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerAlloySmelter extends ContainerBase {
    private TileEntityAlloySmelter alloySmelter;
    private int cookTime = 0;
    private int burnTime = 0;
    private int fuelTime = 0;

    public ContainerAlloySmelter(PlayerInventory arg, TileEntityAlloySmelter arg2) {
        this.alloySmelter = arg2;
        this.addSlot(new Slot(arg2, 0, 20, 34));
        this.addSlot(new Slot(arg2, 3, 38, 34));
        this.addSlot(new Slot(arg2, 4, 56, 34));
        this.addSlot(new FurnaceOutput(arg.player, arg2, 2, 116, 34));

        int var3;
        for(var3 = 0; var3 < 3; ++var3) {
            for(int var4 = 0; var4 < 9; ++var4) {
                this.addSlot(new Slot(arg, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for(var3 = 0; var3 < 9; ++var3) {
            this.addSlot(new Slot(arg, var3, 8 + var3 * 18, 142));
        }

    }

    @Environment(EnvType.SERVER)
    public void addListener(ContainerListener arg) {
        super.addListener(arg);
        arg.updateProperty(this, 0, this.alloySmelter.cookTime);
        arg.updateProperty(this, 1, this.alloySmelter.burnTime);
        arg.updateProperty(this, 2, this.alloySmelter.fuelTime);
    }

    public void tick() {
        super.tick();

        for(int var1 = 0; var1 < this.listeners.size(); ++var1) {
            ContainerListener var2 = (ContainerListener)this.listeners.get(var1);
            if (this.cookTime != this.alloySmelter.cookTime) {
                var2.updateProperty(this, 0, this.alloySmelter.cookTime);
            }

            if (this.burnTime != this.alloySmelter.burnTime) {
                var2.updateProperty(this, 1, this.alloySmelter.burnTime);
            }

            if (this.fuelTime != this.alloySmelter.fuelTime) {
                var2.updateProperty(this, 2, this.alloySmelter.fuelTime);
            }
        }

        this.cookTime = this.alloySmelter.cookTime;
        this.burnTime = this.alloySmelter.burnTime;
        this.fuelTime = this.alloySmelter.fuelTime;
    }

    @Environment(EnvType.CLIENT)
    public void setProperty(int i, int j) {
        if (i == 0) {
            this.alloySmelter.cookTime = j;
        }

        if (i == 1) {
            this.alloySmelter.burnTime = j;
        }

        if (i == 2) {
            this.alloySmelter.fuelTime = j;
        }

    }

    public boolean canUse(PlayerBase arg) {
        return this.alloySmelter.canPlayerUse(arg);
    }

    public ItemInstance transferSlot(int i) {
        ItemInstance var2 = null;
        Slot var3 = (Slot)this.slots.get(i);
        if (var3 != null && var3.hasItem()) {
            ItemInstance var4 = var3.getItem();
            var2 = var4.copy();
            if (i == 2) {
                this.insertItem(var4, 3, 39, true);
            } else if (i >= 3 && i < 30) {
                this.insertItem(var4, 30, 39, false);
            } else if (i >= 30 && i < 39) {
                this.insertItem(var4, 3, 30, false);
            } else {
                this.insertItem(var4, 3, 39, false);
            }

            if (var4.count == 0) {
                var3.setStack((ItemInstance)null);
            } else {
                var3.markDirty();
            }

            if (var4.count == var2.count) {
                return null;
            }

            var3.onCrafted(var4);
        }

        return var2;
    }
}
