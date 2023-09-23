package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;

public class PrimitiveBrush extends LazyItemTemplate {
    public PrimitiveBrush(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
        this.setDurability(127);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        ItemInstance tool = player.getHeldItem();
        if (level.getTileId(x, y, z) == BlockListener.bountifulSand.id)
        {
            level.setTile(x, y, z, 0);
            tool.applyDamage(1, player);
            if (rand.nextBoolean()) level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.desertPotItem)));
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockListener.bountifulSnow.id)
        {
            level.setTile(x, y, z, 0);
            tool.applyDamage(1, player);
            if (rand.nextBoolean()) level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.frozenPotItem)));
            return true;
        } else if (level.getTileId(x, y, z) == BlockListener.factoryRubble.id)
        {
            level.setTile(x, y, z, 0);
            tool.applyDamage(1, player);
            if (rand.nextInt(6) == 0) level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.brickSteelPlate)));
            if (rand.nextInt(6) == 0) level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.bricksidianScrew)));
            if (rand.nextInt(6) == 0) level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.brickSteelIngot)));
            if (rand.nextBoolean()) level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.durableLeatherStrap)));
            return true;
        }
        return false;
    }
}
