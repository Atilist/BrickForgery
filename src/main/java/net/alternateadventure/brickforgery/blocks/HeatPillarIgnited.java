package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kozibrodka.wolves.events.mod_FCBetterThanWolves;
import net.kozibrodka.wolves.modsupport.AffectedByBellows;
import net.kozibrodka.wolves.utils.FCBlockPos;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Random;

public class HeatPillarIgnited extends LazyBlockTemplate implements AffectedByBellows {
    public HeatPillarIgnited(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
        setLightEmittance(0.75F);
    }

    public boolean isFullOpaque() {
        return false;
    }

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
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int l) {
        if (level.getTileId(x, y - 1, z) != mod_FCBetterThanWolves.fcBBQ.id) level.setTile(x, y, z, BlockListener.heatPillar.id);
        else if (level.getTileMeta(x, y - 1, z) < 4) level.setTile(x, y, z, BlockListener.heatPillar.id);
    }

    @Override
    public void affectBlock(Level world, int i, int j, int k, FCBlockPos tempTargetPos, int facing) {
        world.setTile(i, j, k, BlockListener.heatPillarStoked.id);
    }
}
