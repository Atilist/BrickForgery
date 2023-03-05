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
            desertPot,
            frozenPotSealed,
            frozenPot,

            brickFrameCrafterDusted,
            brickFrameCrafter,

            clayPile,
            planksPile,

            woodenBricks,

            dust,

            brickCrop,

            brickSoil,
            brickSoilDepleted;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        desertPot = new DesertPot(Identifier.of(MOD_ID, "desert_pot"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "desert_pot");
        frozenPotSealed = new FrozenPotSealed(Identifier.of(MOD_ID, "frozen_pot_sealed"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "frozen_pot_sealed");
        frozenPot = new FrozenPot(Identifier.of(MOD_ID, "frozen_pot"), Material.STONE).setHardness(1.0F).setTranslationKey(MOD_ID, "frozen_pot");

        brickFrameCrafterDusted = new BrickFrameCrafterDusted(Identifier.of(MOD_ID, "brick_frame_crafter_dusted"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "brick_frame_crafter_dusted");
        brickFrameCrafter = new BrickFrameCrafter(Identifier.of(MOD_ID, "brick_frame_crafter"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "brick_frame_crafter");

        clayPile = new ResourcePile(Identifier.of(MOD_ID, "clay_pile"), Material.DIRT).setHardness(0.5F).setSounds(BlockBase.GRAVEL_SOUNDS).setTranslationKey(MOD_ID, "clay_pile");
        planksPile = new ResourcePile(Identifier.of(MOD_ID, "planks_pile"), Material.WOOD).setHardness(1.5F).setSounds(BlockBase.WOOD_SOUNDS).setTranslationKey(MOD_ID, "planks_pile");

        woodenBricks = new WoodenBricks(Identifier.of(MOD_ID, "wooden_bricks"), Material.WOOD).setHardness(1.5F).setSounds(BlockBase.WOOD_SOUNDS).setTranslationKey(MOD_ID, "wooden_bricks");

        dust = new Dust(Identifier.of(MOD_ID, "dust"), Material.SAND).setHardness(0.5F).setSounds(BlockBase.SAND_SOUNDS).setTranslationKey(MOD_ID, "dust");

        brickCrop = new BrickCrop(Identifier.of(MOD_ID, "brick_crop"), Material.PLANT).setHardness(0.5F).setSounds(BlockBase.GRASS_SOUNDS).setTranslationKey(MOD_ID, "brick_crop");

        brickSoil = new BrickSoil(Identifier.of(MOD_ID, "brick_soil"), Material.STONE).setHardness(0.5F).setSounds(BlockBase.STONE_SOUNDS).setTranslationKey(MOD_ID, "brick_soil");
        brickSoilDepleted = new BrickSoilDepleted(Identifier.of(MOD_ID, "brick_soil_depleted"), Material.SAND).setHardness(0.5F).setSounds(BlockBase.SAND_SOUNDS).setTranslationKey(MOD_ID, "brick_soil_depleted");
    }
}
