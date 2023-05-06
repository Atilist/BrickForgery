package net.alternateadventure.brickforgery.items;

import net.minecraft.block.BlockBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;

public class FernItem extends LazyItemTemplate {

    public FernItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        if (level.getTileId(x, y, z) == BlockBase.GRASS.id && level.getTileId(x, y + 1, z) == 0)
        {
            level.placeBlockWithMetaData(x, y + 1, z, BlockBase.TALLGRASS.id, 2);
            item.count--;
            return true;
        }
        return false;
    }
}
