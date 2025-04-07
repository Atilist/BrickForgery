package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class IndestructibleBlock extends LazyBlockTemplate {
    public IndestructibleBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, float blastResistance) {
        super(identifier, material, hardness, blockSounds);
        setResistance(blastResistance);
    }

    @Override
    public Block setUnbreakable() {
        return super.setUnbreakable();
    }

    public void convertToRegularBlock(World level, int x, int y, int z)
    {
        if (level.getBlockId(x, y, z) == BlockListener.forestVaultWalls.id) level.setBlock(x, y, z, BlockListener.forestOrnament.id);
        else if (level.getBlockId(x, y, z) == BlockListener.desertWellBricks.id) level.setBlock(x, y, z, BlockListener.ancientSandstoneBricks.id);
        else if (level.getBlockId(x, y, z) == BlockListener.desertWellFloor.id) level.setBlock(x, y, z, BlockListener.ancientSandstoneTile.id);
        else if (level.getBlockId(x, y, z) == BlockListener.frostVaultBricks.id) level.setBlock(x, y, z, BlockListener.ancientIceBricks.id);
        else if (level.getBlockId(x, y, z) == BlockListener.frostVaultTiling.id) level.setBlock(x, y, z, BlockListener.ancientIceTiling.id);
        else level.setBlock(x, y, z, 0);
        convertSurroundingBlock(level, x, y + 1, z);
        convertSurroundingBlock(level, x, y - 1, z);
        convertSurroundingBlock(level, x + 1, y, z);
        convertSurroundingBlock(level, x - 1, y, z);
        convertSurroundingBlock(level, x, y, z + 1);
        convertSurroundingBlock(level, x, y, z - 1);
    }

    private void convertSurroundingBlock(World level, int x, int y, int z)
    {
        Block block = Block.BLOCKS[level.getBlockId(x, y, z)];
        if (block == null) return;
        if (!(block instanceof IndestructibleBlock)) return;
        ((IndestructibleBlock) block).convertToRegularBlock(level, x, y, z);
    }
}
