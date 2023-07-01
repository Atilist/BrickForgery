package net.alternateadventure.brickforgery.utils;

public class ValueConverter {

    public static int[] rotationToCoordinateOffset(int rotation)
    {
        int[] offsets = new int[2];

        switch (rotation) {
            case 0 -> offsets[1] = -1;
            case 1 -> offsets[0] = 1;
            case 2 -> offsets[1] = 1;
            case 3 -> offsets[0] = -1;
        }

        return offsets;
    }

}
