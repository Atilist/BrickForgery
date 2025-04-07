package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FrozenPotSealed extends TemplateBlock {

    // TODO: Add custom pot models
    public FrozenPotSealed(Identifier identifier, Material material) {
        super(identifier, material);
        setSoundGroup(Block.GLASS_SOUND_GROUP);
    }

    @Override
    public FrozenPotSealed setHardness(float Hardness) {
        return (FrozenPotSealed) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return i == 0 ? TextureListener.FrozenPotBottom : i == 1 ? TextureListener.FrozenPotTopSealed : TextureListener.FrozenPotSide;
    }

    @Override
    public int getDroppedItemId(int i, Random random) {
        return ItemListener.frozenPotItem.id;
    }
}
