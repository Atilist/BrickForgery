package net.alternateadventure.brickforgery.lootpools;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class DesertPotLootPool {

    public static ItemStack getLoot(int reliability, int luck, Random random) {
        luck = random.nextInt(luck);
        reliability = random.nextInt(reliability + 1);
        if (luck == 0) {
            return new ItemStack(Block.SAND);
        } else if (luck < 4) {
            if (reliability > 0) return new ItemStack(ItemListener.leatherStrap, reliability);
        } else if (luck < 5) {
            if (reliability > 0) return new ItemStack(ItemListener.goldenScrew, reliability);
        }
        return new ItemStack(Block.SAND);
    }

}
