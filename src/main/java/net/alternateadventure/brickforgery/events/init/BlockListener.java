package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.blocks.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;

public class BlockListener {

    public static Block
            exoticShrub,
            exoticShrubDead,
            nightWheatCrop,
            nightSapling,
            nightLog,
            nightLeaves,
            nightPlanks,

            desertPot,
            frozenPotSealed,
            mossyPot,

            brickLauncher,

            clayPile,
            planksPile,

            woodenBricks,
            stoneBricks,

            dust,

            brickCrop,

            brickSoil,
            brickSoilDepleted,

            spikeMount;

    public static LazyBlockTemplate
            dirtBricks,
            sugarCaneBox,
            cactusBox,
            sandBricks,
            flintBox,

            commonPot,

            forestVaultKeyhole,
            forestVaultWalls,
            forestOrnament,

            desertPotSealed,

            desertWellBricks,
            desertWellFloor,
            desertWellKeyhole,
            ancientSandstoneBricks,
            ancientSandstoneTile,

            frozenPot,

            frostVaultBricks,
            frostVaultTiling,
            frostVaultKeyhole,
            ancientIceBricks,
            ancientIceTiling,

            bountifulSand,
            bountifulSnow,
            factoryRubble,

            doublePlant,

            primitiveMachineFrame,
            primitiveBrickFrameCrafter,

            heatPillar,
            heatPillarIgnited,
            heatPillarStoked,

            cryogenicHibachi,
            frostburn,

            brickFrameCrafter,
            brickSteelMachineFrame,

            itemChuteChain,
            itemSlideChain,
            itemElevatorChain,

            largeStoneBricks,
            fastBricks,

            coalOreBricks,
            ironOreBricks,
            goldOreBricks,
            redstoneOreBricks,
            diamondOreBricks;

    public static DirectionalMachineTemplate
            alloySmelter,
            alloySmelterActive,

            itemSlide;

    public static LazySimpleMachine
            improvedMillstone,

            primitiveSlicer,
            primitiveMetalworkingStation,
            primitiveCrusher,
            primitiveWasher,

            slicer,
            metalworkingStation,

            itemChute,
            itemElevator;

    @Entrypoint.Namespace
    public static Namespace MOD_ID;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        dirtBricks = new LazyBlockTemplate(Identifier.of(MOD_ID,  "dirt_bricks"), Material.SOIL, 1.5F, Block.GRAVEL_SOUND_GROUP);
        sugarCaneBox = new LazyBlockTemplate(Identifier.of(MOD_ID,  "sugar_cane_box"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP);
        cactusBox = new LazyBlockTemplate(Identifier.of(MOD_ID,  "cactus_box"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP);
        sandBricks = new LazyBlockTemplate(Identifier.of(MOD_ID,  "sand_bricks"), Material.SAND, 1.5F, Block.SAND_SOUND_GROUP);
        flintBox = new LazyBlockTemplate(Identifier.of(MOD_ID,  "flint_box"), Material.SOIL, 1.5F, Block.GRAVEL_SOUND_GROUP);

        exoticShrub = new ExoticShrub(Identifier.of(MOD_ID, "exotic_shrub"), Material.PLANT).setHardness(0.0F).setSoundGroup(Block.GRAVEL_SOUND_GROUP).setTranslationKey(MOD_ID, "exotic_shrub");
        exoticShrubDead = new ExoticShrubDead(Identifier.of(MOD_ID, "exotic_shrub_dead"), Material.PLANT).setHardness(0.0F).setSoundGroup(Block.GRAVEL_SOUND_GROUP).setTranslationKey(MOD_ID, "exotic_shrub_dead");
        nightWheatCrop = new NightWheatCrop(Identifier.of(MOD_ID, "night_wheat_crop"), Material.PLANT).setHardness(0.0F).setSoundGroup(Block.GRAVEL_SOUND_GROUP).setTranslationKey(MOD_ID, "night_wheat_crop");
        nightSapling = new NightSapling(Identifier.of(MOD_ID, "night_sapling"), Material.PLANT).setHardness(0.0F).setSoundGroup(Block.GRAVEL_SOUND_GROUP).setTranslationKey(MOD_ID, "night_sapling");
        nightLog = new NightLog(Identifier.of(MOD_ID, "night_log"), Material.WOOD).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP).setTranslationKey(MOD_ID, "night_log");
        nightLeaves = new NightLeaves(Identifier.of(MOD_ID, "night_leaves"), Material.LEAVES).setHardness(0.5F).setSoundGroup(Block.GRAVEL_SOUND_GROUP).setTranslationKey(MOD_ID, "night_leaves");
        nightPlanks = new NightPlanks(Identifier.of(MOD_ID, "night_planks"), Material.WOOD).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP).setTranslationKey(MOD_ID, "night_planks");
        doublePlant = new DoublePlant(Identifier.of(MOD_ID, "double_plant"), Material.PLANT, 0.0F, Block.GRAVEL_SOUND_GROUP);

        bountifulSand = new LazyBlockTemplate(Identifier.of(MOD_ID,  "bountiful_sand"), Material.SAND, 1.5F, Block.SAND_SOUND_GROUP);
        bountifulSnow = new LazyBlockTemplate(Identifier.of(MOD_ID,  "bountiful_snow"), Material.SNOW_BLOCK, 1.5F, Block.WOOL_SOUND_GROUP);
        factoryRubble = new LazyBlockTemplate(Identifier.of(MOD_ID,  "factory_rubble"), Material.SOIL, 1.5F, Block.GRAVEL_SOUND_GROUP);

        commonPot = new CommonPot(Identifier.of(MOD_ID, "common_pot"), Material.STONE, 1.5F, Block.GLASS_SOUND_GROUP);
        forestVaultKeyhole = new IndestructibleBlock(Identifier.of(MOD_ID, "forest_vault_keyhole"), Material.STONE, -1.0F, Block.STONE_SOUND_GROUP, 6000000.0F);
        forestVaultWalls = new IndestructibleBlock(Identifier.of(MOD_ID, "forest_vault_walls"), Material.STONE, -1.0F, Block.STONE_SOUND_GROUP, 6000000.0F);
        forestOrnament = new LazyBlockTemplate(Identifier.of(MOD_ID,  "forest_ornament"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);

        desertPotSealed = new DesertPotSealed(Identifier.of(MOD_ID, "desert_pot_sealed"), Material.STONE, 1.0F, Block.GLASS_SOUND_GROUP);
        desertPot = new DesertPot(Identifier.of(MOD_ID, "desert_pot"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "desert_pot");
        desertWellBricks = new IndestructibleBlock(Identifier.of(MOD_ID, "desert_well_bricks"), Material.STONE, -1.0F, Block.STONE_SOUND_GROUP, 6000000.0F);
        desertWellFloor = new IndestructibleBlock(Identifier.of(MOD_ID, "desert_well_floor"), Material.STONE, -1.0F, Block.STONE_SOUND_GROUP, 6000000.0F);
        desertWellKeyhole = new IndestructibleBlock(Identifier.of(MOD_ID, "desert_well_keyhole"), Material.STONE, -1.0F, Block.STONE_SOUND_GROUP, 6000000.0F);
        ancientSandstoneBricks = new LazyBlockTemplate(Identifier.of(MOD_ID,  "ancient_sandstone_bricks"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);
        ancientSandstoneTile = new LazyBlockTemplate(Identifier.of(MOD_ID,  "ancient_sandstone_tile"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);

        frozenPotSealed = new FrozenPotSealed(Identifier.of(MOD_ID, "frozen_pot_sealed"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "frozen_pot_sealed");
        frozenPot = new FrozenPot(Identifier.of(MOD_ID, "frozen_pot"), Material.STONE, 1.0F, Block.GLASS_SOUND_GROUP);
        frostVaultBricks = new IndestructibleBlock(Identifier.of(MOD_ID, "frost_vault_bricks"), Material.STONE, -1.0F, Block.STONE_SOUND_GROUP, 6000000.0F);
        frostVaultTiling = new IndestructibleBlock(Identifier.of(MOD_ID, "frost_vault_tiling"), Material.STONE, -1.0F, Block.STONE_SOUND_GROUP, 6000000.0F);
        frostVaultKeyhole = new IndestructibleBlock(Identifier.of(MOD_ID, "frost_vault_keyhole"), Material.STONE, -1.0F, Block.STONE_SOUND_GROUP, 6000000.0F);
        ancientIceBricks = new LazyBlockTemplate(Identifier.of(MOD_ID,  "ancient_ice_bricks"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);
        ancientIceTiling = new LazyBlockTemplate(Identifier.of(MOD_ID,  "ancient_ice_tiling"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);

        mossyPot = new MossyPot(Identifier.of(MOD_ID, "mossy_pot"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "mossy_pot");

        improvedMillstone = new ImprovedMillstone(Identifier.of(MOD_ID, "improved_millstone"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);

        primitiveMachineFrame = new MachineFrame(Identifier.of(MOD_ID, "primitive_machine_frame"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP);
        primitiveBrickFrameCrafter = new BrickFrameCrafter(Identifier.of(MOD_ID, "primitive_brick_frame_crafter"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP, 0);
        primitiveSlicer = new SlicerBase(Identifier.of(MOD_ID, "primitive_slicer"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP, 0);
        primitiveMetalworkingStation = new MetalworkingStationBase(Identifier.of(MOD_ID, "primitive_metalworking_station"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP, 0);
        primitiveCrusher = new CrusherBase(Identifier.of(MOD_ID, "primitive_crusher"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP, 0);
        primitiveWasher = new WasherBase(Identifier.of(MOD_ID, "primitive_washer"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP, 0);

        heatPillar = new HeatPillar(Identifier.of(MOD_ID, "heat_pillar"), Material.GLASS, 1.5F, Block.GLASS_SOUND_GROUP);
        heatPillarIgnited = new HeatPillarIgnited(Identifier.of(MOD_ID, "heat_pillar_ignited"), Material.GLASS, 1.5F, Block.GLASS_SOUND_GROUP);
        heatPillarStoked = new HeatPillarStoked(Identifier.of(MOD_ID, "heat_pillar_stoked"), Material.GLASS, 1.5F, Block.GLASS_SOUND_GROUP);

        cryogenicHibachi = new CryogenicHibachi(Identifier.of(MOD_ID, "cryogenic_hibachi"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);
        frostburn = new Frostburn(Identifier.of(MOD_ID, "frostburn"), Material.SNOW_BLOCK, 1.5F, Block.GLASS_SOUND_GROUP);

        brickSteelMachineFrame = new MachineFrame(Identifier.of(MOD_ID, "brick_steel_machine_frame"), Material.METAL, 1.5F, Block.METAL_SOUND_GROUP);
        slicer = new SlicerBase(Identifier.of(MOD_ID, "slicer"), Material.METAL, 1.5F, Block.METAL_SOUND_GROUP, 1);
        metalworkingStation = new MetalworkingStationBase(Identifier.of(MOD_ID, "metalworking_station"), Material.METAL, 1.5F, Block.METAL_SOUND_GROUP, 1);
        alloySmelter = new AlloySmelter(Identifier.of(MOD_ID, "alloy_smelter"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP, false);
        alloySmelterActive = new AlloySmelter(Identifier.of(MOD_ID, "alloy_smelter_active"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP, true);
        brickFrameCrafter = new BrickFrameCrafter(Identifier.of(MOD_ID, "brick_frame_crafter"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP, 1);
        brickLauncher = new BrickLauncher(Identifier.of(MOD_ID, "brick_launcher"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "brick_launcher");

        itemChute = new ItemChute(Identifier.of(MOD_ID, "item_chute"), Material.GLASS, 1.5F, Block.METAL_SOUND_GROUP);
        itemSlide = new ItemSlide(Identifier.of(MOD_ID, "item_slide"), Material.GLASS, 1.5F, Block.METAL_SOUND_GROUP);
        itemElevator = new ItemElevator(Identifier.of(MOD_ID, "item_elevator"), Material.GLASS, 1.5F, Block.METAL_SOUND_GROUP);
        itemChuteChain = new LazyBlockTemplate(Identifier.of(MOD_ID, "item_chute_chain"), Material.GLASS, 1.5F, Block.METAL_SOUND_GROUP);
        itemSlideChain = new LazyBlockTemplate(Identifier.of(MOD_ID, "item_slide_chain"), Material.GLASS, 1.5F, Block.METAL_SOUND_GROUP);
        itemElevatorChain = new LazyBlockTemplate(Identifier.of(MOD_ID, "item_elevator_chain"), Material.GLASS, 1.5F, Block.METAL_SOUND_GROUP);

        clayPile = new ResourcePile(Identifier.of(MOD_ID, "clay_pile"), Material.SOIL).setHardness(0.5F).setSoundGroup(Block.GRAVEL_SOUND_GROUP).setTranslationKey(MOD_ID, "clay_pile");
        planksPile = new ResourcePile(Identifier.of(MOD_ID, "planks_pile"), Material.WOOD).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP).setTranslationKey(MOD_ID, "planks_pile");

        woodenBricks = new WoodenBricks(Identifier.of(MOD_ID, "wooden_bricks"), Material.WOOD).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP).setTranslationKey(MOD_ID, "wooden_bricks");
        stoneBricks = new StoneBricks(Identifier.of(MOD_ID, "stone_bricks"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "stone_bricks");
        largeStoneBricks = new LazyBlockTemplate(Identifier.of(MOD_ID, "large_stone_bricks"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);
        fastBricks = new FastBricks(Identifier.of(MOD_ID, "fast_bricks"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);

        dust = new Dust(Identifier.of(MOD_ID, "dust"), Material.SAND).setHardness(0.5F).setSoundGroup(Block.SAND_SOUND_GROUP).setTranslationKey(MOD_ID, "dust");

        brickCrop = new BrickCrop(Identifier.of(MOD_ID, "brick_crop"), Material.PLANT).setHardness(0.5F).setSoundGroup(Block.GRAVEL_SOUND_GROUP).setTranslationKey(MOD_ID, "brick_crop");

        brickSoil = new BrickSoil(Identifier.of(MOD_ID, "brick_soil"), Material.STONE).setHardness(0.5F).setSoundGroup(Block.STONE_SOUND_GROUP).setTranslationKey(MOD_ID, "brick_soil");
        brickSoilDepleted = new BrickSoilDepleted(Identifier.of(MOD_ID, "brick_soil_depleted"), Material.SAND).setHardness(0.5F).setSoundGroup(Block.SAND_SOUND_GROUP).setTranslationKey(MOD_ID, "brick_soil_depleted");

        spikeMount = new SpikeMount(Identifier.of(MOD_ID, "spike_mount"), Material.METAL).setHardness(1.5F).setSoundGroup(Block.METAL_SOUND_GROUP).setTranslationKey(MOD_ID, "spike_mount");

        coalOreBricks = new CoalOreBricks(Identifier.of(MOD_ID, "coal_ore_bricks"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);
        ironOreBricks = new IronOreBricks(Identifier.of(MOD_ID, "iron_ore_bricks"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);
        goldOreBricks = new GoldOreBricks(Identifier.of(MOD_ID, "gold_ore_bricks"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);
        redstoneOreBricks = new RedstoneOreBricks(Identifier.of(MOD_ID, "redstone_ore_bricks"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);
        diamondOreBricks = new DiamondOreBricks(Identifier.of(MOD_ID, "diamond_ore_bricks"), Material.STONE, 1.5F, Block.STONE_SOUND_GROUP);

    }
}
