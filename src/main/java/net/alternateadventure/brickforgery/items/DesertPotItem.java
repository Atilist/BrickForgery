package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;

public class DesertPotItem extends LazyItemTemplate {
    public DesertPotItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        if (level.getTileId(x, y, z) == BlockListener.potPedestal.id && level.getTileId(x, y + 1, z) == 0)
        {
            level.setTile(x, y + 1, z, BlockListener.desertPotSealed.id);
            item.count--;
            return true;
        }
        return false;
    }
}
