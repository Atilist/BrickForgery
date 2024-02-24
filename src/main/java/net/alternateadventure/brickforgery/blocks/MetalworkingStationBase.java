package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.containers.ContainerMetalworkingStation;
import net.alternateadventure.brickforgery.events.init.BlockEntityListener;
import net.alternateadventure.brickforgery.tileentities.TileEntityMetalworkingStation;
import net.kozibrodka.wolves.events.BlockListener;
import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.tileentity.TileEntityBase;
import net.modificationstation.stationapi.api.gui.screen.container.GuiHelper;
import net.modificationstation.stationapi.api.util.Identifier;

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
            GuiHelper.openGUI(player, Identifier.of(BlockEntityListener.MOD_ID, "gui_metalworking_station"), tileEntityMetalworkingStation, new ContainerMetalworkingStation(player.inventory, tileEntityMetalworkingStation));
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

    @Override
    public void onBlockPlaced(Level level, int x, int y, int z) {
        super.onBlockPlaced(level, x, y, z);
        if (level.getTileId(x, y - 1, z) == BlockListener.axleBlock.id && level.getTileMeta(x, y - 1, z) == 3) level.setTileMeta(x, y, z, 1);
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int l) {
        if (level.getTileId(x, y - 1, z) != BlockListener.axleBlock.id) return;
        if (level.getTileMeta(x, y - 1, z) == 3) level.setTileMeta(x, y, z, 1);
        else level.setTileMeta(x, y, z, 0);
    }

    @Override
    public void randomDisplayTick(Level level, int x, int y, int z, Random random) {
        if (level.getTileMeta(x, y, z) != 1) return;
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
}
