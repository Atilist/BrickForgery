package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class DirtBrickSand extends LazyItemTemplate {
    public DirtBrickSand(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity playerBase, World level, int x, int y, int z, int l) {
        if (level.getBlockId(x, y, z) != BlockListener.sugarCaneBox.id) {
            return false;
        }
        if (level.getBlockId(x + 1, y, z + 1) != BlockListener.sugarCaneBox.id) {
            return false;
        }
        if (level.getBlockId(x + 1, y, z - 1) != BlockListener.sugarCaneBox.id) {
            return false;
        }
        if (level.getBlockId(x - 1, y, z + 1) != BlockListener.sugarCaneBox.id) {
            return false;
        }
        if (level.getBlockId(x - 1, y, z - 1) != BlockListener.sugarCaneBox.id) {
            return false;
        }
        if (level.getBlockId(x + 1, y, z) != BlockListener.dirtBricks.id) {
            return false;
        }
        if (level.getBlockId(x - 1, y, z) != BlockListener.dirtBricks.id) {
            return false;
        }
        if (level.getBlockId(x, y, z + 1) != BlockListener.dirtBricks.id) {
            return false;
        }
        if (level.getBlockId(x, y, z - 1) != BlockListener.dirtBricks.id) {
            return false;
        }
        itemInstance.itemId = ItemListener.sandBrick.id;
        return true;
    }
}
