package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class ExoticShrubBlock extends TemplateBlock {

    public ExoticShrubBlock(Identifier identifier, Material material) {
        super(identifier, material);
        setTickRandomly(true);
    }

    @Override
    public ExoticShrubBlock setHardness(float Hardness) {
        return (ExoticShrubBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i, int j) {
        return j < 15 ? TextureListener.ExoticShrub : TextureListener.ExoticShrubMature;
    }

    @Override
    protected int getDroppedItemMeta(int i) {
        return 0;
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
    public boolean onUse(World level, int x, int y, int z, PlayerEntity playerBase) {
        if (level.getBlockMeta(x, y, z) != 15) return false;
        level.setBlock(x, y, z, BlockListener.exoticShrub.id, 0);
        level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.exoticFruit)));
        return true;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        int belowId = world.getBlockId(x, y - 1, z);
        return world.getBlockId(x, y, z) == 0 && (belowId == Block.GRASS_BLOCK.id || belowId == Block.DIRT.id || belowId == Block.FARMLAND.id);
    }

    @Override
    public void onTick(World level, int x, int y, int z, Random random) {
        if (!getsSkylight(level, x, y, z)) {
            level.setBlock(x, y, z, BlockListener.exoticShrubDead.id, level.getBlockMeta(x, y, z));
            return;
        }
        if (level.getTime() % 24000 < 12000) return;
        if (level.getBlockMeta(x, y, z) == 15) {
            boolean fertilizedFlowers = false;
            if (random.nextInt(2) != 0) return;

            if (checkForFlowerAndGrow(level, x + 1, y, z, Block.ROSE.id, 0))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x - 1, y, z, Block.ROSE.id, 0))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x, y, z + 1, Block.ROSE.id, 0))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x, y, z - 1, Block.ROSE.id, 0))  fertilizedFlowers = true;

            if (checkForFlowerAndGrow(level, x + 1, y, z, Block.DANDELION.id, 1))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x - 1, y, z, Block.DANDELION.id, 1))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x, y, z + 1, Block.DANDELION.id, 1))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x, y, z - 1, Block.DANDELION.id, 1))  fertilizedFlowers = true;

            if (fertilizedFlowers) level.setBlockMeta(x, y, z, 0);
        } else level.setBlockMeta(x, y, z, level.getBlockMeta(x, y, z) + 1);
    }

    public boolean checkForFlowerAndGrow(World level, int x, int y, int z, int inputBlockID, int outputBlockMeta) {
        if (level.getBlockId(x, y, z) == inputBlockID) {
            level.setBlock(x, y, z, BlockListener.doublePlant.id, outputBlockMeta);
            return true;
        }
        return false;
    }

    public boolean getsSkylight(World level, int x, int y, int z) {
        for (int height = y + 1; height <= level.getTopSolidBlockY(x, z); height++) {
            if (level.getBlockId(x, height, z) == 0) continue;
            if (level.method_1783(x, height, z)) return false;
        }
        return true;
    }
}
