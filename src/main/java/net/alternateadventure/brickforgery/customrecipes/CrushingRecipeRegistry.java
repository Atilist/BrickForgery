package net.alternateadventure.brickforgery.customrecipes;

import net.alternateadventure.brickforgery.utils.TierAndByproductOutput;
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

    public ArrayList<ItemStack[]> getRecipes() {
        ArrayList<ItemStack[]> ItemStacks = new ArrayList<>();
        ArrayList<ItemStack> inputs = new ArrayList<>();
        ArrayList<ItemStack> outputs = new ArrayList<>();
        ArrayList<ItemStack> byproducts = new ArrayList<>();
        for (Object obj : recipes.keySet()) {
            if (obj instanceof Integer)
            {
                inputs.add(new ItemStack((Integer) obj, 1, 0));
                outputs.add(getResult((Integer) obj).tieredMachineRecipeData.output);
                byproducts.add(getResult((Integer) obj).byproduct);
            }
        }
        for (int i = 0; i < inputs.size(); i++) {
            if (i >= outputs.size()) break;
            ItemStacks.add(new ItemStack[] {inputs.get(i), outputs.get(i), byproducts.get(i)});
        }
        return ItemStacks;
    }
}
