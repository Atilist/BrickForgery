package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class Dust extends TemplateBlock {

    public Dust(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public Dust setHardness(float Hardness) {
        return (Dust) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return TextureListener.Dust;
    }
}
