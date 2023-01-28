package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class BrickFrameCrafterDusted extends TemplateBlockBase {
    public BrickFrameCrafterDusted(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public BrickFrameCrafterDusted setHardness(float Hardness) {
        return (BrickFrameCrafterDusted) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return i == 0 ? TextureListener.BrickFrameCrafterBottom : i == 1 ? TextureListener.BrickFrameCrafterTopDusted : TextureListener.BrickFrameCrafterSide;
    }
}
