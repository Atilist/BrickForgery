package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.blocks.IndestructibleBlock;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;

public class ExoticKey extends LazyItemTemplate {
    public ExoticKey(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int l) {
        if (level.getTileId(x, y, z) != BlockListener.forestVaultKeyhole.id) return false;
        level.setTile(x, y, z, 0);
        convertAdjacentBlock(level, x + 1, y, z);
        convertAdjacentBlock(level, x - 1, y, z);
        convertAdjacentBlock(level, x, y, z + 1);
        convertAdjacentBlock(level, x, y, z - 1);
        item.count--;
        return true;
    }

    private void convertAdjacentBlock(Level level, int x, int y, int z)
    {
        BlockBase block = BlockBase.BY_ID[level.getTileId(x, y, z)];
        if (block == null) return;
        if (!(block instanceof IndestructibleBlock)) return;
        ((IndestructibleBlock) block).convertToRegularBlock(level, x, y, z);
    }
}
