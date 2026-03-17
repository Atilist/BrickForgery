package net.alternateadventure.brickforgery.registry.machine.records;

import net.minecraft.item.ItemStack;

public record HarvestingOutput(ItemStack itemResult, int newBlockId, int newBlockMeta) {
}
