package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class DoublePlant extends LazyBlockTemplate {
    public DoublePlant(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public int getTexture(int i, int j) {
        return j == 0 ? TextureListener.DoubleRose : TextureListener.DoubleDandelion;
    }

    public boolean isOpaque() {
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
    public boolean onUse(World level, int x, int y, int z, PlayerEntity arg2) {
        ItemStack playerItem = arg2.getHeldItem();
        if (playerItem == null) return false;
        if (playerItem.itemId != Item.SHEARS.id) return false;
        if (level.getBlockMeta(x, y, z) == 0) {
            level.setBlock(x, y, z, Block.ROSE.id, 1);
            level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(Block.ROSE)));
        } else if (level.getBlockMeta(x, y, z) == 1) {
            level.setBlock(x, y, z, Block.DANDELION.id, 1);
            level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(Block.DANDELION)));
        }
        playerItem.damage(1, arg2);
        return true;
    }

    @Override
    public int getDroppedItemId(int i, Random random) {
        if (i == 0) return Block.ROSE.id;
        return Block.DANDELION.id;
    }

    @Override
    public Box getCollisionShape(World arg, int i, int j, int k) {
        return null;
    }
}
