package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.lootpools.DesertPotLootPool;
import net.alternateadventure.brickforgery.lootpools.FrozenPotLootPool;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class PrimitiveGrabber extends LazyItemTemplate {
    public PrimitiveGrabber(Identifier identifier) {
        super(identifier);
        this.maxCount = 1;
        this.setMaxDamage(127);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity player, World level, int x, int y, int z, int facing) {
        ItemStack tool = player.getHeldItem();
        final int reliability = 3;
        final int luck = 5;
        if (level.getBlockId(x, y, z) == BlockListener.commonPot.id) {
            level.setBlock(x, y, z, 0);
            tool.damage(1, player);
            if (random.nextBoolean()) level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.leatherStrap)));
            return true;
        }
        if (level.getBlockId(x, y, z) == BlockListener.desertPot.id) {
            level.setBlock(x, y, z, 0);
            tool.damage(1, player);
            level.spawnEntity(new ItemEntity(level, x, y, z, DesertPotLootPool.getLoot(reliability, luck, new Random())));
            return true;
        }
        else if (level.getBlockId(x, y, z) == BlockListener.frozenPot.id) {
            level.setBlock(x, y, z, 0);
            tool.damage(1, player);
            if (random.nextBoolean()) level.spawnEntity(new ItemEntity(level, x, y, z, FrozenPotLootPool.getLoot(reliability, luck, new Random())));
            return true;
        }
        return false;
    }
}
