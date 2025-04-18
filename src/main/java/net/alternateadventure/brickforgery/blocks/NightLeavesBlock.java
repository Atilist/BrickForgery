package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class NightLeavesBlock extends TemplateBlock {
    int[] field_1171;

    public NightLeavesBlock(Identifier identifier, Material material) {
        super(identifier, material);
        setTickRandomly(true);
    }

    @Override
    public NightLeavesBlock setHardness(float Hardness) {
        return (NightLeavesBlock) super.setHardness(Hardness);
    }

    @Override
    public int getTexture(int i, int j) {
        return TextureListener.NightLeaves;
    }

    @Override
    protected int getDroppedItemMeta(int i) {
        return 0;
    }

    @Override
    public int getDroppedItemId(int i, Random random) {
        return BlockListener.nightSapling.id;
    }

    @Override
    public int getDroppedItemCount(Random random) {
        return random.nextInt(20) == 0 ? 1 : 0;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void onBreak(World arg, int i, int j, int k) {
        byte var5 = 1;
        int var6 = var5 + 1;
        if (arg.isRegionLoaded(i - var6, j - var6, k - var6, i + var6, j + var6, k + var6)) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
                for(int var8 = -var5; var8 <= var5; ++var8) {
                    for(int var9 = -var5; var9 <= var5; ++var9) {
                        int var10 = arg.getBlockId(i + var7, j + var8, k + var9);
                        if (var10 == BlockListener.nightLeaves.id) {
                            int var11 = arg.getBlockMeta(i + var7, j + var8, k + var9);
                            arg.setBlockMetaWithoutNotifyingNeighbors(i + var7, j + var8, k + var9, var11 | 8);
                        }
                    }
                }
            }
        }

    }

    @Override
    public void onTick(World arg, int i, int j, int k, Random random) {
        if (!arg.isRemote) {
            int var6 = arg.getBlockMeta(i, j, k);
            if ((var6 & 8) != 0) {
                byte var7 = 4;
                int var8 = var7 + 1;
                byte var9 = 32;
                int var10 = var9 * var9;
                int var11 = var9 / 2;
                if (this.field_1171 == null) {
                    this.field_1171 = new int[var9 * var9 * var9];
                }
                int var12;
                if (arg.isRegionLoaded(i - var8, j - var8, k - var8, i + var8, j + var8, k + var8)) {
                    var12 = -var7;
                    label111:
                    while(true) {
                        int var13;
                        int var14;
                        int var15;
                        if (var12 > var7) {
                            var12 = 1;
                            while(true) {
                                if (var12 > 4) {
                                    break label111;
                                }
                                for(var13 = -var7; var13 <= var7; ++var13) {
                                    for(var14 = -var7; var14 <= var7; ++var14) {
                                        for(var15 = -var7; var15 <= var7; ++var15) {
                                            if (this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1) {
                                                if (this.field_1171[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.field_1171[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.field_1171[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2) {
                                                    this.field_1171[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2) {
                                                    this.field_1171[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2) {
                                                    this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2) {
                                                    this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
                                                }
                                            }
                                        }
                                    }
                                }
                                ++var12;
                            }
                        }
                        for(var13 = -var7; var13 <= var7; ++var13) {
                            for(var14 = -var7; var14 <= var7; ++var14) {
                                var15 = arg.getBlockId(i + var12, j + var13, k + var14);
                                if (var15 == BlockListener.nightLog.id) {
                                    this.field_1171[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                                } else if (var15 == BlockListener.nightLeaves.id) {
                                    this.field_1171[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                                } else {
                                    this.field_1171[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                                }
                            }
                        }
                        ++var12;
                    }
                }
                var12 = this.field_1171[var11 * var10 + var11 * var9 + var11];
                if (var12 >= 0) {
                    arg.setBlockMetaWithoutNotifyingNeighbors(i, j, k, var6 & -9);
                } else {
                    this.dropAndRemove(arg, i, j, k);
                }
            }
        }
    }

    private void dropAndRemove(World arg, int i, int j, int k) {
        this.dropStacks(arg, i, j, k, arg.getBlockMeta(i, j, k));
        arg.setBlock(i, j, k, 0);
    }
}
