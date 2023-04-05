package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public class FrozenPotArea {

    public void generate(Level level, Random rand, int x, int y, int z) {
        if (level.getTileId(x, y, z) == BlockBase.SNOW.id && level.getTileId(x, y - 1, z) != 0) level.setTile(x, y, z, BlockListener.frozenPotSealed.id);
    }
}
