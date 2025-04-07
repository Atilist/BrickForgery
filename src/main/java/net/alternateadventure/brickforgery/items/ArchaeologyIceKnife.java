package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ArchaeologyIceKnife extends TemplateItem {

    public ArchaeologyIceKnife(Identifier identifier) {
        super(identifier);
        this.maxCount = 1;
        this.setMaxDamage(256);
    }

    @Override
    public boolean useOnBlock(ItemStack item, PlayerEntity player, World level, int x, int y, int z, int facing) {
        ItemStack tool = player.getHeldItem();
        if (level.getBlockId(x, y, z) == Block.SNOW_BLOCK.id) {
            level.setBlock(x, y, z, 0);
            level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.snowBrick, 4)));
            tool.damage(1, player);
            return true;
        }
        if (level.getBlockId(x, y, z) == Block.GRASS.id && level.getBlockMeta(x, y, z) == 2) {
            level.setBlock(x, y, z, 0);
            level.spawnEntity(new ItemEntity(level, x, y, z, new ItemStack(ItemListener.fernItem)));
            tool.damage(1, player);
            return true;
        }
        return false;
    }
}
