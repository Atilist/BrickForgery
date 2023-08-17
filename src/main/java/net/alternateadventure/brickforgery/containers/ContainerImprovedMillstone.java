package net.alternateadventure.brickforgery.containers;

import net.alternateadventure.brickforgery.tileentities.TileEntityImprovedMillstone;
import net.alternateadventure.brickforgery.tileentities.TileEntitySlicer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.container.ContainerBase;
import net.minecraft.container.ContainerListener;
import net.minecraft.container.slot.FurnaceOutput;
import net.minecraft.container.slot.Slot;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemInstance;

public class ContainerImprovedMillstone extends ContainerBase {
    private TileEntityImprovedMillstone improvedMillstone;
    private int sliceTime = 0;

    public ContainerImprovedMillstone(PlayerInventory arg, TileEntityImprovedMillstone arg2) {
        this.improvedMillstone = arg2;

        for (int index = 0; index < 3; index++) {
            this.addSlot(new Slot(arg2, index * 2, 56, 9 + 26 * index));
            this.addSlot(new FurnaceOutput(arg.player, arg2, index * 2 + 1, 116, 9 + 26 * index));
        }
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
        arg.updateProperty(this, 0, this.improvedMillstone.millingTime);
    }

    public void tick() {
        super.tick();

        for(int var1 = 0; var1 < this.listeners.size(); ++var1) {
            ContainerListener var2 = (ContainerListener)this.listeners.get(var1);
            if (this.sliceTime != this.improvedMillstone.millingTime) {
                var2.updateProperty(this, 0, this.improvedMillstone.millingTime);
            }
        }

        this.sliceTime = this.improvedMillstone.millingTime;
    }

    @Environment(EnvType.CLIENT)
    public void setProperty(int i, int j) {
        if (i == 0) {
            this.improvedMillstone.millingTime = j;
        }
    }

    public boolean canUse(PlayerBase arg) {
        return this.improvedMillstone.canPlayerUse(arg);
    }

    public ItemInstance transferSlot(int i) {
        ItemInstance var2 = null;
        Slot var3 = (Slot)this.slots.get(i);
        if (var3 != null && var3.hasItem()) {
            ItemInstance var4 = var3.getItem();
            var2 = var4.copy();
            if (i == 2) {
                this.insertItem(var4, 3, 38, true);
            } else if (i >= 3 && i < 30) {
                this.insertItem(var4, 30, 38, false);
            } else if (i >= 30 && i < 39) {
                this.insertItem(var4, 3, 30, false);
            } else {
                this.insertItem(var4, 3, 38, false);
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
