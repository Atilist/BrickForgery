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
        this.setDurability(32);
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
        return false;
    }
}
