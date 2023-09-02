package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.guis.*;
import net.alternateadventure.brickforgery.tileentities.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.modificationstation.stationapi.api.event.registry.GuiHandlerRegistryEvent;
import net.modificationstation.stationapi.api.event.tileentity.TileEntityRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.GuiHandlerRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;
import uk.co.benjiweber.expressions.tuple.BiTuple;

public class TileEntityListener {

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    private static void registerTileEntities(TileEntityRegisterEvent event)
    {
        event.register(TileEntityAlloySmelter.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_alloy_smelter")));
        event.register(TileEntitySlicer.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_slicer")));
        event.register(TileEntityMetalworkingStation.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_metalworking_station")));
        event.register(TileEntityItemChute.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_item_chute")));
        event.register(TileEntityItemSlide.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_item_slide")));
        event.register(TileEntityItemElevator.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_item_elevator")));
        event.register(TileEntityImprovedMillstone.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_improved_millstone")));
        event.register(TileEntityCrusher.class, String.valueOf(Identifier.of(MOD_ID, "tile_entity_crusher")));
    }

    @EventListener
    public void registerGuiHandlers(GuiHandlerRegistryEvent event)
    {
        GuiHandlerRegistry registry = event.registry;

        registry.registerValueNoMessage(Identifier.of(MOD_ID, "gui_alloy_smelter"), BiTuple.of(this::openAlloySmelter, TileEntityAlloySmelter::new));
        registry.registerValueNoMessage(Identifier.of(MOD_ID, "gui_slicer"), BiTuple.of(this::openSlicer, TileEntitySlicer::new));
        registry.registerValueNoMessage(Identifier.of(MOD_ID, "gui_metalworking_station"), BiTuple.of(this::openMetalworkingStation, TileEntityMetalworkingStation::new));
        registry.registerValueNoMessage(Identifier.of(MOD_ID, "gui_improved_millstone"), BiTuple.of(this::openImprovedMillstone, TileEntityImprovedMillstone::new));
        registry.registerValueNoMessage(Identifier.of(MOD_ID, "gui_crusher"), BiTuple.of(this::openCrusher, TileEntityCrusher::new));
    }

    public ScreenBase openAlloySmelter(PlayerBase playerBase, InventoryBase inventoryBase)
    {
        return new GUIAlloySmelter(playerBase.inventory, (TileEntityAlloySmelter) inventoryBase);
    }

    public ScreenBase openSlicer(PlayerBase playerBase, InventoryBase inventoryBase)
    {
        return new GUISlicer(playerBase.inventory, (TileEntitySlicer) inventoryBase);
    }

    public ScreenBase openMetalworkingStation(PlayerBase playerBase, InventoryBase inventoryBase)
    {
        return new GUIMetalworkingStation(playerBase.inventory, (TileEntityMetalworkingStation) inventoryBase);
    }

    public ScreenBase openImprovedMillstone(PlayerBase playerBase, InventoryBase inventoryBase)
    {
        return new GUIImprovedMillstone(playerBase.inventory, (TileEntityImprovedMillstone) inventoryBase);
    }

    public ScreenBase openCrusher(PlayerBase playerBase, InventoryBase inventoryBase)
    {
        return new GUICrusher(playerBase.inventory, (TileEntityCrusher) inventoryBase);
    }
}
