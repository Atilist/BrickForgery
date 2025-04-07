package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class NightWheatCrop extends TemplateBlock {

    public NightWheatCrop(Identifier identifier, Material material) {
        super(identifier, material);
        setTickRandomly(true);
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
    }

    @Override
    public NightWheatCrop setHardness(float Hardness) {
        return (NightWheatCrop) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i, int j) {
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
    protected int getDroppedItemMeta(int i) {
        return 0;
    }

    @Override
    public int getDroppedItemId(int i, Random randomom) {
        return i == 7 ? ItemListener.nightWheat.id : -1;
    }

    public Box getCollisionShape(World arg, int i, int j, int k) {
        return null;
    }

    public boolean isOpaque() {
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
    public boolean canPlaceAt(World level, int x, int y, int z) {
        return level.getBlockId(x, y, z) == 0 && level.getBlockId(x, y - 1, z) == Block.FARMLAND.id;
    }

    @Override
    public boolean onUse(World level, int x, int y, int z, PlayerEntity player) {
        if (level.getTime() % 24000 < 12000) return false;
        if (level.getBlockMeta(x, y, z) == 7) return false;
        ItemStack item = player.getHeldItem();
        if (item == null) return false;
        if (item.itemId != Item.DYE.id && item.getDamage() != 15) return false;
        item.count--;
        level.setBlock(x, y, z, BlockListener.nightWheatCrop.id, 7);
        return true;
    }

    @Override
    public void onTick(World level, int x, int y, int z, Random randomom) {
        if (level.getTime() % 24000 < 12000) return;
        if (level.getBlockMeta(x, y, z) == 7) {
            if (randomom.nextInt(16) != 0) return;
            if (level.getBlockId(x + 1, y, z) == Block.GRASS.id && level.getBlockMeta(x + 1, y, z) == 2) level.setBlock(x + 1, y, z, BlockListener.exoticShrub.id);
            if (level.getBlockId(x - 1, y, z) == Block.GRASS.id && level.getBlockMeta(x - 1, y, z) == 2) level.setBlock(x - 1, y, z, BlockListener.exoticShrub.id);
            if (level.getBlockId(x, y, z + 1) == Block.GRASS.id && level.getBlockMeta(x, y, z + 1) == 2) level.setBlock(x, y, z + 1, BlockListener.exoticShrub.id);
            if (level.getBlockId(x, y, z - 1) == Block.GRASS.id && level.getBlockMeta(x, y, z - 1) == 2) level.setBlock(x, y, z - 1, BlockListener.exoticShrub.id);
        }
        else if (randomom.nextInt(4) == 0) level.setBlock(x, y, z, level.getBlockMeta(x, y, z) + 1);
    }
    
    @Override
    public void dropStacks(World level, int x, int y, int z, int meta, float luck) {
        super.dropStacks(level, x, y, z, meta, luck);
        for(int attempts = 0; attempts < 3; ++attempts) {
            if (!(level.random.nextInt(15) <= meta)) continue;
            float askNotchWhyThisVariableExists = 0.7F;
            float randomomX = level.random.nextFloat() * askNotchWhyThisVariableExists + (1.0F - askNotchWhyThisVariableExists) * 0.5F;
            float randomomY = level.random.nextFloat() * askNotchWhyThisVariableExists + (1.0F - askNotchWhyThisVariableExists) * 0.5F;
            float randomomZ = level.random.nextFloat() * askNotchWhyThisVariableExists + (1.0F - askNotchWhyThisVariableExists) * 0.5F;
            ItemEntity item = new ItemEntity(level, (float) x + randomomX, (float) y + randomomY, (float) z + randomomZ, new ItemStack(ItemListener.nightSeeds));
            item.pickupDelay = 10;
            level.spawnEntity(item);
        }
    }
}
