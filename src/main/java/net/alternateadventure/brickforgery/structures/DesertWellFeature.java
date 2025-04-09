package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class DesertWellFeature {

    public void generate(World level, Random rand, int x, int y, int z) {
        if (level.getBlockId(x, y, z) != Block.SAND.id || level.getBlockId(x, y + 1, z) != 0) return;

        for (int xOffset = -2; xOffset <= 2; xOffset++) {
            for (int zOffset = -2; zOffset <= 2; zOffset++) {
                for (int yOffset = 0; yOffset < 2; yOffset++) {
                    level.setBlock(x + xOffset, y + yOffset, z + zOffset, Block.SANDSTONE.id);
                }
            }
        }

        level.setBlock(x + 2, y + 1, z, Block.SLAB.id, 1);
        level.setBlock(x - 2, y + 1, z, Block.SLAB.id, 1);
        level.setBlock(x, y + 1, z + 2, Block.SLAB.id, 1);
        level.setBlock(x, y + 1, z - 2, Block.SLAB.id, 1);

        level.setBlock(x, y, z, Block.WATER.id);
        level.setBlock(x + 1, y, z, Block.WATER.id);
        level.setBlock(x - 1, y, z, Block.WATER.id);
        level.setBlock(x, y, z + 1, Block.WATER.id);
        level.setBlock(x, y, z - 1, Block.WATER.id);

        level.setBlock(x, y + 1, z, 0);
        level.setBlock(x + 1, y + 1, z, 0);
        level.setBlock(x - 1, y + 1, z, 0);
        level.setBlock(x, y + 1, z + 1, 0);
        level.setBlock(x, y + 1, z - 1, 0);

        for (int yOffset = 1; yOffset < 4; yOffset++) {
            level.setBlock(x + 1, y + yOffset, z + 1, Block.SANDSTONE.id);
            level.setBlock(x - 1, y + yOffset, z + 1, Block.SANDSTONE.id);
            level.setBlock(x + 1, y + yOffset, z - 1, Block.SANDSTONE.id);
            level.setBlock(x - 1, y + yOffset, z - 1, Block.SANDSTONE.id);
        }

        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int zOffset = -1; zOffset <= 1; zOffset++) {
                level.setBlock(x + xOffset, y + 4, z + zOffset, Block.SLAB.id, 1);
            }
        }

        level.setBlock(x, y + 4, z, Block.SANDSTONE.id);

        for (int height = -1; height >= -8; height--) {
            level.setBlock(x, y + height, z, Block.WATER.id);
            level.setBlock(x + 1, y + height, z, Block.SANDSTONE.id);
            level.setBlock(x - 1, y + height, z, Block.SANDSTONE.id);
            level.setBlock(x, y + height, z + 1, Block.SANDSTONE.id);
            level.setBlock(x, y + height, z - 1, Block.SANDSTONE.id);
        }

        for (int xOffset = -5; xOffset <= 5; xOffset++) {
            for (int zOffset = -5; zOffset <= 5; zOffset++) {
                for (int yOffset = -9; yOffset >= -14; yOffset--) {
                    if (xOffset < 5 && xOffset > -5 && zOffset < 5 && zOffset > -5 && yOffset < -9 && yOffset > -14) {
                        if (yOffset == -13 && rand.nextInt(4) == 0) level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.bountifulSand.id);
                        else level.setBlock(x + xOffset, y + yOffset, z + zOffset, 0);
                        continue;
                    }
                    if (yOffset > -14) level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.desertWellBricks.id);
                    else level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.desertWellFloor.id);
                }
            }
        }

        level.setBlock(x, y - 9, z, BlockListener.desertWellKeyhole.id);
    }
}
