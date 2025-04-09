package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class DustBlock extends TemplateBlock {

    public DustBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public DustBlock setHardness(float Hardness) {
        return (DustBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return TextureListener.Dust;
    }
}
