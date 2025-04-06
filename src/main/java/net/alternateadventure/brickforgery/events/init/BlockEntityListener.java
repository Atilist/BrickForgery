package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.tileentities.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.block.entity.BlockEntityRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;

public class BlockEntityListener {

    @Entrypoint.Namespace
    public static Namespace MOD_ID;

    @EventListener
    public static void registerBlockEntities(BlockEntityRegisterEvent event) {
        event.register(TileEntityAlloySmelter.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_alloy_smelter")));
        event.register(TileEntitySlicer.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_slicer")));
        event.register(TileEntityMetalworkingStation.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_metalworking_station")));
        event.register(TileEntityItemChute.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_item_chute")));
        event.register(TileEntityItemSlide.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_item_slide")));
        event.register(TileEntityItemElevator.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_item_elevator")));
        event.register(TileEntityImprovedMillstone.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_improved_millstone")));
        event.register(TileEntityCrusher.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_crusher")));
        event.register(TileEntityWasher.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_washer")));
    }
}
