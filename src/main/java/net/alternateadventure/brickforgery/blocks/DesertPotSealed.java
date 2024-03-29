package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

// TODO: Add custom pot models
public class DesertPotSealed extends LazyBlockTemplate {
    public DesertPotSealed(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public int getDropId(int i, Random random) {
        return ItemListener.desertPotItem.id;
    }
}
