package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.customrecipes.BrickFramingRecipeRegistry;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.alternateadventure.brickforgery.interfaces.BrickFrameIngredient;
import net.minecraft.block.BlockBase;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class BrickFrameCrafter extends LazyBlockTemplate {
    public int tier;
    private final Random random = new Random();

    public BrickFrameCrafter(Identifier identifier, Material material, float hardness, BlockSounds blockSounds, int tier) {
        super(identifier, material, hardness, blockSounds);
        this.tier = tier;
    }

    @Override
    public BrickFrameCrafter setHardness(float Hardness) {
        return (BrickFrameCrafter) super.setHardness(Hardness);
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
        int[] blocks = new int[4];
        blocks[0] = level.getTileId(x + 1, y, z);
        blocks[1] = level.getTileId(x - 1, y, z);
        blocks[2] = level.getTileId(x, y, z + 1);
        blocks[3] = level.getTileId(x, y, z - 1);
        ItemInstance output = BrickFramingRecipeRegistry.getInstance().getResult(item, blocks);
        if (output == null) return;
        output = output.copy();
        item.count--;
        if (output.count < 1) output.count = 1;
        transformBlock(level, x + 1, y, z);
        transformBlock(level, x - 1, y, z);
        transformBlock(level, x, y, z + 1);
        transformBlock(level, x, y, z - 1);
        if (tier < 1 && random.nextBoolean()) return; // 50% chance of failure if tier is below 1
        level.spawnEntity(new Item(level, x + 0.5, y + 1, z + 0.5, output));
    }

    private void transformBlock(Level world, int x, int y, int z) {
        BlockBase blockBase = BlockBase.BY_ID[world.getTileId(x, y, z)];
        if (blockBase == null) return;
        if (blockBase instanceof BrickFrameIngredient ingredient) {
            ingredient.transformBlock(world, x, y, z, new Random());
        }
    }
}
