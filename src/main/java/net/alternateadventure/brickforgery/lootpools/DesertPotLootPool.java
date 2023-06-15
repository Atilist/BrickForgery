package net.alternateadventure.brickforgery.lootpools;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;

import java.util.Random;

public class DesertPotLootPool {

    public static ItemInstance getLoot(int reliability, int luck, Random random)
    {
        luck = random.nextInt(luck);
        reliability = random.nextInt(reliability);
        if (luck == 0)
        {
            return new ItemInstance(BlockBase.SAND);
        }
        else if (luck < 4)
        {
            if (reliability > 0) return new ItemInstance(ItemListener.leatherStrap, reliability);
        }
        else if (luck < 5)
        {
            if (reliability > 0) return new ItemInstance(ItemListener.goldenScrew, reliability);
        }
        return new ItemInstance(BlockBase.SAND);
    }

}
