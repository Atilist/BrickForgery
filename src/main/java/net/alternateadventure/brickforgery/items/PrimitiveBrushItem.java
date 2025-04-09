package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class PrimitiveBrushItem extends LazyItemTemplate {
    public PrimitiveBrushItem(Identifier identifier) {
        super(identifier);
        this.maxCount = 1;
        this.setMaxDamage(127);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity player, World level, int x, int y, int z, int facing) {
        ItemStack tool = player.getHand();
        if (level.getBlockId(x, y, z) == BlockListener.bountifulSand.id) {
            level.setBlock(x, y, z, 0);
            tool.damage(1, player);
            if (random.nextBoolean()) level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.desertPotItem)));
            return true;
        } else if (level.getBlockId(x, y, z) == BlockListener.bountifulSnow.id) {
            level.setBlock(x, y, z, 0);
            tool.damage(1, player);
            if (random.nextBoolean()) level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.frozenPotItem)));
            return true;
        } else if (level.getBlockId(x, y, z) == BlockListener.factoryRubble.id) {
            level.setBlock(x, y, z, 0);
            tool.damage(1, player);
            if (random.nextInt(6) == 0) level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.brickSteelPlate)));
            if (random.nextInt(6) == 0) level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.bricksidianScrew)));
            if (random.nextInt(6) == 0) level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.brickSteelIngot)));
            if (random.nextBoolean()) level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.durableLeatherStrap)));
            return true;
        }
        return false;
    }
}
