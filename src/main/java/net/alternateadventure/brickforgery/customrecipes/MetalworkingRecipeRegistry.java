package net.alternateadventure.brickforgery.customrecipes;

import net.alternateadventure.brickforgery.utils.TieredMachineRecipeData;
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

    public ArrayList<ItemStack[]> getRecipes() {
        ArrayList<ItemStack[]> ItemStacks = new ArrayList<>();
        ArrayList<ItemStack> inputs = new ArrayList<>();
        ArrayList<ItemStack> outputs = new ArrayList<>();
        for (Object obj : recipes.keySet()) {
            if (obj instanceof Integer)
            {
                inputs.add(new ItemStack((Integer) obj, 1, 0));
                outputs.add(getResult((Integer) obj).output);
            }
        }
        for (int i = 0; i < inputs.size(); i++) {
            if (i >= outputs.size()) break;
            ItemStacks.add(new ItemStack[] {inputs.get(i), outputs.get(i)});
        }
        return ItemStacks;
    }
}
