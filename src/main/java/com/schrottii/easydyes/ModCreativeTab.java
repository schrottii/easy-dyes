package com.schrottii.easydyes;

import com.schrottii.easydyes.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab extends CreativeModeTab {
    private ModCreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.NORMALITEM.get());
    }

    public static final ModCreativeTab EASYDYES = new ModCreativeTab(CreativeModeTab.TABS.length, "Easy Dyes");
}