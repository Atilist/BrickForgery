package net.alternateadventure.brickforgery.containers;

import net.alternateadventure.brickforgery.tileentities.TileEntityCrusher;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;

public class CrusherScreenHandler extends ScreenHandler {
    private final TileEntityCrusher crusher;
    private int sliceTime = 0;

    public CrusherScreenHandler(PlayerInventory arg, TileEntityCrusher arg2) {
        this.crusher = arg2;

        this.addSlot(new Slot(arg2, 0, 56, 35));
        this.addSlot(new FurnaceOutputSlot(arg.player, arg2, 1, 116, 35));
        this.addSlot(new FurnaceOutputSlot(arg.player, arg2, 2, 116, 61));

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
    public void addListener(ScreenHandlerListener arg) {
        super.addListener(arg);
        arg.onPropertyUpdate(this, 0, this.crusher.crushingTime);
    }

    @Override
    public void sendContentUpdates() {
        super.sendContentUpdates();

        for (Object listener : this.listeners) {
            ScreenHandlerListener var2 = (ScreenHandlerListener) listener;
            if (this.sliceTime != this.crusher.crushingTime) {
                var2.onPropertyUpdate(this, 0, this.crusher.crushingTime);
            }
        }

        this.sliceTime = this.crusher.crushingTime;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void setProperty(int i, int j) {
        if (i == 0) {
            this.crusher.crushingTime = j;
        }
    }

    @Override
    public boolean canUse(PlayerEntity arg) {
        return this.crusher.canPlayerUse(arg);
    }

    @Override
    public ItemStack quickMove(int i) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.slots.get(i);
        if (var3 != null && var3.hasStack()) {
            ItemStack var4 = var3.getStack();
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
