package net.alternateadventure.brickforgery.utils;

import net.minecraft.item.ItemStack;

public record TieredBrickFramingRecipe(ItemStack inputItem, int block1, int block2, int block3, int block4, ItemStack output, TierEnum tier) {
}
