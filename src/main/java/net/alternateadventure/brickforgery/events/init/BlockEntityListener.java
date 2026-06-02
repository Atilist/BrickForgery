package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.block.entity.AlloySmelterBlockEntity;
import net.alternateadventure.brickforgery.block.entity.BrickForgeBlockEntity;
import net.alternateadventure.brickforgery.block.entity.CrusherBlockEntity;
import net.alternateadventure.brickforgery.block.entity.ImprovedMillstoneBlockEntity;
import net.alternateadventure.brickforgery.block.entity.MetalworkingStationBlockEntity;
import net.alternateadventure.brickforgery.block.entity.SlicerBlockEntity;
import net.alternateadventure.brickforgery.block.entity.WasherBlockEntity;
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
        event.register(String.valueOf(Identifier.of(MOD_ID, "tile_entity_alloy_smelter")), AlloySmelterBlockEntity.class);
        event.register(String.valueOf(Identifier.of(MOD_ID, "tile_entity_slicer")), SlicerBlockEntity.class);
        event.register(String.valueOf(Identifier.of(MOD_ID, "tile_entity_metalworking_station")), MetalworkingStationBlockEntity.class);
        event.register(String.valueOf(Identifier.of(MOD_ID, "tile_entity_improved_millstone")), ImprovedMillstoneBlockEntity.class);
        event.register(String.valueOf(Identifier.of(MOD_ID, "tile_entity_crusher")), CrusherBlockEntity.class);
        event.register(String.valueOf(Identifier.of(MOD_ID, "tile_entity_washer")), WasherBlockEntity.class);
        event.register(String.valueOf(Identifier.of(MOD_ID, "tile_entity_brick_forge")), BrickForgeBlockEntity.class);
    }
}
