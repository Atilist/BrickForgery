package net.alternateadventure.brickforgery.blocks;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class LazyBlockTemplate extends TemplateBlockBase {

    int topTextureInternal;
    int sideTextureInternal;
    int bottomTextureInternal;

    public LazyBlockTemplate(Identifier identifier, Material material, float hardness, BlockSounds blockSounds) {
        super(identifier, material);
        setTranslationKey(identifier.modID, identifier.id);
        setHardness(hardness);
        setSounds(blockSounds);
    }

    @Override
    public LazyBlockTemplate setHardness(float Hardness) {
        return (LazyBlockTemplate) super.setHardness(Hardness);
    }

    public void specifyTextures(int topTexture, int sideTexture, int bottomTexture)
    {
        topTextureInternal = topTexture;
        sideTextureInternal = sideTexture;
        bottomTextureInternal = bottomTexture;
    }

    @Override
    public int getTextureForSide(int i) {
        return i == 0 ? bottomTextureInternal : i == 1 ? topTextureInternal : sideTextureInternal;
    }
}
