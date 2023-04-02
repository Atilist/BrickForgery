package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.alternateadventure.brickforgery.interfaces.SpikeCrushable;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class BrickLauncher extends TemplateBlockBase {

    public BrickLauncher(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public BrickLauncher setHardness(float Hardness) {
        return (BrickLauncher) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int i) {
        return i == 0 ? TextureListener.BrickLauncherBottom : i == 1 ? TextureListener.BrickLauncherTop : TextureListener.BrickLauncherSide;
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase arg2) {
        crushBlock(level, x, y, z);
        return true;
    }

    public void crushBlock(Level level, int x, int y, int z) {
        BlockBase inputBlock = BlockBase.BY_ID[level.getTileId(x, y + 1, z)];
        if (inputBlock == null) return;
        if (!(inputBlock instanceof SpikeCrushable)) return;
        int yOffset;
        for (yOffset = 1; yOffset < ((SpikeCrushable) inputBlock).requiredDistance(); yOffset++) if (level.getTileId(x, y - yOffset, z) != 0) return;
        if (level.getTileId(x, y - yOffset - 1, z) != BlockListener.spikeMount.id || level.getTileMeta(x, y - yOffset - 1, z) != 1) return;
        level.spawnEntity(new Item(level, x, y - yOffset, z, ((SpikeCrushable) inputBlock).crushingOutput()));
        level.setTile(x, y + 1, z, 0);
        level.placeBlockWithMetaData(x, y - yOffset - 1, z, BlockListener.spikeMount.id, 0);
    }
}