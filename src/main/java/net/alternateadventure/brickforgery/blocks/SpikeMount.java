package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class SpikeMount extends TemplateBlockBase {

    public SpikeMount(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public SpikeMount setHardness(float Hardness) {
        return (SpikeMount) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i, int j) {
        return j == 0 ? TextureListener.SpikeMount : TextureListener.SpikeMountLoaded;
    }

    @Override
    protected int droppedMeta(int i) {
        return 0;
    }

    public boolean isFullOpaque() {
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
    public boolean canUse(Level level, int x, int y, int z, PlayerBase arg2) {
        if (level.getTileMeta(x, y, z) == 1) return false;
        ItemInstance playerItem = arg2.getHeldItem();
        if (playerItem == null) return false;
        if (playerItem.itemId != ItemBase.flint.id) return false;
        level.placeBlockWithMetaData(x, y, z, BlockListener.spikeMount.id, 1);
        playerItem.count--;
        return true;
    }
}
