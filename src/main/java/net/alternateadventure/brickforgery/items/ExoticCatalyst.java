package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.util.Identifier;

public class ExoticCatalyst extends LazyItemTemplate{
    public ExoticCatalyst(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        ItemInstance tool = player.getHeldItem();
        if (level.getTileId(x, y, z) == BlockBase.COAL_ORE.id)
        {
            level.setTile(x, y, z, BlockListener.coalOreBricks.id);
            tool.count--;
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockBase.IRON_ORE.id)
        {
            level.setTile(x, y, z, BlockListener.ironOreBricks.id);
            tool.count--;
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockBase.GOLD_ORE.id)
        {
            level.setTile(x, y, z, BlockListener.goldOreBricks.id);
            tool.count--;
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockBase.REDSTONE_ORE.id || level.getTileId(x, y, z) == BlockBase.REDSTONE_ORE_LIT.id)
        {
            level.setTile(x, y, z, BlockListener.redstoneOreBricks.id);
            tool.count--;
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockBase.DIAMOND_ORE.id)
        {
            level.setTile(x, y, z, BlockListener.diamondOreBricks.id);
            tool.count--;
            return true;
        }
        return false;
    }
}
