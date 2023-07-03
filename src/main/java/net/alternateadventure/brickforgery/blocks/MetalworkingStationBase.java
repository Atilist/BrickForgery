package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.containers.ContainerMetalworkingStation;
import net.alternateadventure.brickforgery.containers.ContainerSlicer;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.events.init.TileEntityListener;
import net.alternateadventure.brickforgery.tileentities.TileEntityMetalworkingStation;
import net.alternateadventure.brickforgery.tileentities.TileEntitySlicer;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.tileentity.TileEntityBase;
import net.modificationstation.stationapi.api.gui.screen.container.GuiHelper;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Random;

public class MetalworkingStationBase extends LazySimpleMachine {
    private Random rand = new Random();
    public int tier;
    public MetalworkingStationBase(Identifier identifier, Material material, float hardness, BlockSounds blockSounds, int tier) {
        super(identifier, material, hardness, blockSounds);
        this.tier = tier;
    }

    @Override
    public boolean canUse(Level world, int x, int y, int z, PlayerBase player) {
        TileEntityBase tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileEntityMetalworkingStation tileEntityMetalworkingStation)
            GuiHelper.openGUI(player, Identifier.of(TileEntityListener.MOD_ID, "gui_metalworking_station"), tileEntityMetalworkingStation, new ContainerMetalworkingStation(player.inventory, tileEntityMetalworkingStation));
        return true;
    }

    @Override
    protected TileEntityBase createTileEntity() {
        return new TileEntityMetalworkingStation();
    }

    public void onBlockRemoved(Level arg, int i, int j, int k) {

        TileEntityMetalworkingStation metalworkingStation = (TileEntityMetalworkingStation) arg.getTileEntity(i, j, k);

        for(int var6 = 0; var6 < metalworkingStation.getInventorySize(); ++var6) {
            ItemInstance var7 = metalworkingStation.getInventoryItem(var6);
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

        super.onBlockRemoved(arg, i, j, k);
    }
}
