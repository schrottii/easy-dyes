package com.schrottii.easydyes;

import com.schrottii.easydyes.blocks.entity.ModBlockEntities;
import com.schrottii.easydyes.items.ModItems;
import com.schrottii.easydyes.blocks.ModBlocks;
import com.schrottii.easydyes.recipe.ModRecipes;
import com.schrottii.easydyes.screen.DyeStationScreen;
import com.mojang.logging.LogUtils;
import com.schrottii.easydyes.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
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
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}
