package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class ExoticShrubDeadBlock extends TemplateBlock {

    public ExoticShrubDeadBlock(Identifier identifier, Material material) {
        super(identifier, material);
        setTickRandomly(true);
    }

    @Override
    public ExoticShrubDeadBlock setHardness(float Hardness) {
        return (ExoticShrubDeadBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i, int j) {
        return TextureListener.ExoticShrubDead;
    }

    @Override
    protected int getDroppedItemMeta(int i) {
        return 0;
    }

    @Override
    public int getDroppedItemId(int i, Random random) {
        return BlockListener.exoticShrub.id;
    }

    @Override
    public Box getCollisionShape(World arg, int i, int j, int k) {
        return null;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean canPlaceAt(World level, int x, int y, int z) {
        return level.getBlockId(x, y, z) == 0 && (level.getBlockId(x, y - 1, z) == Block.GRASS.id || level.getBlockId(x, y - 1, z) == Block.DIRT.id || level.getBlockId(x, y - 1, z) == Block.FARMLAND.id);
    }

    @Override
    public void onTick(World level, int x, int y, int z, Random random) {
        if (!getsSkylight(level, x, y, z)) return;
        level.setBlock(x, y, z, BlockListener.exoticShrub.id, level.getBlockMeta(x, y, z));
    }

    public boolean getsSkylight(World level, int x, int y, int z)
    {
        for (int height = y + 1; height <= level.getTopSolidBlockY(x, z); height++) {
            if (level.getBlockId(x, height, z) == 0) continue;
            if (level.method_1783(x, height, z)) return false;
        }
        return true;
    }
}

