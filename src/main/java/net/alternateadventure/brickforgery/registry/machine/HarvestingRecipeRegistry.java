package net.alternateadventure.brickforgery.registry.machine;

import net.alternateadventure.brickforgery.registry.machine.records.HarvestingInput;
import net.alternateadventure.brickforgery.registry.machine.records.HarvestingOutput;

import java.util.HashMap;
import java.util.Map;

public class HarvestingRecipeRegistry {
    private static final HarvestingRecipeRegistry INSTANCE = new HarvestingRecipeRegistry();
    private final Map<HarvestingInput, HarvestingOutput> recipes = new HashMap<>();

    public static HarvestingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addRecipe(HarvestingInput input, HarvestingOutput output) {
        this.recipes.put(input, output);
    }

    public HarvestingOutput getResult(int blockId, int blockMeta) {
        return this.recipes.get(new HarvestingInput(blockId, blockMeta));
    }

//    public ArrayList<SlicingRecipe> getRecipes() {
//        ArrayList<SlicingRecipe> convertedRecipes = new ArrayList<>();
//        ArrayList<ItemStack> inputs = new ArrayList<>();
//        ArrayList<ItemStack> outputs = new ArrayList<>();
//
//        for (Object obj : this.recipes.keySet()) {
//            if (obj instanceof Integer) {
//                inputs.add(new ItemStack((Integer) obj, 1, 0));
//                TieredMachineRecipeData result = this.getResult((Integer) obj);
//                outputs.add(result.output);
//            }
//        }
//
//        for(int i = 0; i < inputs.size() && i < outputs.size(); ++i) {
//            convertedRecipes.add(new SlicingRecipe(inputs.get(i), outputs.get(i)));
//        }
//
//        return convertedRecipes;
//    }
}
