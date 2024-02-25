package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemBase;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class Frostburn extends LazyBlockTemplate {
    public Frostburn(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
        setLightEmittance(0.5F);
        this.setTicksRandomly(true);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    public Box getCollisionShape(Level arg, int i, int j, int k) {
        return null;
    }

    @Override
    public boolean canPlaceAt(Level arg, int i, int j, int k) {
        return arg.getTileId(i, j - 1, k) == BlockListener.cryogenicHibachi.id;
    }

    @Override
    public void onAdjacentBlockUpdate(Level arg, int i, int j, int k, int l) {
        if (!canPlaceAt(arg, i, j, k)) {
            arg.setTile(i, j, k, 0);
        }
    }

    @Override
    public void onScheduledTick(Level arg, int i, int j, int k, Random random) {
        if (arg.getTileMeta(i, j, k) < 3) {
            arg.setTileMeta(i, j, k, arg.getTileMeta(i, j, k) + 1);
        } else {
            arg.setTile(i, j, k, 0);
        }
    }

    @Override
    public void onEntityCollision(Level arg, int i, int j, int k, EntityBase arg2) {
        if (arg2 instanceof Item) {
            if (((Item) arg2).item.itemId == ItemBase.brick.id) {
                ((Item) arg2).item.itemId = ItemListener.frozenBrick.id;
                arg.playSound((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.fizz", 1.0F, arg.rand.nextFloat() * 0.4F + 2.8F);
            }
        }
    }


}
