package net.alternateadventure.brickforgery.block.item;

import net.alternateadventure.brickforgery.block.HarvesterBlockTemplate;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import org.jetbrains.annotations.NotNull;

public class HarvesterBlockItem extends BlockItem implements CustomTooltipProvider {
    public HarvesterBlockItem(int i) {
        super(i);
    }

    @Override
    public @NotNull String[] getTooltip(ItemStack stack, String originalTooltip) {
        int range = 0;
        String block = " blocks.";
        if (this.getBlock() != null) {
            range = ((HarvesterBlockTemplate)this.getBlock()).getTier().ordinal() + 1;
        }
        if (range == 1) {
            block = " block.";
        }
        return new String[] {
                originalTooltip,
                "§7Harvests crops around it.",
                "§7Harvesting range is " + range + block
        };
    }
}
