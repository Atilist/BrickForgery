package net.alternateadventure.brickforgery.compat.ami;

import net.alternateadventure.brickforgery.compat.ami.alloysmelting.AlloySmeltingRecipeCategory;
import net.alternateadventure.brickforgery.compat.ami.alloysmelting.AlloySmeltingRecipeHandler;
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
import net.alternateadventure.brickforgery.customrecipes.*;
import net.alternateadventure.brickforgery.events.init.BlockListener;
import net.glasslauncher.mods.alwaysmoreitems.api.*;
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
    }

    @Override
    public void onRecipeRegistryAvailable(RecipeRegistry recipeRegistry) {

    }

    @Override
    public SyncableRecipe deserializeRecipe(NbtCompound recipe) {
        return null;
    }
}
