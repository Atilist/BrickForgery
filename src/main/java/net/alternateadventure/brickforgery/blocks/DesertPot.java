package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

// TODO: Add custom pot models
public class DesertPot extends TemplateBlock {

    public DesertPot(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(GLASS_SOUNDS);
    }

    @Override
    public DesertPot setHardness(float Hardness) {
        return (DesertPot) super.setHardness(Hardness);
    }

    @Override
    public int getDropCount(Random random) {
        if (random.nextInt(4) == 0) return 1 + random.nextInt(4);
        return 0;
    }

    @Override
    public int getDropId(int i, Random random) {
        return ItemListener.thermalPowder.id;
    }

    @Override
    public int getTextureForSide(int i) {
        return i == 0 ? TextureListener.DesertPotBottom : i == 1 ? TextureListener.DesertPotTop : TextureListener.DesertPotSide;
    }
}
