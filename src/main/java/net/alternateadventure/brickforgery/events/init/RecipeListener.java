package net.alternateadventure.brickforgery.events.init;

import net.alternateadventure.brickforgery.registry.machine.*;
import net.alternateadventure.brickforgery.registry.tool.BrushRecipeRegistry;
import net.alternateadventure.brickforgery.registry.tool.ChiselRecipeRegistry;
import net.alternateadventure.brickforgery.registry.tool.GrabberRecipeRegistry;
import net.alternateadventure.brickforgery.utils.*;
import net.kozibrodka.wolves.api.HibachiIgnitionRegistry;
import net.kozibrodka.wolves.recipe.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;
        // Output <- Input
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {

            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.sugarCaneStick), "X", "Y", "X", 'X', new ItemStack(Item.SUGAR_CANE), 'Y', new ItemStack(ItemListener.nightCaneStick));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.sugarCaneFrame), "X X", " X ", "X X", 'X', new ItemStack(ItemListener.sugarCaneStick));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.sugarCaneBox), "YXY", "XYX", "YXY", 'X', new ItemStack(Item.SUGAR_CANE), 'Y', new ItemStack(ItemListener.sugarCaneFrame));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.sugarCaneSlicer), "YXY", "YZY", "Y#Y", 'X', new ItemStack(Block.PLANKS), 'Y', new ItemStack(ItemListener.dirtBrick), 'Z', new ItemStack(BlockListener.sugarCaneBox), '#', new ItemStack(net.kozibrodka.wolves.events.BlockListener.gearBox));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.sugarCaneBrickFrameCrafter), "#X#", "YZY", "YYY", 'X', new ItemStack(Item.CLAY), 'Y', new ItemStack(ItemListener.dirtBrick), 'Z', new ItemStack(BlockListener.sugarCaneBox), '#', new ItemStack(ItemListener.sugarCaneFrame));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.exoticMutationSample), " X ", "XYX", "ZZZ", 'X', new ItemStack(ItemListener.sugarCaneStick), 'Y', new ItemStack(ItemListener.exoticFruit), 'Z', new ItemStack(ItemListener.cactusFrame));

            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.cactusBox), "YXY", "XZX", "YXY", 'X', new ItemStack(BlockListener.sandBricks), 'Y', new ItemStack(ItemListener.cactusFrame), 'Z', new ItemStack(BlockListener.sugarCaneBox));

            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.dirtBricks), "XX", "XX", 'X', new ItemStack(ItemListener.dirtBrick));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.sandBricks), "XX", "XX", 'X', new ItemStack(ItemListener.sandBrick));

            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.flintFrame), " X ", "XYX", " X ", 'X', new ItemStack(Item.FLINT), 'Y', new ItemStack(ItemListener.cactusFrame));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.flintBox), "XYX", "YZY", "XYX", 'X', new ItemStack(ItemListener.flintFrame), 'Y', new ItemStack(Block.GRAVEL), 'Z', new ItemStack(BlockListener.cactusBox));

            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.primitiveBrush), "-X-", "+Y+", "#Z#", 'X', new ItemStack(ItemListener.nightWheat), 'Y', new ItemStack(Item.GOLD_INGOT), 'Z', new ItemStack(ItemListener.denseNightWood), '#', new ItemStack(ItemListener.leatherStrap), '+', new ItemStack(Item.PAPER), '-', new ItemStack(ItemListener.concentratedFortune));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.primitiveChisel), "-X-", "#Y#", "+Z+", 'X', new ItemStack(Item.GOLD_INGOT), 'Y', new ItemStack(Item.FLINT), 'Z', new ItemStack(ItemListener.denseNightWood), '#', new ItemStack(Item.PAPER), '+', new ItemStack(ItemListener.leatherStrap), '-', new ItemStack(ItemListener.concentratedFortune));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.primitiveGrabber), "-X-", "#Y#", "+Z+", 'X', new ItemStack(Item.DIAMOND), 'Y', new ItemStack(Item.IRON_INGOT), 'Z', new ItemStack(ItemListener.denseNightWood), '#', new ItemStack(Item.PAPER), '+', new ItemStack(net.kozibrodka.wolves.events.ItemListener.hempCloth), '-', new ItemStack(ItemListener.concentratedFortune));

            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.nightWoodBeam, 2), "XY ", "YZY", " YX", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(ItemListener.leatherStrap), 'Z', new ItemStack(ItemListener.denseNightWood));

            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.exoticKey), "YYX", "ZZ ", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(ItemListener.denseNightWood), 'Z', new ItemStack(ItemListener.exoticFruit));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.desertKey), "YYX", "ZZ ", 'X', new ItemStack(Block.SANDSTONE), 'Y', new ItemStack(ItemListener.illuminantCrystal), 'Z', new ItemStack(ItemListener.fortunePowder));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.iceKey), "YYX", "ZZ ", 'X', new ItemStack(Block.SNOW_BLOCK), 'Y', new ItemStack(ItemListener.denseNightWood), 'Z', new ItemStack(ItemListener.fortunePowder));

            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.improvedMillstone), "Z+Z", "X#X", "XYX", 'X', new ItemStack(ItemListener.denseNightWood), 'Y', new ItemStack(ItemListener.woodenFrame), 'Z', new ItemStack(Block.CHEST), '#', new ItemStack(net.kozibrodka.wolves.events.BlockListener.millStone), '+', new ItemStack(net.kozibrodka.wolves.events.BlockListener.hopper));

            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.primitiveMachineFrame), "XYX", "Z#Z", "XYX", 'X', new ItemStack(ItemListener.goldenScrew), 'Y', new ItemStack(ItemListener.nightWoodBeam), 'Z', new ItemStack(ItemListener.woodenFrame), '#', new ItemStack(BlockListener.flintBox));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.primitiveBrickFrameCrafter), "#Y#", "Y+Y", "XZX", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Block.BRICKS), 'Z', new ItemStack(BlockListener.primitiveMachineFrame), '#', new ItemStack(Block.PISTON), '+', new ItemStack(BlockListener.sugarCaneBrickFrameCrafter));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.primitiveSlicer), "#-#", "ZYZ", "X+X", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(BlockListener.sugarCaneSlicer), 'Z', new ItemStack(BlockListener.primitiveMachineFrame), '#', new ItemStack(Item.SHEARS), '+', new ItemStack(net.kozibrodka.wolves.events.BlockListener.gearBox), '-', new ItemStack(ItemListener.dryBrickFrame));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.primitiveMetalworkingStation), "#-#", "YZY", "X+X", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Block.SLAB), 'Z', new ItemStack(BlockListener.primitiveMachineFrame), '#', new ItemStack(Item.IRON_INGOT), '+', new ItemStack(net.kozibrodka.wolves.events.BlockListener.gearBox), '-', new ItemStack(ItemListener.dryBrickFrame));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.primitiveCrusher), "+X+", "-Y-", "Z#Z", 'X', new ItemStack(BlockListener.improvedMillstone), 'Y', new ItemStack(BlockListener.primitiveMachineFrame), 'Z', new ItemStack(Block.BRICKS), '#', new ItemStack(net.kozibrodka.wolves.events.BlockListener.gearBox), '+', new ItemStack(Item.DIAMOND_PICKAXE), '-', new ItemStack(Block.OBSIDIAN));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.primitiveWasher), "-X-", "+Y+", "Z#Z", 'X', new ItemStack(net.kozibrodka.wolves.events.BlockListener.turntable), 'Y', new ItemStack(BlockListener.primitiveMachineFrame), 'Z', new ItemStack(Block.BRICKS), '#', new ItemStack(net.kozibrodka.wolves.events.BlockListener.gearBox), '+', new ItemStack(ItemListener.primitiveBrush), '-', new ItemStack(ItemListener.concentratedFortune));

            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.heatPillar), "XYX", "XZX", "XYX", 'X', new ItemStack(ItemListener.thermalGlass), 'Y', new ItemStack(ItemListener.concentratedThermal), 'Z', new ItemStack(ItemListener.hardenedBrickFrame));

            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.cryogenicHibachi), "XXX", " Y ", 'X', new ItemStack(ItemListener.concentratedCryogenic), 'Y', new ItemStack(net.kozibrodka.wolves.events.BlockListener.hibachi));

            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.itemChute), "X X", "Y#Y", "Z Z", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(ItemListener.brickSteelPlate), 'Z', new ItemStack(BlockListener.largeStoneBricks), '#', new ItemStack(BlockListener.primitiveMachineFrame));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.itemSlide), "XYX", " # ", "ZZZ", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(ItemListener.brickSteelPlate), 'Z', new ItemStack(BlockListener.largeStoneBricks), '#', new ItemStack(BlockListener.primitiveMachineFrame));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.itemElevator), "X X", "Y#Y", "Z+Z", 'X', new ItemStack(ItemListener.brickSteelPlate), 'Y', new ItemStack(BlockListener.nightPlanks), 'Z', new ItemStack(BlockListener.largeStoneBricks), '#', new ItemStack(BlockListener.primitiveMachineFrame), '+', new ItemStack(Block.PISTON));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.itemChuteChain), "X X", "Y#Y", "Z Z", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.IRON_INGOT), 'Z', new ItemStack(BlockListener.largeStoneBricks), '#', new ItemStack(BlockListener.primitiveMachineFrame));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.itemSlideChain), "XYX", " # ", "ZZZ", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.IRON_INGOT), 'Z', new ItemStack(BlockListener.largeStoneBricks), '#', new ItemStack(BlockListener.primitiveMachineFrame));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.itemElevatorChain), "X X", "Y#Y", "Z+Z", 'X', new ItemStack(Item.IRON_INGOT), 'Y', new ItemStack(BlockListener.nightPlanks), 'Z', new ItemStack(BlockListener.largeStoneBricks), '#', new ItemStack(BlockListener.primitiveMachineFrame), '+', new ItemStack(Block.PISTON));

            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.archaeologyToolBase), "#X#", "YZY", "YZY", 'X', new ItemStack(ItemListener.hardenedBrickFrame), 'Y', new ItemStack(ItemListener.brickSteelPlate), 'Z', new ItemStack(ItemListener.brickSteelBeam), '#', new ItemStack(ItemListener.bricksidianScrew));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.iceBlade), "XXX", "YZY", "YZY", 'X', new ItemStack(ItemListener.dryBrickFrame), 'Y', new ItemStack(Block.SNOW_BLOCK), 'Z', new ItemStack(ItemListener.toolRepairKit));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.archaeologyToolBase), "X", "Y", 'X', new ItemStack(ItemListener.dryBrickFrame), 'Y', new ItemStack(ItemListener.brickCatalyst));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.archaeologyBrush), "X", "Y", "Z", 'X', new ItemStack(ItemListener.primitiveBrush, 1, -1), 'Y', new ItemStack(ItemListener.brickFrame), 'Z', new ItemStack(ItemListener.archaeologyToolBase));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.archaeologyChisel), "X", "Y", "Z", 'X', new ItemStack(ItemListener.primitiveChisel, 1, -1), 'Y', new ItemStack(ItemListener.brickFrame), 'Z', new ItemStack(ItemListener.archaeologyToolBase));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.archaeologyIceKnife), "X", "Y", "Z", 'X', new ItemStack(ItemListener.iceBlade), 'Y', new ItemStack(ItemListener.dryBrickFrame), 'Z', new ItemStack(ItemListener.archaeologyToolBase));

            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.woodenFrame), "XZX", "ZYZ", "XZX", 'X', new ItemStack(net.kozibrodka.wolves.events.BlockListener.corner), 'Y', new ItemStack(ItemListener.flintFrame), 'Z', new ItemStack(net.kozibrodka.wolves.events.ItemListener.haft));
            CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.woodenBrick, 8), "YYY", "YXY", "YYY", 'X', new ItemStack(ItemListener.brickFrame), 'Y', new ItemStack(net.kozibrodka.wolves.events.BlockListener.moulding));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.woodenBricks), "XX", "XX", 'X', new ItemStack(ItemListener.woodenBrick));

            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.stoneBricks), "XX", "XX", 'X', new ItemStack(ItemListener.stoneBrick));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.largeStoneBricks, 4), "XY", "YX", 'X', new ItemStack(ItemListener.stoneBrick), 'Y', new ItemStack(Block.STONE));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.largeStoneBricks, 4), "YX", "XY", 'X', new ItemStack(ItemListener.stoneBrick), 'Y', new ItemStack(Block.STONE));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.fastBricks), "XXX", "YZY", 'X', new ItemStack(ItemListener.exoticFruit), 'Y', new ItemStack(ItemListener.brickFrame), 'Z', new ItemStack(Block.BRICKS));

            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.brickLauncher), "XYX", "XZX", "XYX", 'X', new ItemStack(BlockListener.stoneBricks), 'Y', new ItemStack(Block.PISTON), 'Z', new ItemStack(Block.DISPENSER));
            CraftingRegistry.addShapedRecipe(new ItemStack(BlockListener.spikeMount), " X ", "XYX", "ZZZ", 'X', new ItemStack(Item.IRON_INGOT), 'Y', new ItemStack(ItemListener.brokenSpikeHolder), 'Z', new ItemStack(ItemListener.dryBrickFrame));

            CraftingRegistry.addShapedRecipe(new ItemStack(Item.STICK, 4), "X", "X", 'X', new ItemStack(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemStack(Block.STONE_PRESSURE_PLATE), "XX", 'X', new ItemStack(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemStack(Block.CHEST), "XXX", "X X", "XXX", 'X', new ItemStack(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemStack(Item.SIGN), "XXX", "XXX", " Y ", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.STICK));
            CraftingRegistry.addShapedRecipe(new ItemStack(Item.WOODEN_AXE), "XX", "XY", " Y", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.STICK));
            CraftingRegistry.addShapedRecipe(new ItemStack(Item.WOODEN_AXE), "XX", "YX", "Y ", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.STICK));
            CraftingRegistry.addShapedRecipe(new ItemStack(Item.WOODEN_HOE), "XX", " Y", " Y", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.STICK));
            CraftingRegistry.addShapedRecipe(new ItemStack(Item.WOODEN_HOE), "XX", "Y ", "Y ", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.STICK));
            CraftingRegistry.addShapedRecipe(new ItemStack(Item.WOODEN_PICKAXE), "XXX", " Y ", " Y ", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.STICK));
            CraftingRegistry.addShapedRecipe(new ItemStack(Item.WOODEN_SHOVEL), "X", "Y", "Y", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.STICK));
            CraftingRegistry.addShapedRecipe(new ItemStack(Item.WOODEN_SWORD), "X", "X", "Y", 'X', new ItemStack(BlockListener.nightPlanks), 'Y', new ItemStack(Item.STICK));
            CraftingRegistry.addShapedRecipe(new ItemStack(Block.SLAB, 3, 2), "XXX", 'X', new ItemStack(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemStack(Block.WOODEN_STAIRS, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(BlockListener.nightPlanks));
            CraftingRegistry.addShapedRecipe(new ItemStack(Block.WOODEN_STAIRS, 4), "  X", " XX", "XXX", 'X', new ItemStack(BlockListener.nightPlanks));

            addAnvilRecipe(new ItemStack(BlockListener.brickSteelMachineFrame, 1), new Object[] {"XYYYX", "Y###Y", "Y#Z#Y", "Y###Y", "XYYYX", 'X', new ItemStack(ItemListener.bricksidianScrew), 'Y', new ItemStack(ItemListener.brickSteelBeam), 'Z', new ItemStack(BlockListener.primitiveMachineFrame), '#', new ItemStack(ItemListener.hardenedBrickFrame)});
            addAnvilRecipe(new ItemStack(BlockListener.slicer, 1), new Object[] {"XWWWX", "U-#-U", "VYZYV", "V+Y+V", "X+++X", 'U', new ItemStack(Item.DIAMOND), 'V', new ItemStack(ItemListener.nightWoodBeam), 'W', new ItemStack(net.kozibrodka.wolves.events.ItemListener.refinedSword, 1, -1), 'X', new ItemStack(ItemListener.reinforcedBrickFrame), 'Y', new ItemStack(ItemListener.brickSteelPlate), 'Z', new ItemStack(BlockListener.brickSteelMachineFrame), '#', new ItemStack(BlockListener.primitiveSlicer), '+', new ItemStack(BlockListener.stoneBricks), '-', new ItemStack(ItemListener.bricksidianIngot)});
            addAnvilRecipe(new ItemStack(BlockListener.metalworkingStation, 1), new Object[] {"XWWWX","U-#-U", "VYZYV", "V+Y+V", "X+++X", 'U', new ItemStack(Item.DIAMOND), 'V', new ItemStack(ItemListener.goldenScrew), 'W', new ItemStack(net.kozibrodka.wolves.events.ItemListener.refinedAxe, 1, -1), 'X', new ItemStack(ItemListener.reinforcedBrickFrame), 'Y', new ItemStack(ItemListener.brickSteelPlate), 'Z', new ItemStack(BlockListener.brickSteelMachineFrame), '#', new ItemStack(BlockListener.primitiveMetalworkingStation), '+', new ItemStack(BlockListener.largeStoneBricks), '-', new ItemStack(ItemListener.brickSteelIngot)});
            addAnvilRecipe(new ItemStack(BlockListener.brickFrameCrafter, 1), new Object[] {"X---X", "UY#YU", "VYZYV", "WYYYW", "X+++X", 'U', new ItemStack(net.kozibrodka.wolves.events.BlockListener.saw), 'V', new ItemStack(net.kozibrodka.wolves.events.ItemListener.grate), 'W', new ItemStack(net.kozibrodka.wolves.events.BlockListener.turntable), 'X', new ItemStack(ItemListener.reinforcedBrickFrame), 'Y', new ItemStack(ItemListener.brickSteelPlate), 'Z', new ItemStack(BlockListener.brickSteelMachineFrame), '#', new ItemStack(BlockListener.primitiveBrickFrameCrafter), '+', new ItemStack(ItemListener.bricksidianIngot), '-', new ItemStack(net.kozibrodka.wolves.events.ItemListener.rollersItem)});
            addAnvilRecipe(new ItemStack(BlockListener.alloySmelter, 1), new Object[] {"Y+++Y", "Y###Y", "XWZWX", "XWWWX", "X---X", 'W', new ItemStack(net.kozibrodka.wolves.events.ItemListener.concentratedHellfire), 'X', new ItemStack(Block.BRICKS), 'Y', new ItemStack(ItemListener.brickSteelPlate), 'Z', new ItemStack(BlockListener.brickSteelMachineFrame), '#', new ItemStack(Block.FURNACE), '+', new ItemStack(net.kozibrodka.wolves.events.BlockListener.crucible), '-', new ItemStack(ItemListener.thermalGlass)});
            addAnvilRecipe(new ItemStack(ItemListener.brickSteelBeam, 4), new Object[] {"XY   ", "YX   ", "  X  ", "   XY", "   YX", 'X', new ItemStack(ItemListener.brickSteelIngot), 'Y', new ItemStack(ItemListener.durableLeatherStrap)});
            addAnvilRecipe(new ItemStack(ItemListener.largeBrickRaw), new Object[] {"XX+XX", "XZYZX", "+Y#Y+", "XZYZX", "XX+XX", 'X', new ItemStack(Item.CLAY), 'Y', new ItemStack(ItemListener.brickSteelIngot), 'Z', new ItemStack(ItemListener.brickSteelPlate), '#', new ItemStack(Block.BRICKS), '+', new ItemStack(ItemListener.stoneBrick)});

            BrickFramingRecipeRegistry.getInstance().addRecipe(new ItemStack(ItemListener.sugarCaneFrame), BlockListener.cactusPlanks.id, BlockListener.cactusPlanks.id, BlockListener.cactusPlanks.id, BlockListener.cactusPlanks.id, new ItemStack(ItemListener.cactusFrame), TierEnum.SUGAR_CANE);
            BrickFramingRecipeRegistry.getInstance().addRecipe(new ItemStack(ItemListener.woodenFrame), BlockListener.nightPlanks.id, BlockListener.nightPlanks.id, Block.CLAY.id, Block.CLAY.id, new ItemStack(ItemListener.brickFrame), TierEnum.PRIMITIVE);
            BrickFramingRecipeRegistry.getInstance().addRecipe(new ItemStack(ItemListener.woodenFrame), BlockListener.planksPile.id, BlockListener.planksPile.id, BlockListener.clayPile.id, BlockListener.clayPile.id, new ItemStack(ItemListener.brickFrame), TierEnum.PRIMITIVE);
        }
        // Output <- Input
        else if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.nightCaneStick), new ItemStack(ItemListener.exoticFruit), new ItemStack(Item.SUGAR_CANE));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.dirtBrick), new ItemStack(ItemListener.sugarCaneFrame), new ItemStack(Block.DIRT));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.dirtBrickSand), new ItemStack(ItemListener.cactusFrame), new ItemStack(ItemListener.dirtBrick), new ItemStack(Block.SAND));

            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.toolRepairKit, 8), new ItemStack(ItemListener.nightWoodBeam), new ItemStack(ItemListener.goldenScrew), new ItemStack(Item.PAPER));

            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.primitiveBrush), new ItemStack(ItemListener.primitiveBrush, 1, -1), new ItemStack(ItemListener.toolRepairKit));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.primitiveChisel), new ItemStack(ItemListener.primitiveChisel, 1, -1), new ItemStack(ItemListener.toolRepairKit));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.primitiveGrabber), new ItemStack(ItemListener.primitiveGrabber, 1, -1), new ItemStack(ItemListener.toolRepairKit));

            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.archaeologyBrush), new ItemStack(ItemListener.archaeologyBrush, 1, -1), new ItemStack(ItemListener.toolRepairKit));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.archaeologyChisel), new ItemStack(ItemListener.archaeologyChisel, 1, -1), new ItemStack(ItemListener.toolRepairKit));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.archaeologyIceKnife), new ItemStack(ItemListener.archaeologyIceKnife, 1, -1), new ItemStack(ItemListener.toolRepairKit));

            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.glueMixture), new ItemStack(ItemListener.nightWheat), new ItemStack(net.kozibrodka.wolves.events.ItemListener.flour), new ItemStack(Block.CACTUS));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.dryBrickFrame), new ItemStack(ItemListener.brickFrame), new ItemStack(ItemListener.brickAsh));
            CraftingRegistry.addShapelessRecipe(new ItemStack(Item.CLAY), new ItemStack(ItemListener.clayPowder), new ItemStack(ItemListener.snowBrick));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.nightSeeds), new ItemStack(ItemListener.exoticMutationSample), new ItemStack(Item.SEEDS));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.nightSapling), new ItemStack(ItemListener.exoticMutationSample), new ItemStack(Block.SAPLING, 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.nightPlanks, 4), new ItemStack(BlockListener.nightLog));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.nightSeeds), new ItemStack(ItemListener.nightWheat));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ItemListener.exoticCatalyst), new ItemStack(ItemListener.brickCatalyst), new ItemStack(ItemListener.exoticFruit));

            addCauldronRecipe(new ItemStack(ItemListener.denseNightWood), new ItemStack[] {new ItemStack(BlockListener.nightLog), new ItemStack(net.kozibrodka.wolves.events.ItemListener.wicker)});
            addCauldronRecipe(new ItemStack(ItemListener.concentratedFortune), new ItemStack[] {new ItemStack(ItemListener.fortunePowder, 8), new ItemStack(Item.DYE, 1, 4)});
            addCauldronRecipe(new ItemStack(ItemListener.illuminantCrystal), new ItemStack[] {new ItemStack(ItemListener.groundSandstone), new ItemStack(Item.GLOWSTONE_DUST)});
            addCauldronRecipe(new ItemStack(ItemListener.concentratedThermal), new ItemStack[] {new ItemStack(ItemListener.thermalPowder, 8), new ItemStack(ItemListener.illuminantCrystal)});
            addCauldronRecipe(new ItemStack(ItemListener.concentratedCryogenic), new ItemStack[] {new ItemStack(ItemListener.cryogenicPowder, 8), new ItemStack(Block.SNOW_BLOCK)});

            MillingRecipeRegistry.getInstance().addMillingRecipe(BlockRegistry.INSTANCE.getId(Block.SANDSTONE), new ItemStack(ItemListener.groundSandstone));

            MillingRecipeRegistry.getInstance().addMillingRecipe(ItemListener.MOD_ID.id("iron_ore_washed"), new ItemStack(ItemListener.ironOrePowdered, 2));
            MillingRecipeRegistry.getInstance().addMillingRecipe(ItemListener.MOD_ID.id("gold_ore_washed"), new ItemStack(ItemListener.goldOrePowdered, 2));

            AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemStack(Item.BRICK), new ItemStack(Block.STONE), new ItemStack(ItemListener.brickFrame), new ItemStack(ItemListener.stoneBrick, 1));
            AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemStack(ItemListener.frozenBrick), new ItemStack(net.kozibrodka.wolves.events.ItemListener.steel), new ItemStack(net.kozibrodka.wolves.events.ItemListener.netherCoal), new ItemStack(ItemListener.brickSteelIngot, 1));
            AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemStack(Item.BRICK), new ItemStack(Item.GOLD_INGOT), new ItemStack(Block.OBSIDIAN), new ItemStack(ItemListener.bricksidianIngot, 1));

            AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemStack(net.kozibrodka.wolves.events.ItemListener.tannedLeather), new ItemStack(ItemListener.nightWheat), new ItemStack(ItemListener.exoticFruit), new ItemStack(ItemListener.durableLeather, 1));
            AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemStack(ItemListener.hardenedBrickFrame), new ItemStack(ItemListener.bricksidianIngot), new ItemStack(ItemListener.brickSteelIngot), new ItemStack(ItemListener.reinforcedBrickFrame, 1));

            AlloySmeltingRecipeRegistry.getInstance().addRecipe(new ItemStack(ItemListener.largeBrickRaw), new ItemStack(ItemListener.reinforcedBrickFrame), new ItemStack(ItemListener.bricksidianIngot), new ItemStack(ItemListener.largeBrick, 1));

            SlicingRecipeRegistry.getInstance().addSlicingRecipe(Block.CACTUS.asItem().id, new TieredMachineRecipeData(TierEnum.SUGAR_CANE, new ItemStack(BlockListener.cactusPlanks)));
            SlicingRecipeRegistry.getInstance().addSlicingRecipe(Item.LEATHER.id, new TieredMachineRecipeData(TierEnum.PRIMITIVE, new ItemStack(ItemListener.leatherStrap)));
            SlicingRecipeRegistry.getInstance().addSlicingRecipe(ItemListener.durableLeather.id, new TieredMachineRecipeData(TierEnum.BRICK, new ItemStack(ItemListener.durableLeatherStrap)));

            MetalworkingRecipeRegistry.getInstance().addMetalworkingRecipe(Item.GOLD_INGOT.id, new TieredMachineRecipeData(TierEnum.PRIMITIVE, new ItemStack(ItemListener.goldenScrew)));
            MetalworkingRecipeRegistry.getInstance().addMetalworkingRecipe(ItemListener.bricksidianIngot.id, new TieredMachineRecipeData(TierEnum.BRICK, new ItemStack(ItemListener.bricksidianScrew)));
            MetalworkingRecipeRegistry.getInstance().addMetalworkingRecipe(ItemListener.brickSteelIngot.id, new TieredMachineRecipeData(TierEnum.BRICK, new ItemStack(ItemListener.brickSteelPlate)));

            HibachiIgnitionRegistry.getInstance().addBlockIgnition(BlockListener.heatPillar.id, BlockListener.heatPillarIgnited.id);

            addCrucibleRecipe(new ItemStack(ItemListener.hardenedBrickFrame), new ItemStack[] {new ItemStack(ItemListener.dryBrickFrame), new ItemStack(ItemListener.illuminantCrystal), new ItemStack(net.kozibrodka.wolves.events.ItemListener.coalDust)});
            addCrucibleRecipe(new ItemStack(ItemListener.thermalGlass), new ItemStack[] {new ItemStack(Block.GLASS, 8), new ItemStack(ItemListener.concentratedThermal), new ItemStack(net.kozibrodka.wolves.events.ItemListener.hellfireDust)});
            addCrucibleRecipe(new ItemStack(ItemListener.illuminantCrystal, 8), new ItemStack[] {new ItemStack(ItemListener.groundSandstone, 8), new ItemStack(Item.GLOWSTONE_DUST), new ItemStack(Item.FLINT)});

            addCrucibleRecipe(new ItemStack(ItemListener.ironOrePurified, 4), new ItemStack[] {new ItemStack(ItemListener.ironOrePowdered, 3), new ItemStack(ItemListener.illuminantCrystal), new ItemStack(net.kozibrodka.wolves.events.ItemListener.hellfireDust)});
            addCrucibleRecipe(new ItemStack(ItemListener.goldOrePurified, 4), new ItemStack[] {new ItemStack(ItemListener.goldOrePowdered, 3), new ItemStack(ItemListener.illuminantCrystal), new ItemStack(net.kozibrodka.wolves.events.ItemListener.hellfireDust)});

            addStokedCauldronRecipe(new ItemStack(net.kozibrodka.wolves.events.ItemListener.glue, 4), new ItemStack[] { new ItemStack(ItemListener.glueMixture)});

            CrushingRecipeRegistry.getInstance().addCrushingRecipe(Block.SAND.asItem().id, new TierAndByproductOutput(new TieredMachineRecipeData(TierEnum.PRIMITIVE, new ItemStack(BlockListener.dust)), new ItemStack(ItemListener.goldOrePowdered), 0.1));
            CrushingRecipeRegistry.getInstance().addCrushingRecipe(Block.IRON_ORE.asItem().id, new TierAndByproductOutput(new TieredMachineRecipeData(TierEnum.PRIMITIVE, new ItemStack(ItemListener.ironOreCrushed)), new ItemStack(ItemListener.ironOrePowdered), 0.5));
            CrushingRecipeRegistry.getInstance().addCrushingRecipe(Block.GOLD_ORE.asItem().id, new TierAndByproductOutput(new TieredMachineRecipeData(TierEnum.PRIMITIVE, new ItemStack(ItemListener.goldOreCrushed)), new ItemStack(ItemListener.goldOrePowdered), 0.5));

            WashingRecipeRegistry.getInstance().addWashingRecipe(Block.DIRT.asItem().id, new TierAndByproductOutput(new TieredMachineRecipeData(TierEnum.PRIMITIVE, new ItemStack(Block.SAND)), new ItemStack(Item.CLAY), 0.75));
            WashingRecipeRegistry.getInstance().addWashingRecipe(BlockListener.dust.asItem().id, new TierAndByproductOutput(new TieredMachineRecipeData(TierEnum.PRIMITIVE, new ItemStack(Block.CLAY)), new ItemStack(Item.CLAY), 0.25));
            WashingRecipeRegistry.getInstance().addWashingRecipe(ItemListener.ironOreCrushed.id, new TierAndByproductOutput(new TieredMachineRecipeData(TierEnum.PRIMITIVE, new ItemStack(ItemListener.ironOreWashed)), new ItemStack(ItemListener.ironOrePowdered), 0.5));
            WashingRecipeRegistry.getInstance().addWashingRecipe(ItemListener.goldOreCrushed.id, new TierAndByproductOutput(new TieredMachineRecipeData(TierEnum.PRIMITIVE, new ItemStack(ItemListener.goldOreWashed)), new ItemStack(ItemListener.goldOrePowdered), 0.5));

            BrushRecipeRegistry.getInstance().addBrushingRecipe(BlockListener.bountifulSand.id, new TieredBlockConversionData(new int[] {BlockListener.desertPotSealed.id, BlockListener.desertPot.id}, new int[] {50, 70}, TierEnum.PRIMITIVE));
            BrushRecipeRegistry.getInstance().addBrushingRecipe(BlockListener.bountifulSnow.id, new TieredBlockConversionData(new int[] {BlockListener.frozenPotSealed.id, BlockListener.frozenPot.id}, new int[] {50, 70}, TierEnum.PRIMITIVE));

            ChiselRecipeRegistry.getInstance().addChiselingRecipe(BlockListener.desertPotSealed.id, new TieredBlockConversionData(new int[] {BlockListener.desertPot.id}, new int[] {90}, TierEnum.PRIMITIVE));
            ChiselRecipeRegistry.getInstance().addChiselingRecipe(BlockListener.frozenPotSealed.id, new TieredBlockConversionData(new int[] {BlockListener.frozenPot.id}, new int[] {90}, TierEnum.PRIMITIVE));

            GrabberRecipeRegistry.getInstance().addChiselingRecipe(BlockListener.commonPot.id, new TieredBlockLootingData(new ItemStack[] {new ItemStack(ItemListener.leatherStrap, 1), new ItemStack(Block.GRAVEL, 1)}, new int[] {90, 30}, 40, TierEnum.PRIMITIVE));
            GrabberRecipeRegistry.getInstance().addChiselingRecipe(BlockListener.desertPot.id, new TieredBlockLootingData(new ItemStack[] {new ItemStack(ItemListener.leatherStrap, 1), new ItemStack(ItemListener.goldenScrew, 1), new ItemStack(Block.SAND, 1)}, new int[] {50, 70, 30}, 60, TierEnum.PRIMITIVE));
            GrabberRecipeRegistry.getInstance().addChiselingRecipe(BlockListener.frozenPot.id, new TieredBlockLootingData(new ItemStack[] {new ItemStack(ItemListener.leatherStrap, 1), new ItemStack(ItemListener.goldenScrew, 1), new ItemStack(Block.SNOW_BLOCK, 1)}, new int[] {50, 70, 30}, 60, TierEnum.PRIMITIVE));
        }
        // Input -> Output
        else if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(BlockListener.nightLog.asItem().id, new ItemStack(Item.COAL, 1, 1));
            SmeltingRegistry.addSmeltingRecipe(BlockListener.nightPlanks.asItem().id, new ItemStack(Block.PLANKS));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.glueMixture.id, new ItemStack(net.kozibrodka.wolves.events.ItemListener.glue));
            SmeltingRegistry.addSmeltingRecipe(BlockListener.woodenBricks.asItem().id, new ItemStack(ItemListener.brickAsh));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.coalOreBrick.id, new ItemStack(Item.COAL));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOreBrick.id, new ItemStack(Item.IRON_INGOT));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOreCrushed.id, new ItemStack(Item.IRON_INGOT));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOreWashed.id, new ItemStack(Item.IRON_INGOT));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOrePowdered.id, new ItemStack(Item.IRON_INGOT));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.ironOrePurified.id, new ItemStack(Item.IRON_INGOT));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOreBrick.id, new ItemStack(Item.GOLD_INGOT));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOreCrushed.id, new ItemStack(Item.GOLD_INGOT));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOreWashed.id, new ItemStack(Item.GOLD_INGOT));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOrePowdered.id, new ItemStack(Item.GOLD_INGOT));
            SmeltingRegistry.addSmeltingRecipe(ItemListener.goldOrePurified.id, new ItemStack(Item.GOLD_INGOT));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.redstoneOreBrick.id, new ItemStack(Item.REDSTONE, 4));

            SmeltingRegistry.addSmeltingRecipe(ItemListener.diamondOreBrick.id, new ItemStack(Item.DIAMOND));

        }
    }

    private static void addAnvilRecipe(ItemStack output, Object[] inputs) {
        AnvilCraftingManager.getInstance().addRecipe(output, inputs);
    }

    public static void addCauldronRecipe(ItemStack output, ItemStack[] inputs) {
        CauldronCraftingManager.getInstance().addRecipe(output, inputs);
    }

    public static void addCrucibleRecipe(ItemStack output, ItemStack[] inputs) {
        CrucibleCraftingManager.getInstance().addRecipe(output, inputs);
    }

    public static void addStokedCauldronRecipe(ItemStack item, ItemStack[] inputs) {
        StokedCauldronCraftingManager.getInstance().addRecipe(item, inputs);
    }
}
