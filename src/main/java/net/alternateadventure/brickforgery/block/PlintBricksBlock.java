package net.alternateadventure.brickforgery.block;

import net.alternateadventure.brickforgery.api.BrickFrameIngredient;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class PlintBricksBlock extends LazyBlockTemplate implements BrickFrameIngredient {
    public PlintBricksBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public void transformBlock(World world, int x, int y, int z, Random random) {
        world.setBlock(x, y, z, BlockListener.plintPile.id);
        world.setBlockState(x, y, z, BlockListener.plintPile.getDefaultState().with(ResourcePileBlock.USES, 15));
    }
}
