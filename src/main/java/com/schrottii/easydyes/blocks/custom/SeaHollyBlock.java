package com.schrottii.easydyes.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SeaHollyBlock extends FlowerBlock
{
    public SeaHollyBlock(MobEffect p_53512_, int p_53513_, BlockBehaviour.Properties p_53514_) {
        super(p_53512_, p_53513_, p_53514_);
    }

    protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
        return p_51042_.is(BlockTags.DIRT) || p_51042_.is(Blocks.FARMLAND) || p_51042_.is(BlockTags.SAND);
    }
}
