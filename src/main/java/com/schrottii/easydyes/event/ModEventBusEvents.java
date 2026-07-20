package com.schrottii.easydyes.event;

import com.schrottii.easydyes.recipe.BlackingMachineRecipe;
import com.schrottii.easydyes.recipe.BleachingMachineRecipe;
import com.schrottii.easydyes.recipe.DyeRemovalMachineRecipe;
import com.schrottii.easydyes.recipe.DyeStationRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, DyeStationRecipe.Type.ID, DyeStationRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, BleachingMachineRecipe.Type.ID, BleachingMachineRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, BlackingMachineRecipe.Type.ID, BlackingMachineRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, DyeRemovalMachineRecipe.Type.ID, DyeRemovalMachineRecipe.Type.INSTANCE);
    }
}
