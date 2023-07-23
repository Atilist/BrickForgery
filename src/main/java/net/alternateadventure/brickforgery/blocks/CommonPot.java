package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
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
        if (random.nextInt(4) == 0) return 1 + random.nextInt(4);
        return 0;
    }

    @Override
    public int getDropId(int i, Random random) {
        return ItemListener.fortunePowder.id;
    }
}
