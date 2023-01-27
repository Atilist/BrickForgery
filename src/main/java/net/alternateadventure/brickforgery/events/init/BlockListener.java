package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.blocks.DesertPot;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    public static BlockBase desertPot;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        desertPot = new DesertPot(Identifier.of(MOD_ID, "DesertPot"), Material.STONE).setHardness(1.0F).setTranslationKey("desert_pot");
    }
}
