package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.items.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    public static TemplateItemBase
            archeologyToolBase,
            archeologyBrush,
            archeologyChisel,
            archeologyIceKnife,

            brickFrame;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        archeologyToolBase = new TemplateItemBase(Identifier.of(MOD_ID, "archeology_tool_base")).setTranslationKey(MOD_ID, "archeology_tool_base");
        archeologyBrush = new ArcheologyBrush(Identifier.of(MOD_ID, "archeology_brush")).setTranslationKey(MOD_ID, "archeology_brush");

        brickFrame = new TemplateItemBase(Identifier.of(MOD_ID, "brick_frame")).setTranslationKey(MOD_ID, "brick_frame");
    }
}
