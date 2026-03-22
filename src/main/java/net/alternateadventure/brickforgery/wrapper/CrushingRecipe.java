package net.alternateadventure.brickforgery.wrapper;

import net.alternateadventure.brickforgery.util.TierEnum;
import net.minecraft.item.ItemStack;

public record CrushingRecipe(ItemStack input, ItemStack[] outputs, TierEnum tier) {
}
