package net.alternateadventure.brickforgery.customrecipes;

import net.alternateadventure.brickforgery.utils.TierAndByproductOutput;
import net.alternateadventure.brickforgery.utils.TieredMachineRecipeData;
import net.minecraft.item.ItemInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CrushingRecipeRegistry {
    private static final CrushingRecipeRegistry INSTANCE = new CrushingRecipeRegistry();
    private Map recipes = new HashMap();

    public static final CrushingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addCrushingRecipe(int i, TierAndByproductOutput arg) {
        this.recipes.put(i, arg);
    }

    public TierAndByproductOutput getResult(int i) {
        return (TierAndByproductOutput)this.recipes.get(i);
    }

    public ArrayList<ItemInstance[]> getRecipes() {
        ArrayList<ItemInstance[]> itemInstances = new ArrayList<>();
        ArrayList<ItemInstance> inputs = new ArrayList<>();
        ArrayList<ItemInstance> outputs = new ArrayList<>();
        ArrayList<ItemInstance> byproducts = new ArrayList<>();
        for (Object obj : recipes.keySet()) {
            if (obj instanceof Integer)
            {
                inputs.add(new ItemInstance((Integer) obj, 1, 0));
                outputs.add(getResult((Integer) obj).tieredMachineRecipeData.output);
                byproducts.add(getResult((Integer) obj).byproduct);
            }
        }
        for (int i = 0; i < inputs.size(); i++) {
            if (i >= outputs.size()) break;
            itemInstances.add(new ItemInstance[] {inputs.get(i), outputs.get(i), byproducts.get(i)});
        }
        return itemInstances;
    }
}
