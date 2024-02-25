package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.items.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemBase;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {

    @Entrypoint.Namespace
    public static final Namespace MOD_ID = Null.get();

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
            clayPowder;

    public static LazyItemTemplate
            denseNightWood,
            glueMixture,

            fortunePowder,
            concentratedFortune,

            exoticKey,
            desertKey,
            iceKey,

            desertPotItem,
            frozenPotItem,

            primitiveBrush,
            primitiveChisel,
            primitiveGrabber,

            groundSandstone,
            illuminantCrystal,

            ironOreCrushed,
            ironOreWashed,
            ironOrePowdered,
            ironOrePurified,

            goldOreCrushed,
            goldOreWashed,
            goldOrePowdered,
            goldOrePurified,

            thermalPowder,
            concentratedThermal,
            thermalGlass,

            cryogenicPowder,
            concentratedCryogenic,

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
            diamondOreBrick,

            largeBrickRaw,
            largeBrick;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        exoticFruit = new TemplateItem(Identifier.of(MOD_ID, "exotic_fruit")).setTranslationKey(MOD_ID, "exotic_fruit");
        nightSeeds = new NightSeeds(Identifier.of(MOD_ID, "night_seeds")).setTranslationKey(MOD_ID, "night_seeds");
        nightWheat = new TemplateItem(Identifier.of(MOD_ID, "night_wheat")).setTranslationKey(MOD_ID, "night_wheat");
        fernItem = new FernItem(Identifier.of(MOD_ID, "fern_item"));

        denseNightWood = new LazyItemTemplate(Identifier.of(MOD_ID, "dense_night_wood"));
        glueMixture = new LazyItemTemplate(Identifier.of(MOD_ID, "glue_mixture"));

        fortunePowder = new LazyItemTemplate(Identifier.of(MOD_ID, "fortune_powder"));
        concentratedFortune = new LazyItemTemplate(Identifier.of(MOD_ID, "concentrated_fortune"));

        exoticKey = new ExoticKey(Identifier.of(MOD_ID, "exotic_key"));
        desertKey = new DesertKey(Identifier.of(MOD_ID, "desert_key"));
        iceKey = new IceKey(Identifier.of(MOD_ID, "ice_key"));

        desertPotItem = new DesertPotItem(Identifier.of(MOD_ID, "desert_pot_item"));
        frozenPotItem = new FrozenPotItem(Identifier.of(MOD_ID, "frozen_pot_item"));

        primitiveBrush = new PrimitiveBrush(Identifier.of(MOD_ID, "primitive_brush"));
        primitiveChisel = new PrimitiveChisel(Identifier.of(MOD_ID, "primitive_chisel"));
        primitiveGrabber = new PrimitiveGrabber(Identifier.of(MOD_ID, "primitive_grabber"));

        groundSandstone = new LazyItemTemplate(Identifier.of(MOD_ID, "ground_sandstone"));
        illuminantCrystal = new LazyItemTemplate(Identifier.of(MOD_ID, "illuminant_crystal"));

        ironOreCrushed = new LazyItemTemplate(Identifier.of(MOD_ID, "iron_ore_crushed"));
        ironOreWashed = new LazyItemTemplate(Identifier.of(MOD_ID, "iron_ore_washed"));
        ironOrePowdered = new LazyItemTemplate(Identifier.of(MOD_ID, "iron_ore_powdered"));
        ironOrePurified = new LazyItemTemplate(Identifier.of(MOD_ID, "iron_ore_purified"));

        goldOreCrushed = new LazyItemTemplate(Identifier.of(MOD_ID, "gold_ore_crushed"));
        goldOreWashed = new LazyItemTemplate(Identifier.of(MOD_ID, "gold_ore_washed"));
        goldOrePowdered = new LazyItemTemplate(Identifier.of(MOD_ID, "gold_ore_powdered"));
        goldOrePurified = new LazyItemTemplate(Identifier.of(MOD_ID, "gold_ore_purified"));

        thermalPowder = new LazyItemTemplate(Identifier.of(MOD_ID, "thermal_powder"));
        concentratedThermal = new LazyItemTemplate(Identifier.of(MOD_ID, "concentrated_thermal"));
        thermalGlass = new LazyItemTemplate(Identifier.of(MOD_ID, "thermal_glass"));

        cryogenicPowder = new LazyItemTemplate(Identifier.of(MOD_ID, "cryogenic_powder"));
        concentratedCryogenic = new LazyItemTemplate(Identifier.of(MOD_ID, "concentrated_cryogenic"));

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

        archeologyToolBase = new TemplateItem(Identifier.of(MOD_ID, "archeology_tool_base")).setTranslationKey(MOD_ID, "archeology_tool_base");
        iceBlade = new TemplateItem(Identifier.of(MOD_ID, "ice_blade")).setTranslationKey(MOD_ID, "ice_blade");
        brokenSpikeHolder = new TemplateItem(Identifier.of(MOD_ID, "broken_spike_holder")).setTranslationKey(MOD_ID, "broken_spike_holder");

        brickFrame = new TemplateItem(Identifier.of(MOD_ID, "brick_frame")).setTranslationKey(MOD_ID, "brick_frame");
        dryBrickFrame = new TemplateItem(Identifier.of(MOD_ID, "dry_brick_frame")).setTranslationKey(MOD_ID, "dry_brick_frame");

        woodenBrick = new TemplateItem(Identifier.of(MOD_ID, "wooden_brick")).setTranslationKey(MOD_ID, "wooden_brick");
        brickAsh = new TemplateItem(Identifier.of(MOD_ID, "brick_ash")).setTranslationKey(MOD_ID, "brick_ash");
        stoneBrick = new TemplateItem(Identifier.of(MOD_ID, "stone_brick")).setTranslationKey(MOD_ID, "stone_brick");
        snowBrick = new TemplateItem(Identifier.of(MOD_ID, "snow_brick")).setTranslationKey(MOD_ID, "snow_brick");
        frozenBrick = new TemplateItem(Identifier.of(MOD_ID, "frozen_brick")).setTranslationKey(MOD_ID, "frozen_brick");

        brickSeedlings = new BrickSeedlings(Identifier.of(MOD_ID, "brick_seedlings")).setTranslationKey(MOD_ID, "brick_seedlings");
        brickCatalyst = new BrickCatalyst(Identifier.of(MOD_ID, "brick_catalyst")).setTranslationKey(MOD_ID, "brick_catalyst");
        clayPowder = new TemplateItem(Identifier.of(MOD_ID, "clay_powder")).setTranslationKey(MOD_ID, "clay_powder");

        exoticCatalyst = new ExoticCatalyst(Identifier.of(MOD_ID, "exotic_catalyst"));

        coalOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "coal_ore_brick"));
        ironOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "iron_ore_brick"));
        goldOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "gold_ore_brick"));
        redstoneOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "redstone_ore_brick"));
        diamondOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "diamond_ore_brick"));

        largeBrickRaw = new LazyItemTemplate(Identifier.of(MOD_ID, "large_brick_raw"));
        largeBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "large_brick"));
    }
}
