package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.blocks.entity.AlloySmelterBlockEntity;
import net.alternateadventure.brickforgery.blocks.entity.BrickForgeBlockEntity;
import net.alternateadventure.brickforgery.blocks.entity.CrusherBlockEntity;
import net.alternateadventure.brickforgery.blocks.entity.ImprovedMillstoneBlockEntity;
import net.alternateadventure.brickforgery.blocks.entity.MetalworkingStationBlockEntity;
import net.alternateadventure.brickforgery.blocks.entity.SlicerBlockEntity;
import net.alternateadventure.brickforgery.blocks.entity.WasherBlockEntity;
import net.alternateadventure.brickforgery.guis.AlloySmelterScreen;
import net.alternateadventure.brickforgery.guis.BrickForgeScreen;
import net.alternateadventure.brickforgery.guis.CrusherScreen;
import net.alternateadventure.brickforgery.guis.ImprovedMillstoneScreen;
import net.alternateadventure.brickforgery.guis.MetalworkingStationScreen;
import net.alternateadventure.brickforgery.guis.SlicerScreen;
import net.alternateadventure.brickforgery.guis.WasherScreen;
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

        Registry.register(registry, Identifier.of(MOD_ID, "gui_alloy_smelter"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openAlloySmelter, AlloySmelterBlockEntity::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_slicer"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openSlicer, SlicerBlockEntity::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_metalworking_station"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openMetalworkingStation, MetalworkingStationBlockEntity::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_improved_millstone"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openImprovedMillstone, ImprovedMillstoneBlockEntity::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_crusher"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openCrusher, CrusherBlockEntity::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_washer"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openWasher, WasherBlockEntity::new));
        Registry.register(registry, Identifier.of(MOD_ID, "gui_brick_forge"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openBrickForge, BrickForgeBlockEntity::new));
    }

    public Screen openAlloySmelter(PlayerEntity playerBase, Inventory inventoryBase) {
        return new AlloySmelterScreen(playerBase.inventory, (AlloySmelterBlockEntity) inventoryBase);
    }

    public Screen openSlicer(PlayerEntity playerBase, Inventory inventoryBase) {
        return new SlicerScreen(playerBase.inventory, (SlicerBlockEntity) inventoryBase);
    }

    public Screen openMetalworkingStation(PlayerEntity playerBase, Inventory inventoryBase) {
        return new MetalworkingStationScreen(playerBase.inventory, (MetalworkingStationBlockEntity) inventoryBase);
    }

    public Screen openImprovedMillstone(PlayerEntity playerBase, Inventory inventoryBase) {
        return new ImprovedMillstoneScreen(playerBase.inventory, (ImprovedMillstoneBlockEntity) inventoryBase);
    }

    public Screen openCrusher(PlayerEntity playerBase, Inventory inventoryBase) {
        return new CrusherScreen(playerBase.inventory, (CrusherBlockEntity) inventoryBase);
    }

    public Screen openWasher(PlayerEntity playerBase, Inventory inventoryBase) {
        return new WasherScreen(playerBase.inventory, (WasherBlockEntity) inventoryBase);
    }

    public Screen openBrickForge(PlayerEntity playerBase, Inventory inventoryBase) {
        return new BrickForgeScreen(playerBase.inventory, (BrickForgeBlockEntity) inventoryBase);
    }
}
