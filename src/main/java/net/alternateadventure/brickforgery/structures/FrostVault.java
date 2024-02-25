package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public class FrostVault {

    public void generate(Level level, Random rand, int x, int y, int z) {
        if (!(level.getTileId(x, y + 1, z) == 0 && level.getTileId(x, y, z) == BlockBase.SNOW.id)) return;
        for (int xOffset = -6; xOffset <= 6; xOffset++) {
            for (int zOffset = -6; zOffset <= 6; zOffset++) {
                for (int yOffset = 1; yOffset >= -6; yOffset--) {
                    if (yOffset == 0) {
                        level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockListener.frostVaultBricks.id);
                    } else if ((xOffset == -6 || xOffset == 6 || zOffset == -6 || zOffset == 6) && yOffset > -6) {
                        level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockListener.frostVaultBricks.id);
                    } else if (yOffset == -6) {
                        level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockListener.frostVaultTiling.id);
                    } else {
                        if (yOffset == -5 && rand.nextInt(4) == 0) {
                            level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockListener.frozenPot.id);
                        } else {
                            level.setTile(x + xOffset, y + yOffset, z + zOffset, 0);
                        }

                    }
                }
            }
        }
        level.setTile(x, y, z, BlockListener.frostVaultKeyhole.id);
    }
}
