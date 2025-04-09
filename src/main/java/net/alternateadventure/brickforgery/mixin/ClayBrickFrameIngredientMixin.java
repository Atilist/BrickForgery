package net.alternateadventure.brickforgery.mixin;

import net.alternateadventure.brickforgery.blocks.ResourcePileBlock;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.interfaces.BrickFrameIngredient;
import net.minecraft.block.ClayBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.Random;

@Mixin(ClayBlock.class)
@Unique
public class ClayBrickFrameIngredientMixin implements BrickFrameIngredient {
    @Override
    public void transformBlock(World world, int x, int y, int z, Random random) {
        world.setBlock(x, y, z, BlockListener.clayPile.id);
        world.setBlockStateWithNotify(x, y, z, BlockListener.clayPile.getDefaultState().with(ResourcePileBlock.USES, 15));
    }
}
