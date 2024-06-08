package net.alternateadventure.brickforgery.mixin;

import net.alternateadventure.brickforgery.blocks.ResourcePile;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.interfaces.BrickFrameIngredient;
import net.minecraft.block.Clay;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.Random;

@Mixin(Clay.class)
@Unique
public class ClayBrickFrameIngredientMixin implements BrickFrameIngredient {
    @Override
    public void transformBlock(Level world, int x, int y, int z, Random random) {
        world.setTile(x, y, z, BlockListener.clayPile.id);
        world.setBlockStateWithNotify(x, y, z, BlockListener.clayPile.getDefaultState().with(ResourcePile.USES, 15));
    }
}
