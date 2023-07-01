package net.alternateadventure.brickforgery.blocks;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Random;

public class CommonPot extends LazyBlockTemplate {
    public CommonPot(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public int getDropCount(Random random) {
        return 0;
    }
}
