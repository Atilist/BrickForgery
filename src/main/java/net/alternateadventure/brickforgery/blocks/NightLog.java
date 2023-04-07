package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class NightLog extends TemplateBlockBase {

    public NightLog(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public NightLog setHardness(float Hardness) {
        return (NightLog) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return i < 2 ? TextureListener.NightLogTop : TextureListener.NightLogSide;
    }
}
