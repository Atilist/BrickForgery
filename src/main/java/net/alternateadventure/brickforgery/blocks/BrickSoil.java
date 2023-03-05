package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class BrickSoil extends TemplateBlockBase {

    public BrickSoil(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public BrickSoil setHardness(float Hardness) {
        return (BrickSoil) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return i == 0 ? TextureListener.BrickSoilBottom : i == 1 ? TextureListener.BrickSoilTop : TextureListener.BrickSoilSide;
    }
}
