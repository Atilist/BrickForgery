package net.alternateadventure.brickforgery.utils;

import java.util.Random;

public class TieredBlockConversionData {
    private final int[] blockIds;
    private final int[] weights;
    private final TierEnum tier;
    private final Random random = new Random();

    /**
     * Constructor which specifies all important parameters.
     * @param blockIds Randomly picked block IDs.
     * @param weights Weight corresponding to the block ID of the same index. Weight must be in the range of 1 to 100. Array must have the same length as the blockIds one.
     * @param tier Required tier to convert the block.
     */
    public TieredBlockConversionData(int[] blockIds, int[] weights, TierEnum tier) {
        this.blockIds = blockIds;
        this.tier = tier;
        this.weights = weights;
    }

    public TierEnum getTier() {
        return tier;
    }

    public int getRandomBlockId() {
        for (int i = 0; i < blockIds.length; i++) {
            if (random.nextInt(100) < weights[i]) {
                return blockIds[i];
            }
        }
        return 0;
    }
}
