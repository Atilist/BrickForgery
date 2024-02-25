package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.util.Identifier;

public class IndestructibleBlock extends LazyBlockTemplate {
    public IndestructibleBlock(Identifier identifier, Material material, float hardness, BlockSounds blockSounds, float blastResistance) {
        super(identifier, material, hardness, blockSounds);
        setBlastResistance(blastResistance);
    }

    @Override
    public BlockBase setUnbreakable() {
        return super.setUnbreakable();
    }

    public void convertToRegularBlock(Level level, int x, int y, int z)
    {
        if (level.getTileId(x, y, z) == BlockListener.forestVaultWalls.id) level.setTile(x, y, z, BlockListener.forestOrnament.id);
        else if (level.getTileId(x, y, z) == BlockListener.desertWellBricks.id) level.setTile(x, y, z, BlockListener.ancientSandstoneBricks.id);
        else if (level.getTileId(x, y, z) == BlockListener.desertWellFloor.id) level.setTile(x, y, z, BlockListener.ancientSandstoneTile.id);
        else if (level.getTileId(x, y, z) == BlockListener.frostVaultBricks.id) level.setTile(x, y, z, BlockListener.ancientIceBricks.id);
        else if (level.getTileId(x, y, z) == BlockListener.frostVaultTiling.id) level.setTile(x, y, z, BlockListener.ancientIceTiling.id);
        else level.setTile(x, y, z, 0);
        convertSurroundingBlock(level, x, y + 1, z);
        convertSurroundingBlock(level, x, y - 1, z);
        convertSurroundingBlock(level, x + 1, y, z);
        convertSurroundingBlock(level, x - 1, y, z);
        convertSurroundingBlock(level, x, y, z + 1);
        convertSurroundingBlock(level, x, y, z - 1);
    }

    private void convertSurroundingBlock(Level level, int x, int y, int z)
    {
        BlockBase block = BlockBase.BY_ID[level.getTileId(x, y, z)];
        if (block == null) return;
        if (!(block instanceof IndestructibleBlock)) return;
        ((IndestructibleBlock) block).convertToRegularBlock(level, x, y, z);
    }
}
