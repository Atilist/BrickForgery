package net.alternateadventure.brickforgery.containers;

import net.alternateadventure.brickforgery.blocks.entity.BrickForgeBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;

public class BrickForgeScreenHandler extends ScreenHandler {
    private final BrickForgeBlockEntity brickForgeBlockEntity;
    private int sliceTime = 0;

    public BrickForgeScreenHandler(PlayerInventory arg, BrickForgeBlockEntity brickForgeBlockEntity) {
        this.brickForgeBlockEntity = brickForgeBlockEntity;

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(brickForgeBlockEntity, i, 20 + 18 * (i % 3), 16 + 18 * (i / 3)));
        }

        this.addSlot(new FurnaceOutputSlot(arg.player, brickForgeBlockEntity, 9, 116, 35));

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
    public void addListener(ScreenHandlerListener arg) {
        super.addListener(arg);
        arg.onPropertyUpdate(this, 0, this.brickForgeBlockEntity.forgeTime);
    }

    public void sendContentUpdates() {
        super.sendContentUpdates();

        for (Object listener : this.listeners) {
            ScreenHandlerListener var2 = (ScreenHandlerListener) listener;
            if (this.sliceTime != this.brickForgeBlockEntity.forgeTime) {
                var2.onPropertyUpdate(this, 0, this.brickForgeBlockEntity.forgeTime);
            }
        }

        this.sliceTime = this.brickForgeBlockEntity.forgeTime;
    }

    @Environment(EnvType.CLIENT)
    public void setProperty(int i, int j) {
        if (i == 0) {
            this.brickForgeBlockEntity.forgeTime = j;
        }
    }

    public boolean canUse(PlayerEntity arg) {
        return this.brickForgeBlockEntity.canPlayerUse(arg);
    }

//    public ItemStack quickMove(int i) {
//        ItemStack var2 = null;
//        Slot var3 = (Slot)this.slots.get(i);
//        if (var3 != null && var3.hasStack()) {
//            ItemStack var4 = var3.getStack();
//            var2 = var4.copy();
//            if (i == 2) {
//                this.insertItem(var4, 3, 38, true);
//            } else if (i >= 3 && i < 30) {
//                this.insertItem(var4, 30, 38, false);
//            } else if (i >= 30 && i < 39) {
//                this.insertItem(var4, 3, 30, false);
//            } else {
//                this.insertItem(var4, 3, 38, false);
//            }
//
//            if (var4.count == 0) {
//                var3.setStack(null);
//            } else {
//                var3.markDirty();
//            }
//
//            if (var4.count == var2.count) {
//                return null;
//            }
//
//            var3.onTakeItem(var4);
//        }
//
//        return var2;
//    }
}
