package net.alternateadventure.brickforgery.items;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class BrickCatalyst extends TemplateItem {

    public BrickCatalyst(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        return false;
    }
}
