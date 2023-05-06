package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class ArcheologyIceKnife extends TemplateItemBase {

    public ArcheologyIceKnife(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
        this.setDurability(256);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        ItemInstance tool = player.getHeldItem();
        if (level.getTileId(x, y, z) == BlockBase.SNOW_BLOCK.id)
        {
            level.setTile(x, y, z, 0);
            level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.snowBrick, 4)));
            tool.applyDamage(1, player);
            return true;
        }
        if (level.getTileId(x, y, z) == BlockBase.TALLGRASS.id && level.getTileMeta(x, y, z) == 2)
        {
            level.setTile(x, y, z, 0);
            level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.fernItem)));
            tool.applyDamage(1, player);
            return true;
        }
        return false;
    }
}
