package net.alternateadventure.brickforgery.customrecipes;

import net.alternateadventure.brickforgery.utils.TieredMachineRecipeData;
import net.alternateadventure.brickforgery.wrappers.MetalworkingRecipe;
import net.alternateadventure.brickforgery.wrappers.SlicingRecipe;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SlicingRecipeRegistry {
    private static final SlicingRecipeRegistry INSTANCE = new SlicingRecipeRegistry();
    private final Map<Object, Object> recipes = new HashMap<>();

    public static SlicingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addSlicingRecipe(int i, TieredMachineRecipeData arg) {
        this.recipes.put(i, arg);
    }

    public TieredMachineRecipeData getResult(int i) {
        return (TieredMachineRecipeData)this.recipes.get(i);
    }

    public ArrayList<SlicingRecipe> getRecipes() {
        ArrayList<SlicingRecipe> convertedRecipes = new ArrayList<>();
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
            convertedRecipes.add(new SlicingRecipe(inputs.get(i), outputs.get(i)));
        }

        return convertedRecipes;
    }
}
