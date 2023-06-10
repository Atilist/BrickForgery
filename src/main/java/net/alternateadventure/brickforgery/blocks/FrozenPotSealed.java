package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class FrozenPotSealed extends TemplateBlockBase {

    public FrozenPotSealed(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(GLASS_SOUNDS);
    }

    @Override
    public FrozenPotSealed setHardness(float Hardness) {
        return (FrozenPotSealed) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return i == 0 ? TextureListener.FrozenPotBottom : i == 1 ? TextureListener.FrozenPotTopSealed : TextureListener.FrozenPotSide;
    }

    @Override
    public int getDropId(int i, Random random) {
        return ItemListener.archeologyToolBase.id;
    }
}
