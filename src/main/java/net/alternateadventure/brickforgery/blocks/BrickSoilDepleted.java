package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class BrickSoilDepleted extends TemplateBlock {

    public BrickSoilDepleted(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public BrickSoilDepleted setHardness(float Hardness) {
        return (BrickSoilDepleted) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i) {
        return i == 0 ? TextureListener.BrickSoilBottomDepleted : i == 1 ? TextureListener.BrickSoilTopDepleted : TextureListener.BrickSoilSideDepleted;
    }

    @Override
    public boolean onUse(World level, int x, int y, int z, PlayerEntity playerBase) {
        ItemStack heldItem = playerBase.getHeldItem();
        if (heldItem == null) return false;
        if (heldItem.itemId == Item.BRICK.id)
        {
            level.setBlock(x, y, z, BlockListener.brickSoil.id);
            heldItem.count--;
            return true;
        }
        return false;
    }
}
