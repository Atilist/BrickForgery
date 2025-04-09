package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.registry.tool.BrushRecipeRegistry;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.alternateadventure.brickforgery.utils.TieredBlockConversionData;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class BrushToolTemplate extends ArchaeologyToolTemplate {
    public BrushToolTemplate(Identifier identifier, int durability, TierEnum tier) {
        super(identifier, durability, tier);
    }

    @Override
    public boolean useOnBlock(ItemStack itemInstance, PlayerEntity player, World world, int x, int y, int z, int facing) {
        ItemStack tool = player.getHand();
        if (world.getBlockId(x, y, z) == BlockListener.factoryRubble.id && tier.ordinal() >= TierEnum.PRIMITIVE.ordinal()) {
            world.setBlock(x, y, z, 0);
            tool.damage(1, player);
            if (random.nextInt(6) == 0) world.spawnEntity(new ItemEntity(world, x, y, z, new ItemStack(ItemListener.brickSteelPlate)));
            if (random.nextInt(6) == 0) world.spawnEntity(new ItemEntity(world, x, y, z, new ItemStack(ItemListener.bricksidianScrew)));
            if (random.nextInt(6) == 0) world.spawnEntity(new ItemEntity(world, x, y, z, new ItemStack(ItemListener.brickSteelIngot)));
            if (random.nextBoolean()) world.spawnEntity(new ItemEntity(world, x, y, z, new ItemStack(ItemListener.durableLeatherStrap)));
            return true;
        }
        TieredBlockConversionData tieredBlockConversionData = BrushRecipeRegistry.getInstance().getResult(world.getBlockId(x, y, z));
        if (tieredBlockConversionData == null) return false;
        if (tieredBlockConversionData.getTier().ordinal() > tier.ordinal()) return false;
        world.setBlock(x, y, z, tieredBlockConversionData.getRandomBlockId());
        tool.damage(1, player);
        return true;
    }
}
