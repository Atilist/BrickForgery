package net.alternateadventure.brickforgery.customrecipes;

import net.minecraft.item.ItemInstance;

import java.util.ArrayList;

public class BrickFramingRecipeRegistry {
    private static final BrickFramingRecipeRegistry INSTANCE = new BrickFramingRecipeRegistry();
    private final ArrayList<ItemInstance[]> inputsList = new ArrayList<>();

    // TODO: Cycling through a list is very inefficient, so this will be replaced later
    public static BrickFramingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public ItemInstance getResult(ItemInstance inputItem, int[] inputIds) {
        for (ItemInstance[] referenceInputs : inputsList) {
            if (referenceInputs == null) continue;
            if (inputItem == null) continue;
            if (referenceInputs.length - 2 != inputIds.length) continue;
            if (!referenceInputs[0].isDamageAndIDIdentical(inputItem)) continue;
            boolean[] blocksMatching = new boolean[inputIds.length];
            for (int i = 1; i < referenceInputs.length - 1; i++) {
                for (int j = 0; j < inputIds.length; j++) {
                    if (referenceInputs[i].itemId == inputIds[j]) blocksMatching[j] = true;
                }
            }
            boolean allInputsMatching = true;
            for (int i = 0; i < blocksMatching.length; i++) {
                if (!blocksMatching[i]) {
                    allInputsMatching = false;
                    break;
                }
            }
            if (!allInputsMatching) continue;
            return referenceInputs[referenceInputs.length - 1];
        }
        return null;
    }

    public void addRecipe(ItemInstance inputItem, ItemInstance block1, ItemInstance block2, ItemInstance block3, ItemInstance block4, ItemInstance output) {
        inputsList.add(new ItemInstance[] {inputItem, block1, block2, block3, block4, output});
    }

    public ArrayList<ItemInstance[]> getRecipes() {
        return inputsList;
    }
}
