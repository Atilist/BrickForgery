package net.alternateadventure.brickforgery.customrecipes;

import net.minecraft.item.ItemInstance;

import java.util.ArrayList;

public class AlloySmeltingRecipeRegistry {
    private static final AlloySmeltingRecipeRegistry INSTANCE = new AlloySmeltingRecipeRegistry();
    private ArrayList<ItemInstance[]> inputsList = new ArrayList();

    // TODO: Cycling through a list is very inefficient, so this will be replaced later
    public static AlloySmeltingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public ItemInstance getResult(ItemInstance input1, ItemInstance input2, ItemInstance input3)
    {
        for (ItemInstance[] referenceInputs : inputsList) {
            if (referenceInputs == null) continue;
            if (input1 == null) continue;
            if (input2 == null) continue;
            if (input3 == null) continue;
            if (input1.isDamageAndIDIdentical(referenceInputs[0]) && input2.isDamageAndIDIdentical(referenceInputs[1]) && input3.isDamageAndIDIdentical(referenceInputs[2])) {
                return referenceInputs[3];
            }
        }
        return null;
    }

    public void addRecipe(ItemInstance input1, ItemInstance input2, ItemInstance input3, ItemInstance output)
    {
        inputsList.add(new ItemInstance[] {input1, input2, input3, output});
    }
}
