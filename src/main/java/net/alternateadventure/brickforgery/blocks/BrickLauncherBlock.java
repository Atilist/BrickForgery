package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.alternateadventure.brickforgery.interfaces.SpikeCrushable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class BrickLauncherBlock extends TemplateBlock {

    public BrickLauncherBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public BrickLauncherBlock setHardness(float Hardness) {
        return (BrickLauncherBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return i == 0 ? TextureListener.BrickLauncherBottom : i == 1 ? TextureListener.BrickLauncherTop : TextureListener.BrickLauncherSide;
    }

    @Override
    public boolean onUse(World level, int x, int y, int z, PlayerEntity arg2) {
        crushBlock(level, x, y, z);
        return true;
    }

    public void crushBlock(World level, int x, int y, int z) {
        Block inputBlock = Block.BLOCKS[level.getBlockId(x, y + 1, z)];
        if (inputBlock == null) return;
        if (!(inputBlock instanceof SpikeCrushable)) return;
        int yOffset;
        for (yOffset = 1; yOffset < ((SpikeCrushable) inputBlock).requiredDistance(); yOffset++) if (level.getBlockId(x, y - yOffset, z) != 0) return;
        if (level.getBlockId(x, y - yOffset - 1, z) != BlockListener.spikeMount.id || level.getBlockMeta(x, y - yOffset - 1, z) != 1) return;
        level.spawnEntity(new ItemEntity(level, x, y - yOffset, z, ((SpikeCrushable) inputBlock).crushingOutput()));
        level.setBlock(x, y + 1, z, 0);
        level.setBlock(x, y - yOffset - 1, z, BlockListener.spikeMount.id, 0);
    }
}