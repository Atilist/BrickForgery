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
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.primitiveBrush), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.nightWheat), 'Y', new ItemInstance(ItemBase.paper), 'Z', new ItemInstance(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.potPedestal), "XXX", "YZY", "YZY", 'X', new ItemInstance(ItemBase.feather), 'Y', new ItemInstance(BlockListener.nightLog), 'Z', new ItemInstance(BlockListener.nightPlanks));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyToolBase), "X", "Y", 'X', new ItemInstance(ItemListener.dryBrickFrame), 'Y', new ItemInstance(ItemListener.brickCatalyst));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyBrush), " X ", "ZYZ", 'X', new ItemInstance(ItemListener.primitiveBrush), 'Y', new ItemInstance(ItemListener.archeologyToolBase), 'Z', new ItemInstance(ItemBase.string));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyChisel), " X ", "#Y#", " Z ", 'X', new ItemInstance(ItemBase.goldIngot), 'Y', new ItemInstance(ItemBase.flint), 'Z', new ItemInstance(ItemListener.archeologyToolBase), '#', new ItemInstance(ItemListener.brickFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyIceKnife), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.iceBlade), 'Y', new ItemInstance(ItemListener.dryBrickFrame), 'Z', new ItemInstance(ItemListener.archeologyToolBase));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.woodenBricks), "XX", "XX", 'X', new ItemInstance(ItemListener.woodenBrick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.stoneBricks), "XX", "XX", 'X', new ItemInstance(ItemListener.stoneBrick));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.brickHammer), "XYX", " Z ", " Z ", 'X', new ItemInstance(ItemBase.brick), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(ItemListener.woodenBrick));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.brickLauncher), "XYX", "XZX", "XYX", 'X', new ItemInstance(BlockListener.stoneBricks), 'Y', new ItemInstance(BlockBase.PISTON), 'Z', new ItemInstance(BlockBase.DISPENSER));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.spikeMount), " X ", "XYX", "ZZZ", 'X', new ItemInstance(ItemBase.ironIngot), 'Y', new ItemInstance(ItemListener.brokenSpikeHolder), 'Z', new ItemInstance(ItemListener.dryBrickFrame));
        }
        // Output <- Input
        else if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.dryBrickFrame), new ItemInstance(ItemListener.brickFrame), new ItemInstance(ItemListener.brickAsh), new ItemInstance(ItemListener.brickCatalyst));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemBase.clay), new ItemInstance(ItemListener.clayPowder), new ItemInstance(ItemListener.snowBrick));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.nightSeeds), new ItemInstance(ItemListener.exoticFruit), new ItemInstance(ItemBase.seeds));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.nightSapling), new ItemInstance(ItemListener.exoticFruit), new ItemInstance(BlockBase.SAPLING, 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.nightPlanks, 4), new ItemInstance(BlockListener.nightLog));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.nightSeeds), new ItemInstance(ItemListener.nightWheat));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.exoticCatalyst), new ItemInstance(ItemListener.brickCatalyst), new ItemInstance(ItemListener.exoticFruit));
        }
        // Input -> Output
        else if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(BlockListener.woodenBricks.id, new ItemInstance(ItemListener.brickAsh));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.coalOreBrick.id, new ItemInstance(ItemBase.coal));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOreBrick.id, new ItemInstance(ItemBase.ironIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOreBrick.id, new ItemInstance(ItemBase.goldIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.redstoneOreBrick.id, new ItemInstance(ItemBase.redstoneDust, 4));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.diamondOreBrick.id, new ItemInstance(ItemBase.diamond));
        }
    }
}
