package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
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
        else if (level.getTileId(x, y, z) == BlockListener.dust.id)
        {
            level.setTile(x, y, z, 0);
            tool.applyDamage(1, player);
            level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.brickSeedlings)));
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockBase.GRAVEL.id)
        {
            level.setTile(x, y, z, 0);
            tool.applyDamage(1, player);
            level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemBase.flint, 2)));
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockListener.brickCrop.id && level.getTileMeta(x, y, z) == 3)
        {
            level.setTile(x, y, z, 0);
            tool.applyDamage(1, player);
            level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.brickSeedlings)));
            level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.brickCatalyst)));
            return true;
        }
        return false;
    }
}
