package net.alternateadventure.brickforgery.items;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.template.item.TemplateSecondaryBlockItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class LazySecondaryBlockItem extends TemplateSecondaryBlockItem {
    public LazySecondaryBlockItem(Identifier identifier, Block tile) {
        super(identifier, tile);
        setTranslationKey(identifier.namespace, identifier.path);
    }
}
