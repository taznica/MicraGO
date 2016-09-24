package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabGo extends CreativeTabs {

    public static final Item item = new ItemCube();

    public TabGo (String label) {
        super (label);
    }

    @Override
    public Item getTabIconItem () {
        return item;
    }
}
