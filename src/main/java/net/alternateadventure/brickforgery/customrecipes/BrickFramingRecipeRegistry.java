package net.alternateadventure.brickforgery.customrecipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class BrickFramingRecipeRegistry {
    private static final BrickFramingRecipeRegistry INSTANCE = new BrickFramingRecipeRegistry();
    private final ArrayList<ItemStack[]> inputsList = new ArrayList<>();

    // TODO: Cycling through a list is very inefficient, so this will be replaced later
    public static BrickFramingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public ItemStack getResult(ItemStack inputItem, int[] inputIds) {
        for (ItemStack[] referenceInputs : inputsList) {
            if (referenceInputs == null) continue;
            if (inputItem == null) continue;
            if (referenceInputs.length - 2 != inputIds.length) continue;
            if (!referenceInputs[0].isItemEqual(inputItem)) continue;
            boolean[] blocksMatching = new boolean[inputIds.length];
            for (int i = 1; i < referenceInputs.length - 1; i++) {
                for (int j = 0; j < inputIds.length; j++) {
                    if (referenceInputs[i].itemId == inputIds[j]) blocksMatching[j] = true;
                }
            }
            boolean allInputsMatching = true;
            for (boolean b : blocksMatching) {
                if (!b) {
                    allInputsMatching = false;
                    break;
                }
            }
            if (!allInputsMatching) continue;
            return referenceInputs[referenceInputs.length - 1];
        }
        return null;
    }

    public void addRecipe(ItemStack inputItem, ItemStack block1, ItemStack block2, ItemStack block3, ItemStack block4, ItemStack output) {
        inputsList.add(new ItemStack[] {inputItem, block1, block2, block3, block4, output});
    }

    public ArrayList<ItemStack[]> getRecipes() {
        return inputsList;
    }
}
