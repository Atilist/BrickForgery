package net.alternateadventure.brickforgery.blocks;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Living;
import net.minecraft.level.Level;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.maths.MathHelper;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;

public class DirectionalMachineTemplate extends TemplateBlockWithEntity {

    int topTextureInternal;
    int sideTextureInternal;
    int bottomTextureInternal;
    int frontTextureInternal;
    int backTextureInternal;

    public DirectionalMachineTemplate(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material);
        setTranslationKey(identifier.namespace, identifier.path);
        setHardness(hardness);
        setSounds(blockSounds);
    }

    public void specifyTextures(int topTexture, int sideTexture, int bottomTexture, int frontTexture, int backTexture)
    {
        topTextureInternal = topTexture;
        sideTextureInternal = sideTexture;
        bottomTextureInternal = bottomTexture;
        frontTextureInternal = frontTexture;
        backTextureInternal = backTexture;
    }

    public void specifyTextures(int topTexture, int sideTexture, int bottomTexture, int frontTexture)
    {
        topTextureInternal = topTexture;
        sideTextureInternal = sideTexture;
        bottomTextureInternal = bottomTexture;
        frontTextureInternal = frontTexture;
        backTextureInternal = sideTexture;
    }

    @Override
    public int getTextureForSide(int i, int j) {
        if (i == 0) return bottomTextureInternal;
        if (i == 1) return topTextureInternal;
        if (i == 2 && j % 4 == 0) return frontTextureInternal;
        if (i == 3 && j % 4 == 2) return frontTextureInternal;
        if (i == 4 && j % 4 == 3) return frontTextureInternal;
        if (i == 5 && j % 4 == 1) return frontTextureInternal;
        if (i == 2 && j % 4 == 2) return backTextureInternal;
        if (i == 3 && j % 4 == 0) return backTextureInternal;
        if (i == 4 && j % 4 == 1) return backTextureInternal;
        if (i == 5 && j % 4 == 3) return backTextureInternal;
        return sideTextureInternal;
    }

    public void afterPlaced(Level level, int x, int y, int z, Living living) {
        int facing = MathHelper.floor((double)(living.yaw * 4.0F / 360.0F) + 0.5D) & 3;
        level.setTileMeta(x, y, z, facing);
    }

    @Override
    protected TileEntityBase createTileEntity() {
        return null;
    }
}
