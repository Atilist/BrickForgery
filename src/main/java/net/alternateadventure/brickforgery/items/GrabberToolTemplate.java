package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.registry.tool.GrabberRecipeRegistry;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.alternateadventure.brickforgery.utils.TieredBlockLootingData;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class GrabberToolTemplate extends ArchaeologyToolTemplate {
    public GrabberToolTemplate(Identifier identifier, int durability, TierEnum tier) {
        super(identifier, durability, tier);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity player, World world, int x, int y, int z, int facing) {
        ItemStack tool = player.getHand();
        TieredBlockLootingData tieredBlockLootingData = GrabberRecipeRegistry.getInstance().getResult(world.getBlockId(x, y, z));
        if (tieredBlockLootingData == null) return false;
        if (tieredBlockLootingData.getTier().ordinal() > tier.ordinal()) return false;
        ItemStack output = tieredBlockLootingData.getRandomItemStack();
        if (output == null) return false;
        world.spawnEntity(new ItemEntity(world, x + 0.5, y + 0.5, z + 0.5, output));
        if (tieredBlockLootingData.getBreakingChance() > random.nextInt(100)) {
            world.setBlock(x, y, z, 0);
        }
        tool.damage(1, player);
        return true;
    }
}
