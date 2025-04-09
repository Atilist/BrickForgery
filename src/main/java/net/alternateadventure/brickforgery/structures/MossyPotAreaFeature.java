package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class MossyPotAreaFeature {
    public void generate(World level, Random rand, int x, int y, int z) {
        if (level.getBlockId(x, y, z) == 0 && level.getBlockId(x, y - 1, z) == Block.STONE.id) level.setBlock(x, y, z, BlockListener.mossyPot.id);
    }
}
