package net.alternateadventure.brickforgery.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class FernItem extends LazyItemTemplate {

    public FernItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity playerBase, World level, int x, int y, int z, int facing) {
        if (level.getBlockId(x, y, z) == Block.GRASS_BLOCK.id && level.getBlockId(x, y + 1, z) == 0) {
            level.setBlock(x, y + 1, z, Block.GRASS.id, 2);
            itemInstance.count--;
            return true;
        }
        return false;
    }
}
