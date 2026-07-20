package com.schrottii.easydyes.blocks.entity;

import com.schrottii.easydyes.EasyDyes;
import com.schrottii.easydyes.blocks.entity.custom.BlackingMachineBlockEntity;
import com.schrottii.easydyes.blocks.entity.custom.DyeRemovalMachineBlockEntity;
import com.schrottii.easydyes.blocks.entity.custom.DyeStationBlockEntity;
import com.schrottii.easydyes.blocks.entity.custom.BleachingMachineBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.schrottii.easydyes.blocks.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, EasyDyes.MODID);

    public static final RegistryObject<BlockEntityType<DyeStationBlockEntity>> DYE_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("dye_station_block_entity", () ->
                    BlockEntityType.Builder.of(DyeStationBlockEntity::new,
                            ModBlocks.DYE_STATION.get()).build(null));

    public static final RegistryObject<BlockEntityType<BleachingMachineBlockEntity>> BLEACHING_MACHINE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("bleaching_machine_block_entity", () ->
                    BlockEntityType.Builder.of(BleachingMachineBlockEntity::new,
                            ModBlocks.BLEACHING_MACHINE.get()).build(null));

    public static final RegistryObject<BlockEntityType<BlackingMachineBlockEntity>> BLACKING_MACHINE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("blacking_machine_block_entity", () ->
                    BlockEntityType.Builder.of(BlackingMachineBlockEntity::new,
                            ModBlocks.BLACKING_MACHINE.get()).build(null));

    public static final RegistryObject<BlockEntityType<DyeRemovalMachineBlockEntity>> DYE_REMOVAL_MACHINE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("dye_removal_machine_block_entity", () ->
                    BlockEntityType.Builder.of(DyeRemovalMachineBlockEntity::new,
                            ModBlocks.DYE_REMOVAL_MACHINE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}