package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class NightSapling extends TemplateBlock {

    public NightSapling(Identifier identifier, Material material) {
        super(identifier, material);
        setTickRandomly(true);
    }

    @Override
    public NightSapling setHardness(float Hardness) {
        return (NightSapling) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i, int j) {
        return TextureListener.NightSapling;
    }

    @Override
    protected int getDroppedItemMeta(int i) {
        return 0;
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
    public boolean canPlaceAt(World level, int x, int y, int z) {
        return level.getBlockId(x, y, z) == 0 && (level.getBlockId(x, y - 1, z) == Block.GRASS.id || level.getBlockId(x, y - 1, z) == Block.DIRT.id);
    }

    @Override
    public void onTick(World level, int x, int y, int z, Random random) {
        if (level.getTime() % 24000 < 12000) return;
        if (level.getBlockMeta(x, y, z) == 15 && random.nextInt(4) == 0)
        {
            growTree(level, x, y, z, random);
            return;
        }
        if (level.getBlockMeta(x, y, z) < 15) level.setBlockMeta(x, y, z, level.getBlockMeta(x, y, z) + 1);
    }

    @Override
    public boolean onUse(World level, int x, int y, int z, PlayerEntity player) {
        if (level.getTime() % 24000 < 12000) return false;
        ItemStack item = player.getHeldItem();
        if (item == null) return false;
        if (item.itemId != Item.DYE.id && item.getDamage() != 15) return false;
        item.count--;
        growTree(level, x, y, z, new Random());
        return true;
    }

    private void growTree(World level, int x, int y, int z, Random random) {
        int randomHeight = random.nextInt(5) + 4;
        level.setBlock(x, y - 1, z, Block.DIRT.id);
        for (int height = 0; height < randomHeight; height++) {
            level.setBlock(x, y + height, z, BlockListener.nightLog.id);
        }
        for (int xOffset = -2; xOffset <= 2; xOffset++) {
            for (int yOffset = randomHeight - 3; yOffset < randomHeight + 1; yOffset++) {
                for (int zOffset = -2; zOffset <= 2; zOffset++) {
                    if (level.getBlockId(x + xOffset, y + yOffset, z + zOffset) != 0) continue;
                    if (yOffset > randomHeight - 1 && (xOffset == -2 || xOffset == 2) && (zOffset == -2 || zOffset == 2)) continue;
                    level.setBlock(x + xOffset, y + yOffset, z + zOffset, BlockListener.nightLeaves.id, 8);
                }
            }
        }
    }
}
