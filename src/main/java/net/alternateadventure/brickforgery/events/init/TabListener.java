package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.tabs.*;
import net.glasslauncher.hmifabric.event.HMITabRegistryEvent;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.util.Identifier;

public class TabListener {

    @EventListener
    public void registerTabs(HMITabRegistryEvent event) {
        event.registry.register(Identifier.of(BlockListener.MOD_ID, "alloysmelting"), new AlloySmeltingTab(BlockListener.MOD_ID), new ItemInstance(BlockListener.alloySmelter));
        event.registry.register(Identifier.of(BlockListener.MOD_ID, "slicing"), new SlicingTab(BlockListener.MOD_ID), new ItemInstance(BlockListener.slicer));
        event.registry.register(Identifier.of(BlockListener.MOD_ID, "metalworking"), new MetalworkingTab(BlockListener.MOD_ID), new ItemInstance(BlockListener.metalworkingStation));
        event.registry.register(Identifier.of(BlockListener.MOD_ID, "crushing"), new CrushingTab(BlockListener.MOD_ID), new ItemInstance(BlockListener.primitiveCrusher));
        event.registry.register(Identifier.of(BlockListener.MOD_ID, "washing"), new WashingTab(BlockListener.MOD_ID), new ItemInstance(BlockListener.primitiveWasher));
        event.registry.register(Identifier.of(BlockListener.MOD_ID, "brickframing"), new BrickFramingTab(BlockListener.MOD_ID), new ItemInstance(BlockListener.brickFrameCrafter));
    }
}
