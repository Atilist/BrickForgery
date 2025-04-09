package net.alternateadventure.brickforgery.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.modificationstation.stationapi.api.util.Identifier;

public class HeatPillarBlock extends LazyBlockTemplate {
    public HeatPillarBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    public boolean isFullOpaque() {
        return false;
    }

    public boolean isFullCube() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }
}
