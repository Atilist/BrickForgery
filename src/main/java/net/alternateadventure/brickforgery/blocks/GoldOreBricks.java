package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.interfaces.SpikeCrushable;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.registry.Identifier;

public class GoldOreBricks extends LazyBlockTemplate implements SpikeCrushable {
    public GoldOreBricks(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public ItemInstance crushingOutput() {
        return new ItemInstance(ItemListener.goldOreBrick, 2);
    }

    @Override
    public int requiredDistance() {
        return 5;
    }
}
