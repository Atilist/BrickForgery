package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.structures.*;
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
        int x;
        int y;
        int z;
        for (int attempts = 0; attempts < 8; attempts++) {
            x = event.x + event.random.nextInt(16);
            y = event.random.nextInt(36) + 12;
            z = event.z + event.random.nextInt(16);
            new BrickFrameCrafterRoom().generate(event.level, event.random, x, y, z);
        }
        if (event.biome == Biome.DESERT) {
            for (int attempts = 0; attempts < 4; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(48) + 64;
                z = event.z + event.random.nextInt(16);
                new DesertPotArea().generate(event.level, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.TUNDRA) {
            x = event.x + event.random.nextInt(16);
            y = event.random.nextInt(48) + 64;
            z = event.z + event.random.nextInt(16);
            new FrozenPotArea().generate(event.level, event.random, x, y, z);
        }
        if (event.biome == Biome.RAINFOREST) {
            for (int attempts = 0; attempts < 64; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(96) + 32;
                z = event.z + event.random.nextInt(16);
                new MossyPotArea().generate(event.level, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.PLAINS || event.biome == Biome.SHRUBLAND || event.biome == Biome.SAVANNA || event.biome == Biome.SWAMPLAND) {
            for (int attempts = 0; attempts < 4; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(48) + 64;
                z = event.z + event.random.nextInt(16);
                new ExoticShrubArea().generate(event.level, event.random, x, y, z);
            }
        }
    }
}