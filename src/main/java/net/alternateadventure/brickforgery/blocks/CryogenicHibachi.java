package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class CryogenicHibachi extends LazyBlockTemplate {
    public CryogenicHibachi(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
        this.setTicksRandomly(true);
    }

    @Override
    public void onScheduledTick(Level arg, int i, int j, int k, Random random) {
        if (arg.hasRedstonePower(i, j, k)) {
            if (arg.getTileId(i, j + 1, k) == 0) {
                arg.setTile(i, j + 1, k, BlockListener.frostburn.id);
                arg.playSound((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "fire.ignite", 1.0F, arg.rand.nextFloat() * 0.4F + 0.8F);
            } else if (arg.getTileId(i, j + 1, k) == BlockListener.frostburn.id) {
                arg.setTileMeta(i, j + 1, k, 0);
            } else if (arg.getTileId(i, j + 1, k) == BlockBase.STILL_WATER.id || arg.getTileId(i, j + 1, k) == BlockBase.FLOWING_WATER.id) {
                arg.setTile(i, j + 1, k, BlockBase.SNOW_BLOCK.id);
            }
        } else if (arg.getTileId(i, j + 1, k) == BlockListener.frostburn.id) {
            arg.setTile(i, j + 1, k, 0);
        }
    }

    @Override
    public int getTickrate() {
        return 1;
    }

    @Override
    public void onAdjacentBlockUpdate(Level arg, int i, int j, int k, int l) {
        arg.method_216(i, j, k, this.id, getTickrate());
    }
}
