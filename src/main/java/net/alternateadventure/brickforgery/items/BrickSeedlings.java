package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class BrickSeedlings extends TemplateItemBase {

    public BrickSeedlings(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        if (level.getTileId(x, y, z) == BlockListener.brickSoil.id && level.getTileId(x, y + 1, z) == 0)
        {
            level.setTile(x, y + 1, z, BlockListener.brickCrop.id);
            item.count--;
            return true;
        }
        return false;
    }
}
