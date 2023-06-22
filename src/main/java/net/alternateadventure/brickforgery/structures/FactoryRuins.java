package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public class FactoryRuins {

    public void generate(Level level, Random rand, int x, int y, int z) {
        if (!(level.getTileId(x, y, z) != 0 && level.getTileId(x, y + 1, z) == 0)) return;
        int yOffset = 0;
        for (; yOffset > -10; yOffset--) {
            level.setTile(x, y + yOffset, z, BlockBase.GRAVEL.id);
            level.setTile(x + 1, y + yOffset, z, BlockBase.COBBLESTONE.id);
            level.setTile(x - 1, y + yOffset, z, BlockBase.COBBLESTONE.id);
            level.setTile(x, y + yOffset, z + 1, BlockBase.COBBLESTONE.id);
            level.setTile(x, y + yOffset, z - 1, BlockBase.COBBLESTONE.id);
        }
        for (int xOffset = -3; xOffset <= 3; xOffset++) {
            for (int zOffset = -3; zOffset <= 3; zOffset++) {
                level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockBase.COBBLESTONE.id);
            }
        }
        level.setTile(x, y + yOffset, z, BlockBase.TRAPDOOR.id);
        yOffset--;
        for (; yOffset > -15; yOffset--) {
            for (int xOffset = -3; xOffset <= 3; xOffset++) {
                for (int zOffset = -3; zOffset <= 3; zOffset++) {
                    if (xOffset > -3 && xOffset < 3 && zOffset > -3 && zOffset < 3) level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockListener.factoryRubble.id);
                    else level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockListener.largeStoneBricks.id);
                }
            }
        }
        for (int xOffset = -3; xOffset <= 3; xOffset++) {
            for (int zOffset = -3; zOffset <= 3; zOffset++) {
                level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockBase.BRICKS.id);
            }
        }
    }
}
