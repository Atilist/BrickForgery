package net.alternateadventure.brickforgery.registry.machine.records;

import org.jetbrains.annotations.NotNull;

public record IdMetaCount(int id, int meta, int count) implements Comparable<IdMetaCount> {

    @Override
    public int compareTo(@NotNull IdMetaCount o) {
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
        if (o.count < this.count) {
            return -1;
        } else if (o.count > this.count) {
            return 1;
        }
        return 0;
    }
}
