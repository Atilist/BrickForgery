package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class CryogenicHibachiBlock extends LazyBlockTemplate {
    public CryogenicHibachiBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
        this.setTickRandomly(true);
    }

    @Override
    public void onTick(World arg, int i, int j, int k, Random random) {
        if (arg.canTransferPower(i, j, k)) {
            if (arg.getBlockId(i, j + 1, k) == 0) {
                arg.setBlock(i, j + 1, k, BlockListener.frostburn.id);
                arg.playSound((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "fire.ignite", 1.0F, arg.random.nextFloat() * 0.4F + 0.8F);
            } else if (arg.getBlockId(i, j + 1, k) == BlockListener.frostburn.id) {
                arg.setBlockMeta(i, j + 1, k, 0);
            } else if (arg.getBlockId(i, j + 1, k) == Block.WATER.id || arg.getBlockId(i, j + 1, k) == Block.FLOWING_WATER.id) {
                arg.setBlock(i, j + 1, k, Block.SNOW_BLOCK.id);
            }
        } else if (arg.getBlockId(i, j + 1, k) == BlockListener.frostburn.id) {
            arg.setBlock(i, j + 1, k, 0);
        }
    }
    
    @Override
    public int getTickRate() {
        return 1;
    }

    @Override
    public void neighborUpdate(World arg, int i, int j, int k, int l) {
        arg.scheduleBlockUpdate(i, j, k, this.id, getTickRate());
    }
}
