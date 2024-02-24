package net.alternateadventure.brickforgery.structures;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public class AetherArena {

    public void generate(Level level, Random rand, int x, int y, int z) {
        int scale = 0;
        buildOctagon(level, rand, x, y, z, 7 + scale, 0, 2, 3, false);
        buildOctagon(level, rand, x, y + 4, z, 9 + scale, 7 + scale, 2, 3, false);
        for (int wallHeight = 0; wallHeight < 4; wallHeight++) {
            buildOctagon(level, rand, x, y + wallHeight, z, 8 + scale, 7 + scale, 2, 3, true);
        }
        buildStaircase(level, rand, x + 10 + scale, y + 4, z, 0, 4, 4);
        buildStaircase(level, rand, x - 10 - scale, y + 4, z, 1, 4, 4);
        buildStaircase(level, rand, x, y + 4, z + 10 + scale, 2, 4, 4);
        buildStaircase(level, rand, x, y + 4, z - 10 - scale, 3, 4, 4);

        int inverter = -1;
        int rotator = 1;
        int rotation = rand.nextInt(4);
        switch (rotation)
        {
            case 0:
                break;
            case 1:
                inverter = 1;
                break;
            case 2:
                rotator = 0;
                break;
            case 3:
                rotator = 0;
                inverter = 1;
                break;
        }
        for (int height = 0; height < 3; height++) {
            level.setTile(x + (8 + scale) * (rotator * inverter) + 1 - rotator, y + 1 + height, z + (8 + scale) * ((1 - rotator) * inverter) - rotator, 0);
            level.setTile(x + (8 + scale) * (rotator * inverter), y + 1 + height, z + (8 + scale) * ((1 - rotator) * inverter), 0);
            level.setTile(x + (8 + scale) * (rotator * inverter) - 1 + rotator, y + 1 + height, z + (8 + scale) * ((1 - rotator) * inverter) + rotator, 0);
        }
        buildStaircase(level, rand, x + (13 + scale) * (rotator * inverter), y - 6, z + (13 + scale) * ((1 - rotator) * inverter), rotation, 1, 6);
    }

    private void buildOctagon(Level level, Random random, int x, int y, int z, int radius, int innerRadius, int upperFraction, int lowerFraction, boolean isWall)
    {
        for (int xOffset = -radius; xOffset <= radius; xOffset++) {
            for (int zOffset = -radius; zOffset <= radius; zOffset++) {
                int xRadius = xOffset;
                if (xRadius < 0) xRadius *= -1;
                int zRadius = zOffset;
                if (zRadius < 0) zRadius *= -1;
                if ((xRadius + zRadius) * upperFraction < innerRadius * lowerFraction && !(xRadius > innerRadius || zRadius > innerRadius)) continue;
                if ((xRadius + zRadius) * upperFraction > radius * lowerFraction) continue;
                if (isWall) level.setTile(x + xOffset, y, z + zOffset, BlockBase.GOLD_BLOCK.id);
                else level.setTile(x + xOffset, y, z + zOffset, getRandomBlockID(random));
            }
        }
    }

    /**
     * Generates a staircase into a specific direction.
     * @param rotation This parameter can be set to have a value ranging between 0 and 3. The value determines the direction the staircase generates into. 0 is positive x. 1 is negative x. 2 is positive z. 3 is negative z.
     */
    private void buildStaircase(Level level, Random random, int x, int y, int z, int rotation, int width, int length)
    {
        int xLength = 0;
        int zLength = 0;
        int xWidth = 0;
        int zWidth = 0;
        switch (rotation)
        {
            case 0:
                xLength = 1;
                zWidth = 1;
                break;
            case 1:
                xLength = -1;
                zWidth = 1;
                break;
            case 2:
                zLength = 1;
                xWidth = 1;
                break;
            case 3:
                zLength = -1;
                xWidth = 1;
                break;
        }
        for (int step = 0; step < length; step++) {
            for (int sideOffset = -width; sideOffset <= width; sideOffset++) {
                level.setTile(x + step * xLength + sideOffset * xWidth, y + step, z + step * zLength + sideOffset * zWidth, getRandomLowerStairID(random));
                if (random.nextInt(16) != 0) level.setTileWithMetadata(x + step * xLength + sideOffset * xWidth, y + step + 1, z + step * zLength + sideOffset * zWidth, getRandomUpperStairID(random), rotation);
            }
        }
    }

    private int getRandomBlockID(Random random)
    {
        if (random.nextInt(16) == 0) return 0;
        if (random.nextInt(16) == 0) return BlockBase.MOSSY_COBBLESTONE.id;
        if (random.nextInt(16) == 0) return BlockBase.STONE_SLAB.id;
        return BlockBase.COBBLESTONE.id;
    }

    private int getRandomLowerStairID(Random random)
    {
        if (random.nextInt(16) == 0) return 0;
        if (random.nextInt(16) == 0) return BlockBase.MOSSY_COBBLESTONE.id;
        return BlockBase.COBBLESTONE.id;
    }

    private int getRandomUpperStairID(Random random)
    {
        if (random.nextInt(16) == 0) return BlockBase.WOOD_STAIRS.id;
        return BlockBase.COBBLESTONE_STAIRS.id;
    }
}
