package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class NightPlanks extends TemplateBlockBase {

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