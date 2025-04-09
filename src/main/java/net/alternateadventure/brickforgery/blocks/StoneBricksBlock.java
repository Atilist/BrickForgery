package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.alternateadventure.brickforgery.interfaces.SpikeCrushable;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class StoneBricksBlock extends TemplateBlock implements SpikeCrushable {

    public StoneBricksBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public StoneBricksBlock setHardness(float Hardness) {
        return (StoneBricksBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return TextureListener.StoneBricks;
    }

    @Override
    public ItemStack crushingOutput() {
        return new ItemStack(ItemListener.clayPowder, 4);
    }

    @Override
    public int requiredDistance() {
        return 2;
    }
}
