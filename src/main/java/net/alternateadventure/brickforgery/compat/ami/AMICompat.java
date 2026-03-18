package net.alternateadventure.brickforgery.compat.ami;

import net.alternateadventure.brickforgery.compat.ami.alloysmelting.AlloySmeltingRecipeCategory;
import net.alternateadventure.brickforgery.compat.ami.alloysmelting.AlloySmeltingRecipeHandler;
import net.alternateadventure.brickforgery.compat.ami.brickforging.BrickForgingRecipeCategory;
import net.alternateadventure.brickforgery.compat.ami.brickforging.BrickForgingRecipeHandler;
import net.alternateadventure.brickforgery.compat.ami.brickframing.BrickFramingRecipeCategory;
import net.alternateadventure.brickforgery.compat.ami.brickframing.BrickFramingRecipeHandler;
import net.alternateadventure.brickforgery.compat.ami.crushing.CrushingRecipeCategory;
import net.alternateadventure.brickforgery.compat.ami.crushing.CrushingRecipeHandler;
import net.alternateadventure.brickforgery.compat.ami.metalworking.MetalworkingRecipeCategory;
import net.alternateadventure.brickforgery.compat.ami.metalworking.MetalworkingRecipeHandler;
import net.alternateadventure.brickforgery.compat.ami.slicing.SlicingRecipeCategory;
import net.alternateadventure.brickforgery.compat.ami.slicing.SlicingRecipeHandler;
import net.alternateadventure.brickforgery.compat.ami.washing.WashingRecipeCategory;
import net.alternateadventure.brickforgery.compat.ami.washing.WashingRecipeHandler;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.alternateadventure.brickforgery.events.init.ItemListener;
import net.alternateadventure.brickforgery.registry.machine.AlloySmeltingRecipeRegistry;
import net.alternateadventure.brickforgery.registry.machine.BrickForgingRecipeRegistry;
import net.alternateadventure.brickforgery.registry.machine.BrickFramingRecipeRegistry;
import net.alternateadventure.brickforgery.registry.machine.CrushingRecipeRegistry;
import net.alternateadventure.brickforgery.registry.machine.MetalworkingRecipeRegistry;
import net.alternateadventure.brickforgery.registry.machine.SlicingRecipeRegistry;
import net.alternateadventure.brickforgery.registry.machine.WashingRecipeRegistry;
import net.glasslauncher.mods.alwaysmoreitems.api.AMIHelpers;
import net.glasslauncher.mods.alwaysmoreitems.api.ItemRegistry;
import net.glasslauncher.mods.alwaysmoreitems.api.ModPluginProvider;
import net.glasslauncher.mods.alwaysmoreitems.api.ModRegistry;
import net.glasslauncher.mods.alwaysmoreitems.api.RecipeRegistry;
import net.glasslauncher.mods.alwaysmoreitems.api.SyncableRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.modificationstation.stationapi.api.util.Identifier;

public class AMICompat implements ModPluginProvider {

    @Override
    public String getName() {
        return "Brick Forgery";
    }

    @Override
    public Identifier getId() {
        return BlockListener.MOD_ID.id("brickforgery");
    }

    @Override
    public void onAMIHelpersAvailable(AMIHelpers amiHelpers) {

    }

    @Override
    public void onItemRegistryAvailable(ItemRegistry itemRegistry) {

    }

    @Override
    public void register(ModRegistry registry) {
        registry.addRecipeCategories(new AlloySmeltingRecipeCategory());
        registry.addRecipeHandlers(new AlloySmeltingRecipeHandler());
        registry.addRecipes(AlloySmeltingRecipeRegistry.getInstance().getRecipes());

        registry.addRecipeCategories(new BrickFramingRecipeCategory());
        registry.addRecipeHandlers(new BrickFramingRecipeHandler());
        registry.addRecipes(BrickFramingRecipeRegistry.getInstance().getRecipes());

        registry.addRecipeCategories(new CrushingRecipeCategory());
        registry.addRecipeHandlers(new CrushingRecipeHandler());
        registry.addRecipes(CrushingRecipeRegistry.getInstance().getRecipes());

        registry.addRecipeCategories(new MetalworkingRecipeCategory());
        registry.addRecipeHandlers(new MetalworkingRecipeHandler());
        registry.addRecipes(MetalworkingRecipeRegistry.getInstance().getRecipes());

        registry.addRecipeCategories(new SlicingRecipeCategory());
        registry.addRecipeHandlers(new SlicingRecipeHandler());
        registry.addRecipes(SlicingRecipeRegistry.getInstance().getRecipes());

        registry.addRecipeCategories(new WashingRecipeCategory());
        registry.addRecipeHandlers(new WashingRecipeHandler());
        registry.addRecipes(WashingRecipeRegistry.getInstance().getRecipes());

        registry.addRecipeCategories(new BrickForgingRecipeCategory());
        registry.addRecipeHandlers(new BrickForgingRecipeHandler());
        registry.addRecipes(BrickForgingRecipeRegistry.getInstance().getRecipes());

        registry.addDescription(new ItemStack(ItemListener.sandBrick), "description.brickforgery.sand_brick");
        registry.addDescription(new ItemStack(BlockListener.sandinator), "description.brickforgery.sandinator");
        registry.addDescription(new ItemStack(BlockListener.nightCane), "description.brickforgery.night_cane");
        registry.addDescription(new ItemStack(BlockListener.sugarCaneBrickFrameCrafter), "description.brickforgery.brick_frame_crafter");
        registry.addDescription(new ItemStack(BlockListener.primitiveBrickFrameCrafter), "description.brickforgery.brick_frame_crafter");
        registry.addDescription(new ItemStack(BlockListener.brickFrameCrafter), "description.brickforgery.brick_frame_crafter");
        registry.addDescription(new ItemStack(BlockListener.exoticShrub), "description.brickforgery.exotic_shrub");
        registry.addDescription(new ItemStack(ItemListener.exoticFruit), "description.brickforgery.exotic_fruit");
    }

    @Override
    public void onRecipeRegistryAvailable(RecipeRegistry recipeRegistry) {

    }

    @Override
    public SyncableRecipe deserializeRecipe(NbtCompound recipe) {
        return null;
    }

    @Override
    public void updateBlacklist(AMIHelpers amiHelpers) {

    }
}
