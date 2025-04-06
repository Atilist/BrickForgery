package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.containers.ContainerAlloySmelter;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.BlockEntityListener;
import net.alternateadventure.brickforgery.tileentities.TileEntityAlloySmelter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.gui.screen.container.GuiHelper;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class AlloySmelter extends DirectionalMachineTemplate {

    private Random rand = new Random();
    private final boolean lit;
    private static boolean SETTING_TILE = false;

    public AlloySmelter(Identifier identifier, Material material, float hardness, BlockSounds blockSounds, boolean isLit) {
        super(identifier, material, hardness, blockSounds);
        lit = isLit;
        if (isLit) setLightEmittance(1.0F);
    }

    @Override
    public int getDropId(int i, Random random) {
        return BlockListener.alloySmelter.id;
    }

    @Override
    public boolean canUse(Level world, int x, int y, int z, PlayerBase player) {
        TileEntityBase tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileEntityAlloySmelter tileEntityAlloySmelter)
            GuiHelper.openGUI(player, Identifier.of(BlockEntityListener.MOD_ID, "gui_alloy_smelter"), tileEntityAlloySmelter, new ContainerAlloySmelter(player.inventory, tileEntityAlloySmelter));
        return true;
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(Level level, int x, int y, int z, Random random) {
        if (this.lit) {
            int var6 = level.getTileMeta(x, y, z);
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

    public static void updateAlloySmelterState(boolean bl, World arg, int i, int j, int k) {
        int var5 = arg.getTileMeta(i, j, k);
        TileEntityBase var6 = arg.getTileEntity(i, j, k);
        SETTING_TILE = true;
        if (bl) {
            arg.setTile(i, j, k, BlockListener.alloySmelterActive.id);
        } else {
            arg.setTile(i, j, k, BlockListener.alloySmelter.id);
        }

        SETTING_TILE = false;
        arg.setTileMeta(i, j, k, var5);
        var6.validate();
        arg.setTileEntity(i, j, k, var6);
    }

    public void onBlockRemoved(Level arg, int i, int j, int k) {
        if (!SETTING_TILE) {
            TileEntityAlloySmelter alloySmelter = (TileEntityAlloySmelter)arg.getTileEntity(i, j, k);

            for(int var6 = 0; var6 < alloySmelter.getInventorySize(); ++var6) {
                ItemInstance var7 = alloySmelter.getInventoryItem(var6);
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
                        Item var12 = new Item(arg, (double)((float)i + var8), (double)((float)j + var9), (double)((float)k + var10), new ItemInstance(var7.itemId, var11, var7.getDamage()));
                        float var13 = 0.05F;
                        var12.velocityX = (double)((float)this.rand.nextGaussian() * var13);
                        var12.velocityY = (double)((float)this.rand.nextGaussian() * var13 + 0.2F);
                        var12.velocityZ = (double)((float)this.rand.nextGaussian() * var13);
                        arg.spawnEntity(var12);
                    }
                }
            }
        }

        super.onBlockRemoved(arg, i, j, k);
    }

    @Override
    protected TileEntityBase createTileEntity() {
        return new TileEntityAlloySmelter();
    }
}
