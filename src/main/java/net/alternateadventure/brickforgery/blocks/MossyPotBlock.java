package net.alternateadventure.brickforgery.blocks;

import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.IntProperty;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class MossyPotBlock extends TemplateBlock {

    public static final IntProperty TYPES = IntProperty.of("types", 0, 1);

    public MossyPotBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(TYPES);
    }

    @Override
    public int getDroppedItemId(int i, Random random) {
        return ItemListener.brokenSpikeHolder.id;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 0;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}