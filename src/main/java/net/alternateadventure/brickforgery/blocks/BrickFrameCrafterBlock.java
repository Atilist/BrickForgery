package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.customrecipes.BrickFramingRecipeRegistry;
import net.alternateadventure.brickforgery.interfaces.BrickFrameIngredient;
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
    public int tier;
    private final Random random = new Random();

    public BrickFrameCrafterBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, int tier) {
        super(identifier, material, hardness, blockSounds);
        this.tier = tier;
    }

    @Override
    public BrickFrameCrafterBlock setHardness(float Hardness) {
        return (BrickFrameCrafterBlock) super.setHardness(Hardness);
    }

    @Override
    public boolean onUse(World arg, int i, int j, int k, PlayerEntity arg2) {
        craftFrame(arg, i, j, k, arg2);
        return true;
    }

    public void craftFrame(World level, int x, int y, int z, PlayerEntity player) {
        if (level.getBlockId(x, y + 1, z) != 0) return;
        ItemStack item = player.getHeldItem();
        if (item == null) return;
        int[] blocks = new int[4];
        blocks[0] = level.getBlockId(x + 1, y, z);
        blocks[1] = level.getBlockId(x - 1, y, z);
        blocks[2] = level.getBlockId(x, y, z + 1);
        blocks[3] = level.getBlockId(x, y, z - 1);
        ItemStack output = BrickFramingRecipeRegistry.getInstance().getResult(item, blocks);
        if (output == null) return;
        output = output.copy();
        item.count--;
        if (output.count < 1) output.count = 1;
        transformBlock(level, x + 1, y, z);
        transformBlock(level, x - 1, y, z);
        transformBlock(level, x, y, z + 1);
        transformBlock(level, x, y, z - 1);
        if (tier < 1 && random.nextBoolean()) return; // 50% chance of failure if tier is below 1
        level.spawnEntity(new ItemEntity(level, x + 0.5, y + 1, z + 0.5, output));
    }

    private void transformBlock(World world, int x, int y, int z) {
        Block blockBase = Block.BLOCKS[world.getBlockId(x, y, z)];
        if (blockBase == null) return;
        if (blockBase instanceof BrickFrameIngredient ingredient) {
            ingredient.transformBlock(world, x, y, z, new Random());
        }
    }
}
