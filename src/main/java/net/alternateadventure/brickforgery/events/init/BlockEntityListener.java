package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.blocks.entity.*;
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
        event.register(AlloySmelterBlockEntity.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_alloy_smelter")));
        event.register(SlicerBlockEntity.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_slicer")));
        event.register(MetalworkingStationBlockEntity.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_metalworking_station")));
        event.register(ItemChuteBlockEntity.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_item_chute")));
        event.register(ItemSlideBlockEntity.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_item_slide")));
        event.register(ItemElevatorBlockEntity.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_item_elevator")));
        event.register(ImprovedMillstoneBlockEntity.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_improved_millstone")));
        event.register(CrusherBlockEntity.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_crusher")));
        event.register(WasherBlockEntity.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_washer")));
    }
}
