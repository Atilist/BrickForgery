package net.alternateadventure.brickforgery.registry.machine.records;

import net.alternateadventure.brickforgery.util.TierEnum;
import net.minecraft.item.ItemStack;

public record OutputAndInputs(ItemStack output, IdMetaCount[] inputs, TierEnum minimumTier) {
}
