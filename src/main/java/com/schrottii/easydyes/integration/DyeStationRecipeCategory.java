package com.schrottii.easydyes.integration;

import com.schrottii.easydyes.EasyDyes;
import com.schrottii.easydyes.blocks.ModBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import com.schrottii.easydyes.recipe.DyeStationRecipe;

import javax.annotation.Nonnull;

public class DyeStationRecipeCategory implements IRecipeCategory<DyeStationRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(EasyDyes.MODID, "dye_stationing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(EasyDyes.MODID, "textures/gui/dye_station_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public DyeStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.DYE_STATION.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends DyeStationRecipe> getRecipeClass() {
        return DyeStationRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Dye Station");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull DyeStationRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 29).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 48).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 116, 29).addItemStack(recipe.getResultItem());
    }
}