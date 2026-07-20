package com.schrottii.easydyes.blocks;

import com.schrottii.easydyes.EasyDyes;
import com.schrottii.easydyes.ModCreativeTab;
import com.schrottii.easydyes.blocks.custom.*;
import com.schrottii.easydyes.items.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.schrottii.easydyes.ModCreativeTab;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

@Mod.EventBusSubscriber(modid = EasyDyes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EasyDyes.MODID);


    public static final RegistryObject<Block> DYE_STATION = registerBlock("dye_station",
            () -> new DyeStationBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).noOcclusion()));

    public static final RegistryObject<Block> BLEACHING_MACHINE = registerBlock("bleaching_machine",
            () -> new BleachingMachineBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).noOcclusion()));

    public static final RegistryObject<Block> BLACKING_MACHINE = registerBlock("blacking_machine",
            () -> new BlackingMachineBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).noOcclusion()));

    public static final RegistryObject<Block> DYE_REMOVAL_MACHINE = registerBlock("dye_removal_machine",
            () -> new DyeRemovalMachineBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).noOcclusion()));

    public static final RegistryObject<Block> LUCKY_COLOR_BLOCK = registerBlock("lucky_color_block",
            () -> new Block(Block.Properties.of(Material.STONE).strength(1f, 1200f)));

    public static final RegistryObject<Block> SEA_HOLLY_FLOWER = registerBlock("sea_holly_flower",
            () -> new SeaHollyBlock(MobEffects.WATER_BREATHING, 120,  Block.Properties.of(Material.PLANT).strength(0f, 1f).noCollission()));

    public static final RegistryObject<Block> HELLEBORE_FLOWER = registerBlock("hellebore_flower",
            () -> new FlowerBlock(MobEffects.CONFUSION, 30,  Block.Properties.of(Material.PLANT).strength(0f, 1f).noCollission()));

    public static final RegistryObject<Block> BLACK_RAMPION_FLOWER = registerBlock("black_rampion_flower",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 30,  Block.Properties.of(Material.PLANT).strength(0f, 1f).noCollission()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, ModCreativeTab.EASYDYES);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
        };
    }
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
