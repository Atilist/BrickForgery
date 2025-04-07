package net.alternateadventure.brickforgery.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class FastBricks extends LazyBlockTemplate {

    public FastBricks(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public Box getCollisionShape(World arg, int i, int j, int k) {
        return Box.create(i, j, k, i + 1.0, j + 0.99, k + 1.0);
    }

    @Override
    public void onEntityCollision(World level, int x, int y, int z, Entity entityBase) {
        if (entityBase == null) return;
        if (!(entityBase instanceof PlayerEntity)) return;
        entityBase.velocityX *= 1.15;
        entityBase.velocityZ *= 1.15;
    }
}
