package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kozibrodka.wolves.api.AffectedByBellows;
import net.kozibrodka.wolves.utils.BlockPosition;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class HeatPillarStoked extends LazyBlockTemplate implements AffectedByBellows {
    public HeatPillarStoked(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
        setLuminance(1.0F);
        setTickRandomly(true);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public int getDroppedItemId(int i, Random random) {
        return BlockListener.heatPillar.id;
    }

    @Override
    public void onTick(World level, int x, int y, int z, Random random) {
        if (level.getBlockMeta(x, y, z) < 4) level.setBlockMeta(x, y, z, level.getBlockMeta(x, y, z) + 1);
        else level.setBlock(x, y, z, BlockListener.heatPillarIgnited.id, 0);
    }

    @Override
    public void neighborUpdate(World level, int x, int y, int z, int l) {
        if (level.getBlockId(x, y - 1, z) != net.kozibrodka.wolves.events.BlockListener.hibachi.id) level.setBlock(x, y, z, BlockListener.heatPillar.id);
        else if (level.getBlockMeta(x, y - 1, z) < 4) level.setBlock(x, y, z, BlockListener.heatPillar.id);
    }

    @Override
    public void affectBlock(World world, int i, int j, int k, BlockPosition tempTargetPos, int facing) {
        world.setBlockMeta(i, j, k, 0);
    }
}
