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

        // Output <- Input
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyBrush), "X", "Y", "Z", 'X', new ItemInstance(ItemBase.wheat), 'Y', new ItemInstance(ItemBase.string), 'Z', new ItemInstance(ItemListener.archeologyToolBase));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyChisel), " X ", "#Y#", " Z ", 'X', new ItemInstance(ItemBase.goldIngot), 'Y', new ItemInstance(ItemBase.flint), 'Z', new ItemInstance(ItemListener.archeologyToolBase), '#', new ItemInstance(ItemListener.brickFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyIceKnife), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.iceBlade), 'Y', new ItemInstance(ItemListener.dryBrickFrame), 'Z', new ItemInstance(ItemListener.archeologyToolBase));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.woodenBricks), "XX", "XX", 'X', new ItemInstance(ItemListener.woodenBrick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.stoneBricks), "XX", "XX", 'X', new ItemInstance(ItemListener.stoneBrick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.brickHammer), "XYX", " Z ", " Z ", 'X', new ItemInstance(ItemBase.brick), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(ItemListener.woodenBrick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyToolBase), "X", "Y", 'X', new ItemInstance(ItemListener.dryBrickFrame), 'Y', new ItemInstance(ItemListener.brickCatalyst));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.brickLauncher), "XYX", "XZX", "XYX", 'X', new ItemInstance(BlockListener.stoneBricks), 'Y', new ItemInstance(BlockBase.PISTON), 'Z', new ItemInstance(BlockBase.DISPENSER));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.spikeMount), " X ", "XYX", "ZZZ", 'X', new ItemInstance(ItemBase.ironIngot), 'Y', new ItemInstance(ItemListener.brokenSpikeHolder), 'Z', new ItemInstance(ItemListener.dryBrickFrame));
        }
        // Output <- Input
        else if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.dryBrickFrame), new ItemInstance(ItemListener.brickFrame), new ItemInstance(ItemListener.brickAsh), new ItemInstance(ItemListener.brickCatalyst));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemBase.clay), new ItemInstance(ItemListener.clayPowder), new ItemInstance(ItemListener.snowBrick));
        }
        // Input -> Output
        else if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(BlockListener.woodenBricks.id, new ItemInstance(ItemListener.brickAsh));
        }
    }
}
