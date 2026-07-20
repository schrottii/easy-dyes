package com.schrottii.easydyes.integration;

import com.schrottii.easydyes.EasyDyes;
import com.schrottii.easydyes.recipe.BlackingMachineRecipe;
import com.schrottii.easydyes.recipe.BleachingMachineRecipe;
import com.schrottii.easydyes.recipe.DyeRemovalMachineRecipe;
import com.schrottii.easydyes.recipe.DyeStationRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(EasyDyes.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                DyeStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                BleachingMachineRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                BlackingMachineRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                DyeRemovalMachineRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<DyeStationRecipe> recipes = rm.getAllRecipesFor(DyeStationRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(DyeStationRecipeCategory.UID, DyeStationRecipe.class), recipes);

        List<BleachingMachineRecipe> recipes2 = rm.getAllRecipesFor(BleachingMachineRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(BleachingMachineRecipeCategory.UID, BleachingMachineRecipe.class), recipes2);

        List<BlackingMachineRecipe> recipes3 = rm.getAllRecipesFor(BlackingMachineRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(BlackingMachineRecipeCategory.UID, BlackingMachineRecipe.class), recipes3);

        List<DyeRemovalMachineRecipe> recipes4 = rm.getAllRecipesFor(DyeRemovalMachineRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(DyeRemovalMachineRecipeCategory.UID, DyeRemovalMachineRecipe.class), recipes4);
    }
}