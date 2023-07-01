package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public class CommonPotArea {
    public void generate(Level level, Random rand, int x, int y, int z) {
        int randomX;
        int randomY;
        int randomZ;
        for (int i = 0; i < 512; i++) {
            randomX = rand.nextInt(10) - 9;
            randomY = rand.nextInt(10) - 9;
            randomZ = rand.nextInt(10) - 9;
            if ((level.getTileId(x + randomX, y + randomY, z + randomZ) == 0 || level.getTileId(x + randomX, y + randomY, z + randomZ) == BlockBase.SNOW.id) && level.getTileId(x + randomX, y + randomY - 1, z + randomZ) == BlockBase.GRASS.id) {
                if (!rand.nextBoolean()) continue;
                level.setTile(x + randomX, y + randomY - 1, z + randomZ, BlockBase.DOUBLE_STONE_SLAB.id);
                if (rand.nextBoolean()) level.setTile(x + randomX, y + randomY, z + randomZ, BlockListener.commonPot.id);
            }
        }
    }
}
