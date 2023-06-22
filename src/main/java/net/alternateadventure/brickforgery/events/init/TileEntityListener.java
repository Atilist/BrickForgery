package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.guis.GUIAlloySmelter;
import net.alternateadventure.brickforgery.tileentities.TileEntityAlloySmelter;
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
        event.register(TileEntityAlloySmelter.class, Identifier.of(MOD_ID, "tile_entity_alloy_smelter").toString());
    }

    @EventListener
    public void registerGuiHandlers(GuiHandlerRegistryEvent event)
    {
        GuiHandlerRegistry registry = event.registry;
        registry.registerValueNoMessage(Identifier.of(MOD_ID, "gui_alloy_smelter"), BiTuple.of(this::openAlloySmelter, TileEntityAlloySmelter::new));
    }

    public ScreenBase openAlloySmelter(PlayerBase playerBase, InventoryBase inventoryBase)
    {
        return new GUIAlloySmelter(playerBase.inventory, (TileEntityAlloySmelter) inventoryBase);
    }
}