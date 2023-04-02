package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.alternateadventure.brickforgery.interfaces.SpikeCrushable;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class StoneBricks extends TemplateBlockBase implements SpikeCrushable {

    public StoneBricks(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public StoneBricks setHardness(float Hardness) {
        return (StoneBricks) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return TextureListener.StoneBricks;
    }

    @Override
    public ItemInstance crushingOutput() {
        return new ItemInstance(ItemListener.clayPowder, 4);
    }

    @Override
    public int requiredDistance() {
        return 2;
    }
}
