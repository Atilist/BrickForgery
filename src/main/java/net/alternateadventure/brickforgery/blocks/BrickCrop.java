package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class BrickCrop extends TemplateBlockBase {

    public BrickCrop(Identifier identifier, Material material) {
        super(identifier, material);
        setTicksRandomly(true);
    }

    @Override
    public BrickCrop setHardness(float Hardness) {
        return (BrickCrop) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i, int j) {
        return j == 0 ? TextureListener.BrickCropBud : j == 1 ? TextureListener.BrickCropSmall : j == 2 ? TextureListener.BrickCropBlooming : TextureListener.BrickCropMature;
    }

    @Override
    protected int droppedMeta(int i) {
        return 0;
    }

    @Override
    public int getDropId(int i, Random random) {
        return ItemListener.brickSeedlings.id;
    }

    public Box getCollisionShape(Level arg, int i, int j, int k) {
        return null;
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
    public void onScheduledTick(Level level, int x, int y, int z, Random random) {
        if (level.getTileMeta(x, y, z) == 3) return;
        if (!(level.getTileId(x, y - 1, z) == BlockListener.brickSoil.id)) return;
        if (level.getTileMeta(x, y, z) == 2)
        {
            level.setTileMeta(x, y, z, 3);
            level.setTile(x, y - 1, z, BlockListener.brickSoilDepleted.id);
        }
        else level.setTileMeta(x, y, z, level.getTileMeta(x, y, z) + 1);
    }
}
