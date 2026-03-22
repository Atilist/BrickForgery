package net.alternateadventure.brickforgery.block;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class SandinatorBlock extends LazyBlockTemplate {
    private final Random random = new Random();

    public SandinatorBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
        setBoundingBox(0, 0, 0, 1, 0.99F, 1);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void onEntityCollision(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            ItemStack input = itemEntity.stack;
            if (input == null) return;
            Item item = input.getItem();
            if (item == null) return;
            if (item.id != ItemListener.dirtBrickSand.id) return;
            if (world.getBlockId(x, y - 1, z) != BlockListener.sugarCaneBox.id) return;
            if (world.getBlockId(x + 1, y - 1, z + 1) != BlockListener.sugarCaneBox.id) return;
            if (world.getBlockId(x + 1, y - 1, z - 1) != BlockListener.sugarCaneBox.id) return;
            if (world.getBlockId(x - 1, y - 1, z + 1) != BlockListener.sugarCaneBox.id) return;
            if (world.getBlockId(x - 1, y - 1, z - 1) != BlockListener.sugarCaneBox.id) return;
            if (world.getBlockId(x + 1, y - 1, z) != BlockListener.dirtBricks.id) return;
            if (world.getBlockId(x - 1, y - 1, z) != BlockListener.dirtBricks.id) return;
            if (world.getBlockId(x, y - 1, z + 1) != BlockListener.dirtBricks.id) return;
            if (world.getBlockId(x, y - 1, z - 1) != BlockListener.dirtBricks.id) return;
            entity.markDead();
            ItemStack result = new ItemStack(ItemListener.sandBrick, input.count, 0);
            boolean xOrZ = random.nextBoolean();
            int offset = random.nextInt(3) - 1;
            if (xOrZ) {
                world.spawnEntity(new ItemEntity(world, x + offset + 0.5, y, z + 0.5, result));
            } else {
                world.spawnEntity(new ItemEntity(world, x + 0.5, y, z + offset + 0.5, result));
            }
        }
    }
}
