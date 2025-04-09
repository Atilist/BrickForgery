package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FrozenPotSealedBlock extends TemplateBlock {

    // TODO: Add custom pot models
    public FrozenPotSealedBlock(Identifier identifier, Material material) {
        super(identifier, material);
        setSoundGroup(Block.GLASS_SOUND_GROUP);
    }

    @Override
    public FrozenPotSealedBlock setHardness(float Hardness) {
        return (FrozenPotSealedBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return i == 0 ? TextureListener.FrozenPotBottom : i == 1 ? TextureListener.FrozenPotTopSealed : TextureListener.FrozenPotSide;
    }

    @Override
    public int getDroppedItemCount(Random random) {
        if (random.nextInt(4) == 0) return 1 + random.nextInt(4);
        return 0;
    }

    @Override
    public int getDroppedItemId(int i, Random random) {
        return ItemListener.cryogenicPowder.id;
    }
}
