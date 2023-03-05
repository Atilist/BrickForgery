package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class Dust extends TemplateBlockBase {

    public Dust(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public Dust setHardness(float Hardness) {
        return (Dust) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return TextureListener.Dust;
    }
}
