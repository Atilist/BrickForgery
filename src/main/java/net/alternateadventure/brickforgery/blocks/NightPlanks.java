package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.alternateadventure.brickforgery.interfaces.BrickFrameIngredient;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class NightPlanks extends TemplateBlock implements BrickFrameIngredient {

    public NightPlanks(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public NightPlanks setHardness(float Hardness) {
        return (NightPlanks) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return TextureListener.NightPlanks;
    }

    @Override
    public void transformBlock(Level world, int x, int y, int z, Random random) {
        world.setTile(x, y, z, BlockListener.planksPile.id);
        world.setBlockStateWithNotify(x, y, z, BlockListener.planksPile.getDefaultState().with(ResourcePile.USES, 15));
    }
}