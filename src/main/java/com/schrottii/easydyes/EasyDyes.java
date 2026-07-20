package com.schrottii.easydyes;

import com.schrottii.easydyes.blocks.entity.ModBlockEntities;
import com.schrottii.easydyes.items.ModItems;
import com.schrottii.easydyes.blocks.ModBlocks;
import com.schrottii.easydyes.recipe.ModRecipes;
import com.schrottii.easydyes.screen.*;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("easydyes")
public class EasyDyes
{

    // Directly reference a slf4j logger
    public static final String MODID = "easydyes";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EasyDyes()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup (final FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.DYE_STATION_MENU.get(), DyeStationScreen::new);
        MenuScreens.register(ModMenuTypes.BLEACHING_MACHINE_MENU.get(), BleachingMachineScreen::new);
        MenuScreens.register(ModMenuTypes.BLACKING_MACHINE_MENU.get(), BlackingMachineScreen::new);
        MenuScreens.register(ModMenuTypes.DYE_REMOVAL_MACHINE_MENU.get(), DyeRemovalMachineScreen::new);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SEA_HOLLY_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HELLEBORE_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_RAMPION_FLOWER.get(), RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}
