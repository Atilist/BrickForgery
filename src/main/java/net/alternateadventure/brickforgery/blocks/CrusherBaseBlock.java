package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.containers.CrusherScreenHandler;
import net.alternateadventure.brickforgery.events.init.BlockEntityListener;
import net.alternateadventure.brickforgery.blocks.entity.CrusherBlockEntity;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.kozibrodka.wolves.events.BlockListener;
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

public class CrusherBaseBlock extends LazySimpleMachineBlockTemplate {
    private final Random rand = new Random();
    public TierEnum tier;
    public CrusherBaseBlock(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, TierEnum tier) {
        super(identifier, material, hardness, blockSounds);
        this.tier = tier;
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        BlockEntity tileEntity = world.getBlockEntity(x, y, z);
        if (tileEntity instanceof CrusherBlockEntity crusherBlockEntity)
            GuiHelper.openGUI(player, Identifier.of(BlockEntityListener.MOD_ID, "gui_crusher"), crusherBlockEntity, new CrusherScreenHandler(player.inventory, crusherBlockEntity));
        return true;
    }


    @Override
    protected BlockEntity createBlockEntity() {
        return new CrusherBlockEntity();
    }

    @Override
    public void onBreak(World arg, int i, int j, int k) {

        CrusherBlockEntity crusher = (CrusherBlockEntity) arg.getBlockEntity(i, j, k);

        for(int var6 = 0; var6 < crusher.size(); ++var6) {
            ItemStack var7 = crusher.getStack(var6);
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

        super.onBreak(arg, i, j, k);
    }

    @Override
    public void onPlaced(World level, int x, int y, int z) {
        super.onPlaced(level, x, y, z);
        if (level.getBlockId(x, y - 1, z) == BlockListener.axleBlock.id && level.getBlockMeta(x, y - 1, z) == 3 || level.getBlockId(x, y + 1, z) == BlockListener.axleBlock.id && level.getBlockMeta(x, y + 1, z) == 3) level.setBlockMeta(x, y, z, 1);
    }

    @Override
    public void neighborUpdate(World level, int x, int y, int z, int l) {
        if (level.getBlockId(x, y - 1, z) != BlockListener.axleBlock.id && level.getBlockId(x, y + 1, z) != BlockListener.axleBlock.id && level.getBlockMeta(x, y, z) == 1) level.setBlockMeta(x, y, z, 0);
        else if (level.getBlockMeta(x, y - 1, z) == 3 || level.getBlockMeta(x, y + 1, z) == 3 && level.getBlockMeta(x, y, z) == 0) level.setBlockMeta(x, y, z, 1);
    }

    @Override
    public void randomDisplayTick(World level, int x, int y, int z, Random random) {
        if (level.getBlockMeta(x, y, z) != 1) return;
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
}