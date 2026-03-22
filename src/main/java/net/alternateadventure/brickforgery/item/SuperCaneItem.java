package net.alternateadventure.brickforgery.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class SuperCaneItem extends LazySecondaryBlockItem implements CustomTooltipProvider {
    public SuperCaneItem(Identifier identifier, Block tile) {
        super(identifier, tile);
    }

    @Override
    public @NotNull String[] getTooltip(ItemStack itemStack, String s) {
        return new String[] {s, "§7Four times more sugar cane per block.", "§7Only grows on dirt bricks!"};
    }
}
