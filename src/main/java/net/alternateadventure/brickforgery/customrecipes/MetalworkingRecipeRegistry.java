package net.alternateadventure.brickforgery.customrecipes;

import net.alternateadventure.brickforgery.utils.TieredMachineRecipeData;
import net.alternateadventure.brickforgery.wrappers.MetalworkingRecipe;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MetalworkingRecipeRegistry {
    private static final MetalworkingRecipeRegistry INSTANCE = new MetalworkingRecipeRegistry();
    private final Map<Object, Object> recipes = new HashMap<>();

    public static MetalworkingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addMetalworkingRecipe(int i, TieredMachineRecipeData arg) {
        this.recipes.put(i, arg);
    }

    public TieredMachineRecipeData getResult(int i) {
        return (TieredMachineRecipeData)this.recipes.get(i);
    }

    public ArrayList<MetalworkingRecipe> getRecipes() {
        ArrayList<MetalworkingRecipe> convertedRecipes = new ArrayList<>();
        ArrayList<ItemStack> inputs = new ArrayList<>();
        ArrayList<ItemStack> outputs = new ArrayList<>();

        for (Object obj : this.recipes.keySet()) {
            if (obj instanceof Integer) {
                inputs.add(new ItemStack((Integer) obj, 1, 0));
                TieredMachineRecipeData result = this.getResult((Integer) obj);
                outputs.add(result.output);
            }
        }

        for(int i = 0; i < inputs.size() && i < outputs.size(); ++i) {
            convertedRecipes.add(new MetalworkingRecipe(inputs.get(i), outputs.get(i)));
        }

        return convertedRecipes;
    }
}
