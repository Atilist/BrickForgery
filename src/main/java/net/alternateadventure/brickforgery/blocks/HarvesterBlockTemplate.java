package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.registry.machine.HarvestingRecipeRegistry;
import net.alternateadventure.brickforgery.registry.machine.records.HarvestingOutput;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.kozibrodka.wolves.utils.MechanicalDevice;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;
import net.newfrontiercraft.nfc.block.entity.BasicItemChuteBlockEntity;

import java.util.Random;

public class HarvesterBlockTemplate extends LazyBlockTemplate implements MechanicalDevice {
    private final TierEnum tier;

    public HarvesterBlockTemplate(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, TierEnum tier) {
        super(identifier, material, hardness, blockSounds);
        setTickRandomly(true);
        this.tier = tier;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        world.scheduleBlockUpdate(x, y, z, this.id, getTickRate());
        if (world.getBlockEntity(x, y - 1, z) instanceof BasicItemChuteBlockEntity basicItemChuteBlockEntity) {
            int range = 1 + tier.ordinal();
            for (int xOffset = -range; xOffset <= range; xOffset++) {
                for (int zOffset = -range; zOffset <= range; zOffset++) {
                    int localBlockId = world.getBlockId(x + xOffset, y, z + zOffset);
                    int localBlockMeta = world.getBlockMeta(x + xOffset, y, z + zOffset);
                    HarvestingOutput output = HarvestingRecipeRegistry.getInstance().getResult(localBlockId, localBlockMeta);
                    if (output == null) continue;
                    ItemStack outputItem = output.itemResult();
                    if (outputItem == null) {
                        world.setBlock(x + xOffset, y, z + zOffset, output.newBlockId(), output.newBlockMeta());
                        return;
                    }
                    outputItem = outputItem.copy();
                    ItemStack slotItem = basicItemChuteBlockEntity.getStack(0);
                    if (slotItem == null) {
                        basicItemChuteBlockEntity.setStack(0, outputItem);
                        world.setBlock(x + xOffset, y, z + zOffset, output.newBlockId(), output.newBlockMeta());
                        return;
                    } else if (slotItem.isItemEqual(outputItem)) {
                        int totalCount = slotItem.count + outputItem.count;
                        if (totalCount <= slotItem.getMaxCount()) {
                            world.setBlock(x + xOffset, y, z + zOffset, output.newBlockId(), output.newBlockMeta());
                            outputItem.count = totalCount;
                            basicItemChuteBlockEntity.setStack(0, outputItem);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getTickRate() {
        return 64 / (tier.ordinal() + 1);
    }

    @Override
    public boolean canOutputMechanicalPower() {
        return false;
    }

    @Override
    public boolean canInputMechanicalPower() {
        return true;
    }

    @Override
    public boolean canInputMechanicalPower(World world, int firstHorizontalWorldCoordinate, int verticalWorldCoordinate, int secondHorizontalWorldCoordinate, int side) {
        return side == 1;
    }

    @Override
    public void powerMachine(World world, int x, int y, int z, int side) {
        world.setBlockMeta(x, y, z, 1);
    }

    @Override
    public void unpowerMachine(World world, int x, int y, int z, int side) {
        world.setBlockMeta(x, y, z, 0);
    }

    @Override
    public boolean isMachinePowered(World world, int x, int y, int z) {
        return world.getBlockMeta(x, y, z) == 1;
    }
}
