package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.interfaces.BrickFrameIngredient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.IntProperty;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class ResourcePileBlock extends TemplateBlock implements BrickFrameIngredient {

    public static final IntProperty USES = IntProperty.of("uses", 0, 15);

    public ResourcePileBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(USES);
    }

    @Override
    public int getDroppedItemCount(Random random) {
        return 0;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 0;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public void transformBlock(World world, int x, int y, int z, Random random) {
        int blockState = world.getBlockState(x, y, z).get(ResourcePileBlock.USES);
        if (blockState == 1) world.setBlock(x, y, z, 0);
        else if (world.getBlockId(x, y, z) == BlockListener.clayPile.id) world.setBlockStateWithNotify(x, y, z, BlockListener.clayPile.getDefaultState().with(ResourcePileBlock.USES, blockState - 1));
        else if (world.getBlockId(x, y, z) == BlockListener.planksPile.id) world.setBlockStateWithNotify(x, y, z, BlockListener.planksPile.getDefaultState().with(ResourcePileBlock.USES, blockState - 1));
    }
}
