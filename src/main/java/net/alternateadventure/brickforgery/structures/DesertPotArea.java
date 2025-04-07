package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class DesertPotArea {

    public void generate(World level, Random rand, int x, int y, int z) {
        if (!(level.getBlockId(x, y, z) == 0 && level.getBlockId(x, y - 1, z) == Block.SAND.id)) return;
        for (int xOffset = -4; xOffset <= 4; xOffset++) {
            for (int yOffset = -5; yOffset <= 2; yOffset++) {
                for (int zOffset = -4; zOffset <= 4; zOffset++) {
                    if (level.getBlockId(x + xOffset, y + yOffset, z + zOffset) != Block.SAND.id)
                    {
                        if (level.getBlockId(x + xOffset, y + yOffset, z + zOffset) == 0 && level.getBlockId(x + xOffset, y + yOffset - 1, z + zOffset) == BlockListener.bountifulSand.id && rand.nextInt(8) == 0) level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.desertPotSealed.id);
                    }
                    else if (rand.nextInt(4) == 0) level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.bountifulSand.id);
                }
            }
        }
    }
}
