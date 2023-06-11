package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class NightSapling extends TemplateBlockBase {

    public NightSapling(Identifier identifier, Material material) {
        super(identifier, material);
        setTicksRandomly(true);
    }

    @Override
    public NightSapling setHardness(float Hardness) {
        return (NightSapling) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i, int j) {
        return TextureListener.NightSapling;
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

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return level.getTileId(x, y, z) == 0 && (level.getTileId(x, y - 1, z) == BlockBase.GRASS.id || level.getTileId(x, y - 1, z) == BlockBase.DIRT.id);
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random random) {
        if (level.getLevelTime() % 24000 < 12000) return;
        if (level.getTileMeta(x, y, z) == 15 && random.nextInt(4) == 0)
        {
            growTree(level, x, y, z, random);
            return;
        }
        if (level.getTileMeta(x, y, z) < 15) level.setTileMeta(x, y, z, level.getTileMeta(x, y, z) + 1);
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase player) {
        if (level.getLevelTime() % 24000 < 12000) return false;
        ItemInstance item = player.getHeldItem();
        if (item == null) return false;
        if (item.itemId != ItemBase.dyePowder.id && item.getDamage() != 15) return false;
        item.count--;
        growTree(level, x, y, z, new Random());
        return true;
    }

    private void growTree(Level level, int x, int y, int z, Random random)
    {
        int randomHeight = random.nextInt(5) + 4;
        level.setTile(x, y - 1, z, BlockBase.DIRT.id);
        for (int height = 0; height < randomHeight; height++)
        {
            level.setTile(x, y + height, z, BlockListener.nightLog.id);
        }
        for (int xOffset = -2; xOffset <= 2; xOffset++)
        {
            for (int yOffset = randomHeight - 3; yOffset < randomHeight + 1; yOffset++)
            {
                for (int zOffset = -2; zOffset <= 2; zOffset++)
                {
                    if (level.getTileId(x + xOffset, y + yOffset, z + zOffset) != 0) continue;
                    if (yOffset > randomHeight - 1 && (xOffset == -2 || xOffset == 2) && (zOffset == -2 || zOffset == 2)) continue;
                    level.setTileWithMetadata(x + xOffset, y + yOffset, z + zOffset, BlockListener.nightLeaves.id, 8);
                }
            }
        }
    }
}
