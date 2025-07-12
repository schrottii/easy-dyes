package com.schrottii.easydyes.world.feature;

import com.schrottii.easydyes.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> LUCKY_COLOR_BLOCK =
            FeatureUtils.register("lucky_color_block", Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LUCKY_COLOR_BLOCK.get())));
}
