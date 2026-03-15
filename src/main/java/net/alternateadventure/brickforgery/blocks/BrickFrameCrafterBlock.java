package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.interfaces.BrickFrameIngredient;
import net.alternateadventure.brickforgery.registry.machine.BrickFramingRecipeRegistry;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class BrickFrameCrafterBlock extends LazyBlockTemplate {
    public TierEnum tier;

    public BrickFrameCrafterBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, TierEnum tier) {
        super(identifier, material, hardness, blockSounds);
        this.tier = tier;
    }

    @Override
    public BrickFrameCrafterBlock setHardness(float Hardness) {
        return (BrickFrameCrafterBlock) super.setHardness(Hardness);
    }

    @Override
    public boolean onUse(World arg, int i, int j, int k, PlayerEntity arg2) {
        manuallyCraftFrame(arg, i, j, k, arg2);
        return true;
    }

    public void manuallyCraftFrame(World level, int x, int y, int z, PlayerEntity player) {
        ItemStack item = player.getHand();
        if (item == null) return;
        if (craftFrame(level, x, y, z, item)) {
            item.count--;
        }
    }

    public boolean craftFrame(World world, int x, int y, int z, ItemStack item) {
        if (item == null) return false;
        int[] blocks = new int[4];
        blocks[0] = world.getBlockId(x + 1, y, z);
        blocks[1] = world.getBlockId(x - 1, y, z);
        blocks[2] = world.getBlockId(x, y, z + 1);
        blocks[3] = world.getBlockId(x, y, z - 1);
        ItemStack output = BrickFramingRecipeRegistry.getInstance().getResult(item, blocks, tier);
        if (output == null) return false;
        output = output.copy();
        if (output.count < 1) output.count = 1;
        boolean foundOutput = false;
        if (world.getBlockId(x, y + 1, z) == 0) {
            foundOutput = true;
            dropItem(world, x, y + 1, z, output);
        } else if (world.getBlockId(x, y - 1, z) == 0) {
            foundOutput = true;
            dropItem(world, x, y - 1, z, output);
        }
        if (!foundOutput) return false;
        transformBlock(world, x + 1, y, z);
        transformBlock(world, x - 1, y, z);
        transformBlock(world, x, y, z + 1);
        transformBlock(world, x, y, z - 1);
        return true;
    }

    private void dropItem(World world, int x, int y, int z, ItemStack output) {
        world.spawnEntity(new ItemEntity(world, x + 0.5, y + 1, z + 0.5, output));
    }

    private void transformBlock(World world, int x, int y, int z) {
        Block blockBase = Block.BLOCKS[world.getBlockId(x, y, z)];
        if (blockBase == null) return;
        if (blockBase instanceof BrickFrameIngredient ingredient) {
            ingredient.transformBlock(world, x, y, z, new Random());
        } else {
            world.setBlock(x, y, z, 0);
        }
    }
}
