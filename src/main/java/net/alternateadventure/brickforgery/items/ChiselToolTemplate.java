package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.registry.tool.ChiselRecipeRegistry;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.alternateadventure.brickforgery.utils.TieredBlockConversionData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class ChiselToolTemplate extends ArchaeologyToolTemplate {
    public ChiselToolTemplate(Identifier identifier, int durability, TierEnum tier) {
        super(identifier, durability, tier);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity player, World world, int x, int y, int z, int facing) {
        ItemStack tool = player.getHand();
        TieredBlockConversionData tieredBlockConversionData = ChiselRecipeRegistry.getInstance().getResult(world.getBlockId(x, y, z));
        if (tieredBlockConversionData == null) return false;
        if (tieredBlockConversionData.getTier().ordinal() > tier.ordinal()) return false;
        world.setBlock(x, y, z, tieredBlockConversionData.getRandomBlockId());
        tool.damage(1, player);
        return true;
    }
}
