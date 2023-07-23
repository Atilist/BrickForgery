package net.alternateadventure.brickforgery.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

public class TextureListener {

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        ItemListener.exoticFruit.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Plants/ExoticFruit"));
        ItemListener.nightSeeds.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightSeeds"));
        ItemListener.nightWheat.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/NightWheat"));
        ItemListener.fernItem.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/FernItem"));

        ItemListener.denseNightWood.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/DenseNightWood"));

        ItemListener.fortunePowder.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/FortunePowder"));
        ItemListener.concentratedFortune.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ConcentratedFortune"));

        ItemListener.exoticKey.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Keys/ExoticKey"));

        ItemListener.desertPotItem.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/DesertPotItem"));
        ItemListener.frozenPotItem.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/FrozenPotItem"));

        ItemListener.primitiveBrush.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/PrimitiveBrush"));
        ItemListener.primitiveChisel.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/PrimitiveChisel"));
        ItemListener.primitiveGrabber.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/PrimitiveGrabber"));

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
        ItemListener.hardenedBrickFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/HardenedBrickFrame"));

        ItemListener.toolRepairKit.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ToolRepairKit"));

        ItemListener.archeologyBrush.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyBrush"));
        ItemListener.archeologyChisel.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyChisel"));
        ItemListener.archeologyIceKnife.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyIceKnife"));

        ItemListener.archeologyToolBase.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyToolBase"));
        ItemListener.iceBlade.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/IceBlade"));
        ItemListener.brokenSpikeHolder.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/BrokenSpikeHolder"));

        ItemListener.brickFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickFrame"));
        ItemListener.dryBrickFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/DryBrickFrame"));

        ItemListener.woodenBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/WoodenBrick"));
        ItemListener.brickAsh.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickAsh"));
        ItemListener.stoneBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/StoneBrick"));
        ItemListener.snowBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/SnowBrick"));
        ItemListener.frozenBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/FrozenBrick"));

        ItemListener.brickSeedlings.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Farming/BrickSeedlings"));
        ItemListener.brickCatalyst.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickCatalyst"));
        ItemListener.clayPowder.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ClayPowder"));

        ItemListener.brickHammer.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Tools/BrickHammer"));
        ItemListener.exoticCatalyst.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/ExoticCatalyst"));

        ItemListener.coalOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/CoalOreBrick"));
        ItemListener.ironOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/IronOreBrick"));
        ItemListener.goldOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/GoldOreBrick"));
        ItemListener.redstoneOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/RedstoneOreBrick"));
        ItemListener.diamondOreBrick.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Ores/DiamondOreBrick"));

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

        FrozenPotTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotTop")).index;
        FrozenPotSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotSide")).index;
        FrozenPotBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotBottom")).index;
        FrozenPotTopSealed = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotTopSealed")).index;

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

        BlockListener.potPedestal.specifyTextures(PotPedestalTop, PotPedestalSide, PotPedestalBottom);

        BlockListener.bountifulSand.specifyTextures(BountifulSand);
        BlockListener.bountifulSnow.specifyTextures(BountifulSnow);
        BlockListener.factoryRubble.specifyTextures(FactoryRubble);

        BlockListener.commonPot.specifyTextures(CommonPotTop, CommonPotSide, CommonPotBottom);
        BlockListener.forestVaultKeyhole.specifyTextures(ForestVaultKeyhole, ForestVaultSide, ForestVaultKeyhole);
        BlockListener.forestVaultWalls.specifyTextures(ForestVaultTop, ForestVaultSide, ForestVaultTop);
        BlockListener.forestOrnament.specifyTextures(ForestVaultTop, ForestVaultSide, ForestVaultTop);

        BlockListener.desertPotSealed.specifyTextures(DesertPotTopSealed, DesertPotSide, DesertPotBottom);

        BlockListener.primitiveMachineFrame.specifyTextures(PrimitiveMachineFrame);
        BlockListener.primitiveBrickFrameCrafter.specifyTextures(PrimitiveBrickFrameCrafterTop, PrimitiveBrickFrameCrafterSide, PrimitiveBrickFrameCrafterBottom);
        BlockListener.primitiveSlicer.specifyTextures(PrimitiveSlicerTop, PrimitiveSlicerSide, PrimitiveSlicerBottom);
        BlockListener.primitiveMetalworkingStation.specifyTextures(PrimitiveMetalworkingStationTop, PrimitiveMetalworkingStationSide, PrimitiveMetalworkingStationBottom);

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

        BlockListener.spikeMount.asItem().setTexturePosition(SpikeMount);
        BlockListener.exoticShrub.asItem().setTexturePosition(ExoticShrub);
        BlockListener.nightSapling.asItem().setTexturePosition(NightSapling);
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

            FrozenPotTop,
            FrozenPotSide,
            FrozenPotBottom,
            FrozenPotTopSealed,

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
