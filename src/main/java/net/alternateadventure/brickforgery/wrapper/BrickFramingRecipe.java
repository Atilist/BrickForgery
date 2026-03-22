package net.alternateadventure.brickforgery.wrapper;

import net.alternateadventure.brickforgery.util.TierEnum;
import net.minecraft.item.ItemStack;

public record BrickFramingRecipe(ItemStack[] inputs, ItemStack output, TierEnum tier) {
}
