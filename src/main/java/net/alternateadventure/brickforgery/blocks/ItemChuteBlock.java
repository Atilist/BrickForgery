package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.blocks.entity.ItemChuteBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemChuteBlock extends LazySimpleMachineBlockTemplate {
    public ItemChuteBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new ItemChuteBlockEntity();
    }
}
