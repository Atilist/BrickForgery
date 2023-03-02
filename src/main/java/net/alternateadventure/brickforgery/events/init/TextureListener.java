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
        ItemListener.archeologyBrush.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyBrush"));
        ItemListener.archeologyChisel.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyChisel"));
        ItemListener.archeologyIceKnife.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyIceKnife"));

        ItemListener.archeologyToolBase.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyToolBase"));
        ItemListener.iceBlade.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/LootItems/IceBlade"));

        ItemListener.brickFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickFrame"));

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
    }

    public static int
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
            BrickFrameCrafterBottom;
}
