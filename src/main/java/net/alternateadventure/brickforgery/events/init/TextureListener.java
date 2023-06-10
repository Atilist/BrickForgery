package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.blocks.IronOreBricks;
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

        ItemListener.desertPotItem.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/DesertPotItem"));
        ItemListener.frozenPotItem.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/FrozenPotItem"));
        ItemListener.primitiveBrush.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/PrimitiveBrush"));

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

        DesertPotTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotTop")).index;
        DesertPotSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotSide")).index;
        DesertPotBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotBottom")).index;

        FrozenPotTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotTop")).index;
        FrozenPotSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotSide")).index;
        FrozenPotBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotBottom")).index;
        FrozenPotTopSealed = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/FrozenPotTopSealed")).index;

        BrickFrameCrafterTopDusted = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Machines/BrickFrameCrafterTopDusted")).index;
        BrickFrameCrafterTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Machines/BrickFrameCrafterTop")).index;
        BrickFrameCrafterSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Machines/BrickFrameCrafterSide")).index;
        BrickFrameCrafterBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Machines/BrickFrameCrafterBottom")).index;
        BrickLauncherTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickLauncherTop")).index;
        BrickLauncherSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickLauncherSide")).index;
        BrickLauncherBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Machines/BrickLauncherBottom")).index;

        IcyTerracotta = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/IcyTerracotta")).index;
        DenseIce = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/WorldGeneration/DenseIce")).index;

        WoodenBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/WoodenBricks")).index;
        StoneBricks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/StoneBricks")).index;

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

            DesertPotTop,
            DesertPotSide,
            DesertPotBottom,

            FrozenPotTop,
            FrozenPotSide,
            FrozenPotBottom,
            FrozenPotTopSealed,

            BrickFrameCrafterTopDusted,
            BrickFrameCrafterTop,
            BrickFrameCrafterSide,
            BrickFrameCrafterBottom,
            BrickLauncherTop,
            BrickLauncherSide,
            BrickLauncherBottom,

            IcyTerracotta,
            DenseIce,

            WoodenBricks,
            StoneBricks,

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
