package net.alternateadventure.brickforgery.containers;

import net.alternateadventure.brickforgery.tileentities.TileEntityAlloySmelter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;

public class AlloySmelterScreenHandler extends ScreenHandler {
    private final TileEntityAlloySmelter alloySmelter;
    private int cookTime = 0;
    private int burnTime = 0;
    private int fuelTime = 0;

    public AlloySmelterScreenHandler(PlayerInventory arg, TileEntityAlloySmelter arg2) {
        this.alloySmelter = arg2;
        this.addSlot(new Slot(arg2, 0, 20, 34));
        this.addSlot(new Slot(arg2, 3, 38, 34));
        this.addSlot(new Slot(arg2, 4, 56, 34));
        this.addSlot(new FurnaceOutputSlot(arg.player, arg2, 2, 116, 34));

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

    @Override
    @Environment(EnvType.SERVER)
    public void addListener(ScreenHandlerListener listener) {
        super.addListener(listener);
        listener.onPropertyUpdate(this, 0, this.alloySmelter.cookTime);
        listener.onPropertyUpdate(this, 1, this.alloySmelter.burnTime);
        listener.onPropertyUpdate(this, 2, this.alloySmelter.fuelTime);
    }

    @Override
    public void sendContentUpdates() {
        super.sendContentUpdates();

        for (Object listener : this.listeners) {
            ScreenHandlerListener var2 = (ScreenHandlerListener) listener;
            if (this.cookTime != this.alloySmelter.cookTime) {
                var2.onPropertyUpdate(this, 0, this.alloySmelter.cookTime);
            }

            if (this.burnTime != this.alloySmelter.burnTime) {
                var2.onPropertyUpdate(this, 1, this.alloySmelter.burnTime);
            }

            if (this.fuelTime != this.alloySmelter.fuelTime) {
                var2.onPropertyUpdate(this, 2, this.alloySmelter.fuelTime);
            }
        }

        this.cookTime = this.alloySmelter.cookTime;
        this.burnTime = this.alloySmelter.burnTime;
        this.fuelTime = this.alloySmelter.fuelTime;
    }

    @Override
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

    @Override
    public boolean canUse(PlayerEntity arg) {
        return this.alloySmelter.canPlayerUse(arg);
    }

    @Override
    public ItemStack quickMove(int i) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.slots.get(i);
        if (var3 != null && var3.hasStack()) {
            ItemStack var4 = var3.getStack();
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
                var3.setStack(null);
            } else {
                var3.markDirty();
            }

            if (var4.count == var2.count) {
                return null;
            }

            var3.onTakeItem(var4);
        }

        return var2;
    }
}
