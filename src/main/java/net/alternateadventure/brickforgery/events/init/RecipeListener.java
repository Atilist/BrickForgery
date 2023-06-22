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
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.primitiveChisel), " X ", "#Y#", " Z ", 'X', new ItemInstance(ItemBase.goldIngot), 'Y', new ItemInstance(ItemBase.flint), 'Z', new ItemInstance(BlockListener.nightPlanks), '#', new ItemInstance(ItemBase.paper));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.primitiveGrabber), "#X#", " Y ", " Z ", 'X', new ItemInstance(ItemBase.diamond), 'Y', new ItemInstance(ItemBase.paper), 'Z', new ItemInstance(BlockListener.nightPlanks), '#', new ItemInstance(ItemBase.ironIngot));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.potPedestal), "XXX", "YZY", "YZY", 'X', new ItemInstance(ItemBase.feather), 'Y', new ItemInstance(BlockListener.nightLog), 'Z', new ItemInstance(BlockListener.nightPlanks));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.nightWoodBeam, 2), "YXY", " X ", "YXY", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemListener.leatherStrap));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.brickSteelBeam, 2), "YXY", " X ", "YXY", 'X', new ItemInstance(ItemListener.brickSteelIngot), 'Y', new ItemInstance(ItemListener.durableLeatherStrap));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveMachineFrame), "XYX", "Y Y", "XYX", 'X', new ItemInstance(ItemListener.goldenScrew), 'Y', new ItemInstance(ItemListener.nightWoodBeam));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveBrickFrameCrafter), "#Y#", "YZY", "XYX", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(BlockBase.BRICKS), 'Z', new ItemInstance(BlockListener.primitiveMachineFrame), '#', new ItemInstance(BlockBase.PISTON));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveSlicer), "#Y#", "YZY", "XYX", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(BlockBase.OBSIDIAN), 'Z', new ItemInstance(BlockListener.primitiveMachineFrame), '#', new ItemInstance(ItemBase.shears));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveMetalworkingStation), "#Y#", "YZY", "XYX", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(BlockBase.STONE_SLAB), 'Z', new ItemInstance(BlockListener.primitiveMachineFrame), '#', new ItemInstance(ItemBase.ironIngot));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.brickSteelMachineFrame), "XYX", "YZY", "XYX", 'X', new ItemInstance(ItemListener.bricksidianScrew), 'Y', new ItemInstance(ItemListener.brickSteelBeam), 'Z', new ItemInstance(BlockListener.primitiveMachineFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.slicer), "-#-", "+Z+", "XYX", 'X', new ItemInstance(ItemListener.hardenedBrickFrame), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.brickSteelMachineFrame), '#', new ItemInstance(BlockListener.primitiveSlicer), '+', new ItemInstance(ItemListener.stoneBrick), '-', new ItemInstance(ItemBase.diamond));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.metalworkingStation), "+#+", "YZY", "XYX", 'X', new ItemInstance(ItemListener.hardenedBrickFrame), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.brickSteelMachineFrame), '#', new ItemInstance(BlockListener.primitiveMetalworkingStation), '+', new ItemInstance(BlockListener.largeStoneBricks));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.brickFrameCrafter), "X#X", "YZY", "XYX", 'X', new ItemInstance(ItemListener.hardenedBrickFrame), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.brickSteelMachineFrame), '#', new ItemInstance(BlockListener.primitiveBrickFrameCrafter));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.alloySmelter), "###", "YZY", "XYX", 'X', new ItemInstance(BlockBase.BRICKS), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.brickSteelMachineFrame), '#', new ItemInstance(BlockBase.FURNACE));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyToolBase), "XXX", "YZY", "YZY", 'X', new ItemInstance(ItemListener.brickFrame), 'Y', new ItemInstance(BlockBase.BRICKS), 'Z', new ItemInstance(ItemListener.toolRepairKit));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.iceBlade), "XXX", "YZY", "YZY", 'X', new ItemInstance(ItemListener.dryBrickFrame), 'Y', new ItemInstance(BlockBase.SNOW_BLOCK), 'Z', new ItemInstance(ItemListener.toolRepairKit));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyToolBase), "X", "Y", 'X', new ItemInstance(ItemListener.dryBrickFrame), 'Y', new ItemInstance(ItemListener.brickCatalyst));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyBrush), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.primitiveBrush, 1, -1), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(ItemListener.archeologyToolBase));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyChisel), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.primitiveChisel, 1, -1), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(ItemListener.archeologyToolBase));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyIceKnife), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.iceBlade), 'Y', new ItemInstance(ItemListener.dryBrickFrame), 'Z', new ItemInstance(ItemListener.archeologyToolBase));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.woodenBricks), "XX", "XX", 'X', new ItemInstance(ItemListener.woodenBrick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.stoneBricks), "XX", "XX", 'X', new ItemInstance(ItemListener.stoneBrick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.largeStoneBricks, 4), "XY", "YX", 'X', new ItemInstance(ItemListener.stoneBrick), 'Y', new ItemInstance(BlockBase.STONE));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.largeStoneBricks, 4), "YX", "XY", 'X', new ItemInstance(ItemListener.stoneBrick), 'Y', new ItemInstance(BlockBase.STONE));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.fastBricks), "XXX", "YZY", 'X', new ItemInstance(ItemListener.exoticFruit), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(BlockBase.BRICKS));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.brickHammer), "XYX", " Z ", " Z ", 'X', new ItemInstance(ItemBase.brick), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(ItemListener.woodenBrick));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.brickLauncher), "XYX", "XZX", "XYX", 'X', new ItemInstance(BlockListener.stoneBricks), 'Y', new ItemInstance(BlockBase.PISTON), 'Z', new ItemInstance(BlockBase.DISPENSER));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.spikeMount), " X ", "XYX", "ZZZ", 'X', new ItemInstance(ItemBase.ironIngot), 'Y', new ItemInstance(ItemListener.brokenSpikeHolder), 'Z', new ItemInstance(ItemListener.dryBrickFrame));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.stick, 4), "X", "X", 'X', new ItemInstance(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockBase.WORKBENCH), "XX", "XX", 'X', new ItemInstance(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockBase.STONE_PRESSURE_PLATE), "XX", 'X', new ItemInstance(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockBase.CHEST), "XXX", "X X", "XXX", 'X', new ItemInstance(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.sign), "XXX", "XXX", " Y ", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.stick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.woodAxe), "XX", "XY", " Y", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.stick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.woodAxe), "XX", "YX", "Y ", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.stick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.woodHoe), "XX", " Y", " Y", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.stick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.woodHoe), "XX", "Y ", "Y ", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.stick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.woodPickaxe), "XXX", " Y ", " Y ", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.stick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.woodShovel), "X", "Y", "Y", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.stick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.woodSword), "X", "X", "Y", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.stick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockBase.STONE_SLAB, 3, 2), "XXX", 'X', new ItemInstance(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockBase.WOOD_STAIRS, 4), "X  ", "XX ", "XXX", 'X', new ItemInstance(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockBase.WOOD_STAIRS, 4), "  X", " XX", "XXX", 'X', new ItemInstance(BlockListener.nightPlanks));
        }
        // Output <- Input
        else if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.toolRepairKit, 8), new ItemInstance(ItemListener.nightWoodBeam), new ItemInstance(ItemListener.goldenScrew), new ItemInstance(ItemBase.paper));

            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.primitiveBrush), new ItemInstance(ItemListener.primitiveBrush, 1, -1), new ItemInstance(ItemListener.toolRepairKit));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.primitiveChisel), new ItemInstance(ItemListener.primitiveChisel, 1, -1), new ItemInstance(ItemListener.toolRepairKit));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.primitiveGrabber), new ItemInstance(ItemListener.primitiveGrabber, 1, -1), new ItemInstance(ItemListener.toolRepairKit));

            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.archeologyBrush), new ItemInstance(ItemListener.archeologyBrush, 1, -1), new ItemInstance(ItemListener.toolRepairKit));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.archeologyChisel), new ItemInstance(ItemListener.archeologyChisel, 1, -1), new ItemInstance(ItemListener.toolRepairKit));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.archeologyIceKnife), new ItemInstance(ItemListener.archeologyIceKnife, 1, -1), new ItemInstance(ItemListener.toolRepairKit));

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
            SmeltingRegistry.addSmeltingRecipe(BlockListener.nightLog.id, new ItemInstance(ItemBase.coal, 1, 1));
            SmeltingRegistry.addSmeltingRecipe(BlockListener.nightPlanks.id, new ItemInstance(BlockBase.WOOD));

            SmeltingRegistry.addSmeltingRecipe(BlockListener.woodenBricks.id, new ItemInstance(ItemListener.brickAsh));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.coalOreBrick.id, new ItemInstance(ItemBase.coal));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOreBrick.id, new ItemInstance(ItemBase.ironIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOreBrick.id, new ItemInstance(ItemBase.goldIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.redstoneOreBrick.id, new ItemInstance(ItemBase.redstoneDust, 4));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.diamondOreBrick.id, new ItemInstance(ItemBase.diamond));
        }
    }
}
