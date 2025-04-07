package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ArcheologyChisel extends TemplateItem {

    public ArcheologyChisel(Identifier identifier) {
        super(identifier);
        this.maxCount = 1;
        this.setMaxDamage(256);
    }

    @Override
    public boolean useOnBlock(ItemStack item, PlayerEntity player, World level, int x, int y, int z, int facing) {
        ItemStack tool = player.getHand();
        if (level.getBlockId(x, y, z) == BlockListener.frozenPotSealed.id) {
            level.setBlock(x, y, z, BlockListener.frozenPot.id);
            tool.damage(1, player);
            return true;
        }
        else if (level.getBlockId(x, y, z) == BlockListener.desertPotSealed.id) {
            level.setBlock(x, y, z, BlockListener.desertPot.id);
            tool.damage(1, player);
            return true;
        }
        return false;
    }
}
