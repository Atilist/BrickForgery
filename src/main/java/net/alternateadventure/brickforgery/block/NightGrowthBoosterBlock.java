package net.alternateadventure.brickforgery.block;

import net.alternateadventure.brickforgery.events.init.BlockListener;
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

public class NightGrowthBoosterBlock extends LazyBlockTemplate {
    public NightGrowthBoosterBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
        setTickRandomly(true);
        setLuminance(0.4F);
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

    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.getTime() % 24000 < 12000) return;
        world.scheduleBlockUpdate(x, y, z, this.id, 20);
        for (int xOffset = -1; xOffset <= 2; xOffset++) {
            for (int zOffset = -1; zOffset <= 2; zOffset++) {
                int blockId = world.getBlockId(x + xOffset, y, z + zOffset);
                if (!(blockId == BlockListener.nightCane.id || blockId == BlockListener.doubleNightCane.id)) continue;
                int blockMeta = world.getBlockMeta(x + xOffset, y, z + zOffset);
                if (blockMeta == 15) continue;
                world.setBlockMeta(x + xOffset, y, z + zOffset, blockMeta + 1);
            }
        }
    }

    public boolean canPlaceAt(World world, int x, int y, int z) {
        int blockId = world.getBlockId(x, y - 1, z);
        return blockId == Block.GRASS_BLOCK.id || blockId == Block.DIRT.id;
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
        return ItemListener.nightGrowthBoosterItem.id;
    }

    public boolean canGrow(World world, int x, int y, int z) {
        return this.canPlaceAt(world, x, y, z);
    }

    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }
}
