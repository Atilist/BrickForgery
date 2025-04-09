package net.alternateadventure.brickforgery.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.modificationstation.stationapi.api.util.Identifier;

public class MachineFrameBlock extends LazyBlockTemplate {
    public MachineFrameBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
