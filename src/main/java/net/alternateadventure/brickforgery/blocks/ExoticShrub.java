package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class ExoticShrub extends TemplateBlockBase {

    public ExoticShrub(Identifier identifier, Material material) {
        super(identifier, material);
        setTicksRandomly(true);
    }

    @Override
    public ExoticShrub setHardness(float Hardness) {
        return (ExoticShrub) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i, int j) {
        return j < 15 ? TextureListener.ExoticShrub : TextureListener.ExoticShrubMature;
    }

    @Override
    protected int droppedMeta(int i) {
        return 0;
    }

    @Override
    public Box getCollisionShape(Level arg, int i, int j, int k) {
        return null;
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase playerBase) {
        if (level.getTileMeta(x, y, z) != 15) return false;
        level.placeBlockWithMetaData(x, y, z, BlockListener.exoticShrub.id, 0);
        level.spawnEntity(new Item(level, x, y, z, new ItemInstance(ItemListener.exoticFruit)));
        return true;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return level.getTileId(x, y, z) == 0 && level.getTileId(x, y, z) == BlockBase.GRASS.id;
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random random) {
        if (level.getTileMeta(x, y, z) == 15 || level.getLevelTime() % 24000 < 12000) return;
        level.setTileMeta(x, y, z, level.getTileMeta(x, y, z) + 1);
    }
}
