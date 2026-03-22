package net.alternateadventure.brickforgery.wrapper;

import net.alternateadventure.brickforgery.util.TierEnum;
import net.minecraft.item.ItemStack;

import java.util.List;

public record BrickForgingRecipe(List<ItemStack> inputs, ItemStack output, TierEnum tier) {
}
