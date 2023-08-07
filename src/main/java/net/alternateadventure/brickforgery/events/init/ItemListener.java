package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.items.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemBase;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    public static ItemBase
            exoticFruit,
            nightSeeds,
            nightWheat,

            archeologyBrush,
            archeologyChisel,
            archeologyIceKnife,

            archeologyToolBase,
            iceBlade,
            brokenSpikeHolder,

            brickFrame,
            dryBrickFrame,

            woodenBrick,
            brickAsh,
            stoneBrick,
            snowBrick,
            frozenBrick,

            brickSeedlings,
            brickCatalyst,
            clayPowder,

            brickHammer;

    public static LazyItemTemplate
            denseNightWood,

            fortunePowder,
            concentratedFortune,

            exoticKey,
            desertKey,

            desertPotItem,
            frozenPotItem,

            primitiveBrush,
            primitiveChisel,
            primitiveGrabber,

            groundSandstone,
            illuminantCrystal,

            thermalPowder,
            concentratedThermal,
            thermalGlass,

            durableLeather,
            brickSteelIngot,
            bricksidianIngot,

            leatherStrap,
            goldenScrew,
            durableLeatherStrap,
            bricksidianScrew,
            brickSteelPlate,

            nightWoodBeam,
            brickSteelBeam,

            woodenFrame,
            hardenedBrickFrame,
            reinforcedBrickFrame,

            toolRepairKit,

            fernItem,
            exoticCatalyst,

            coalOreBrick,
            ironOreBrick,
            goldOreBrick,
            redstoneOreBrick,
            diamondOreBrick;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        exoticFruit = new TemplateItemBase(Identifier.of(MOD_ID, "exotic_fruit")).setTranslationKey(MOD_ID, "exotic_fruit");
        nightSeeds = new NightSeeds(Identifier.of(MOD_ID, "night_seeds")).setTranslationKey(MOD_ID, "night_seeds");
        nightWheat = new TemplateItemBase(Identifier.of(MOD_ID, "night_wheat")).setTranslationKey(MOD_ID, "night_wheat");
        fernItem = new FernItem(Identifier.of(MOD_ID, "fern_item"));

        denseNightWood = new LazyItemTemplate(Identifier.of(MOD_ID, "dense_night_wood"));

        fortunePowder = new LazyItemTemplate(Identifier.of(MOD_ID, "fortune_powder"));
        concentratedFortune = new LazyItemTemplate(Identifier.of(MOD_ID, "concentrated_fortune"));

        exoticKey = new ExoticKey(Identifier.of(MOD_ID, "exotic_key"));
        desertKey = new DesertKey(Identifier.of(MOD_ID, "desert_key"));

        desertPotItem = new DesertPotItem(Identifier.of(MOD_ID, "desert_pot_item"));
        frozenPotItem = new FrozenPotItem(Identifier.of(MOD_ID, "frozen_pot_item"));

        primitiveBrush = new PrimitiveBrush(Identifier.of(MOD_ID, "primitive_brush"));
        primitiveChisel = new PrimitiveChisel(Identifier.of(MOD_ID, "primitive_chisel"));
        primitiveGrabber = new PrimitiveGrabber(Identifier.of(MOD_ID, "primitive_grabber"));

        groundSandstone = new LazyItemTemplate(Identifier.of(MOD_ID, "ground_sandstone"));
        illuminantCrystal = new LazyItemTemplate(Identifier.of(MOD_ID, "illuminant_crystal"));

        thermalPowder = new LazyItemTemplate(Identifier.of(MOD_ID, "thermal_powder"));
        concentratedThermal = new LazyItemTemplate(Identifier.of(MOD_ID, "concentrated_thermal"));
        thermalGlass = new LazyItemTemplate(Identifier.of(MOD_ID, "thermal_glass"));

        durableLeather = new LazyItemTemplate(Identifier.of(MOD_ID, "durable_leather"));
        brickSteelIngot = new LazyItemTemplate(Identifier.of(MOD_ID, "brick_steel_ingot"));
        bricksidianIngot = new LazyItemTemplate(Identifier.of(MOD_ID, "bricksidian_ingot"));

        leatherStrap = new LazyItemTemplate(Identifier.of(MOD_ID, "leather_strap"));
        goldenScrew = new LazyItemTemplate(Identifier.of(MOD_ID, "golden_screw"));
        durableLeatherStrap = new LazyItemTemplate(Identifier.of(MOD_ID, "durable_leather_strap"));
        bricksidianScrew = new LazyItemTemplate(Identifier.of(MOD_ID, "bricksidian_screw"));
        brickSteelPlate = new LazyItemTemplate(Identifier.of(MOD_ID, "brick_steel_plate"));

        nightWoodBeam = new LazyItemTemplate(Identifier.of(MOD_ID, "night_wood_beam"));
        brickSteelBeam = new LazyItemTemplate(Identifier.of(MOD_ID, "brick_steel_beam"));

        woodenFrame = new LazyItemTemplate(Identifier.of(MOD_ID, "wooden_frame"));
        hardenedBrickFrame = new LazyItemTemplate(Identifier.of(MOD_ID, "hardened_brick_frame"));
        reinforcedBrickFrame = new LazyItemTemplate(Identifier.of(MOD_ID, "reinforced_brick_frame"));

        toolRepairKit = new LazyItemTemplate(Identifier.of(MOD_ID, "tool_repair_kit"));

        archeologyBrush = new ArcheologyBrush(Identifier.of(MOD_ID, "archeology_brush")).setTranslationKey(MOD_ID, "archeology_brush");
        archeologyChisel = new ArcheologyChisel(Identifier.of(MOD_ID, "archeology_chisel")).setTranslationKey(MOD_ID, "archeology_chisel");
        archeologyIceKnife = new ArcheologyIceKnife(Identifier.of(MOD_ID, "archeology_ice_knife")).setTranslationKey(MOD_ID, "archeology_ice_knife");

        archeologyToolBase = new TemplateItemBase(Identifier.of(MOD_ID, "archeology_tool_base")).setTranslationKey(MOD_ID, "archeology_tool_base");
        iceBlade = new TemplateItemBase(Identifier.of(MOD_ID, "ice_blade")).setTranslationKey(MOD_ID, "ice_blade");
        brokenSpikeHolder = new TemplateItemBase(Identifier.of(MOD_ID, "broken_spike_holder")).setTranslationKey(MOD_ID, "broken_spike_holder");

        brickFrame = new TemplateItemBase(Identifier.of(MOD_ID, "brick_frame")).setTranslationKey(MOD_ID, "brick_frame");
        dryBrickFrame = new TemplateItemBase(Identifier.of(MOD_ID, "dry_brick_frame")).setTranslationKey(MOD_ID, "dry_brick_frame");

        woodenBrick = new TemplateItemBase(Identifier.of(MOD_ID, "wooden_brick")).setTranslationKey(MOD_ID, "wooden_brick");
        brickAsh = new TemplateItemBase(Identifier.of(MOD_ID, "brick_ash")).setTranslationKey(MOD_ID, "brick_ash");
        stoneBrick = new TemplateItemBase(Identifier.of(MOD_ID, "stone_brick")).setTranslationKey(MOD_ID, "stone_brick");
        snowBrick = new TemplateItemBase(Identifier.of(MOD_ID, "snow_brick")).setTranslationKey(MOD_ID, "snow_brick");
        frozenBrick = new TemplateItemBase(Identifier.of(MOD_ID, "frozen_brick")).setTranslationKey(MOD_ID, "frozen_brick");

        brickSeedlings = new BrickSeedlings(Identifier.of(MOD_ID, "brick_seedlings")).setTranslationKey(MOD_ID, "brick_seedlings");
        brickCatalyst = new BrickCatalyst(Identifier.of(MOD_ID, "brick_catalyst")).setTranslationKey(MOD_ID, "brick_catalyst");
        clayPowder = new TemplateItemBase(Identifier.of(MOD_ID, "clay_powder")).setTranslationKey(MOD_ID, "clay_powder");

        brickHammer = new BrickHammer(Identifier.of(MOD_ID, "brick_hammer")).setTranslationKey(MOD_ID, "brick_hammer");
        exoticCatalyst = new ExoticCatalyst(Identifier.of(MOD_ID, "exotic_catalyst"));

        coalOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "coal_ore_brick"));
        ironOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "iron_ore_brick"));
        goldOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "gold_ore_brick"));
        redstoneOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "redstone_ore_brick"));
        diamondOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "diamond_ore_brick"));

    }
}
