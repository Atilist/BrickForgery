package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.structures.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.OverworldDimension;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;

public class ChunkListener {

    @EventListener
    public void populate(WorldGenEvent.ChunkDecoration event) {
        if (event.world.dimension instanceof OverworldDimension) populateOverworld(event);
    }

    public void populateOverworld (WorldGenEvent.ChunkDecoration event) {
        int x;
        int y;
        int z;
        if (event.x > 512 || event.x < -512 || event.z > 512 || event.z < -512) {
            for (int attempts = 0; attempts < 8; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(36) + 12;
                z = event.z + event.random.nextInt(16);
                new FactoryRuinsFeature().generate(event.world, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.DESERT) {
            for (int attempts = 0; attempts < 4; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(48) + 64;
                z = event.z + event.random.nextInt(16);
                new DesertWellFeature().generate(event.world, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.TUNDRA) {
            for (int attempts = 0; attempts < 8; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(48) + 64;
                z = event.z + event.random.nextInt(16);
                new FrostVaultFeature().generate(event.world, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.RAINFOREST) {
            for (int attempts = 0; attempts < 64; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(96) + 32;
                z = event.z + event.random.nextInt(16);
                new MossyPotAreaFeature().generate(event.world, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.PLAINS || event.biome == Biome.SHRUBLAND || event.biome == Biome.SAVANNA || event.biome == Biome.SWAMPLAND || event.biome == Biome.TUNDRA) {
            for (int attempts = 0; attempts < 4; attempts++) {
                x = event.x + event.random.nextInt(16);
                y = event.random.nextInt(48) + 64;
                z = event.z + event.random.nextInt(16);
                new ExoticShrubAreaFeature().generate(event.world, event.random, x, y, z);
            }
        }
        if ((event.biome == Biome.FOREST || event.biome == Biome.SEASONAL_FOREST || event.biome == Biome.RAINFOREST || event.biome == Biome.TAIGA) && event.random.nextInt(4) == 0) {
            x = event.x + event.random.nextInt(16);
            y = event.random.nextInt(16) + 64;
            z = event.z + event.random.nextInt(16);
            new ForestVaultFeature().generate(event.world, event.random, x, y, z);
        }
    }
}