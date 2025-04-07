package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.tileentities.TileEntityItemElevator;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemElevator extends LazySimpleMachine {
    public ItemElevator(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new TileEntityItemElevator();
    }
}
