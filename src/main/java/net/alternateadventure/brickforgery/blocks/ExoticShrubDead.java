package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class ExoticShrubDead extends TemplateBlock {

    public ExoticShrubDead(Identifier identifier, Material material) {
        super(identifier, material);
        setTicksRandomly(true);
    }

    @Override
    public ExoticShrubDead setHardness(float Hardness) {
        return (ExoticShrubDead) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i, int j) {
        return TextureListener.ExoticShrubDead;
    }

    @Override
    protected int droppedMeta(int i) {
        return 0;
    }

    @Override
    public int getDropId(int i, Random random) {
        return BlockListener.exoticShrub.id;
    }

    @Override
    public Box getCollisionShape(Level arg, int i, int j, int k) {
        return null;
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void appendProperties(StateManager.Builder<BlockBase, BlockState> builder) {
        super.appendProperties(builder);
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return level.getTileId(x, y, z) == 0 && (level.getTileId(x, y - 1, z) == BlockBase.GRASS.id || level.getTileId(x, y - 1, z) == BlockBase.DIRT.id || level.getTileId(x, y - 1, z) == BlockBase.FARMLAND.id);
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random random) {
        if (!getsSkylight(level, x, y, z)) return;
        level.placeBlockWithMetaData(x, y, z, BlockListener.exoticShrub.id, level.getTileMeta(x, y, z));
    }

    public boolean getsSkylight(Level level, int x, int y, int z)
    {
        for (int height = y + 1; height <= level.getHeight(x, z); height++) {
            if (level.getTileId(x, height, z) == 0) continue;
            if (level.isFullOpaque(x, height, z)) return false;
        }
        return true;
    }
}

