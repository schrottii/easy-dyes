package com.schrottii.easydyes.recipe;

import com.schrottii.easydyes.EasyDyes;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, EasyDyes.MODID);

    public static final RegistryObject<RecipeSerializer<DyeStationRecipe>> DYE_STATIONING_SERIALIZER =
            SERIALIZERS.register("dye_stationing", () -> DyeStationRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}