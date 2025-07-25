package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class NightCaneBlock extends LazyBlockTemplate {
    private final int dropQuantity;

    public NightCaneBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, int dropQuantity) {
        super(identifier, material, hardness, blockSounds);
        setTickRandomly(true);
        this.dropQuantity = dropQuantity;
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
    public int getDroppedItemCount(Random random) {
        return dropQuantity;
    }

    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.getTime() % 24000 < 12000) return;
        if (world.isAir(x, y + 1, z)) {
            int var6;
            for(var6 = 1; world.getBlockId(x, y - var6, z) == this.id; ++var6) {
            }

            if (var6 < 3) {
                int var7 = world.getBlockMeta(x, y, z);
                if (var7 == 15) {
                    world.setBlock(x, y + 1, z, this.id);
                    world.setBlockMeta(x, y, z, 0);
                } else {
                    world.setBlockMeta(x, y, z, var7 + 1);
                }
            }
        }

    }

    public boolean canPlaceAt(World world, int x, int y, int z) {
        int var5 = world.getBlockId(x, y - 1, z);
        if (var5 == this.id) {
            return true;
        } else if (var5 != Block.GRASS_BLOCK.id && var5 != Block.DIRT.id) {
            return false;
        } else if (world.getMaterial(x - 1, y - 1, z) == Material.WATER) {
            return true;
        } else if (world.getMaterial(x + 1, y - 1, z) == Material.WATER) {
            return true;
        } else if (world.getMaterial(x, y - 1, z - 1) == Material.WATER) {
            return true;
        } else {
            return world.getMaterial(x, y - 1, z + 1) == Material.WATER;
        }
    }

    public void neighborUpdate(World world, int x, int y, int z, int id) {
        this.breakIfCannotGrow(world, x, y, z);
    }

    protected final void breakIfCannotGrow(World world, int x, int y, int z) {
        if (!this.canGrow(world, x, y, z)) {
            this.dropStacks(world, x, y, z, world.getBlockMeta(x, y, z));
            world.setBlock(x, y, z, 0);
        }

    }

    public int getDroppedItemId(int blockMeta, Random random) {
        return ItemListener.nightCaneStick.id;
    }

    public boolean canGrow(World world, int x, int y, int z) {
        return this.canPlaceAt(world, x, y, z);
    }

    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }
}
