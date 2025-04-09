package net.alternateadventure.brickforgery.registry.tool;

import net.alternateadventure.brickforgery.utils.TieredBlockConversionData;

import java.util.HashMap;
import java.util.Map;

public class BrushRecipeRegistry {
    private static final BrushRecipeRegistry INSTANCE = new BrushRecipeRegistry();
    private final Map<Object, Object> recipes = new HashMap<>();

    public static BrushRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addBrushingRecipe(int i, TieredBlockConversionData arg) {
        this.recipes.put(i, arg);
    }

    public TieredBlockConversionData getResult(int i) {
        return (TieredBlockConversionData)this.recipes.get(i);
    }
}
