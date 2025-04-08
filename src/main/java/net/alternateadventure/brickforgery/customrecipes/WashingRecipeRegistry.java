package net.alternateadventure.brickforgery.customrecipes;

import net.alternateadventure.brickforgery.utils.TierAndByproductOutput;
import net.alternateadventure.brickforgery.wrappers.WashingRecipe;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WashingRecipeRegistry {
    private static final WashingRecipeRegistry INSTANCE = new WashingRecipeRegistry();
    private final Map<Object, Object> recipes = new HashMap<>();

    public static WashingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addWashingRecipe(int i, TierAndByproductOutput arg) {
        this.recipes.put(i, arg);
    }

    public TierAndByproductOutput getResult(int i) {
        return (TierAndByproductOutput)this.recipes.get(i);
    }

    public ArrayList<WashingRecipe> getRecipes() {
        ArrayList<WashingRecipe> convertedRecipes = new ArrayList<>();
        ArrayList<ItemStack> inputs = new ArrayList<>();
        ArrayList<ItemStack[]> outputs = new ArrayList<>();

        for (Object obj : this.recipes.keySet()) {
            if (obj instanceof Integer) {
                inputs.add(new ItemStack((Integer) obj, 1, 0));
                TierAndByproductOutput result = this.getResult((Integer) obj);
                outputs.add(new ItemStack[]{result.tieredMachineRecipeData.output, result.byproduct});
            }
        }

        for(int i = 0; i < inputs.size() && i < outputs.size(); ++i) {
            convertedRecipes.add(new WashingRecipe(inputs.get(i), outputs.get(i)));
        }

        return convertedRecipes;
    }
}

