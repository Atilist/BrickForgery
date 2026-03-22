package net.alternateadventure.brickforgery.blocks.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import org.jetbrains.annotations.NotNull;

public class SuperCaneBlockItem extends BlockItem implements CustomTooltipProvider {
    public SuperCaneBlockItem(int i) {
        super(i);
    }

    @Override
    public @NotNull String[] getTooltip(ItemStack itemStack, String s) {
        return new String[] {s, "§7Four times more sugar cane per block.", "§7Only grows on dirt bricks!"};
    }
}
