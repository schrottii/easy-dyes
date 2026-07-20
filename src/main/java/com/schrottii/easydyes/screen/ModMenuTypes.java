package com.schrottii.easydyes.screen;

import com.schrottii.easydyes.EasyDyes;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, EasyDyes.MODID);

    public static final RegistryObject<MenuType<DyeStationMenu>> DYE_STATION_MENU =
            registerMenuType(DyeStationMenu::new, "dye_station_menu");

    public static final RegistryObject<MenuType<BleachingMachineMenu>> BLEACHING_MACHINE_MENU =
            registerMenuType(BleachingMachineMenu::new, "bleaching_machine_menu");

    public static final RegistryObject<MenuType<BlackingMachineMenu>> BLACKING_MACHINE_MENU =
            registerMenuType(BlackingMachineMenu::new, "blacking_machine_menu");

    public static final RegistryObject<MenuType<DyeRemovalMachineMenu>> DYE_REMOVAL_MACHINE_MENU =
            registerMenuType(DyeRemovalMachineMenu::new, "dye_removal_machine_menu");



    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                 String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}