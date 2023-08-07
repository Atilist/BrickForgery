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
        if (event.x > 512 || event.x < -512 || event.z > 512 || event.z < -512) {
            for (int attempts = 0; attempts < 8; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(36) + 12;
                z = event.z + event.random.nextInt(16);
                new FactoryRuins().generate(event.level, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.DESERT) {
            for (int attempts = 0; attempts < 4; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(48) + 64;
                z = event.z + event.random.nextInt(16);
                new DesertPotArea().generate(event.level, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.DESERT) {
            for (int attempts = 0; attempts < 4; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(48) + 64;
                z = event.z + event.random.nextInt(16);
                new DesertWell().generate(event.level, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.TUNDRA) {
            for (int attempts = 0; attempts < 8; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(48) + 64;
                z = event.z + event.random.nextInt(16);
                new FrozenPotArea().generate(event.level, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.RAINFOREST) {
            for (int attempts = 0; attempts < 64; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(96) + 32;
                z = event.z + event.random.nextInt(16);
                new MossyPotArea().generate(event.level, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.PLAINS || event.biome == Biome.SHRUBLAND || event.biome == Biome.SAVANNA || event.biome == Biome.SWAMPLAND || event.biome == Biome.TUNDRA) {
            for (int attempts = 0; attempts < 4; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(48) + 64;
                z = event.z + event.random.nextInt(16);
                new ExoticShrubArea().generate(event.level, event.random, x, y, z);
            }
        }
        if ((event.biome == Biome.FOREST || event.biome == Biome.SEASONAL_FOREST || event.biome == Biome.RAINFOREST || event.biome == Biome.TAIGA) && event.random.nextInt(4) == 0) {
            x = event.x + event.random.nextInt(16);
            y = event.random.nextInt(16) + 64;
            z = event.z + event.random.nextInt(16);
            new ForestVault().generate(event.level, event.random, x, y, z);
        }
        /* I sometimes use this workspace to test structures for Aether Expansion. This code will be removed once the structure is finished.
        if (event.random.nextInt(8) == 0) {
            x = event.x + event.random.nextInt(16);
            y = 96;
            z = event.z + event.random.nextInt(16);
            new AetherArena().generate(event.level, event.random, x, y, z);
        }
         */
    }
}