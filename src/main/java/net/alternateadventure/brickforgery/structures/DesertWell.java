package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
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

        for (int height = -1; height >= -8; height--) {
            level.setTile(x, y + height, z, BlockBase.STILL_WATER.id);
            level.setTile(x + 1, y + height, z, BlockBase.SANDSTONE.id);
            level.setTile(x - 1, y + height, z, BlockBase.SANDSTONE.id);
            level.setTile(x, y + height, z + 1, BlockBase.SANDSTONE.id);
            level.setTile(x, y + height, z - 1, BlockBase.SANDSTONE.id);
        }

        for (int xOffset = -5; xOffset <= 5; xOffset++) {
            for (int zOffset = -5; zOffset <= 5; zOffset++) {
                for (int yOffset = -9; yOffset >= -14; yOffset--) {
                    if (xOffset < 5 && xOffset > -5 && zOffset < 5 && zOffset > -5 && yOffset < -9 && yOffset > -14)
                    {
                        if (yOffset == -13 && rand.nextInt(4) == 0) level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockListener.desertPot.id);
                        else level.setTile(x + xOffset, y + yOffset, z + zOffset, 0);
                        continue;
                    }
                    if (yOffset > -14) level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockListener.desertWellBricks.id);
                    else level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockListener.desertWellFloor.id);
                }
            }
        }

        level.setTile(x, y - 9, z, BlockListener.desertWellKeyhole.id);
    }
}
