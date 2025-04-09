package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class NightLogBlock extends TemplateBlock {

    public NightLogBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public NightLogBlock setHardness(float Hardness) {
        return (NightLogBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return i < 2 ? TextureListener.NightLogTop : TextureListener.NightLogSide;
    }
}
