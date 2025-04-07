package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.containers.ContainerAlloySmelter;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.BlockEntityListener;
import net.alternateadventure.brickforgery.tileentities.TileEntityAlloySmelter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.gui.screen.container.GuiHelper;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class AlloySmelter extends DirectionalMachineTemplate {

    private final Random rand = new Random();
    private final boolean lit;
    private static boolean SETTING_TILE = false;

    public AlloySmelter(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, boolean isLit) {
        super(identifier, material, hardness, blockSounds);
        lit = isLit;
        if (isLit) setLuminance(1.0F);
    }


    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return BlockListener.alloySmelter.id;
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        BlockEntity tileEntity = world.getBlockEntity(x, y, z);
        if (tileEntity instanceof TileEntityAlloySmelter tileEntityAlloySmelter)
            GuiHelper.openGUI(player, Identifier.of(BlockEntityListener.MOD_ID, "gui_alloy_smelter"), tileEntityAlloySmelter, new ContainerAlloySmelter(player.inventory, tileEntityAlloySmelter));
        return true;
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(World level, int x, int y, int z, Random random) {
        if (this.lit) {
            int var6 = level.getBlockMeta(x, y, z);
            float centeredX = (float)x + 0.5F;
            float randomY = (float)y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float centeredZ = (float)z + 0.5F;
            float frontOffset = 0.52F;
            float secondaryFrontOffset = random.nextFloat() * 0.6F - 0.3F;
            float topOffset = 0.125F;
            if (var6 == 3) {
                level.addParticle("smoke", centeredX - frontOffset, randomY, centeredZ + secondaryFrontOffset, 0.0D, 0.0D, 0.0D);
                level.addParticle("flame", centeredX - frontOffset, randomY, centeredZ + secondaryFrontOffset, 0.0D, 0.0D, 0.0D);
            } else if (var6 == 1) {
                level.addParticle("smoke", centeredX + frontOffset, randomY, centeredZ + secondaryFrontOffset, 0.0D, 0.0D, 0.0D);
                level.addParticle("flame", centeredX + frontOffset, randomY, centeredZ + secondaryFrontOffset, 0.0D, 0.0D, 0.0D);
            } else if (var6 == 0) {
                level.addParticle("smoke", centeredX + secondaryFrontOffset, randomY, centeredZ - frontOffset, 0.0D, 0.0D, 0.0D);
                level.addParticle("flame", centeredX + secondaryFrontOffset, randomY, centeredZ - frontOffset, 0.0D, 0.0D, 0.0D);
            } else if (var6 == 2) {
                level.addParticle("smoke", centeredX + secondaryFrontOffset, randomY, centeredZ + frontOffset, 0.0D, 0.0D, 0.0D);
                level.addParticle("flame", centeredX + secondaryFrontOffset, randomY, centeredZ + frontOffset, 0.0D, 0.0D, 0.0D);
            }
            level.addParticle("smoke", centeredX + topOffset, y + 1.0, centeredZ + topOffset, 0.0D, 0.1D, 0.0D);
            level.addParticle("smoke", centeredX + topOffset, y + 1.0, centeredZ - topOffset, 0.0D, 0.1D, 0.0D);
            level.addParticle("smoke", centeredX - topOffset, y + 1.0, centeredZ + topOffset, 0.0D, 0.1D, 0.0D);
            level.addParticle("smoke", centeredX - topOffset, y + 1.0, centeredZ - topOffset, 0.0D, 0.1D, 0.0D);
        }
    }

    public static void updateAlloySmelterState(boolean bl, World world, int i, int j, int k) {
        int var5 = world.getBlockMeta(i, j, k);
        BlockEntity var6 = world.getBlockEntity(i, j, k);
        SETTING_TILE = true;
        if (bl) {
            world.setBlock(i, j, k, BlockListener.alloySmelterActive.id);
        } else {
            world.setBlock(i, j, k, BlockListener.alloySmelter.id);
        }

        SETTING_TILE = false;
        world.setBlock(i, j, k, var5);
        var6.cancelRemoval();
        world.setBlockEntity(i, j, k, var6);
    }

    @Override
    public void onBreak(World arg, int i, int j, int k) {
        if (!SETTING_TILE) {
            TileEntityAlloySmelter alloySmelter = (TileEntityAlloySmelter)arg.getBlockEntity(i, j, k);

            for(int var6 = 0; var6 < alloySmelter.size(); ++var6) {
                ItemStack var7 = alloySmelter.getStack(var6);
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
                        ItemEntity var12 = new ItemEntity(arg, (double)((float)i + var8), (double)((float)j + var9), (double)((float)k + var10), new ItemStack(var7.itemId, var11, var7.getDamage()));
                        float var13 = 0.05F;
                        var12.velocityX = (double)((float)this.rand.nextGaussian() * var13);
                        var12.velocityY = (double)((float)this.rand.nextGaussian() * var13 + 0.2F);
                        var12.velocityZ = (double)((float)this.rand.nextGaussian() * var13);
                        arg.spawnEntity(var12);
                    }
                }
            }
        }

        super.onBreak(arg, i, j, k);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new TileEntityAlloySmelter();
    }
}
