package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FrozenPot extends TemplateBlock {

    // TODO: Add custom pot models
    public FrozenPot(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(GLASS_SOUNDS);
    }

    @Override
    public FrozenPot setHardness(float Hardness) {
        return (FrozenPot) super.setHardness(Hardness);
    }

    @Override
    public int getDropCount(Random random) {
        return 0;
    }

    @Override
    public int getDropId(int i, Random random) {
        return 0;
    }

    @Override
    public int getTextureForSide(int i) {
        return i == 0 ? TextureListener.FrozenPotBottom : i == 1 ? TextureListener.FrozenPotTop : TextureListener.FrozenPotSide;
    }
}
