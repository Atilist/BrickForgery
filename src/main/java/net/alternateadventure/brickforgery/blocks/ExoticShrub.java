package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class ExoticShrub extends TemplateBlockBase {

    public ExoticShrub(Identifier identifier, Material material) {
        super(identifier, material);
        setTicksRandomly(true);
    }

    @Override
    public ExoticShrub setHardness(float Hardness) {
        return (ExoticShrub) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i, int j) {
        return j < 15 ? TextureListener.ExoticShrub : TextureListener.ExoticShrubMature;
    }

    @Override
    protected int droppedMeta(int i) {
        return 0;
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
    public boolean canUse(Level level, int x, int y, int z, PlayerBase playerBase) {
        if (level.getTileMeta(x, y, z) != 15) return false;
        level.placeBlockWithMetaData(x, y, z, BlockListener.exoticShrub.id, 0);
        level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.exoticFruit)));
        return true;
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
        if (!getsSkylight(level, x, y, z))
        {
            level.placeBlockWithMetaData(x, y, z, BlockListener.exoticShrubDead.id, level.getTileMeta(x, y, z));
            return;
        }
        if (level.isDaylight()) return;
        if (level.getTileMeta(x, y, z) == 15)
        {
            boolean fertilizedFlowers = false;
            if (random.nextInt(2) != 0) return;

            if (checkForFlowerAndGrow(level, x + 1, y, z, BlockBase.ROSE.id, 0))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x - 1, y, z, BlockBase.ROSE.id, 0))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x, y, z + 1, BlockBase.ROSE.id, 0))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x, y, z - 1, BlockBase.ROSE.id, 0))  fertilizedFlowers = true;

            if (checkForFlowerAndGrow(level, x + 1, y, z, BlockBase.DANDELION.id, 1))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x - 1, y, z, BlockBase.DANDELION.id, 1))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x, y, z + 1, BlockBase.DANDELION.id, 1))  fertilizedFlowers = true;
            if (checkForFlowerAndGrow(level, x, y, z - 1, BlockBase.DANDELION.id, 1))  fertilizedFlowers = true;

            if (fertilizedFlowers) level.setTileMeta(x, y, z, 0);
        }
        else level.setTileMeta(x, y, z, level.getTileMeta(x, y, z) + 1);
    }

    public boolean checkForFlowerAndGrow(Level level, int x, int y, int z, int inputBlockID, int outputBlockMeta)
    {
        if (level.getTileId(x, y, z) == inputBlockID)
        {
            level.placeBlockWithMetaData(x, y, z, BlockListener.doublePlant.id, outputBlockMeta);
            return true;
        }
        return false;
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
