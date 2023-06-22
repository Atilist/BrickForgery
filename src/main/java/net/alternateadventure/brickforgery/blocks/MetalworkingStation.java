package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;

public class MetalworkingStation extends LazyBlockTemplate {
    public MetalworkingStation(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material, hardness, blockSounds);
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase playerBase) {
        ItemInstance item = playerBase.getHeldItem();
        if (item == null) return false;
        if (item.itemId == ItemBase.goldIngot.id) {
            item.count--;
            level.spawnEntity(new Item(level, x + 0.5, y + 1, z + 0.5, new ItemInstance(ItemListener.goldenScrew)));
            return true;
        } else if (item.itemId == ItemListener.brickSteelIngot.id) {
            item.count--;
            level.spawnEntity(new Item(level, x + 0.5, y + 1, z + 0.5, new ItemInstance(ItemListener.brickSteelPlate)));
            return true;
        } else if (item.itemId == ItemListener.bricksidianIngot.id) {
            item.count--;
            level.spawnEntity(new Item(level, x + 0.5, y + 1, z + 0.5, new ItemInstance(ItemListener.bricksidianScrew)));
            return true;
        }
        return false;
    }
}
