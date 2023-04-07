package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class NightWheatCrop extends TemplateBlockBase {

    public NightWheatCrop(Identifier identifier, Material material) {
        super(identifier, material);
        setTicksRandomly(true);
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
    }

    @Override
    public NightWheatCrop setHardness(float Hardness) {
        return (NightWheatCrop) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i, int j) {
        return switch (j) {
            case 0 -> TextureListener.NightWheatCropBud;
            case 1 -> TextureListener.NightWheatCropSmall;
            case 2 -> TextureListener.NightWheatCropMedium;
            case 3 -> TextureListener.NightWheatCropLarge;
            case 4 -> TextureListener.NightWheatCropThriving;
            case 5 -> TextureListener.NightWheatCropBlooming;
            case 6 -> TextureListener.NightWheatCropMature;
            case 7 -> TextureListener.NightWheatCropRipe;
            default -> 0;
        };
    }

    @Override
    protected int droppedMeta(int i) {
        return 0;
    }

    @Override
    public int getDropId(int i, Random random) {
        return i == 7 ? ItemListener.nightWheat.id : -1;
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
        return 6;
    }

    @Override
    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return level.getTileId(x, y, z) == 0 && level.getTileId(x, y - 1, z) == BlockBase.FARMLAND.id;
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random random) {
        if (level.getTileMeta(x, y, z) == 7 || level.getLevelTime() % 24000 < 12000) return;
        level.setTileMeta(x, y, z, level.getTileMeta(x, y, z) + 1);
    }

    @Override
    public void beforeDestroyedByExplosion(Level level, int x, int y, int z, int iHaveNoIdea, float whatEvenIsThis)
    {
        super.beforeDestroyedByExplosion(level, x, y, z, iHaveNoIdea, whatEvenIsThis);
        for(int attempts = 0; attempts < 3; ++attempts)
        {
            if (!(level.rand.nextInt(15) <= iHaveNoIdea)) continue;
            float askNotchWhyThisVariableExists = 0.7F;
            float randomX = level.rand.nextFloat() * askNotchWhyThisVariableExists + (1.0F - askNotchWhyThisVariableExists) * 0.5F;
            float randomY = level.rand.nextFloat() * askNotchWhyThisVariableExists + (1.0F - askNotchWhyThisVariableExists) * 0.5F;
            float randomZ = level.rand.nextFloat() * askNotchWhyThisVariableExists + (1.0F - askNotchWhyThisVariableExists) * 0.5F;
            Item item = new Item(level, (float) x + randomX, (float) y + randomY, (float) z + randomZ, new ItemInstance(ItemListener.nightSeeds));
            item.pickupDelay = 10;
            level.spawnEntity(item);
        }
    }
}
