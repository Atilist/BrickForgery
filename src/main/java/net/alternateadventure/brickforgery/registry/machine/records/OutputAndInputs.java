package net.alternateadventure.brickforgery.registry.machine.records;

import net.alternateadventure.brickforgery.utils.TierEnum;
import net.minecraft.item.ItemStack;

public record OutputAndInputs(ItemStack output, IdMetaCount[] inputs, TierEnum minimumTier) {
}
