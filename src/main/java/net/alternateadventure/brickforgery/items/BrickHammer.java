package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class BrickHammer extends TemplateItemBase {

    public BrickHammer(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
        this.setDurability(256);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        ItemInstance tool = player.getHeldItem();
        if (level.getTileId(x, y, z) == BlockBase.SAND.id)
        {
            level.setTile(x, y, z, BlockListener.dust.id);
            tool.applyDamage(1, player);
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockBase.BRICKS.id && level.getTileId(x, y + 1, z) == 0)
        {
            level.setTile(x, y, z, BlockListener.brickSoil.id);
            tool.applyDamage(1, player);
            return true;
        }
        return false;
    }
}
