package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.tileentities.TileEntityItemSlide;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntityBase;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemSlide extends DirectionalMachineTemplate {
    public ItemSlide(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    protected TileEntityBase createTileEntity() {
        return new TileEntityItemSlide();
    }
}