package com.schrottii.easydyes.world.feature;

import com.schrottii.easydyes.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> LUCKY_COLOR_BLOCK =
            FeatureUtils.register("lucky_color_block", Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LUCKY_COLOR_BLOCK.get())));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SEA_HOLLY =
            FeatureUtils.register("sea_holly", Feature.FLOWER,
                    new RandomPatchConfiguration(40, 10, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SEA_HOLLY_FLOWER.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> HELLEBORE =
            FeatureUtils.register("hellebore", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HELLEBORE_FLOWER.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BLACK_RAMPION =
            FeatureUtils.register("black_rampion", Feature.FLOWER,
                    new RandomPatchConfiguration(48, 6, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLACK_RAMPION_FLOWER.get())))));
}
