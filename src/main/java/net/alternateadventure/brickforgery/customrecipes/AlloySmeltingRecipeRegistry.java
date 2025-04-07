package net.alternateadventure.brickforgery.customrecipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class AlloySmeltingRecipeRegistry {
    private static final AlloySmeltingRecipeRegistry INSTANCE = new AlloySmeltingRecipeRegistry();
    private final ArrayList<ItemStack[]> inputsList = new ArrayList<>();

    // TODO: Cycling through a list is very inefficient, so this will be replaced later
    public static AlloySmeltingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public ItemStack getResult(ItemStack input1, ItemStack input2, ItemStack input3) {
        for (ItemStack[] referenceInputs : inputsList) {
            if (referenceInputs == null) continue;
            if (input1 == null) continue;
            if (input2 == null) continue;
            if (input3 == null) continue;
            if (input1.isItemEqual(referenceInputs[0]) && input2.isItemEqual(referenceInputs[1]) && input3.isItemEqual(referenceInputs[2])) {
                return referenceInputs[3];
            }
        }
        return null;
    }

    public void addRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output) {
        inputsList.add(new ItemStack[] {input1, input2, input3, output});
    }

    public ArrayList<ItemStack[]> getRecipes() {
        return inputsList;
    }
}
