package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.blocks.entity.SlicerBlockEntity;
import net.alternateadventure.brickforgery.containers.SlicerScreenHandler;
import net.alternateadventure.brickforgery.events.init.BlockEntityListener;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.kozibrodka.wolves.utils.MechanicalDevice;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.gui.screen.container.GuiHelper;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class SlicerBlockTemplate extends LazySimpleMachineBlockTemplate implements MechanicalDevice {
    private final Random rand = new Random();

    public TierEnum tier;
    private int inputSideTexture;

    public SlicerBlockTemplate(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, TierEnum tier) {
        super(identifier, material, hardness, blockSounds);
        this.tier = tier;
    }

    public void specifyInputTexture(int inputSideTexture) {
        this.inputSideTexture = inputSideTexture;
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
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        BlockEntity tileEntity = world.getBlockEntity(x, y, z);
        if (tileEntity instanceof SlicerBlockEntity slicerBlockEntity)
            GuiHelper.openGUI(player, Identifier.of(BlockEntityListener.MOD_ID, "gui_slicer"), slicerBlockEntity, new SlicerScreenHandler(player.inventory, slicerBlockEntity));
        return true;
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new SlicerBlockEntity();
    }

    public void onBreak(World arg, int i, int j, int k) {

            SlicerBlockEntity slicer = (SlicerBlockEntity) arg.getBlockEntity(i, j, k);

            for(int var6 = 0; var6 < slicer.size(); ++var6) {
                ItemStack var7 = slicer.getStack(var6);
                if (var7 != null) {
                    float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
                    float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
                    float var10 = this.rand.nextFloat() * 0.8F + 0.1F;

                    while(var7.count > 0) {
                        int var11 = this.rand.nextInt(21) + 10;
                        if (var11 > var7.count) {
                            var11 = var7.count;
                        }

                        var7.count -= var11;
                        ItemEntity var12 = new ItemEntity(arg, (float)i + var8, (float)j + var9, (float)k + var10, new ItemStack(var7.itemId, var11, var7.getDamage()));
                        float var13 = 0.05F;
                        var12.velocityX = (float)this.rand.nextGaussian() * var13;
                        var12.velocityY = (float)this.rand.nextGaussian() * var13 + 0.2F;
                        var12.velocityZ = (float)this.rand.nextGaussian() * var13;
                        arg.spawnEntity(var12);
                    }
                }
            }

        super.onBreak(arg, i, j, k);
    }

    @Override
    public void randomDisplayTick(World level, int x, int y, int z, Random random) {
        if (level.getBlockMeta(x, y, z) != 1) return;
        for(int counter = 0; counter < 5; counter++)
        {
            float smokeX = (float)x + random.nextFloat();
            float smokeY = (float)y + random.nextFloat() * 0.5F + 1.0F;
            float smokeZ = (float)z + random.nextFloat();
            level.addParticle("smoke", smokeX, smokeY, smokeZ, 0.0D, 0.0D, 0.0D);
        }
        if(random.nextInt(5) == 0)
        {
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
