package net.alternateadventure.brickforgery.registry.machine.records;

import org.jetbrains.annotations.NotNull;

public record ComparableIdMeta(int id, int meta) implements Comparable<ComparableIdMeta> {

    @Override
    public int compareTo(@NotNull ComparableIdMeta o) {
        if (o.id < this.id) {
            return -1;
        } else if (o.id > this.id) {
            return 1;
        }
        if (o.meta < this.meta) {
            return -1;
        } else if (o.meta > this.meta) {
            return 1;
        }
        return 0;
    }
}
