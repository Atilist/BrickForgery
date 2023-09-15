package net.alternateadventure.brickforgery.containers;

import net.alternateadventure.brickforgery.tileentities.TileEntityCrusher;
import net.alternateadventure.brickforgery.tileentities.TileEntityWasher;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.container.ContainerBase;
import net.minecraft.container.ContainerListener;
import net.minecraft.container.slot.FurnaceOutput;
import net.minecraft.container.slot.Slot;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemInstance;

public class ContainerWasher extends ContainerBase {
    private TileEntityWasher washer;
    private int washingTime = 0;

    public ContainerWasher(PlayerInventory arg, TileEntityWasher arg2) {
        this.washer = arg2;

        this.addSlot(new Slot(arg2, 0, 56, 35));
        this.addSlot(new FurnaceOutput(arg.player, arg2, 1, 116, 35));
        this.addSlot(new FurnaceOutput(arg.player, arg2, 2, 116, 61));

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
        arg.updateProperty(this, 0, this.washer.processingTime);
    }

    public void tick() {
        super.tick();

        for(int var1 = 0; var1 < this.listeners.size(); ++var1) {
            ContainerListener var2 = (ContainerListener)this.listeners.get(var1);
            if (this.washingTime != this.washer.processingTime) {
                var2.updateProperty(this, 0, this.washer.processingTime);
            }
        }

        this.washingTime = this.washer.processingTime;
    }

    @Environment(EnvType.CLIENT)
    public void setProperty(int i, int j) {
        if (i == 0) {
            this.washer.processingTime = j;
        }
    }

    public boolean canUse(PlayerBase arg) {
        return this.washer.canPlayerUse(arg);
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
