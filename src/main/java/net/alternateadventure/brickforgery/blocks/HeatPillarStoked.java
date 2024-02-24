package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kozibrodka.wolves.modsupport.AffectedByBellows;
import net.kozibrodka.wolves.utils.BlockPosition;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class HeatPillarStoked extends LazyBlockTemplate implements AffectedByBellows {
    public HeatPillarStoked(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
        setLightEmittance(1.0F);
        setTicksRandomly(true);
    }

    @Override
    public boolean isFullOpaque() {
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
    public int getDropId(int i, Random random) {
        return BlockListener.heatPillar.id;
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random random) {
        if (level.getTileMeta(x, y, z) < 4) level.setTileMeta(x, y, z, level.getTileMeta(x, y, z) + 1);
        else level.placeBlockWithMetaData(x, y, z, BlockListener.heatPillarIgnited.id, 0);
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int l) {
        if (level.getTileId(x, y - 1, z) != net.kozibrodka.wolves.events.BlockListener.hibachi.id) level.setTile(x, y, z, BlockListener.heatPillar.id);
        else if (level.getTileMeta(x, y - 1, z) < 4) level.setTile(x, y, z, BlockListener.heatPillar.id);
    }

    @Override
    public void affectBlock(Level world, int i, int j, int k, BlockPosition tempTargetPos, int facing) {
        world.setTileMeta(i, j, k, 0);
    }
}
