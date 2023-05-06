package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Random;

public class DoublePlant extends LazyBlockTemplate {
    public DoublePlant(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public int getTextureForSide(int i, int j)
    {
        return j == 0 ? TextureListener.DoubleRose : TextureListener.DoubleDandelion;
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
    public boolean canUse(Level level, int x, int y, int z, PlayerBase arg2) {
        ItemInstance playerItem = arg2.getHeldItem();
        if (playerItem == null) return false;
        if (playerItem.itemId != ItemBase.shears.id) return false;
        if (level.getTileMeta(x, y, z) == 0)
        {
            level.placeBlockWithMetaData(x, y, z, BlockBase.ROSE.id, 1);
            level.spawnEntity(new Item(level, x, y, z, new ItemInstance(BlockBase.ROSE)));
        }
        else if (level.getTileMeta(x, y, z) == 1)
        {
            level.placeBlockWithMetaData(x, y, z, BlockBase.DANDELION.id, 1);
            level.spawnEntity(new Item(level, x, y, z, new ItemInstance(BlockBase.DANDELION)));
        }
        playerItem.applyDamage(1, arg2);
        return true;
    }

    @Override
    public int getDropId(int i, Random random) {
        if (i == 0) return BlockBase.ROSE.id;
        return BlockBase.DANDELION.id;
    }

    @Override
    public Box getCollisionShape(Level arg, int i, int j, int k) {
        return null;
    }
}
