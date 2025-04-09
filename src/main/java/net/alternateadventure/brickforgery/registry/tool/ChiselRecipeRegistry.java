package net.alternateadventure.brickforgery.registry.tool;

import net.alternateadventure.brickforgery.utils.TieredBlockConversionData;

import java.util.HashMap;
import java.util.Map;

public class ChiselRecipeRegistry {
    private static final ChiselRecipeRegistry INSTANCE = new ChiselRecipeRegistry();
    private final Map<Object, Object> recipes = new HashMap<>();

    public static ChiselRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addChiselingRecipe(int i, TieredBlockConversionData arg) {
        this.recipes.put(i, arg);
    }

    public TieredBlockConversionData getResult(int i) {
        return (TieredBlockConversionData)this.recipes.get(i);
    }
}
