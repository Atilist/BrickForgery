package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class NightLog extends TemplateBlock {

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
