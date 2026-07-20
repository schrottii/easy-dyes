package com.schrottii.easydyes.integration;

import com.schrottii.easydyes.EasyDyes;
import com.schrottii.easydyes.blocks.ModBlocks;
import com.schrottii.easydyes.recipe.BleachingMachineRecipe;
import com.schrottii.easydyes.recipe.DyeStationRecipe;
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

import javax.annotation.Nonnull;

public class BleachingMachineRecipeCategory implements IRecipeCategory<BleachingMachineRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(EasyDyes.MODID, "bleaching");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(EasyDyes.MODID, "textures/gui/bleaching_machine_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public BleachingMachineRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.BLEACHING_MACHINE.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends BleachingMachineRecipe> getRecipeClass() {
        return BleachingMachineRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Bleaching Machine");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull BleachingMachineRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 29).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 116, 29).addItemStack(recipe.getResultItem());
    }
}