package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.alternateadventure.brickforgery.interfaces.BrickFrameIngredient;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class NightPlanksBlock extends TemplateBlock implements BrickFrameIngredient {

    public NightPlanksBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public NightPlanksBlock setHardness(float Hardness) {
        return (NightPlanksBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return TextureListener.NightPlanks;
    }

    @Override
    public void transformBlock(World world, int x, int y, int z, Random random) {
        world.setBlock(x, y, z, BlockListener.planksPile.id);
        world.setBlockStateWithNotify(x, y, z, BlockListener.planksPile.getDefaultState().with(ResourcePileBlock.USES, 15));
    }
}