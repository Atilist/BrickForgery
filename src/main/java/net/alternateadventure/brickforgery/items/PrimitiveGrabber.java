package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.lootpools.DesertPotLootPool;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Random;

public class PrimitiveGrabber extends LazyItemTemplate {
    public PrimitiveGrabber(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
        this.setDurability(31);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        ItemInstance tool = player.getHeldItem();
        final int reliability = 3;
        final int luck = 5;
        if (level.getTileId(x, y, z) == BlockListener.desertPot.id)
        {
            level.setTile(x, y, z, 0);
            tool.applyDamage(1, player);
            if (rand.nextBoolean()) level.spawnEntity(new Item(level, x, y, z, DesertPotLootPool.getLoot(reliability, luck, new Random())));
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockListener.frozenPot.id) // Currently, the same loot pool as desert pot. Will be changed later.
        {
            level.setTile(x, y, z, 0);
            tool.applyDamage(1, player);
            if (rand.nextBoolean()) level.spawnEntity(new Item(level, x, y, z, DesertPotLootPool.getLoot(reliability, luck, new Random())));
            return true;
        }
        return false;
    }
}
