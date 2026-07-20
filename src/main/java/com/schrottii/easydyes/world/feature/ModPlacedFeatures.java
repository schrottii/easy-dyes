package com.schrottii.easydyes.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> LUCKY_COLOR_BLOCK_PLACED = PlacementUtils.register("lucky_color_block",
            ModConfiguredFeatures.LUCKY_COLOR_BLOCK, RarityFilter.onAverageOnceEvery(64),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());

    public static final Holder<PlacedFeature> SEA_HOLLY_PLACED = PlacementUtils.register("sea_holly_placed",
            ModConfiguredFeatures.SEA_HOLLY, RarityFilter.onAverageOnceEvery(12),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> HELLEBORE_PLACED = PlacementUtils.register("hellebore_placed",
            ModConfiguredFeatures.HELLEBORE, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> BLACK_RAMPION_PLACED = PlacementUtils.register("black_rampion_placed",
            ModConfiguredFeatures.BLACK_RAMPION, RarityFilter.onAverageOnceEvery(24),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
}
