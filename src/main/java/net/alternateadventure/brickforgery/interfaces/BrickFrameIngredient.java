package net.alternateadventure.brickforgery.interfaces;

import net.minecraft.world.World;

import java.util.Random;

public interface BrickFrameIngredient {
    void transformBlock(World world, int x, int y, int z, Random random);
}
