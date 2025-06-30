package com.schrottii.easydyes;

import com.schrottii.easydyes.items.ModItems;
import com.schrottii.easydyes.blocks.ModBlocks;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("easydyes")
public class easydyes
{

    // Directly reference a slf4j logger
    public static final String MODID = "easydyes";
    private static final Logger LOGGER = LogUtils.getLogger();

    public easydyes()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup (final FMLClientSetupEvent event) {

    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}
