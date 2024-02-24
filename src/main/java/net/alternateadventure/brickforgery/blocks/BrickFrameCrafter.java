package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class BrickFrameCrafter extends TemplateBlock {
    public BrickFrameCrafter(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public BrickFrameCrafter setHardness(float Hardness) {
        return (BrickFrameCrafter) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return i == 0 ? TextureListener.BrickFrameCrafterBottom : i == 1 ? TextureListener.BrickFrameCrafterTop : TextureListener.BrickFrameCrafterSide;
    }

    @Override
    public boolean canUse(Level arg, int i, int j, int k, PlayerBase arg2) {
        craftFrame(arg, i, j, k, arg2);
        return true;
    }

    public void craftFrame(Level level, int x, int y, int z, PlayerBase player) {
        if (level.getTileId(x, y + 1, z) != 0) return;
        ItemInstance item = player.getHeldItem();
        if (item == null) return;
        if (item.itemId != ItemListener.woodenFrame.id) return;

        boolean hasClay = false;
        boolean hasPlanks = false;

        if (level.getTileId(x + 1, y, z) == BlockBase.CLAY.id || level.getTileId(x + 1, y, z) == BlockListener.clayPile.id) hasClay = true;
        if (level.getTileId(x - 1, y, z) == BlockBase.CLAY.id || level.getTileId(x - 1, y, z) == BlockListener.clayPile.id) hasClay = true;
        if (level.getTileId(x, y, z + 1) == BlockBase.CLAY.id || level.getTileId(x, y, z + 1) == BlockListener.clayPile.id) hasClay = true;
        if (level.getTileId(x, y, z - 1) == BlockBase.CLAY.id || level.getTileId(x, y, z - 1) == BlockListener.clayPile.id) hasClay = true;

        if (level.getTileId(x + 1, y, z) == BlockListener.nightPlanks.id || level.getTileId(x + 1, y, z) == BlockListener.planksPile.id) hasPlanks = true;
        if (level.getTileId(x - 1, y, z) == BlockListener.nightPlanks.id || level.getTileId(x - 1, y, z) == BlockListener.planksPile.id) hasPlanks = true;
        if (level.getTileId(x, y, z + 1) == BlockListener.nightPlanks.id || level.getTileId(x, y, z + 1) == BlockListener.planksPile.id) hasPlanks = true;
        if (level.getTileId(x, y, z - 1) == BlockListener.nightPlanks.id || level.getTileId(x, y, z - 1) == BlockListener.planksPile.id) hasPlanks = true;

        if (!(hasClay && hasPlanks)) return;

        item.count--;
        level.spawnEntity(new Item(level, x + 0.5, y + 1, z + 0.5, new ItemInstance(ItemListener.brickFrame)));

        boolean clayDecreased;
        boolean planksDecreased;

        clayDecreased = decreaseClay(level, x + 1, y, z);
        if (!clayDecreased) clayDecreased = decreaseClay(level, x - 1, y, z);
        if (!clayDecreased) clayDecreased = decreaseClay(level, x, y, z + 1);
        if (!clayDecreased) decreaseClay(level, x, y, z - 1);

        planksDecreased = decreasePlanks(level, x + 1, y, z);
        if (!planksDecreased) planksDecreased = decreasePlanks(level, x - 1, y, z);
        if (!planksDecreased) planksDecreased = decreasePlanks(level, x, y, z + 1);
        if (!planksDecreased) decreasePlanks(level, x, y, z - 1);
    }

    public boolean decreaseClay (Level level, int x, int y, int z)
    {
        if (level.getTileId(x, y, z) == BlockBase.CLAY.id)
        {
            level.setTile(x, y, z, BlockListener.clayPile.id);
            level.setBlockStateWithNotify(x, y, z, BlockListener.clayPile.getDefaultState().with(ResourcePile.USES, 15));
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockListener.clayPile.id)
        {
            int blockState = level.getBlockState(x, y, z).get(ResourcePile.USES);
            if (blockState == 1) level.setTile(x, y, z, 0);
            else level.setBlockStateWithNotify(x, y, z, BlockListener.clayPile.getDefaultState().with(ResourcePile.USES, blockState - 1));
            return true;
        }
        return false;
    }

    public boolean decreasePlanks (Level level, int x, int y, int z)
    {
        if (level.getTileId(x, y, z) == BlockListener.nightPlanks.id)
        {
            level.setTile(x, y, z, BlockListener.planksPile.id);
            level.setBlockStateWithNotify(x, y, z, BlockListener.planksPile.getDefaultState().with(ResourcePile.USES, 15));
            return true;
        }
        else if (level.getTileId(x, y, z) == BlockListener.planksPile.id)
        {
            int blockState = level.getBlockState(x, y, z).get(ResourcePile.USES);
            if (blockState == 1) level.setTile(x, y, z, 0);
            else level.setBlockStateWithNotify(x, y, z, BlockListener.planksPile.getDefaultState().with(ResourcePile.USES, blockState - 1));
            return true;
        }
        return false;
    }
}
