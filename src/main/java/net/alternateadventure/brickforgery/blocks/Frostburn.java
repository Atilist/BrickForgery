package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class Frostburn extends LazyBlockTemplate {
    public Frostburn(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
        setLuminance(0.5F);
        this.setTickRandomly(true);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
    
    @Override
    public boolean hasCollision() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    public Box getCollisionShape(World arg, int i, int j, int k) {
        return null;
    }

    @Override
    public boolean canPlaceAt(World arg, int i, int j, int k) {
        return arg.getBlockId(i, j - 1, k) == BlockListener.cryogenicHibachi.id;
    }

    @Override
    public void neighborUpdate(World arg, int i, int j, int k, int l) {
        if (!canPlaceAt(arg, i, j, k)) {
            arg.setBlock(i, j, k, 0);
        }
    }

    @Override
    public void onTick(World arg, int i, int j, int k, Random random) {
        if (arg.getBlockMeta(i, j, k) < 3) {
            arg.setBlock(i, j, k, arg.getBlockMeta(i, j, k) + 1);
        } else {
            arg.setBlock(i, j, k, 0);
        }
    }

    @Override
    public void onEntityCollision(World arg, int i, int j, int k, Entity arg2) {
        if (arg2 instanceof ItemEntity) {
            if (((ItemEntity) arg2).stack.itemId == Item.BRICK.id) {
                ((ItemEntity) arg2).stack.itemId = ItemListener.frozenBrick.id;
                arg.playSound((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.fizz", 1.0F, arg.random.nextFloat() * 0.4F + 2.8F);
            }
        }
    }


}
