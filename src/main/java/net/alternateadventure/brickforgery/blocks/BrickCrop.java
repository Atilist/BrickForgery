package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class BrickCrop extends TemplateBlock {

    public BrickCrop(Identifier identifier, Material material) {
        super(identifier, material);
        setTickRandomly(true);
    }

    @Override
    public BrickCrop setHardness(float Hardness) {
        return (BrickCrop) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i, int j) {
        return j == 0 ? TextureListener.BrickCropBud : j == 1 ? TextureListener.BrickCropSmall : j == 2 ? TextureListener.BrickCropBlooming : TextureListener.BrickCropMature;
    }

    @Override
    protected int getDroppedItemMeta(int blockMeta) {
        return 0;
    }
    
    @Override
    public int getDroppedItemId(int i, Random random) {
        return ItemListener.brickSeedlings.id;
    }

    @Override
    public Box getCollisionShape(World arg, int i, int j, int k) {
        return null;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }
    
    @Override
    public void neighborUpdate(World arg, int i, int j, int k, int l) {
        if (arg.getBlockId(i, j - 1, k) != BlockListener.brickSoil.id && arg.getBlockId(i, j - 1, k) != BlockListener.brickSoilDepleted.id)
        {
            arg.setBlock(i, j, k, 0);
            arg.spawnEntity(new ItemEntity(arg, i, j, k, new ItemStack(ItemListener.brickSeedlings)));
        }
    }

    @Override
    public void onTick(World level, int x, int y, int z, Random random) {
        if (level.getBlockMeta(x, y, z) == 3) return;
        if (!(level.getBlockId(x, y - 1, z) == BlockListener.brickSoil.id)) return;
        if (level.getBlockMeta(x, y, z) == 2)
        {
            if (!checkForFlowers(level, x, y, z)) return;
            level.setBlockMeta(x, y, z, 3);
            level.setBlock(x, y - 1, z, BlockListener.brickSoilDepleted.id);
            removeFlowers(level, x, y, z, random);
        }
        else level.setBlockMeta(x, y, z, level.getBlockMeta(x, y, z) + 1);
    }

    private boolean checkForFlowers(World level, int x, int y, int z) {
        return checkForBlockID(level, x, y, z, Block.ROSE.id) == Block.ROSE.id && checkForBlockID(level, x, y, z, Block.DANDELION.id) == Block.DANDELION.id;
    }

    private int checkForBlockID(World level, int x, int y, int z, int blocKID) {
        if (level.getBlockId(x + 1, y, z) == blocKID) return blocKID;
        if (level.getBlockId(x - 1, y, z) == blocKID) return blocKID;
        if (level.getBlockId(x, y, z + 1) == blocKID) return blocKID;
        if (level.getBlockId(x, y, z - 1) == blocKID) return blocKID;
        return 0;
    }

    private void removeFlowers(World level, int x, int y, int z, Random random) {
        if ((level.getBlockId(x + 1, y, z) == Block.ROSE.id || level.getBlockId(x + 1, y, z) == Block.DANDELION.id) && random.nextInt(2) == 1) level.setBlock(x + 1, y, z, 0);
        if ((level.getBlockId(x - 1, y, z) == Block.ROSE.id || level.getBlockId(x - 1, y, z) == Block.DANDELION.id) && random.nextInt(2) == 1) level.setBlock(x - 1, y, z, 0);
        if ((level.getBlockId(x, y, z + 1) == Block.ROSE.id || level.getBlockId(x, y, z + 1) == Block.DANDELION.id) && random.nextInt(2) == 1) level.setBlock(x, y, z + 1, 0);
        if ((level.getBlockId(x, y, z - 1) == Block.ROSE.id || level.getBlockId(x, y, z - 1) == Block.DANDELION.id) && random.nextInt(2) == 1) level.setBlock(x, y, z - 1, 0);
    }
}
