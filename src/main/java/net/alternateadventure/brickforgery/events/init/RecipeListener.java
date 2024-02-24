package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.customrecipes.*;
import net.alternateadventure.brickforgery.utils.TierAndByproductOutput;
import net.alternateadventure.brickforgery.utils.TieredMachineRecipeData;
import net.kozibrodka.wolves.modsupport.HibachiIgnitionRegistry;
import net.kozibrodka.wolves.recipe.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;
        // Output <- Input
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.primitiveBrush), "-X-", "+Y+", "#Z#", 'X', new ItemInstance(ItemListener.nightWheat), 'Y', new ItemInstance(ItemBase.paper), 'Z', new ItemInstance(ItemListener.denseNightWood), '#', new ItemInstance(ItemListener.leatherStrap), '+', new ItemInstance(ItemListener.goldenScrew), '-', new ItemInstance(ItemListener.concentratedFortune));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.primitiveChisel), "-X-", "#Y#", "+Z+", 'X', new ItemInstance(ItemBase.goldIngot), 'Y', new ItemInstance(ItemBase.flint), 'Z', new ItemInstance(ItemListener.denseNightWood), '#', new ItemInstance(ItemBase.paper), '+', new ItemInstance(ItemListener.leatherStrap), '-', new ItemInstance(ItemListener.concentratedFortune));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.primitiveGrabber), "-X-", "#Y#", "+Z+", 'X', new ItemInstance(ItemBase.diamond), 'Y', new ItemInstance(ItemBase.paper), 'Z', new ItemInstance(ItemListener.denseNightWood), '#', new ItemInstance(ItemBase.ironIngot), '+', new ItemInstance(net.kozibrodka.wolves.events.ItemListener.hempCloth), '-', new ItemInstance(ItemListener.concentratedFortune));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.nightWoodBeam, 2), "XY ", "YZY", " YX", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemListener.leatherStrap), 'Z', new ItemInstance(ItemListener.denseNightWood));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.exoticKey), "YYX", "ZZ ", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemListener.denseNightWood), 'Z', new ItemInstance(ItemListener.exoticFruit));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.desertKey), "YYX", "ZZ ", 'X', new ItemInstance(BlockBase.SANDSTONE), 'Y', new ItemInstance(ItemListener.illuminantCrystal), 'Z', new ItemInstance(ItemListener.fortunePowder));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.improvedMillstone), "Z+Z", "X#X", "XYX", 'X', new ItemInstance(ItemListener.denseNightWood), 'Y', new ItemInstance(ItemListener.woodenFrame), 'Z', new ItemInstance(BlockBase.CHEST), '#', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.millStone), '+', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.hopper));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveMachineFrame), "XYX", "YZY", "XYX", 'X', new ItemInstance(ItemListener.goldenScrew), 'Y', new ItemInstance(ItemListener.nightWoodBeam), 'Z', new ItemInstance(ItemListener.woodenFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveBrickFrameCrafter), "#Y#", "YZY", "XYX", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(BlockBase.BRICKS), 'Z', new ItemInstance(BlockListener.primitiveMachineFrame), '#', new ItemInstance(BlockBase.PISTON));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveSlicer), "#-#", "YZY", "X+X", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(BlockBase.OBSIDIAN), 'Z', new ItemInstance(BlockListener.primitiveMachineFrame), '#', new ItemInstance(ItemBase.shears), '+', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.gearBox), '-', new ItemInstance(ItemListener.dryBrickFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveMetalworkingStation), "#-#", "YZY", "X+X", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(BlockBase.STONE_SLAB), 'Z', new ItemInstance(BlockListener.primitiveMachineFrame), '#', new ItemInstance(ItemBase.ironIngot), '+', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.gearBox), '-', new ItemInstance(ItemListener.dryBrickFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveCrusher), "+X+", "ZYZ", "Z#Z", 'X', new ItemInstance(BlockListener.improvedMillstone), 'Y', new ItemInstance(BlockListener.primitiveMachineFrame), 'Z', new ItemInstance(BlockBase.BRICKS), '#', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.gearBox), '+', new ItemInstance(ItemBase.diamondPickaxe));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.primitiveWasher), "-X-", "+Y+", "Z#Z", 'X', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.turntable), 'Y', new ItemInstance(BlockListener.primitiveMachineFrame), 'Z', new ItemInstance(BlockBase.BRICKS), '#', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.gearBox), '+', new ItemInstance(ItemListener.primitiveBrush), '-', new ItemInstance(ItemListener.concentratedFortune));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.heatPillar), "XYX", "XZX", "XYX", 'X', new ItemInstance(ItemListener.thermalGlass), 'Y', new ItemInstance(ItemListener.concentratedThermal), 'Z', new ItemInstance(ItemListener.hardenedBrickFrame));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.itemChute), "X X", "Y#Y", "Z Z", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.largeStoneBricks), '#', new ItemInstance(BlockListener.primitiveMachineFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.itemSlide), "XYX", " # ", "ZZZ", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.largeStoneBricks), '#', new ItemInstance(BlockListener.primitiveMachineFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.itemElevator), "X X", "Y#Y", "Z+Z", 'X', new ItemInstance(ItemListener.brickSteelPlate), 'Y', new ItemInstance(BlockListener.nightPlanks), 'Z', new ItemInstance(BlockListener.largeStoneBricks), '#', new ItemInstance(BlockListener.primitiveMachineFrame), '+', new ItemInstance(BlockBase.PISTON));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.itemChuteChain), "X X", "Y#Y", "Z Z", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.ironIngot), 'Z', new ItemInstance(BlockListener.largeStoneBricks), '#', new ItemInstance(BlockListener.primitiveMachineFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.itemSlideChain), "XYX", " # ", "ZZZ", 'X', new ItemInstance(BlockListener.nightPlanks), 'Y', new ItemInstance(ItemBase.ironIngot), 'Z', new ItemInstance(BlockListener.largeStoneBricks), '#', new ItemInstance(BlockListener.primitiveMachineFrame));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.itemElevatorChain), "X X", "Y#Y", "Z+Z", 'X', new ItemInstance(ItemBase.ironIngot), 'Y', new ItemInstance(BlockListener.nightPlanks), 'Z', new ItemInstance(BlockListener.largeStoneBricks), '#', new ItemInstance(BlockListener.primitiveMachineFrame), '+', new ItemInstance(BlockBase.PISTON));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyToolBase), "#X#", "YZY", "YZY", 'X', new ItemInstance(ItemListener.hardenedBrickFrame), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(ItemListener.brickSteelBeam), '#', new ItemInstance(ItemListener.bricksidianScrew));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.iceBlade), "XXX", "YZY", "YZY", 'X', new ItemInstance(ItemListener.dryBrickFrame), 'Y', new ItemInstance(BlockBase.SNOW_BLOCK), 'Z', new ItemInstance(ItemListener.toolRepairKit));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyToolBase), "X", "Y", 'X', new ItemInstance(ItemListener.dryBrickFrame), 'Y', new ItemInstance(ItemListener.brickCatalyst));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyBrush), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.primitiveBrush, 1, -1), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(ItemListener.archeologyToolBase));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyChisel), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.primitiveChisel, 1, -1), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(ItemListener.archeologyToolBase));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.archeologyIceKnife), "X", "Y", "Z", 'X', new ItemInstance(ItemListener.iceBlade), 'Y', new ItemInstance(ItemListener.dryBrickFrame), 'Z', new ItemInstance(ItemListener.archeologyToolBase));

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.woodenFrame), "XZX", "ZYZ", "XZX", 'X', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.corner), 'Y', new ItemInstance(net.kozibrodka.wolves.events.ItemListener.hempFibers), 'Z', new ItemInstance(net.kozibrodka.wolves.events.ItemListener.haft));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.woodenBrick, 8), "YYY", "YXY", "YYY", 'X', new ItemInstance(ItemListener.brickFrame), 'Y', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.moulding));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.woodenBricks), "XX", "XX", 'X', new ItemInstance(ItemListener.woodenBrick));

            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.stoneBricks), "XX", "XX", 'X', new ItemInstance(ItemListener.stoneBrick));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.largeStoneBricks, 4), "XY", "YX", 'X', new ItemInstance(ItemListener.stoneBrick), 'Y', new ItemInstance(BlockBase.STONE));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.largeStoneBricks, 4), "YX", "XY", 'X', new ItemInstance(ItemListener.stoneBrick), 'Y', new ItemInstance(BlockBase.STONE));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.fastBricks), "XXX", "YZY", 'X', new ItemInstance(ItemListener.exoticFruit), 'Y', new ItemInstance(ItemListener.brickFrame), 'Z', new ItemInstance(BlockBase.BRICKS));

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

            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.glueMixture), new ItemInstance(ItemListener.nightWheat), new ItemInstance(net.kozibrodka.wolves.events.ItemListener.flour), new ItemInstance(BlockBase.CACTUS));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.dryBrickFrame), new ItemInstance(ItemListener.brickFrame), new ItemInstance(ItemListener.brickAsh));
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

            SmeltingRegistry.addSmeltingRecipe(ItemListener.glueMixture.id, new ItemInstance(net.kozibrodka.wolves.events.ItemListener.glue));
            SmeltingRegistry.addSmeltingRecipe(BlockListener.woodenBricks.id, new ItemInstance(ItemListener.brickAsh));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.coalOreBrick.id, new ItemInstance(ItemBase.coal));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOreBrick.id, new ItemInstance(ItemBase.ironIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOreCrushed.id, new ItemInstance(ItemBase.ironIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOreWashed.id, new ItemInstance(ItemBase.ironIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOrePowdered.id, new ItemInstance(ItemBase.ironIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOrePurified.id, new ItemInstance(ItemBase.ironIngot));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOreBrick.id, new ItemInstance(ItemBase.goldIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOreCrushed.id, new ItemInstance(ItemBase.goldIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOreWashed.id, new ItemInstance(ItemBase.goldIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOrePowdered.id, new ItemInstance(ItemBase.goldIngot));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOrePurified.id, new ItemInstance(ItemBase.goldIngot));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.redstoneOreBrick.id, new ItemInstance(ItemBase.redstoneDust, 4));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.diamondOreBrick.id, new ItemInstance(ItemBase.diamond));

        }

        AddAnvilRecipe(new ItemInstance(BlockListener.brickSteelMachineFrame, 1), new Object[] {"XYYYX", "Y###Y", "Y#Z#Y", "Y###Y", "XYYYX", 'X', new ItemInstance(ItemListener.bricksidianScrew), 'Y', new ItemInstance(ItemListener.brickSteelBeam), 'Z', new ItemInstance(BlockListener.primitiveMachineFrame), '#', new ItemInstance(ItemListener.hardenedBrickFrame)});
        AddAnvilRecipe(new ItemInstance(BlockListener.slicer, 1), new Object[] {"XWWWX", "U-#-U", "VYZYV", "V+Y+V", "X+++X", 'U', new ItemInstance(ItemBase.diamond), 'V', new ItemInstance(ItemListener.nightWoodBeam), 'W', new ItemInstance(net.kozibrodka.wolves.events.ItemListener.refinedSword, 1, -1), 'X', new ItemInstance(ItemListener.reinforcedBrickFrame), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.brickSteelMachineFrame), '#', new ItemInstance(BlockListener.primitiveSlicer), '+', new ItemInstance(BlockListener.stoneBricks), '-', new ItemInstance(ItemListener.bricksidianIngot)});
        AddAnvilRecipe(new ItemInstance(BlockListener.metalworkingStation, 1), new Object[] {"XWWWX","U-#-U", "VYZYV", "V+Y+V", "X+++X", 'U', new ItemInstance(ItemBase.diamond), 'V', new ItemInstance(ItemListener.goldenScrew), 'W', new ItemInstance(net.kozibrodka.wolves.events.ItemListener.refinedAxe, 1, -1), 'X', new ItemInstance(ItemListener.reinforcedBrickFrame), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.brickSteelMachineFrame), '#', new ItemInstance(BlockListener.primitiveMetalworkingStation), '+', new ItemInstance(BlockListener.largeStoneBricks), '-', new ItemInstance(ItemListener.brickSteelIngot)});
        AddAnvilRecipe(new ItemInstance(BlockListener.brickFrameCrafter, 1), new Object[] {"X---X", "UY#YU", "VYZYV", "WYYYW", "X+++X", 'U', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.saw), 'V', new ItemInstance(net.kozibrodka.wolves.events.ItemListener.grate), 'W', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.turntable), 'X', new ItemInstance(ItemListener.reinforcedBrickFrame), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.brickSteelMachineFrame), '#', new ItemInstance(BlockListener.primitiveBrickFrameCrafter), '+', new ItemInstance(ItemListener.bricksidianIngot), '-', new ItemInstance(net.kozibrodka.wolves.events.ItemListener.rollersItem)});
        AddAnvilRecipe(new ItemInstance(BlockListener.alloySmelter, 1), new Object[] {"Y+++Y", "Y###Y", "XWZWX", "XWWWX", "X---X", 'W', new ItemInstance(net.kozibrodka.wolves.events.ItemListener.concentratedHellfire), 'X', new ItemInstance(BlockBase.BRICKS), 'Y', new ItemInstance(ItemListener.brickSteelPlate), 'Z', new ItemInstance(BlockListener.brickSteelMachineFrame), '#', new ItemInstance(BlockBase.FURNACE), '+', new ItemInstance(net.kozibrodka.wolves.events.BlockListener.crucible), '-', new ItemInstance(ItemListener.thermalGlass)});
        AddAnvilRecipe(new ItemInstance(ItemListener.brickSteelBeam, 4), new Object[] {"XY   ", "YX   ", "  X  ", "   XY", "   YX", 'X', new ItemInstance(ItemListener.brickSteelIngot), 'Y', new ItemInstance(ItemListener.durableLeatherStrap)});
        AddAnvilRecipe(new ItemInstance(ItemListener.largeBrickRaw), new Object[] {"XX+XX", "XZYZX", "+Y#Y+", "XZYZX", "XX+XX", 'X', new ItemInstance(ItemBase.clay), 'Y', new ItemInstance(ItemListener.brickSteelIngot), 'Z', new ItemInstance(ItemListener.brickSteelPlate), '#', new ItemInstance(BlockBase.BRICKS), '+', new ItemInstance(ItemListener.stoneBrick)});

        AddCauldronRecipe(new ItemInstance(ItemListener.denseNightWood), new ItemInstance[] {new ItemInstance(BlockListener.nightLog), new ItemInstance(net.kozibrodka.wolves.events.ItemListener.wicker)});
        AddCauldronRecipe(new ItemInstance(ItemListener.concentratedFortune), new ItemInstance[] {new ItemInstance(ItemListener.fortunePowder, 8), new ItemInstance(ItemBase.dyePowder, 1, 4)});
        AddCauldronRecipe(new ItemInstance(ItemListener.illuminantCrystal), new ItemInstance[] {new ItemInstance(ItemListener.groundSandstone), new ItemInstance(ItemBase.glowstoneDust)});
        AddCauldronRecipe(new ItemInstance(ItemListener.concentratedThermal), new ItemInstance[] {new ItemInstance(ItemListener.thermalPowder, 8), new ItemInstance(ItemListener.illuminantCrystal)});

        MillingRecipeRegistry.getInstance().addMillingRecipe(BlockBase.SANDSTONE.id, new ItemInstance(ItemListener.groundSandstone));

        MillingRecipeRegistry.getInstance().addMillingRecipe(ItemListener.ironOreWashed.id, new ItemInstance(ItemListener.ironOrePowdered, 2));
        MillingRecipeRegistry.getInstance().addMillingRecipe(ItemListener.goldOreWashed.id, new ItemInstance(ItemListener.goldOrePowdered, 2));

        AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemInstance(ItemBase.brick), new ItemInstance(BlockBase.STONE), new ItemInstance(ItemListener.brickFrame), new ItemInstance(ItemListener.stoneBrick, 1));
        AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemInstance(ItemBase.brick), new ItemInstance(net.kozibrodka.wolves.events.ItemListener.steel), new ItemInstance(net.kozibrodka.wolves.events.ItemListener.netherCoal), new ItemInstance(ItemListener.brickSteelIngot, 1));
        AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemInstance(ItemBase.brick), new ItemInstance(ItemBase.goldIngot), new ItemInstance(BlockBase.OBSIDIAN), new ItemInstance(ItemListener.bricksidianIngot, 1));

        AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemInstance(net.kozibrodka.wolves.events.ItemListener.tannedLeather), new ItemInstance(ItemListener.nightWheat), new ItemInstance(ItemListener.exoticFruit), new ItemInstance(ItemListener.durableLeather, 1));
        AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemInstance(ItemListener.hardenedBrickFrame), new ItemInstance(ItemListener.bricksidianIngot), new ItemInstance(ItemListener.brickSteelIngot), new ItemInstance(ItemListener.reinforcedBrickFrame, 1));

        AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemInstance(ItemListener.largeBrickRaw), new ItemInstance(ItemListener.reinforcedBrickFrame), new ItemInstance(ItemListener.bricksidianIngot), new ItemInstance(ItemListener.largeBrick, 1));

        SlicingRecipeRegistry.getInstance().addSlicingRecipe(ItemBase.leather.id, new TieredMachineRecipeData(0, new ItemInstance(ItemListener.leatherStrap)));
        SlicingRecipeRegistry.getInstance().addSlicingRecipe(ItemListener.durableLeather.id, new TieredMachineRecipeData(1, new ItemInstance(ItemListener.durableLeatherStrap)));

        MetalworkingRecipeRegistry.getInstance().addMetalworkingRecipe(ItemBase.goldIngot.id, new TieredMachineRecipeData(0, new ItemInstance(ItemListener.goldenScrew)));
        MetalworkingRecipeRegistry.getInstance().addMetalworkingRecipe(ItemListener.bricksidianIngot.id, new TieredMachineRecipeData(1, new ItemInstance(ItemListener.bricksidianScrew)));
        MetalworkingRecipeRegistry.getInstance().addMetalworkingRecipe(ItemListener.brickSteelIngot.id, new TieredMachineRecipeData(1, new ItemInstance(ItemListener.brickSteelPlate)));

        HibachiIgnitionRegistry.getInstance().addBlockIgnition(BlockListener.heatPillar.id, BlockListener.heatPillarIgnited.id);

        AddCrucibleRecipe(new ItemInstance(ItemListener.hardenedBrickFrame), new ItemInstance[] {new ItemInstance(ItemListener.dryBrickFrame), new ItemInstance(ItemListener.illuminantCrystal), new ItemInstance(net.kozibrodka.wolves.events.ItemListener.coalDust)});
        AddCrucibleRecipe(new ItemInstance(ItemListener.thermalGlass), new ItemInstance[] {new ItemInstance(BlockBase.GLASS, 8), new ItemInstance(ItemListener.concentratedThermal), new ItemInstance(net.kozibrodka.wolves.events.ItemListener.hellfireDust)});
        AddCrucibleRecipe(new ItemInstance(ItemListener.illuminantCrystal, 8), new ItemInstance[] {new ItemInstance(ItemListener.groundSandstone, 8), new ItemInstance(ItemBase.glowstoneDust), new ItemInstance(ItemBase.flint)});

        AddCrucibleRecipe(new ItemInstance(ItemListener.ironOrePurified, 4), new ItemInstance[] {new ItemInstance(ItemListener.ironOrePowdered, 3), new ItemInstance(ItemListener.illuminantCrystal), new ItemInstance(net.kozibrodka.wolves.events.ItemListener.hellfireDust)});
        AddCrucibleRecipe(new ItemInstance(ItemListener.goldOrePurified, 4), new ItemInstance[] {new ItemInstance(ItemListener.goldOrePowdered, 3), new ItemInstance(ItemListener.illuminantCrystal), new ItemInstance(net.kozibrodka.wolves.events.ItemListener.hellfireDust)});

        AddStokedCauldronRecipe(new ItemInstance(net.kozibrodka.wolves.events.ItemListener.glue, 4), new ItemInstance[] { new ItemInstance(ItemListener.glueMixture)});

        CrushingRecipeRegistry.getInstance().addCrushingRecipe(BlockBase.SAND.id, new TierAndByproductOutput(new TieredMachineRecipeData(0, new ItemInstance(BlockListener.dust)), new ItemInstance(ItemListener.goldOrePowdered), 0.1));
        CrushingRecipeRegistry.getInstance().addCrushingRecipe(BlockBase.IRON_ORE.id, new TierAndByproductOutput(new TieredMachineRecipeData(0, new ItemInstance(ItemListener.ironOreCrushed)), new ItemInstance(ItemListener.ironOrePowdered), 0.5));
        CrushingRecipeRegistry.getInstance().addCrushingRecipe(BlockBase.GOLD_ORE.id, new TierAndByproductOutput(new TieredMachineRecipeData(0, new ItemInstance(ItemListener.goldOreCrushed)), new ItemInstance(ItemListener.goldOrePowdered), 0.5));

        WashingRecipeRegistry.getInstance().addWashingRecipe(BlockBase.DIRT.id, new TierAndByproductOutput(new TieredMachineRecipeData(0, new ItemInstance(BlockBase.SAND)), new ItemInstance(ItemBase.clay), 0.75));
        WashingRecipeRegistry.getInstance().addWashingRecipe(BlockListener.dust.id, new TierAndByproductOutput(new TieredMachineRecipeData(0, new ItemInstance(BlockBase.CLAY)), new ItemInstance(ItemBase.clay), 0.25));
        WashingRecipeRegistry.getInstance().addWashingRecipe(ItemListener.ironOreCrushed.id, new TierAndByproductOutput(new TieredMachineRecipeData(0, new ItemInstance(ItemListener.ironOreWashed)), new ItemInstance(ItemListener.ironOrePowdered), 0.5));
        WashingRecipeRegistry.getInstance().addWashingRecipe(ItemListener.goldOreCrushed.id, new TierAndByproductOutput(new TieredMachineRecipeData(0, new ItemInstance(ItemListener.goldOreWashed)), new ItemInstance(ItemListener.goldOrePowdered), 0.5));

    }

    private static void AddAnvilRecipe(ItemInstance output, Object[] inputs)
    {
        AnvilCraftingManager.getInstance().addRecipe(output, inputs);
    }

    public static void AddCauldronRecipe(ItemInstance output, ItemInstance[] inputs)
    {
        CauldronCraftingManager.getInstance().AddRecipe(output, inputs);
    }

    public static void AddCrucibleRecipe(ItemInstance itemstack, ItemInstance aitemstack[])
    {
        CrucibleCraftingManager.getInstance().AddRecipe(itemstack, aitemstack);
    }

    public static void AddStokedCauldronRecipe(ItemInstance itemstack, ItemInstance aitemstack[])
    {
        CauldronStokedCraftingManager.getInstance().AddRecipe(itemstack, aitemstack);
    }
}
