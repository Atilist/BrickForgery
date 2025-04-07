package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.interfaces.SpikeCrushable;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.modificationstation.stationapi.api.util.Identifier;

public class GoldOreBricks extends LazyBlockTemplate implements SpikeCrushable {
    public GoldOreBricks(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public ItemStack crushingOutput() {
        return new ItemStack(ItemListener.goldOreBrick, 2);
    }

    @Override
    public int requiredDistance() {
        return 5;
    }
}
