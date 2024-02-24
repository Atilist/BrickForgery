package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
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
    public int getTextureForSide(int i) {
        return i == 0 ? TextureListener.BrickSoilBottomDepleted : i == 1 ? TextureListener.BrickSoilTopDepleted : TextureListener.BrickSoilSideDepleted;
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase playerBase) {
        ItemInstance heldItem = playerBase.getHeldItem();
        if (heldItem == null) return false;
        if (heldItem.itemId == ItemBase.brick.id)
        {
            level.setTile(x, y, z, BlockListener.brickSoil.id);
            heldItem.count--;
            return true;
        }
        return false;
    }
}
