package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class WoodenBricks extends TemplateBlock {

    public WoodenBricks(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public WoodenBricks setHardness(float Hardness) {
        return (WoodenBricks) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return TextureListener.WoodenBricks;
    }
}
