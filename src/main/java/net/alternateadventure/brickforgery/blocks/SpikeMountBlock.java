package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class SpikeMountBlock extends TemplateBlock {

    public SpikeMountBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public SpikeMountBlock setHardness(float Hardness) {
        return (SpikeMountBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i, int j) {
        return j == 0 ? TextureListener.SpikeMount : TextureListener.SpikeMountLoaded;
    }

    @Override
    protected int getDroppedItemMeta(int i) {
        return 0;
    }

    public boolean isOpaque() {
        return false;
    }

    public boolean isFullCube() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean onUse(World level, int x, int y, int z, PlayerEntity arg2) {
        if (level.getBlockMeta(x, y, z) == 1) return false;
        ItemStack playerItem = arg2.getHeldItem();
        if (playerItem == null) return false;
        if (playerItem.itemId != Item.FLINT.id) return false;
        level.setBlock(x, y, z, BlockListener.spikeMount.id, 1);
        playerItem.count--;
        return true;
    }
}
