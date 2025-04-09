package net.alternateadventure.brickforgery.items;

import net.alternateadventure.brickforgery.utils.TierEnum;
import net.modificationstation.stationapi.api.util.Identifier;

public class ArchaeologyToolTemplate extends LazyItemTemplate {
    protected final TierEnum tier;

    public ArchaeologyToolTemplate(Identifier identifier, int durability, TierEnum tier) {
        super(identifier);
        this.maxCount = 1;
        this.setMaxDamage(durability);
        this.tier = tier;
    }
}
