package com.schrottii.easydyes.world;

import com.schrottii.easydyes.EasyDyes;
import com.schrottii.easydyes.world.gen.ModFlowerGeneration;
import com.schrottii.easydyes.world.gen.ModGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EasyDyes.MODID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModGeneration.generateInWorld(event);
        ModFlowerGeneration.generateFlowers(event);
    }
}