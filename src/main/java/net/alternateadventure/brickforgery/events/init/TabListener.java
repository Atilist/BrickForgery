package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.tabs.AlloySmeltingTab;
import net.alternateadventure.brickforgery.tabs.MetalworkingTab;
import net.alternateadventure.brickforgery.tabs.SlicingTab;
import net.glasslauncher.hmifabric.event.HMITabRegistryEvent;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.registry.Identifier;

public class TabListener {

    @EventListener
    public void registerTabs(HMITabRegistryEvent event) {
        event.registry.register(Identifier.of(BlockListener.MOD_ID, "alloysmelting"), new AlloySmeltingTab(BlockListener.MOD_ID), new ItemInstance(BlockListener.alloySmelter));
        event.registry.register(Identifier.of(BlockListener.MOD_ID, "slicing"), new SlicingTab(BlockListener.MOD_ID), new ItemInstance(BlockListener.slicer));
        event.registry.register(Identifier.of(BlockListener.MOD_ID, "metalworking"), new MetalworkingTab(BlockListener.MOD_ID), new ItemInstance(BlockListener.metalworkingStation));
    }
}
