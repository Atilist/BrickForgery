package net.alternateadventure.brickforgery.items;

import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class ArcheologyIceKnife extends TemplateItemBase {

    public ArcheologyIceKnife(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
        this.setDurability(256);
    }
}
