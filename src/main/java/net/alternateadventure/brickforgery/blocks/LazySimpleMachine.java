package net.alternateadventure.brickforgery.blocks;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntityBase;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;

public class LazySimpleMachine extends TemplateBlockWithEntity {

    int topTextureInternal;
    int sideTextureInternal;
    int bottomTextureInternal;

    public LazySimpleMachine(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material);
        setTranslationKey(identifier.namespace, identifier.path);
        setHardness(hardness);
        setSounds(blockSounds);
    }

    public void specifyTextures(int topTexture, int sideTexture, int bottomTexture)
    {
        topTextureInternal = topTexture;
        sideTextureInternal = sideTexture;
        bottomTextureInternal = bottomTexture;
    }

    public void specifyTextures(int universalTexture)
    {
        topTextureInternal = universalTexture;
        sideTextureInternal = universalTexture;
        bottomTextureInternal = universalTexture;
    }

    @Override
    public int getTextureForSide(int i, int j) {
        return i == 0 ? bottomTextureInternal : i == 1 ? topTextureInternal : sideTextureInternal;
    }

    @Override
    protected TileEntityBase createTileEntity() {
        return null;
    }
}
