package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class ExoticCatalystItem extends LazyItemTemplate{
    public ExoticCatalystItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity playerBase, World level, int x, int y, int z, int facing) {
        ItemStack tool = playerBase.getHeldItem();
        if (level.getBlockId(x, y, z) == Block.COAL_ORE.id) {
            level.setBlock(x, y, z, BlockListener.coalOreBricks.id);
            tool.count--;
            return true;
        } else if (level.getBlockId(x, y, z) == Block.IRON_ORE.id) {
            level.setBlock(x, y, z, BlockListener.ironOreBricks.id);
            tool.count--;
            return true;
        } else if (level.getBlockId(x, y, z) == Block.GOLD_ORE.id) {
            level.setBlock(x, y, z, BlockListener.goldOreBricks.id);
            tool.count--;
            return true;
        } else if (level.getBlockId(x, y, z) == Block.REDSTONE_ORE.id || level.getBlockId(x, y, z) == Block.LIT_REDSTONE_ORE.id) {
            level.setBlock(x, y, z, BlockListener.redstoneOreBricks.id);
            tool.count--;
            return true;
        } else if (level.getBlockId(x, y, z) == Block.DIAMOND_ORE.id) {
            level.setBlock(x, y, z, BlockListener.diamondOreBricks.id);
            tool.count--;
            return true;
        }
        return false;
    }
}
