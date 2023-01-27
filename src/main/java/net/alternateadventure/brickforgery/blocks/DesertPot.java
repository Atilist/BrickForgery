package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class DesertPot extends TemplateBlockBase {

    public DesertPot(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public DesertPot setHardness(float Hardness) {
        return (DesertPot) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return i == 0 ? TextureListener.DesertPotBottom : i == 1 ? TextureListener.DesertPotTop : TextureListener.DesertPotSide;
    }
}
