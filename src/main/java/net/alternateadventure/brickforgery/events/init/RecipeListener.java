package net.alternateadventure.brickforgery.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        //Output <- Input
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyBrush), "X", "Y", "Z", 'X', new ItemInstance(ItemBase.wheat), 'Y', new ItemInstance(ItemBase.string), 'Z', new ItemInstance(ItemListener.archeologyToolBase));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyChisel), " X ", "#Y#", " Z ", 'X', new ItemInstance(ItemBase.goldIngot), 'Y', new ItemInstance(ItemBase.flint), 'Z', new ItemInstance(ItemListener.archeologyToolBase), '#', new ItemInstance(ItemListener.brickFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyIceKnife), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.iceBlade), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(ItemListener.archeologyToolBase));
        }
    }
}
