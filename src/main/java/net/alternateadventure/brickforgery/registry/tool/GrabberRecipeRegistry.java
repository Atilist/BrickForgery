package net.alternateadventure.brickforgery.registry.tool;

import net.alternateadventure.brickforgery.utils.TieredBlockLootingData;

import java.util.HashMap;
import java.util.Map;

public class GrabberRecipeRegistry {
    private static final GrabberRecipeRegistry INSTANCE = new GrabberRecipeRegistry();
    private final Map<Object, Object> recipes = new HashMap<>();

    public static GrabberRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addChiselingRecipe(int i, TieredBlockLootingData arg) {
        this.recipes.put(i, arg);
    }

    public TieredBlockLootingData getResult(int i) {
        return (TieredBlockLootingData)this.recipes.get(i);
    }
}
