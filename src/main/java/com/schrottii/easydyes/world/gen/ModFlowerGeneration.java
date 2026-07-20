package com.schrottii.easydyes.world.gen;

import com.schrottii.easydyes.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;

public class ModFlowerGeneration {
    public static void generateFlowers(final BiomeLoadingEvent event) {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

        if(types.contains(BiomeDictionary.Type.BEACH) || types.contains(BiomeDictionary.Type.RIVER)) {
            base.add(ModPlacedFeatures.SEA_HOLLY_PLACED);
        }
        if(types.contains(BiomeDictionary.Type.FOREST)) {
            base.add(ModPlacedFeatures.HELLEBORE_PLACED);
            base.add(ModPlacedFeatures.BLACK_RAMPION_PLACED);
        }
    }
}