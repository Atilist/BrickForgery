package net.alternateadventure.brickforgery.structures;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class ExoticShrubAreaFeature {
    public void generate(World level, Random rand, int x, int y, int z) {
        if ((level.getBlockId(x, y, z) == 0 || level.getBlockId(x, y ,z) == Block.SNOW.id) && level.getBlockId(x, y - 1, z) == Block.GRASS_BLOCK.id) level.setBlock(x, y, z, BlockListener.exoticShrub.id);
    }
}
