package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class BrickSoilBlock extends TemplateBlock {

    public BrickSoilBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public BrickSoilBlock setHardness(float Hardness) {
        return (BrickSoilBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return i == 0 ? TextureListener.BrickSoilBottom : i == 1 ? TextureListener.BrickSoilTop : TextureListener.BrickSoilSide;
    }
}
