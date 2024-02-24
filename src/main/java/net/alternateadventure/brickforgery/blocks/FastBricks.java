package net.alternateadventure.brickforgery.blocks;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.util.Identifier;

public class FastBricks extends LazyBlockTemplate {

    public FastBricks(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public Box getCollisionShape(Level arg, int i, int j, int k) {
        return Box.create(i, j, k, i + 1.0, j + 0.99, k + 1.0);
    }

    @Override
    public void onEntityCollision(Level level, int x, int y, int z, EntityBase entityBase) {
        if (entityBase == null) return;
        if (!(entityBase instanceof PlayerBase)) return;
        entityBase.velocityX *= 1.15;
        entityBase.velocityZ *= 1.15;
    }
}
