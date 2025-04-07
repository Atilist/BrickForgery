package net.alternateadventure.brickforgery.customrecipes;

import net.alternateadventure.brickforgery.utils.TierAndByproductOutput;
import net.alternateadventure.brickforgery.wrappers.CrushingRecipe;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CrushingRecipeRegistry {
    private static final CrushingRecipeRegistry INSTANCE = new CrushingRecipeRegistry();
    private final Map<Object, Object> recipes = new HashMap<>();

    public static CrushingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addCrushingRecipe(int i, TierAndByproductOutput arg) {
        this.recipes.put(i, arg);
    }

    public TierAndByproductOutput getResult(int i) {
        return (TierAndByproductOutput)this.recipes.get(i);
    }

    public ArrayList<CrushingRecipe> getRecipes() {
        ArrayList<CrushingRecipe> convertedRecipes = new ArrayList<>();
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
            convertedRecipes.add(new CrushingRecipe(inputs.get(i), outputs.get(i)));
        }

        return convertedRecipes;
    }
}
