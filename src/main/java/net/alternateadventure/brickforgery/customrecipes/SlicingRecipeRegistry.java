package net.alternateadventure.brickforgery.customrecipes;

import net.alternateadventure.brickforgery.utils.TieredMachineRecipeData;
import net.minecraft.item.ItemInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SlicingRecipeRegistry {
    private static final SlicingRecipeRegistry INSTANCE = new SlicingRecipeRegistry();
    private Map recipes = new HashMap();

    public static final SlicingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addSlicingRecipe(int i, TieredMachineRecipeData arg) {
        this.recipes.put(i, arg);
    }

    public TieredMachineRecipeData getResult(int i) {
        return (TieredMachineRecipeData)this.recipes.get(i);
    }

    public ArrayList<ItemInstance[]> getRecipes() {
        ArrayList<ItemInstance[]> itemInstances = new ArrayList<>();
        ArrayList<ItemInstance> inputs = new ArrayList<>();
        ArrayList<ItemInstance> outputs = new ArrayList<>();
        for (Object obj : recipes.keySet()) {
            if (obj instanceof Integer)
            {
                inputs.add(new ItemInstance((Integer) obj, 1, 0));
                outputs.add(getResult((Integer) obj).output);
            }
        }
        for (int i = 0; i < inputs.size(); i++) {
            if (i >= outputs.size()) break;
            itemInstances.add(new ItemInstance[] {inputs.get(i), outputs.get(i)});
        }
        return itemInstances;
    }
}
