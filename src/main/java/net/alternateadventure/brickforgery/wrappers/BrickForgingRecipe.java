package net.alternateadventure.brickforgery.wrappers;

import net.minecraft.item.ItemStack;

import java.util.List;

public record BrickForgingRecipe(List<ItemStack> inputs, ItemStack output) {
}
