package net.alternateadventure.brickforgery.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;

public class TextureListener {

    @Entrypoint.Namespace
    public static Namespace MOD_ID;

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        String worldGenerationPath = "ExplorationFeatures/WorldGeneration/";
        String machinePath = "MaterialProcessing/Machines/";
        String materialPath = "MaterialProcessing/Materials/";
        String farmingPath = "MaterialProcessing/Farming/";

        ItemListener.dirtBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/DirtBrick"));
        ItemListener.sugarCaneStick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/SugarCaneStick"));

        ItemListener.dirtBrickSand.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/DirtBrickSand"));
        ItemListener.sandBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/SandBrick"));

        ItemListener.exoticFruit.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Plants/ExoticFruit"));
        ItemListener.nightSeeds.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightSeeds"));
        ItemListener.nightWheat.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheat"));
        ItemListener.fernItem.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/FernItem"));

        ItemListener.denseNightWood.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/DenseNightWood"));
        ItemListener.glueMixture.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/GlueMixture"));

        ItemListener.fortunePowder.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/FortunePowder"));
        ItemListener.concentratedFortune.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ConcentratedFortune"));

        ItemListener.exoticKey.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Keys/ExoticKey"));
        ItemListener.desertKey.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Keys/DesertKey"));
        ItemListener.iceKey.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Keys/IceKey"));

        ItemListener.primitiveBrush.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/PrimitiveBrush"));
        ItemListener.primitiveChisel.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/PrimitiveChisel"));
        ItemListener.primitiveGrabber.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/PrimitiveGrabber"));

        ItemListener.groundSandstone.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/GroundSandstone"));
        ItemListener.illuminantCrystal.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/IlluminantCrystal"));

        ItemListener.ironOreCrushed.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/IronOreCrushed"));
        ItemListener.ironOreWashed.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/IronOreWashed"));
        ItemListener.ironOrePowdered.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/IronOrePowdered"));
        ItemListener.ironOrePurified.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/IronOrePurified"));

        ItemListener.goldOreCrushed.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/GoldOreCrushed"));
        ItemListener.goldOreWashed.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/GoldOreWashed"));
        ItemListener.goldOrePowdered.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/GoldOrePowdered"));
        ItemListener.goldOrePurified.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/GoldOrePurified"));

        ItemListener.thermalPowder.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/ThermalPowder"));
        ItemListener.concentratedThermal.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ConcentratedThermal"));
        ItemListener.thermalGlass.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ThermalGlass"));

        ItemListener.cryogenicPowder.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/CryogenicPowder"));
        ItemListener.concentratedCryogenic.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ConcentratedCryogenic"));

        ItemListener.durableLeather.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/DurableLeather"));
        ItemListener.brickSteelIngot.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickSteelIngot"));
        ItemListener.bricksidianIngot.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BricksidianIngot"));

        ItemListener.leatherStrap.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/LeatherStrap"));
        ItemListener.goldenScrew.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/GoldenScrew"));
        ItemListener.durableLeatherStrap.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/DurableLeatherStrap"));
        ItemListener.bricksidianScrew.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BricksidianScrew"));
        ItemListener.brickSteelPlate.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickSteelPlate"));

        ItemListener.nightWoodBeam.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/NightWoodBeam"));
        ItemListener.brickSteelBeam.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickSteelBeam"));

        ItemListener.toolRepairKit.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ToolRepairKit"));

        ItemListener.archaeologyBrush.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyBrush"));
        ItemListener.archaeologyChisel.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyChisel"));
        ItemListener.archaeologyIceKnife.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyIceKnife"));

        ItemListener.archaeologyToolBase.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyToolBase"));
        ItemListener.iceBlade.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/IceBlade"));
        ItemListener.brokenSpikeHolder.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/BrokenSpikeHolder"));

        ItemListener.sugarCaneFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/SugarCaneFrame"));
        ItemListener.cactusFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/CactusFrame"));
        ItemListener.flintFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/FlintFrame"));
        ItemListener.woodenFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/WoodenFrame"));
        ItemListener.brickFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickFrame"));
        ItemListener.dryBrickFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/DryBrickFrame"));
        ItemListener.hardenedBrickFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/HardenedBrickFrame"));
        ItemListener.reinforcedBrickFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ReinforcedBrickFrame"));

        ItemListener.woodenBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/WoodenBrick"));
        ItemListener.brickAsh.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickAsh"));
        ItemListener.stoneBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/StoneBrick"));
        ItemListener.snowBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/SnowBrick"));
        ItemListener.frozenBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/FrozenBrick"));

        ItemListener.brickSeedlings.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickSeedlings"));
        ItemListener.brickCatalyst.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickCatalyst"));
        ItemListener.clayPowder.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ClayPowder"));

        ItemListener.exoticCatalyst.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ExoticCatalyst"));

        ItemListener.coalOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/CoalOreBrick"));
        ItemListener.ironOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/IronOreBrick"));
        ItemListener.goldOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/GoldOreBrick"));
        ItemListener.redstoneOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/RedstoneOreBrick"));
        ItemListener.diamondOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/DiamondOreBrick"));

        ItemListener.largeBrickRaw.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/LargeBrickRaw"));
        ItemListener.largeBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/LargeBrick"));

        ExoticShrub = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Plants/ExoticShrub")).index;
        ExoticShrubMature = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Plants/ExoticShrubMature")).index;
        ExoticShrubDead = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Plants/ExoticShrubDead")).index;

        NightWheatCropBud = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheatCropBud")).index;
        NightWheatCropSmall = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheatCropSmall")).index;
        NightWheatCropMedium = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheatCropMedium")).index;
        NightWheatCropLarge = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheatCropLarge")).index;
        NightWheatCropThriving = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheatCropThriving")).index;
        NightWheatCropBlooming = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheatCropBlooming")).index;
        NightWheatCropMature = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheatCropMature")).index;
        NightWheatCropRipe = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheatCropRipe")).index;

        NightSapling = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightSapling")).index;
        NightLogTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightLogTop")).index;
        NightLogSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightLogSide")).index;
        NightLeaves = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightLeaves")).index;
        NightPlanks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightPlanks")).index;

        DoubleRose = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/DoubleRose")).index;
        DoubleDandelion = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/DoubleDandelion")).index;

        PotPedestalTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PotPedestalTop")).index;
        PotPedestalSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PotPedestalSide")).index;
        PotPedestalBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PotPedestalBottom")).index;

        BountifulSand = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/BountifulSand")).index;
        BountifulSnow = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/BountifulSnow")).index;
        FactoryRubble = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/FactoryRubble")).index;

        CommonPotTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/CommonPotTop")).index;
        CommonPotSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/CommonPotSide")).index;
        CommonPotBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/CommonPotBottom")).index;
        DesertPotTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotTop")).index;
        DesertPotSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotSide")).index;
        DesertPotBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotBottom")).index;
        DesertPotTopSealed = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotTopSealed")).index;

        ForestVaultKeyhole = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/ForestVaultKeyhole")).index;
        ForestVaultTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/ForestVaultTop")).index;
        ForestVaultSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/ForestVaultSide")).index;
        DesertWellBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/DesertWellBricks")).index;
        DesertWellFloor = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/DesertWellFloor")).index;
        DesertWellKeyhole = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/DesertWellKeyhole")).index;

        FrozenPotTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotTop")).index;
        FrozenPotSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotSide")).index;
        FrozenPotBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotBottom")).index;
        FrozenPotTopSealed = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotTopSealed")).index;

        ImprovedMillstoneTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ImprovedMillstoneTop")).index;
        ImprovedMillstoneSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ImprovedMillstoneSide")).index;
        ImprovedMillstoneBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ImprovedMillstoneBottom")).index;

        PrimitiveMachineFrame = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveMachineFrame")).index;
        PrimitiveBrickFrameCrafterTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveBrickFrameCrafterTop")).index;
        PrimitiveBrickFrameCrafterSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveBrickFrameCrafterSide")).index;
        PrimitiveBrickFrameCrafterBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveBrickFrameCrafterBottom")).index;
        PrimitiveSlicerTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveSlicerTop")).index;
        PrimitiveSlicerSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveSlicerSide")).index;
        PrimitiveSlicerBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveSlicerBottom")).index;
        PrimitiveMetalworkingStationTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveMetalworkingStationTop")).index;
        PrimitiveMetalworkingStationSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveMetalworkingStationSide")).index;
        PrimitiveMetalworkingStationBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveMetalworkingStationBottom")).index;
        PrimitiveCrusherTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveCrusherTop")).index;
        PrimitiveCrusherSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveCrusherSide")).index;
        PrimitiveCrusherBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveCrusherBottom")).index;
        PrimitiveWasherTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveWasherTop")).index;
        PrimitiveWasherSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveWasherSide")).index;
        PrimitiveWasherBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/PrimitiveWasherBottom")).index;

        HeatPillar = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/HeatPillar")).index;
        HeatPillarIgnited = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/HeatPillarIgnited")).index;
        HeatPillarStoked = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/HeatPillarStoked")).index;

        BrickSteelMachineFrame = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickSteelMachineFrame")).index;
        SlicerTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/SlicerTop")).index;
        SlicerSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/SlicerSide")).index;
        SlicerBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/SlicerBottom")).index;
        MetalworkingStationTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/MetalworkingStationTop")).index;
        MetalworkingStationSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/MetalworkingStationSide")).index;
        MetalworkingStationBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/MetalworkingStationBottom")).index;
        AlloySmelterTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/AlloySmelterTop")).index;
        AlloySmelterSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/AlloySmelterSide")).index;
        AlloySmelterBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/AlloySmelterBottom")).index;
        AlloySmelterFront = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/AlloySmelterFront")).index;
        AlloySmelterTopActive = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/AlloySmelterTopActive")).index;
        AlloySmelterSideActive = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/AlloySmelterSideActive")).index;
        AlloySmelterFrontActive = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/AlloySmelterFrontActive")).index;
        BrickFrameCrafterTopDusted = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickFrameCrafterTopDusted")).index;
        BrickFrameCrafterTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickFrameCrafterTop")).index;
        BrickFrameCrafterSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickFrameCrafterSide")).index;
        BrickFrameCrafterBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickFrameCrafterBottom")).index;

        ItemChuteTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemChuteTop")).index;
        ItemChuteSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemChuteSide")).index;
        ItemChuteBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemChuteBottom")).index;
        ItemSlideTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideTop")).index;
        ItemSlideSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideSide")).index;
        ItemSlideBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideBottom")).index;
        ItemSlideFront = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideFront")).index;
        ItemSlideBack = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideBack")).index;
        ItemElevatorTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemElevatorTop")).index;
        ItemElevatorSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemElevatorSide")).index;
        ItemElevatorBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemElevatorBottom")).index;
        ItemChuteChainTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemChuteChainTop")).index;
        ItemChuteChainSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemChuteChainSide")).index;
        ItemChuteChainBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemChuteChainBottom")).index;
        ItemSlideChainTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideChainTop")).index;
        ItemSlideChainSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideChainSide")).index;
        ItemSlideChainBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideChainBottom")).index;
        ItemSlideChainFront = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideChainFront")).index;
        ItemSlideChainBack = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemSlideChainBack")).index;
        ItemElevatorChainTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemElevatorChainTop")).index;
        ItemElevatorChainSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemElevatorChainSide")).index;
        ItemElevatorChainBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/ItemElevatorChainBottom")).index;

        BrickLauncherTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickLauncherTop")).index;
        BrickLauncherSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickLauncherSide")).index;
        BrickLauncherBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickLauncherBottom")).index;

        IcyTerracotta = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/IcyTerracotta")).index;
        DenseIce = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/DenseIce")).index;

        WoodenBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/WoodenBricks")).index;
        StoneBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/StoneBricks")).index;
        LargeStoneBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/LargeStoneBricks")).index;
        FastBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/FastBricks")).index;

        Dust = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/Dust")).index;
        StoneBrickOre = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/StoneBrickOre")).index;

        BrickCropBud = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickCropBud")).index;
        BrickCropSmall = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickCropSmall")).index;
        BrickCropBlooming = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickCropBlooming")).index;
        BrickCropMature = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickCropMature")).index;

        BrickSoilTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickSoilTop")).index;
        BrickSoilSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickSoilSide")).index;
        BrickSoilBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickSoilBottom")).index;
        BrickSoilTopDepleted = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickSoilTopDepleted")).index;
        BrickSoilSideDepleted = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickSoilSideDepleted")).index;
        BrickSoilBottomDepleted = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickSoilBottomDepleted")).index;

        SpikeMount = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/SpikeMount")).index;
        SpikeMountLoaded = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/SpikeMountLoaded")).index;

        IronOreBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/IronOreBricks")).index;
        CoalOreBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/CoalOreBricks")).index;
        GoldOreBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/GoldOreBricks")).index;
        RedstoneOreBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/RedstoneOreBricks")).index;
        DiamondOreBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/DiamondOreBricks")).index;

        BlockListener.dirtBricks.specifyTextures(getIndexForPath(materialPath + "DirtBricks"));
        BlockListener.sugarCaneBox.specifyTextures(getIndexForPath(materialPath + "SugarCaneBox"));
        BlockListener.nightCane.specifyTextures(getIndexForPath(farmingPath + "NightCaneSingle"));

        BlockListener.cactusBox.specifyTextures(getIndexForPath(materialPath + "CactusBox"));
        BlockListener.sandBricks.specifyTextures(getIndexForPath(materialPath + "SandBricks"));
        BlockListener.flintBox.specifyTextures(getIndexForPath(materialPath + "FlintBox"));

        BlockListener.bountifulSand.specifyTextures(BountifulSand);
        BlockListener.bountifulSnow.specifyTextures(BountifulSnow);
        BlockListener.factoryRubble.specifyTextures(FactoryRubble);

        BlockListener.commonPot.specifyTextures(CommonPotTop, CommonPotSide, CommonPotBottom);
        BlockListener.forestVaultKeyhole.specifyTextures(ForestVaultKeyhole, ForestVaultSide, ForestVaultKeyhole);
        BlockListener.forestVaultWalls.specifyTextures(ForestVaultTop, ForestVaultSide, ForestVaultTop);
        BlockListener.forestOrnament.specifyTextures(ForestVaultTop, ForestVaultSide, ForestVaultTop);

        BlockListener.desertPotSealed.specifyTextures(DesertPotTopSealed, DesertPotSide, DesertPotBottom);
        BlockListener.desertWellBricks.specifyTextures(DesertWellBricks);
        BlockListener.desertWellFloor.specifyTextures(DesertWellFloor);
        BlockListener.desertWellKeyhole.specifyTextures(DesertWellKeyhole);
        BlockListener.ancientSandstoneBricks.specifyTextures(DesertWellBricks);
        BlockListener.ancientSandstoneTile.specifyTextures(DesertWellFloor);

        BlockListener.frozenPot.specifyTextures(FrozenPotTop, FrozenPotSide, FrozenPotBottom);
        BlockListener.frostVaultBricks.specifyTextures(getIndexForPath(worldGenerationPath + "FrostVaultBricks"));
        BlockListener.frostVaultTiling.specifyTextures(getIndexForPath(worldGenerationPath + "FrostVaultTiling"));
        BlockListener.frostVaultKeyhole.specifyTextures(getIndexForPath(worldGenerationPath + "FrostVaultKeyhole"));
        BlockListener.ancientIceBricks.specifyTextures(getIndexForPath(worldGenerationPath + "FrostVaultBricks"));
        BlockListener.ancientIceTiling.specifyTextures(getIndexForPath(worldGenerationPath + "FrostVaultTiling"));

        BlockListener.improvedMillstone.specifyTextures(ImprovedMillstoneTop, ImprovedMillstoneSide, ImprovedMillstoneBottom);

        BlockListener.primitiveMachineFrame.specifyTextures(PrimitiveMachineFrame);
        BlockListener.primitiveBrickFrameCrafter.specifyTextures(PrimitiveBrickFrameCrafterTop, PrimitiveBrickFrameCrafterSide, PrimitiveBrickFrameCrafterBottom);
        BlockListener.primitiveSlicer.specifyTextures(PrimitiveSlicerTop, PrimitiveSlicerSide, PrimitiveSlicerBottom);
        BlockListener.primitiveMetalworkingStation.specifyTextures(PrimitiveMetalworkingStationTop, PrimitiveMetalworkingStationSide, PrimitiveMetalworkingStationBottom);
        BlockListener.primitiveCrusher.specifyTextures(PrimitiveCrusherTop, PrimitiveCrusherSide, PrimitiveCrusherBottom);
        BlockListener.primitiveWasher.specifyTextures(PrimitiveWasherTop, PrimitiveWasherSide, PrimitiveWasherBottom);

        BlockListener.heatPillar.specifyTextures(HeatPillar);
        BlockListener.heatPillarIgnited.specifyTextures(HeatPillarIgnited);
        BlockListener.heatPillarStoked.specifyTextures(HeatPillarStoked);

        BlockListener.cryogenicHibachi.specifyTextures(getIndexForPath(machinePath + "CryogenicHibachiTop"),
                getIndexForPath(machinePath + "CryogenicHibachiSide"),
                getIndexForPath(machinePath + "CryogenicHibachiBottom"));
        BlockListener.frostburn.specifyTextures(getIndexForPath(machinePath + "Frostburn"));

        BlockListener.brickFrameCrafter.specifyTextures(BrickFrameCrafterTop, BrickFrameCrafterSide, BrickFrameCrafterBottom);
        BlockListener.brickSteelMachineFrame.specifyTextures(BrickSteelMachineFrame);
        BlockListener.slicer.specifyTextures(SlicerTop, SlicerSide, SlicerBottom);
        BlockListener.metalworkingStation.specifyTextures(MetalworkingStationTop, MetalworkingStationSide, MetalworkingStationBottom);
        BlockListener.alloySmelter.specifyTextures(AlloySmelterTop, AlloySmelterSide, AlloySmelterBottom, AlloySmelterFront);
        BlockListener.alloySmelterActive.specifyTextures(AlloySmelterTopActive, AlloySmelterSideActive, AlloySmelterBottom, AlloySmelterFrontActive);

        BlockListener.itemChute.specifyTextures(ItemChuteTop, ItemChuteSide, ItemChuteBottom);
        BlockListener.itemSlide.specifyTextures(ItemSlideTop, ItemSlideSide, ItemSlideBottom, ItemSlideFront, ItemSlideBack);
        BlockListener.itemElevator.specifyTextures(ItemElevatorTop, ItemElevatorSide, ItemElevatorBottom);
        BlockListener.itemChuteChain.specifyTextures(ItemChuteChainTop, ItemChuteChainSide, ItemChuteChainBottom);
        BlockListener.itemSlideChain.specifyTextures(ItemSlideChainTop, ItemSlideChainSide, ItemSlideChainBottom, ItemSlideChainFront, ItemSlideChainBack);
        BlockListener.itemElevatorChain.specifyTextures(ItemElevatorChainTop, ItemElevatorChainSide, ItemElevatorChainBottom);

        BlockListener.largeStoneBricks.specifyTextures(LargeStoneBricks);
        BlockListener.fastBricks.specifyTextures(FastBricks);

        BlockListener.coalOreBricks.specifyTextures(CoalOreBricks);
        BlockListener.ironOreBricks.specifyTextures(IronOreBricks);
        BlockListener.goldOreBricks.specifyTextures(GoldOreBricks);
        BlockListener.redstoneOreBricks.specifyTextures(RedstoneOreBricks);
        BlockListener.diamondOreBricks.specifyTextures(DiamondOreBricks);

        BlockListener.nightCane.asItem().setTextureId(getIndexForPath(farmingPath + "NightCaneSingle"));

        BlockListener.heatPillar.asItem().setTextureId(HeatPillar);
        BlockListener.heatPillarIgnited.asItem().setTextureId(HeatPillarIgnited);
        BlockListener.heatPillarStoked.asItem().setTextureId(HeatPillarStoked);

        BlockListener.spikeMount.asItem().setTextureId(SpikeMount);
        BlockListener.exoticShrub.asItem().setTextureId(ExoticShrub);
        BlockListener.nightSapling.asItem().setTextureId(NightSapling);
    }

    public static int getIndexForPath(String path) {
        return Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, path)).index;
    }

    public static int
            ExoticShrub,
            ExoticShrubMature,
            ExoticShrubDead,

            NightWheatCropBud,
            NightWheatCropSmall,
            NightWheatCropMedium,
            NightWheatCropLarge,
            NightWheatCropThriving,
            NightWheatCropBlooming,
            NightWheatCropMature,
            NightWheatCropRipe,

            NightSapling,
            NightLogTop,
            NightLogSide,
            NightLeaves,
            NightPlanks,

            DoubleRose,
            DoubleDandelion,

            PotPedestalTop,
            PotPedestalSide,
            PotPedestalBottom,

            BountifulSand,
            BountifulSnow,
            FactoryRubble,

            CommonPotTop,
            CommonPotSide,
            CommonPotBottom,
            DesertPotTop,
            DesertPotSide,
            DesertPotBottom,
            DesertPotTopSealed,

            ForestVaultKeyhole,
            ForestVaultTop,
            ForestVaultSide,
            DesertWellBricks,
            DesertWellFloor,
            DesertWellKeyhole,

            FrozenPotTop,
            FrozenPotSide,
            FrozenPotBottom,
            FrozenPotTopSealed,

            ImprovedMillstoneTop,
            ImprovedMillstoneSide,
            ImprovedMillstoneBottom,

            PrimitiveMachineFrame,
            PrimitiveBrickFrameCrafterTop,
            PrimitiveBrickFrameCrafterSide,
            PrimitiveBrickFrameCrafterBottom,
            PrimitiveSlicerTop,
            PrimitiveSlicerSide,
            PrimitiveSlicerBottom,
            PrimitiveMetalworkingStationTop,
            PrimitiveMetalworkingStationSide,
            PrimitiveMetalworkingStationBottom,
            PrimitiveCrusherTop,
            PrimitiveCrusherSide,
            PrimitiveCrusherBottom,
            PrimitiveWasherTop,
            PrimitiveWasherSide,
            PrimitiveWasherBottom,

            HeatPillar,
            HeatPillarIgnited,
            HeatPillarStoked,

            BrickSteelMachineFrame,
            SlicerTop,
            SlicerSide,
            SlicerBottom,
            MetalworkingStationTop,
            MetalworkingStationSide,
            MetalworkingStationBottom,
            AlloySmelterTop,
            AlloySmelterSide,
            AlloySmelterBottom,
            AlloySmelterFront,
            AlloySmelterTopActive,
            AlloySmelterSideActive,
            AlloySmelterFrontActive,
            BrickFrameCrafterTopDusted,
            BrickFrameCrafterTop,
            BrickFrameCrafterSide,
            BrickFrameCrafterBottom,

            ItemChuteTop,
            ItemChuteSide,
            ItemChuteBottom,
            ItemSlideTop,
            ItemSlideSide,
            ItemSlideBottom,
            ItemSlideFront,
            ItemSlideBack,
            ItemElevatorTop,
            ItemElevatorSide,
            ItemElevatorBottom,
            ItemChuteChainTop,
            ItemChuteChainSide,
            ItemChuteChainBottom,
            ItemSlideChainTop,
            ItemSlideChainSide,
            ItemSlideChainBottom,
            ItemSlideChainFront,
            ItemSlideChainBack,
            ItemElevatorChainTop,
            ItemElevatorChainSide,
            ItemElevatorChainBottom,

            BrickLauncherTop,
            BrickLauncherSide,
            BrickLauncherBottom,

            IcyTerracotta,
            DenseIce,

            WoodenBricks,
            StoneBricks,
            LargeStoneBricks,
            FastBricks,

            Dust,
            StoneBrickOre,

            BrickCropBud,
            BrickCropSmall,
            BrickCropBlooming,
            BrickCropMature,

            BrickSoilTop,
            BrickSoilSide,
            BrickSoilBottom,
            BrickSoilTopDepleted,
            BrickSoilSideDepleted,
            BrickSoilBottomDepleted,

            SpikeMount,
            SpikeMountLoaded,

            CoalOreBricks,
            IronOreBricks,
            GoldOreBricks,
            RedstoneOreBricks,
            DiamondOreBricks;

}
