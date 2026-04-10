package net.alternateadventure.brickforgery.block;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class BrickedPlanterBlock extends LazyBlockTemplate {
    public BrickedPlanterBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds) {
        super(identifier, material, hardness, blockSounds);
        setTickRandomly(true);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockId(x, y + 1, z) == BlockListener.superCane.id) {
            world.scheduleBlockUpdate(x, y, z, this.id, random.nextInt(40) + 40);
            int sugarMeta = world.getBlockMeta(x, y + 1, z);
            if (sugarMeta < 15) {
                world.setBlockMeta(x, y + 1, z, sugarMeta + 1);
            } else {
                world.scheduleBlockUpdate(x, y + 1, z, this.id, 1);
            }
        }
    }
}
