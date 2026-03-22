package net.alternateadventure.brickforgery.block;

import net.alternateadventure.brickforgery.util.TierEnum;
import net.kozibrodka.wolves.utils.MechanicalDevice;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;
import net.newfrontiercraft.nfc.block.entity.BasicItemChuteBlockEntity;

import java.util.Random;

public class BrickFrameAutomator extends LazyBlockTemplate implements MechanicalDevice {
    public TierEnum tier;
    private int inputSideTexture;

    public BrickFrameAutomator(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, TierEnum tier) {
        super(identifier, material, hardness, blockSounds);
        this.tier = tier;
        setTickRandomly(true);
    }

    public void specifyInputTexture(int inputSideTexture) {
        this.inputSideTexture = inputSideTexture;
    }

    @Override
    public int getTickRate() {
        return 64 / (tier.ordinal() + 1);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        world.scheduleBlockUpdate(x, y, z, this.id, getTickRate());
        if (world.getBlockMeta(x, y, z) < 6) return;
        int belowId = world.getBlockId(x, y - 1, z);
        if (belowId == 0) return;
        Block block = Block.BLOCKS[belowId];
        if (block instanceof BrickFrameCrafterBlock brickFrameCrafterBlock) {
            if (world.getBlockEntity(x, y + 1, z) instanceof BasicItemChuteBlockEntity basicItemChuteBlockEntity) {
                ItemStack chuteItem = basicItemChuteBlockEntity.getStack(0);
                if (chuteItem == null) return;
                chuteItem = chuteItem.copy();
                if (!brickFrameCrafterBlock.craftFrame(world, x, y - 1, z, chuteItem)) return;
                chuteItem.count--;
                if (chuteItem.count <= 0) {
                    chuteItem = null;
                }
                basicItemChuteBlockEntity.setStack(0, chuteItem);
            }
        }
    }

    @Override
    public int getTexture(int side, int meta) {
        if (meta >= 6) {
            meta -= 6;
        }
        if (meta == 0) {
            if (side == 1) {
                return topTextureInternal;
            }
            if (side == 3) {
                return inputSideTexture;
            }
        }
        if (side == meta) {
            return inputSideTexture;
        }
        return super.getTexture(side, meta);
    }

    @Override
    public void randomDisplayTick(World level, int x, int y, int z, Random random) {
        if (level.getBlockMeta(x, y, z) < 6) return;
        for(int counter = 0; counter < 5; counter++) {
            float smokeX = (float)x + random.nextFloat();
            float smokeY = (float)y + random.nextFloat() * 0.5F + 1.0F;
            float smokeZ = (float)z + random.nextFloat();
            level.addParticle("smoke", smokeX, smokeY, smokeZ, 0.0D, 0.0D, 0.0D);
        }
        if(random.nextInt(5) == 0) {
            level.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.explode", 0.1F + random.nextFloat() * 0.1F, 1.25F + random.nextFloat() * 0.1F);
        }
    }
    @Override
    public void onPlaced(World world, int x, int y, int z, LivingEntity placer) {
        int facing = MathHelper.floor((double)(placer.yaw * 4.0F / 360.0F) + (double)0.5F) & 3;
        if (facing == 0) {
            world.setBlockMeta(x, y, z, 2);
        }

        if (facing == 1) {
            world.setBlockMeta(x, y, z, 5);
        }

        if (facing == 2) {
            world.setBlockMeta(x, y, z, 3);
        }

        if (facing == 3) {
            world.setBlockMeta(x, y, z, 4);
        }
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
    public boolean canInputMechanicalPower(World world, int x, int y, int z, int side) {
        return side == world.getBlockMeta(x, y, z);
    }

    @Override
    public void powerMachine(World world, int x, int y, int z, int side) {
        world.setBlockMeta(x, y, z, world.getBlockMeta(x, y, z) + 6);
    }

    @Override
    public void unpowerMachine(World world, int x, int y, int z, int side) {
        world.setBlockMeta(x, y, z, world.getBlockMeta(x, y, z) - 6);
    }

    @Override
    public boolean isMachinePowered(World world, int x, int y, int z) {
        return world.getBlockMeta(x, y, z) >= 6;
    }
}
