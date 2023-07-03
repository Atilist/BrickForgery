package net.alternateadventure.brickforgery.tabs;


import net.alternateadventure.brickforgery.customrecipes.AlloySmeltingRecipeRegistry;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.guis.GUIAlloySmelter;
import net.glasslauncher.hmifabric.tabs.TabWithTexture;
import net.minecraft.block.BlockBase;
import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.recipe.RecipeRegistry;
import net.modificationstation.stationapi.api.recipe.FuelRegistry;
import net.modificationstation.stationapi.api.registry.ModID;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.alternateadventure.brickforgery.utils.ItemUtil.compare;

public class AlloySmeltingTab extends TabWithTexture {

    private static final Random RANDOM = new Random();
    protected List<ItemInstance[]> recipes;
    private final BlockBase tabBlock;
    private final List<ItemInstance[]> recipesReady;

    public AlloySmeltingTab(ModID tabCreator) {
        this(tabCreator, new ArrayList<ItemInstance[]>(AlloySmeltingRecipeRegistry.getInstance().getRecipes()), BlockListener.alloySmelter);
    }

    public AlloySmeltingTab(ModID tabCreator, List<ItemInstance[]> recipesReady, BlockBase tabBlock) {
        this(tabCreator, 5, recipesReady, tabBlock, "/assets/brickforgery/stationapi/textures/guitextures/alloysmelter.png", 118, 56, 28, 15);
    }

    public AlloySmeltingTab(ModID tabCreator, int slotsPerRecipe, List<ItemInstance[]> recipesReady, BlockBase tabBlock, String texturePath, int width, int height, int textureX, int textureY) {
        super(tabCreator, slotsPerRecipe, texturePath, width, height, 3, 4, textureX, textureY);
        this.recipesReady = recipesReady;
        this.tabBlock = tabBlock;
        recipes = new ArrayList<>();

        int xOffset = -28;
        int yOffset = -12;

        slots[0] = new Integer[] {38 + xOffset, 17 + yOffset};
        slots[3] = new Integer[] {56 + xOffset, 17 + yOffset};
        slots[4] = new Integer[] {74 + xOffset, 17 + yOffset};
        slots[1] = new Integer[] {56 + xOffset, 53 + yOffset};
        slots[2] = new Integer[] {116 + xOffset, 35 + yOffset};
    }

    @Override
    public ItemInstance[][] getItems(int index, ItemInstance filter) {
        ItemInstance[][] items = new ItemInstance[recipesPerPage][];
        for (int j = 0; j < recipesPerPage; j++) {
            items[j] = new ItemInstance[slots.length];
            int k = index + j;
            if (k < recipes.size()) try {
                ItemInstance[] recipe = recipes.get(k);
                items[j][0] = recipe[0];
                items[j][3] = recipe[1];
                items[j][4] = recipe[2];
                items[j][2] = recipe[3];
                ItemInstance[] fuels = FuelRegistry.getFuelsView().keySet().toArray(ItemInstance[]::new);
                items[j][1] = fuels[RANDOM.nextInt(fuels.length)];
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            if (items[j][0] == null && recipesOnThisPage > j) {
                recipesOnThisPage = j;
                redrawSlots = true;
                break;
            }
            if (items[j][0] != null && recipesOnThisPage == j) {
                recipesOnThisPage = j + 1;
                redrawSlots = true;
            }
        }
        return items;
    }

    @Override
    public void updateRecipes(ItemInstance filter, Boolean getUses) {
        recipes.clear();
        updateRecipesWithoutClear(filter, getUses);
    }

    public void updateRecipesWithoutClear(ItemInstance filter, Boolean getUses) {
        lastIndex = 0;
        recipesReady.forEach(recipe -> {
            ItemInstance input0 = recipe[0];
            ItemInstance input1 = recipe[1];
            ItemInstance input2 = recipe[2];
            ItemInstance output = recipe[3];
            if (filter == null || (!getUses && compare(filter, output)) || (getUses && compare(filter, input0)) || (getUses && compare(filter, input1)) || (getUses && compare(filter, input2))) {
                recipes.add(recipe);
            }
        });
        size = recipes.size();
    }

    @Override
    public Class<? extends ContainerBase> getGuiClass() {
        return GUIAlloySmelter.class;
    }

    @Override
    public ItemInstance getTabItem() {
        return new ItemInstance(tabBlock);
    }
}