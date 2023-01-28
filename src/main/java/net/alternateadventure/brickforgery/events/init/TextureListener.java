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
        ItemListener.archeologyToolBase.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyToolBase"));
        ItemListener.archeologyBrush.setTexture(Identifier.of(MOD_ID, "ExplorationFeatures/ArcheologyTools/ArcheologyBrush"));
        ItemListener.brickFrame.setTexture(Identifier.of(MOD_ID, "MaterialProcessing/Materials/BrickFrame"));

        DesertPotTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotTop")).index;
        DesertPotSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotSide")).index;
        DesertPotBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Pots/DesertPotBottom")).index;

        BrickFrameCrafterTopDusted = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Machines/BrickFrameCrafterTopDusted")).index;
        BrickFrameCrafterTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Machines/BrickFrameCrafterTop")).index;
        BrickFrameCrafterSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Machines/BrickFrameCrafterSide")).index;
        BrickFrameCrafterBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ExplorationFeatures/Machines/BrickFrameCrafterBottom")).index;
    }

    public static int
            DesertPotTop,
            DesertPotSide,
            DesertPotBottom,

            BrickFrameCrafterTopDusted,
            BrickFrameCrafterTop,
            BrickFrameCrafterSide,
            BrickFrameCrafterBottom;
}
