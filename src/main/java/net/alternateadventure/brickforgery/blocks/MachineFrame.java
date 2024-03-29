package net.alternateadventure.brickforgery.blocks;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.util.Identifier;

public class MachineFrame extends LazyBlockTemplate {
    public MachineFrame(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }
}
