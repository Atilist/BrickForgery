package net.alternateadventure.brickforgery.registry.machine;

import net.alternateadventure.brickforgery.util.TierEnum;
import net.alternateadventure.brickforgery.util.TieredBrickFramingRecipe;
import net.alternateadventure.brickforgery.wrapper.BrickFramingRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class BrickFramingRecipeRegistry {
    private static final BrickFramingRecipeRegistry INSTANCE = new BrickFramingRecipeRegistry();
    private final ArrayList<TieredBrickFramingRecipe> inputsList = new ArrayList<>();

    // TODO: Cycling through a list is very inefficient, so this will be replaced later
    public static BrickFramingRecipeRegistry getInstance() {
        return INSTANCE;
    }

    public ItemStack getResult(ItemStack inputItem, int[] inputIds, TierEnum machineTier) {
        for (TieredBrickFramingRecipe referenceInputs : inputsList) {
            if (referenceInputs == null) continue;
            if (inputItem == null) break;
            if (machineTier.ordinal() < referenceInputs.tier().ordinal()) continue;
            if (!referenceInputs.inputItem().isItemEqual(inputItem)) continue;
            boolean[] blocksMatching = new boolean[inputIds.length];
            int[] referenceBlocks = new int[4];
            referenceBlocks[0] = referenceInputs.block1();
            referenceBlocks[1] = referenceInputs.block2();
            referenceBlocks[2] = referenceInputs.block3();
            referenceBlocks[3] = referenceInputs.block4();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < inputIds.length; j++) {
                    if (referenceBlocks[i] == inputIds[j]) blocksMatching[j] = true;
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
            return referenceInputs.output();
        }
        return null;
    }

    public void addRecipe(ItemStack inputItem, int block1, int block2, int block3, int block4, ItemStack output, TierEnum tier) {
        inputsList.add(new TieredBrickFramingRecipe(inputItem, block1, block2, block3, block4, output, tier));
    }

    public ArrayList<BrickFramingRecipe> getRecipes() {
        ArrayList<BrickFramingRecipe> convertedRecipes = new ArrayList<>();
        for (TieredBrickFramingRecipe tieredBrickFramingRecipe : inputsList) {
            BrickFramingRecipe brickFramingRecipe = new BrickFramingRecipe(new ItemStack[]{tieredBrickFramingRecipe.inputItem(),
                    new ItemStack(Block.BLOCKS[tieredBrickFramingRecipe.block1()].asItem()),
                    new ItemStack(Block.BLOCKS[tieredBrickFramingRecipe.block2()].asItem()),
                    new ItemStack(Block.BLOCKS[tieredBrickFramingRecipe.block3()].asItem()),
                    new ItemStack(Block.BLOCKS[tieredBrickFramingRecipe.block4()].asItem())},
                    tieredBrickFramingRecipe.output(),
                    tieredBrickFramingRecipe.tier());
            convertedRecipes.add(brickFramingRecipe);
        }
        return convertedRecipes;
    }
}
