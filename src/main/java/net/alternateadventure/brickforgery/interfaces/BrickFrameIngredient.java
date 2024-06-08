package net.alternateadventure.brickforgery.interfaces;

import net.minecraft.level.Level;

import java.util.Random;

public interface BrickFrameIngredient {
    void transformBlock(Level world, int x, int y, int z, Random random);
}
