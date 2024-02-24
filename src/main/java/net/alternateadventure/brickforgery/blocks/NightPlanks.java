package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class NightPlanks extends TemplateBlock {

    public NightPlanks(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public NightPlanks setHardness(float Hardness) {
        return (NightPlanks) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return TextureListener.NightPlanks;
    }
}