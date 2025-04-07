package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.blocks.IndestructibleBlock;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class IceKey extends LazyItemTemplate {
    public IceKey(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity playerBase, World level, int x, int y, int z, int facing) {
        if (level.getBlockId(x, y, z) != BlockListener.frostVaultKeyhole.id) return false;
        level.setBlock(x, y, z, 0);
        convertAdjacentBlock(level, x + 1, y, z);
        convertAdjacentBlock(level, x - 1, y, z);
        convertAdjacentBlock(level, x, y, z + 1);
        convertAdjacentBlock(level, x, y, z - 1);
        itemInstance.count--;
        return true;
    }

    private void convertAdjacentBlock(World level, int x, int y, int z) {
        Block block = Block.BLOCKS[level.getBlockId(x, y, z)];
        if (block == null) return;
        if (!(block instanceof IndestructibleBlock)) return;
        ((IndestructibleBlock) block).convertToRegularBlock(level, x, y, z);
    }
}
