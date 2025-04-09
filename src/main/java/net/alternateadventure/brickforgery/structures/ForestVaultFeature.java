package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class ForestVaultFeature {
    public void generate(World level, Random rand, int x, int y, int z) {
        if (level.getBlockId(x, y, z) != Block.GRASS.id) return;
        for (int xOffset = -2; xOffset <= 2; xOffset++) {
            for (int zOffset = -2; zOffset <= 2; zOffset++) {
                for (int yOffset = 10; yOffset < 18; yOffset++) {
                    if (yOffset % 2 == 1 && (xOffset == 2 || xOffset == -2 || zOffset == 2 || zOffset == -2)) continue;
                    level.setBlock(x + xOffset, y + yOffset, z + zOffset, Block.LEAVES.id);
                }
            }
        }
        level.setBlock(x, y + 18, z, Block.LEAVES.id);
        for (int yOffset = 1; yOffset < 16; yOffset++) {
            level.setBlock(x, y + yOffset, z, Block.LOG.id);
        }
        y -= 10;
        for (int xOffset = -5; xOffset <= 5; xOffset++) {
            for (int zOffset = -5; zOffset <= 5; zOffset++) {
                for (int yOffset = 0; yOffset >= -5; yOffset--) {
                    if (xOffset < 5 && xOffset > -5 && zOffset < 5 && zOffset > -5 && yOffset < 0 && yOffset > -5)
                    {
                        if (yOffset == -4 && rand.nextInt(4) == 0) level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.commonPot.id);
                        else level.setBlock(x + xOffset, y + yOffset, z + zOffset, 0);
                        continue;
                    }
                    level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.forestVaultWalls.id);
                }
            }
        }

        level.setBlock(x, y, z, BlockListener.forestVaultKeyhole.id);
    }
}
