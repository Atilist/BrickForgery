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
            archeologyBrush,
            archeologyChisel,
            archeologyIceKnife,

            archeologyToolBase,
            iceBlade,

            brickFrame,
            dryBrickFrame,

            woodenBrick,
            brickAsh,

            brickSeedlings,
            brickCatalyst,

            brickHammer;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        archeologyBrush = new ArcheologyBrush(Identifier.of(MOD_ID, "archeology_brush")).setTranslationKey(MOD_ID, "archeology_brush");
        archeologyChisel = new ArcheologyChisel(Identifier.of(MOD_ID, "archeology_chisel")).setTranslationKey(MOD_ID, "archeology_chisel");
        archeologyIceKnife = new ArcheologyIceKnife(Identifier.of(MOD_ID, "archeology_ice_knife")).setTranslationKey(MOD_ID, "archeology_ice_knife");

        archeologyToolBase = new TemplateItemBase(Identifier.of(MOD_ID, "archeology_tool_base")).setTranslationKey(MOD_ID, "archeology_tool_base");
        iceBlade = new TemplateItemBase(Identifier.of(MOD_ID, "ice_blade")).setTranslationKey(MOD_ID, "ice_blade");

        brickFrame = new TemplateItemBase(Identifier.of(MOD_ID, "brick_frame")).setTranslationKey(MOD_ID, "brick_frame");
        dryBrickFrame = new TemplateItemBase(Identifier.of(MOD_ID, "dry_brick_frame")).setTranslationKey(MOD_ID, "dry_brick_frame");

        woodenBrick = new TemplateItemBase(Identifier.of(MOD_ID, "wooden_brick")).setTranslationKey(MOD_ID, "wooden_brick");
        brickAsh = new TemplateItemBase(Identifier.of(MOD_ID, "brick_ash")).setTranslationKey(MOD_ID, "brick_ash");

        brickSeedlings = new BrickSeedlings(Identifier.of(MOD_ID, "brick_seedlings")).setTranslationKey(MOD_ID, "brick_seedlings");
        brickCatalyst = new TemplateItemBase(Identifier.of(MOD_ID, "brick_catalyst")).setTranslationKey(MOD_ID, "brick_catalyst");

        brickHammer = new BrickHammer(Identifier.of(MOD_ID, "brick_hammer")).setTranslationKey(MOD_ID, "brick_hammer");
    }
}
