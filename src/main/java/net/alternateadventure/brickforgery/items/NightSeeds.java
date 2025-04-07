package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class NightSeeds extends TemplateItem {

    public NightSeeds(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity playerBase, World level, int x, int y, int z, int facing) {
        if (level.getBlockId(x, y, z) == Block.FARMLAND.id && level.getBlockId(x, y + 1, z) == 0) {
            level.setBlock(x, y + 1, z, BlockListener.nightWheatCrop.id);
            itemInstance.count--;
            return true;
        }
        return false;
    }
}
