package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

// TODO: Add custom pot models
public class DesertPotSealedBlock extends LazyBlockTemplate {
    public DesertPotSealedBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public int getDroppedItemId(int i, Random random) {
        return ItemListener.desertPotItem.id;
    }
}
