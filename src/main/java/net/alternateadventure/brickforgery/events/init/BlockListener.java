package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.blocks.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    public static BlockBase
            exoticShrub,
            nightWheatCrop,
            nightSapling,
            nightLog,
            nightLeaves,
            nightPlanks,

            desertPot,
            frozenPotSealed,
            frozenPot,
            mossyPot,

            brickFrameCrafterDusted,
            brickFrameCrafter,
            brickLauncher,

            clayPile,
            planksPile,

            woodenBricks,
            stoneBricks,

            dust,
            stoneBrickOre,

            brickCrop,

            brickSoil,
            brickSoilDepleted,

            spikeMount;

    public static LazyBlockTemplate
            potPedestal,
            bountifulSand,
            doublePlant,

            coalOreBricks,
            ironOreBricks,
            goldOreBricks,
            redstoneOreBricks,
            diamondOreBricks;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        exoticShrub = new ExoticShrub(Identifier.of(MOD_ID, "exotic_shrub"), Material.PLANT).setHardness(0.0F).setSounds(BlockBase.GRASS_SOUNDS).setTranslationKey(MOD_ID, "exotic_shrub");
        nightWheatCrop = new NightWheatCrop(Identifier.of(MOD_ID, "night_wheat_crop"), Material.PLANT).setHardness(0.0F).setSounds(BlockBase.GRASS_SOUNDS).setTranslationKey(MOD_ID, "night_wheat_crop");
        nightSapling = new NightSapling(Identifier.of(MOD_ID, "night_sapling"), Material.PLANT).setHardness(0.0F).setSounds(BlockBase.GRASS_SOUNDS).setTranslationKey(MOD_ID, "night_sapling");
        nightLog = new NightLog(Identifier.of(MOD_ID, "night_log"), Material.WOOD).setHardness(1.5F).setSounds(BlockBase.WOOD_SOUNDS).setTranslationKey(MOD_ID, "night_log");
        nightLeaves = new NightLeaves(Identifier.of(MOD_ID, "night_leaves"), Material.LEAVES).setHardness(0.5F).setSounds(BlockBase.GRASS_SOUNDS).setTranslationKey(MOD_ID, "night_leaves");
        nightPlanks = new NightPlanks(Identifier.of(MOD_ID, "night_planks"), Material.WOOD).setHardness(1.5F).setSounds(BlockBase.WOOD_SOUNDS).setTranslationKey(MOD_ID, "night_planks");
        doublePlant = new DoublePlant(Identifier.of(MOD_ID, "double_plant"), Material.PLANT, 0.0F, BlockBase.GRASS_SOUNDS);

        potPedestal = new LazyBlockTemplate(Identifier.of(MOD_ID, "pot_pedestal"), Material.WOOD, 1.5F, BlockBase.WOOD_SOUNDS);
        bountifulSand = new LazyBlockTemplate(Identifier.of(MOD_ID,  "bountiful_sand"), Material.SAND, 1.5F, BlockBase.SAND_SOUNDS);

        desertPot = new DesertPot(Identifier.of(MOD_ID, "desert_pot"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "desert_pot");
        frozenPotSealed = new FrozenPotSealed(Identifier.of(MOD_ID, "frozen_pot_sealed"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "frozen_pot_sealed");
        frozenPot = new FrozenPot(Identifier.of(MOD_ID, "frozen_pot"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "frozen_pot");
        mossyPot = new MossyPot(Identifier.of(MOD_ID, "mossy_pot"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "mossy_pot");

        brickFrameCrafterDusted = new BrickFrameCrafterDusted(Identifier.of(MOD_ID, "brick_frame_crafter_dusted"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "brick_frame_crafter_dusted");
        brickFrameCrafter = new BrickFrameCrafter(Identifier.of(MOD_ID, "brick_frame_crafter"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "brick_frame_crafter");
        brickLauncher = new BrickLauncher(Identifier.of(MOD_ID, "brick_launcher"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "brick_launcher");

        clayPile = new ResourcePile(Identifier.of(MOD_ID, "clay_pile"), Material.DIRT).setHardness(0.5F).setSounds(BlockBase.GRAVEL_SOUNDS).setTranslationKey(MOD_ID, "clay_pile");
        planksPile = new ResourcePile(Identifier.of(MOD_ID, "planks_pile"), Material.WOOD).setHardness(1.5F).setSounds(BlockBase.WOOD_SOUNDS).setTranslationKey(MOD_ID, "planks_pile");

        woodenBricks = new WoodenBricks(Identifier.of(MOD_ID, "wooden_bricks"), Material.WOOD).setHardness(1.5F).setSounds(BlockBase.WOOD_SOUNDS).setTranslationKey(MOD_ID, "wooden_bricks");
        stoneBricks = new StoneBricks(Identifier.of(MOD_ID, "stone_bricks"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "stone_bricks");

        dust = new Dust(Identifier.of(MOD_ID, "dust"), Material.SAND).setHardness(0.5F).setSounds(BlockBase.SAND_SOUNDS).setTranslationKey(MOD_ID, "dust");
        stoneBrickOre = new StoneBrickOre(Identifier.of(MOD_ID, "stone_brick_ore"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "stone_brick_ore");

        brickCrop = new BrickCrop(Identifier.of(MOD_ID, "brick_crop"), Material.PLANT).setHardness(0.5F).setSounds(BlockBase.GRASS_SOUNDS).setTranslationKey(MOD_ID, "brick_crop");

        brickSoil = new BrickSoil(Identifier.of(MOD_ID, "brick_soil"), Material.STONE).setHardness(0.5F).setSounds(BlockBase.STONE_SOUNDS).setTranslationKey(MOD_ID, "brick_soil");
        brickSoilDepleted = new BrickSoilDepleted(Identifier.of(MOD_ID, "brick_soil_depleted"), Material.SAND).setHardness(0.5F).setSounds(BlockBase.SAND_SOUNDS).setTranslationKey(MOD_ID, "brick_soil_depleted");

        spikeMount = new SpikeMount(Identifier.of(MOD_ID, "spike_mount"), Material.METAL).setHardness(1.5F).setSounds(BlockBase.METAL_SOUNDS).setTranslationKey(MOD_ID, "spike_mount");

        coalOreBricks = new CoalOreBricks(Identifier.of(MOD_ID, "coal_ore_bricks"), Material.STONE, 1.5F, BlockBase.STONE_SOUNDS);
        ironOreBricks = new IronOreBricks(Identifier.of(MOD_ID, "iron_ore_bricks"), Material.STONE, 1.5F, BlockBase.STONE_SOUNDS);
        goldOreBricks = new GoldOreBricks(Identifier.of(MOD_ID, "gold_ore_bricks"), Material.STONE, 1.5F, BlockBase.STONE_SOUNDS);
        redstoneOreBricks = new RedstoneOreBricks(Identifier.of(MOD_ID, "redstone_ore_bricks"), Material.STONE, 1.5F, BlockBase.STONE_SOUNDS);
        diamondOreBricks = new DiamondOreBricks(Identifier.of(MOD_ID, "diamond_ore_bricks"), Material.STONE, 1.5F, BlockBase.STONE_SOUNDS);
    }
}
