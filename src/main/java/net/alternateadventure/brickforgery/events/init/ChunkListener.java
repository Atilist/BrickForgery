package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.structures.BrickFrameCrafterRoom;
import net.alternateadventure.brickforgery.structures.DesertPotArea;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.dimension.Overworld;
import net.modificationstation.stationapi.api.event.level.gen.LevelGenEvent;

public class ChunkListener {

    @EventListener
    public void populate(LevelGenEvent.ChunkDecoration event) {
        if (event.level.dimension instanceof Overworld) populateOverworld(event);
    }

    public void populateOverworld (LevelGenEvent.ChunkDecoration event) {
        int randomChance = event.random.nextInt(16);
        if (randomChance == 0) {
            int x = event.x + event.random.nextInt(16);
            int y = event.random.nextInt(16) + 24;
            int z = event.z + event.random.nextInt(16);
            new BrickFrameCrafterRoom().generate(event.level, event.random, x, y, z);
        }
        if (event.biome == Biome.DESERT) {
            int x = event.x + event.random.nextInt(16);
            int y = event.random.nextInt(48) + 64;
            int z = event.z + event.random.nextInt(16);
            new DesertPotArea().generate(event.level, event.random, x, y, z);
        }
    }
}