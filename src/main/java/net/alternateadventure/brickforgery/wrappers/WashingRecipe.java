package net.alternateadventure.brickforgery.wrappers;

import net.alternateadventure.brickforgery.utils.TierEnum;
import net.minecraft.item.ItemStack;

public record WashingRecipe(ItemStack input, ItemStack[] outputs, TierEnum tier) {
}
