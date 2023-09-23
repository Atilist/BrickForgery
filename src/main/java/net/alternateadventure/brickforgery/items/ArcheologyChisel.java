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

public class ArcheologyChisel extends TemplateItemBase {

    public ArcheologyChisel(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
        this.setDurability(256);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        ItemInstance tool = player.getHeldItem();
        if (level.getTileId(x, y, z) == BlockListener.frozenPotSealed.id)
        {
            level.setTile(x, y, z, BlockListener.frozenPot.id);
            tool.applyDamage(1, player);
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockListener.desertPotSealed.id)
        {
            level.setTile(x, y, z, BlockListener.desertPot.id);
            tool.applyDamage(1, player);
            return true;
        }
        return false;
    }
}
