package net.alternateadventure.brickforgery.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class FrozenPotItem extends LazyItemTemplate {
    public FrozenPotItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity playerBase, World level, int x, int y, int z, int facing) {
        return false;
    }
}
