package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class ArcheologyBrush extends TemplateItemBase {

    public ArcheologyBrush(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
        this.setDurability(256);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        ItemInstance tool = player.getHeldItem();
        if (level.getTileId(x, y, z) == BlockListener.brickFrameCrafterDusted.id)
        {
            level.setTile(x, y, z, BlockListener.brickFrameCrafter.id);
            tool.applyDamage(1, player);
            return true;
        }
        return false;
    }
}
