package net.alternateadventure.brickforgery.registry.machine;

import net.alternateadventure.brickforgery.registry.machine.records.ComparableIdMeta;
import net.alternateadventure.brickforgery.registry.machine.records.IdMetaCount;
import net.alternateadventure.brickforgery.registry.machine.records.OutputAndInputs;
import net.alternateadventure.brickforgery.utils.TierEnum;
import net.alternateadventure.brickforgery.wrappers.BrickForgingRecipe;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BrickForgingRecipeRegistry {
    private static final BrickForgingRecipeRegistry INSTANCE = new BrickForgingRecipeRegistry();
    private final Map<Integer, OutputAndInputs> recipes = new HashMap<>();

    public static BrickForgingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public void addBrickForgingRecipe(IdMetaCount[] inputs, ItemStack output, TierEnum tier) {
        int inputLength = inputs.length;
        ComparableIdMeta[] rearrangedInputs = new ComparableIdMeta[inputLength];
        for (int i = 0; i < inputLength; i++) {
            rearrangedInputs[i] = new ComparableIdMeta(inputs[i].id(), inputs[i].meta());
        }
        Arrays.sort(rearrangedInputs);
        this.recipes.put(Arrays.hashCode(rearrangedInputs), new OutputAndInputs(output, inputs, tier));
    }

    public OutputAndInputs getResult(ComparableIdMeta[] inputs) {
        Arrays.sort(inputs);
        return this.recipes.get(Arrays.hashCode(inputs));
    }

    public ArrayList<BrickForgingRecipe> getRecipes() {
        ArrayList<BrickForgingRecipe> convertedRecipes = new ArrayList<>();
        ArrayList<ArrayList<ItemStack>> inputs = new ArrayList<>();
        ArrayList<OutputAndInputs> outputs = new ArrayList<>();

        for (Object obj : this.recipes.keySet()) {
            if (obj instanceof Integer recipeKey) {
                ArrayList<ItemStack> convertedRecipeInputs = new ArrayList<>();
                OutputAndInputs result = this.recipes.get(recipeKey);
                IdMetaCount[] completeInputs = result.inputs();
                for (int i = 0; i < completeInputs.length; i++) {
                    convertedRecipeInputs.add(new ItemStack(completeInputs[i].id(), completeInputs[i].count(), completeInputs[i].meta()));
                }
                inputs.add(convertedRecipeInputs);
                outputs.add(result);
            }
        }

        for(int i = 0; i < inputs.size() && i < outputs.size(); ++i) {
            convertedRecipes.add(new BrickForgingRecipe(inputs.get(i), outputs.get(i).output()));
        }

        return convertedRecipes;
    }
}
