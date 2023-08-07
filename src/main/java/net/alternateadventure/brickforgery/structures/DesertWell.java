package net.alternateadventure.brickforgery.structures;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public class DesertWell {

    public void generate(Level level, Random rand, int x, int y, int z)
    {
        if (level.getTileId(x, y, z) != BlockBase.SAND.id || level.getTileId(x, y + 1, z) != 0) return;

        for (int xOffset = -2; xOffset <= 2; xOffset++) {
            for (int zOffset = -2; zOffset <= 2; zOffset++) {
                for (int yOffset = 0; yOffset < 2; yOffset++) {
                    level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockBase.SANDSTONE.id);
                }
            }
        }

        level.setTileWithMetadata(x + 2, y + 1, z, BlockBase.STONE_SLAB.id, 1);
        level.setTileWithMetadata(x - 2, y + 1, z, BlockBase.STONE_SLAB.id, 1);
        level.setTileWithMetadata(x, y + 1, z + 2, BlockBase.STONE_SLAB.id, 1);
        level.setTileWithMetadata(x, y + 1, z - 2, BlockBase.STONE_SLAB.id, 1);

        level.setTile(x, y, z, BlockBase.STILL_WATER.id);
        level.setTile(x + 1, y, z, BlockBase.STILL_WATER.id);
        level.setTile(x - 1, y, z, BlockBase.STILL_WATER.id);
        level.setTile(x, y, z + 1, BlockBase.STILL_WATER.id);
        level.setTile(x, y, z - 1, BlockBase.STILL_WATER.id);

        level.setTile(x, y + 1, z, 0);
        level.setTile(x + 1, y + 1, z, 0);
        level.setTile(x - 1, y + 1, z, 0);
        level.setTile(x, y + 1, z + 1, 0);
        level.setTile(x, y + 1, z - 1, 0);

        for (int yOffset = 1; yOffset < 4; yOffset++)
        {
            level.setTile(x + 1, y + yOffset, z + 1, BlockBase.SANDSTONE.id);
            level.setTile(x - 1, y + yOffset, z + 1, BlockBase.SANDSTONE.id);
            level.setTile(x + 1, y + yOffset, z - 1, BlockBase.SANDSTONE.id);
            level.setTile(x - 1, y + yOffset, z - 1, BlockBase.SANDSTONE.id);
        }

        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int zOffset = -1; zOffset <= 1; zOffset++) {
                level.setTileWithMetadata(x + xOffset, y + 4, z + zOffset, BlockBase.STONE_SLAB.id, 1);
            }
        }

        level.setTile(x, y + 4, z, BlockBase.SANDSTONE.id);
    }
}
