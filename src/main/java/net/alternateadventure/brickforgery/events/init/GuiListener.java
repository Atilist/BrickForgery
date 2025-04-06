package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.guis.*;
import net.alternateadventure.brickforgery.tileentities.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.modificationstation.stationapi.api.client.gui.screen.GuiHandler;
import net.modificationstation.stationapi.api.client.registry.GuiHandlerRegistry;
import net.modificationstation.stationapi.api.event.registry.GuiHandlerRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Registry;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;

public class GuiListener {

    @Entrypoint.Namespace
    public static Namespace MOD_ID;

    @EventListener
    public void registerGuiHandlers(GuiHandlerRegistryEvent event) {
        GuiHandlerRegistry registry = event.registry;

        Registry.register(registry, Identifier.of(MOD_ID, "gui_alloy_smelter"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openAlloySmelter, TileEntityAlloySmelter::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_slicer"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openSlicer, TileEntitySlicer::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_metalworking_station"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openMetalworkingStation, TileEntityMetalworkingStation::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_improved_millstone"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openImprovedMillstone, TileEntityImprovedMillstone::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_crusher"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openCrusher, TileEntityCrusher::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_washer"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openWasher, TileEntityWasher::new));
    }

    public Screen openAlloySmelter(PlayerEntity playerBase, Inventory inventoryBase) {
        return new GUIAlloySmelter(playerBase.inventory, (TileEntityAlloySmelter) inventoryBase);
    }

    public Screen openSlicer(PlayerEntity playerBase, Inventory inventoryBase) {
        return new GUISlicer(playerBase.inventory, (TileEntitySlicer) inventoryBase);
    }

    public Screen openMetalworkingStation(PlayerEntity playerBase, Inventory inventoryBase) {
        return new GUIMetalworkingStation(playerBase.inventory, (TileEntityMetalworkingStation) inventoryBase);
    }

    public Screen openImprovedMillstone(PlayerEntity playerBase, Inventory inventoryBase) {
        return new GUIImprovedMillstone(playerBase.inventory, (TileEntityImprovedMillstone) inventoryBase);
    }

    public Screen openCrusher(PlayerEntity playerBase, Inventory inventoryBase) {
        return new GUICrusher(playerBase.inventory, (TileEntityCrusher) inventoryBase);
    }

    public Screen openWasher(PlayerEntity playerBase, Inventory inventoryBase) {
        return new GUIWasher(playerBase.inventory, (TileEntityWasher) inventoryBase);
    }
}
