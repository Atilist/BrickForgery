package net.alternateadventure.brickforgery.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class NightGrowthBoosterItem extends LazySecondaryBlockItem implements CustomTooltipProvider {
    private static final String GREY = "§7";

    public NightGrowthBoosterItem(Identifier identifier, Block tile) {
        super(identifier, tile);
    }

    @Override
    public @NotNull String[] getTooltip(ItemStack stack, String originalTooltip) {
        return new String[] {
                originalTooltip,
                GREY + "Increases growth speed of",
                GREY + "night cane in an area of",
                GREY + "2 blocks around itself."
        };
    }
}
