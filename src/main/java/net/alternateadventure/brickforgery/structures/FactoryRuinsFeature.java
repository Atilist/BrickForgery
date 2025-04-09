package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class FactoryRuinsFeature {

    public void generate(World level, Random rand, int x, int y, int z) {
        if (!(level.getBlockId(x, y, z) != 0 && level.getBlockId(x, y + 1, z) == 0)) return;
        int yOffset = 0;
        for (; yOffset > -10; yOffset--) {
            level.setBlock(x, y + yOffset, z, Block.GRAVEL.id);
            level.setBlock(x + 1, y + yOffset, z, Block.COBBLESTONE.id);
            level.setBlock(x - 1, y + yOffset, z, Block.COBBLESTONE.id);
            level.setBlock(x, y + yOffset, z + 1, Block.COBBLESTONE.id);
            level.setBlock(x, y + yOffset, z - 1, Block.COBBLESTONE.id);
        }
        for (int xOffset = -3; xOffset <= 3; xOffset++) {
            for (int zOffset = -3; zOffset <= 3; zOffset++) {
                level.setBlock(x + xOffset, y + yOffset, z + zOffset, Block.COBBLESTONE.id);
            }
        }
        level.setBlock(x, y + yOffset, z, Block.TRAPDOOR.id);
        yOffset--;
        for (; yOffset > -15; yOffset--) {
            for (int xOffset = -3; xOffset <= 3; xOffset++) {
                for (int zOffset = -3; zOffset <= 3; zOffset++) {
                    if (xOffset > -3 && xOffset < 3 && zOffset > -3 && zOffset < 3) level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.factoryRubble.id);
                    else level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.largeStoneBricks.id);
                }
            }
        }
        for (int xOffset = -3; xOffset <= 3; xOffset++) {
            for (int zOffset = -3; zOffset <= 3; zOffset++) {
                level.setBlock(x + xOffset, y + yOffset, z + zOffset, Block.BRICKS.id);
            }
        }
    }
}
