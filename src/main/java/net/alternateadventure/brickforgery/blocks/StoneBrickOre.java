package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class StoneBrickOre extends TemplateBlockBase {

    public StoneBrickOre(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public StoneBrickOre setHardness(float Hardness) {
        return (StoneBrickOre) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return TextureListener.StoneBrickOre;
    }

    @Override
    public int getDropId(int i, Random random) {
        return ItemListener.stoneBrick.id;
    }

    @Override
    public int getDropCount(Random random) {
        return 1 + random.nextInt(3);
    }
}
