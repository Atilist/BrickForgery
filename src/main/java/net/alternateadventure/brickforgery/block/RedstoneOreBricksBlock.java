package net.alternateadventure.brickforgery.block;

import net.alternateadventure.brickforgery.api.SpikeCrushable;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.modificationstation.stationapi.api.util.Identifier;

public class RedstoneOreBricksBlock extends LazyBlockTemplate implements SpikeCrushable {
    public RedstoneOreBricksBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public ItemStack crushingOutput() {
        return new ItemStack(ItemListener.redstoneOreBrick, 2);
    }

    @Override
    public int requiredDistance() {
        return 5;
    }
}
