package net.alternateadventure.brickforgery.utils;

import net.minecraft.item.ItemStack;

import java.util.Random;

public class TieredBlockLootingData {
    private final ItemStack[] itemStacks;
    private final int[] weights;
    private final int breakingChance;
    private final TierEnum tier;
    private final Random random = new Random();

    /**
     * Constructor which specifies all important parameters.
     * @param itemStacks Randomly picked items. Must never be null.
     * @param weights Weight corresponding to the item of the same index. Weight must be in the range of 1 to 100. Array must have the same length as the itemStacks one.
     * @param breakingChance Chance of the block to break and be replaced by air after it gets looted.
     * @param tier Required tier to loot the block.
     */
    public TieredBlockLootingData(ItemStack[] itemStacks, int[] weights, int breakingChance, TierEnum tier) {
        this.itemStacks = itemStacks;
        this.tier = tier;
        this.weights = weights;
        this.breakingChance = breakingChance;
    }

    public TierEnum getTier() {
        return tier;
    }

    public ItemStack getRandomItemStack() {
        for (int i = 0; i < itemStacks.length; i++) {
            if (random.nextInt(100) < weights[i]) {
                return itemStacks[i].copy();
            }
        }
        return null;
    }

    public int getBreakingChance() {
        return breakingChance;
    }
}
