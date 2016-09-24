package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    public static final CreativeTabs tabGo = new TabGo("tabgo");

    public static final Item cube = new ItemCube();
    public static final Item fullCube = new ItemFullCube();
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.register(cube, new ResourceLocation(MODID, "cube"));
//        EntityRegistry.registerModEntity(EntityCube.class, "cube", EntityRegistry.findGlobalUniqueEntityId(), this, 10, 10, true);
//        RenderingRegistry.registerEntityRenderingHandler(EntityCube.class, new RenderBall(cube));

        GameRegistry.register(fullCube, new ResourceLocation(MODID, "fullCube"));
//        EntityRegistry.registerModEntity(EntityFullCube.class, "fullCube", EntityRegistry.findGlobalUniqueEntityId(), this, 10, 10, true);
//        RenderingRegistry.registerEntityRenderingHandler(EntityFullCube.class, new RenderBall(fullCube));
    }
}
