package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.items.*;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;

public class ItemListener {

    @Entrypoint.Namespace
    public static Namespace MOD_ID;

    public static Item
            exoticFruit,
            nightSeeds,
            nightWheat,

            archaeologyIceKnife,

            archaeologyToolBase,
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
            dirtBrick,
            sugarCaneStick,

            dirtBrickSand,
            sandBrick,

            denseNightWood,
            glueMixture,

            fortunePowder,
            concentratedFortune,

            exoticKey,
            desertKey,
            iceKey,

            primitiveBrush,
            primitiveChisel,
            primitiveGrabber,

            archaeologyBrush,
            archaeologyChisel,

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

            sugarCaneFrame,
            cactusFrame,
            flintFrame,
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
        dirtBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "dirt_brick"));
        sugarCaneStick = new LazyItemTemplate(Identifier.of(MOD_ID, "sugar_cane_stick"));

        dirtBrickSand = new DirtBrickSandItem(Identifier.of(MOD_ID, "dirt_brick_sand"));
        sandBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "sand_brick"));

        exoticFruit = new TemplateItem(Identifier.of(MOD_ID, "exotic_fruit")).setTranslationKey(MOD_ID, "exotic_fruit");
        nightSeeds = new NightSeedsItem(Identifier.of(MOD_ID, "night_seeds")).setTranslationKey(MOD_ID, "night_seeds");
        nightWheat = new TemplateItem(Identifier.of(MOD_ID, "night_wheat")).setTranslationKey(MOD_ID, "night_wheat");
        fernItem = new FernItem(Identifier.of(MOD_ID, "fern_item"));

        denseNightWood = new LazyItemTemplate(Identifier.of(MOD_ID, "dense_night_wood"));
        glueMixture = new LazyItemTemplate(Identifier.of(MOD_ID, "glue_mixture"));

        fortunePowder = new LazyItemTemplate(Identifier.of(MOD_ID, "fortune_powder"));
        concentratedFortune = new LazyItemTemplate(Identifier.of(MOD_ID, "concentrated_fortune"));

        exoticKey = new ExoticKeyItem(Identifier.of(MOD_ID, "exotic_key"));
        desertKey = new DesertKeyItem(Identifier.of(MOD_ID, "desert_key"));
        iceKey = new IceKeyItem(Identifier.of(MOD_ID, "ice_key"));

        primitiveBrush = new BrushToolTemplate(Identifier.of(MOD_ID, "primitive_brush"), 256, TierEnum.PRIMITIVE);
        primitiveChisel = new ChiselToolTemplate(Identifier.of(MOD_ID, "primitive_chisel"), 256, TierEnum.PRIMITIVE);
        primitiveGrabber = new GrabberToolTemplate(Identifier.of(MOD_ID, "primitive_grabber"), 256, TierEnum.PRIMITIVE);

        archaeologyBrush = new BrushToolTemplate(Identifier.of(MOD_ID, "archaeology_brush"), 512, TierEnum.BRICK);
        archaeologyChisel = new ChiselToolTemplate(Identifier.of(MOD_ID, "archaeology_chisel"), 512, TierEnum.BRICK);

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

        sugarCaneFrame = new LazyItemTemplate(Identifier.of(MOD_ID, "sugar_cane_frame"));
        cactusFrame = new LazyItemTemplate(Identifier.of(MOD_ID, "cactus_frame"));
        flintFrame = new LazyItemTemplate(Identifier.of(MOD_ID, "flint_frame"));
        woodenFrame = new LazyItemTemplate(Identifier.of(MOD_ID, "wooden_frame"));
        hardenedBrickFrame = new LazyItemTemplate(Identifier.of(MOD_ID, "hardened_brick_frame"));
        reinforcedBrickFrame = new LazyItemTemplate(Identifier.of(MOD_ID, "reinforced_brick_frame"));

        toolRepairKit = new LazyItemTemplate(Identifier.of(MOD_ID, "tool_repair_kit"));

        archaeologyIceKnife = new ArchaeologyIceKnifeItem(Identifier.of(MOD_ID, "archaeology_ice_knife")).setTranslationKey(MOD_ID, "archaeology_ice_knife");

        archaeologyToolBase = new TemplateItem(Identifier.of(MOD_ID, "archaeology_tool_base")).setTranslationKey(MOD_ID, "archaeology_tool_base");
        iceBlade = new TemplateItem(Identifier.of(MOD_ID, "ice_blade")).setTranslationKey(MOD_ID, "ice_blade");
        brokenSpikeHolder = new TemplateItem(Identifier.of(MOD_ID, "broken_spike_holder")).setTranslationKey(MOD_ID, "broken_spike_holder");

        brickFrame = new TemplateItem(Identifier.of(MOD_ID, "brick_frame")).setTranslationKey(MOD_ID, "brick_frame");
        dryBrickFrame = new TemplateItem(Identifier.of(MOD_ID, "dry_brick_frame")).setTranslationKey(MOD_ID, "dry_brick_frame");

        woodenBrick = new TemplateItem(Identifier.of(MOD_ID, "wooden_brick")).setTranslationKey(MOD_ID, "wooden_brick");
        brickAsh = new TemplateItem(Identifier.of(MOD_ID, "brick_ash")).setTranslationKey(MOD_ID, "brick_ash");
        stoneBrick = new TemplateItem(Identifier.of(MOD_ID, "stone_brick")).setTranslationKey(MOD_ID, "stone_brick");
        snowBrick = new TemplateItem(Identifier.of(MOD_ID, "snow_brick")).setTranslationKey(MOD_ID, "snow_brick");
        frozenBrick = new TemplateItem(Identifier.of(MOD_ID, "frozen_brick")).setTranslationKey(MOD_ID, "frozen_brick");

        brickSeedlings = new BrickSeedlingsItem(Identifier.of(MOD_ID, "brick_seedlings")).setTranslationKey(MOD_ID, "brick_seedlings");
        brickCatalyst = new BrickCatalystItem(Identifier.of(MOD_ID, "brick_catalyst")).setTranslationKey(MOD_ID, "brick_catalyst");
        clayPowder = new TemplateItem(Identifier.of(MOD_ID, "clay_powder")).setTranslationKey(MOD_ID, "clay_powder");

        exoticCatalyst = new ExoticCatalystItem(Identifier.of(MOD_ID, "exotic_catalyst"));

        coalOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "coal_ore_brick"));
        ironOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "iron_ore_brick"));
        goldOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "gold_ore_brick"));
        redstoneOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "redstone_ore_brick"));
        diamondOreBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "diamond_ore_brick"));

        largeBrickRaw = new LazyItemTemplate(Identifier.of(MOD_ID, "large_brick_raw"));
        largeBrick = new LazyItemTemplate(Identifier.of(MOD_ID, "large_brick"));
    }
}
