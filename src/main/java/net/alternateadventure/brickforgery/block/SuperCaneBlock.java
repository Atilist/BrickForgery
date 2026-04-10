package net.alternateadventure.brickforgery.block;

import net.alternateadventure.brickforgery.block.item.SuperCaneBlockItem;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

@HasCustomBlockItemFactory(SuperCaneBlockItem.class)
public class SuperCaneBlock extends LazyBlockTemplate {
    public SuperCaneBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
        this.setTickRandomly(true);
        float shrinkingFactor = 0.375F;
        this.setBoundingBox(0.5F - shrinkingFactor, 0.0F, 0.5F - shrinkingFactor, 0.5F + shrinkingFactor, 1.0F, 0.5F + shrinkingFactor);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.isAir(x, y + 1, z)) {
            int sugarCaneHeight;
            for (sugarCaneHeight = 1; world.getBlockId(x, y - sugarCaneHeight, z) == this.id; ++sugarCaneHeight);
            if (sugarCaneHeight < 3) {
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

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        int belowId = world.getBlockId(x, y - 1, z);
        if (belowId == this.id) {
            return true;
        } else if (belowId != BlockListener.dirtBricks.id && belowId != BlockListener.brickedPlanter.id) {
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

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        this.breakIfCannotGrow(world, x, y, z);
    }

    protected final void breakIfCannotGrow(World world, int x, int y, int z) {
        if (!this.canGrow(world, x, y, z)) {
            this.dropStacks(world, x, y, z, world.getBlockMeta(x, y, z));
            world.setBlock(x, y, z, 0);
        }

    }

    @Override
    public boolean canGrow(World world, int x, int y, int z) {
        return this.canPlaceAt(world, x, y, z);
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    public int getDroppedItemId(int blockMeta, Random random) {
        return Item.SUGAR_CANE.id;
    }

    @Override
    public int getDroppedItemCount(Random random) {
        return 4;
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
}
