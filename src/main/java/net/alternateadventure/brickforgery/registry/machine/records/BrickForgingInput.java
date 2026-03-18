package net.alternateadventure.brickforgery.registry.machine.records;

import java.util.Arrays;

public record BrickForgingInput(ComparableIdMeta[] inputs) {

    @Override
    public int hashCode() {
        return Arrays.hashCode(inputs);
    }
}
