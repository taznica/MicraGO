package com.example.examplemod;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    public static final CreativeTabs tabGo = new TabGo("tabgo");

    public static Entity TARGET;

    public static final Item cube = new ItemCube();
    public static final Item fullCube = new ItemFullCube();
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

        int trackingRange = 80;
        int updateFrequency = 3;
        boolean sendVelocityUpdates = true;

        GameRegistry.register(cube, new ResourceLocation(MODID, "cube"));
        EntityRegistry.registerModEntity(EntityCube.class, "entityCube", 0, this, trackingRange, updateFrequency, sendVelocityUpdates, 2243405, 7375001);
//        EntityRegistry.addSpawn(Entity.class, 8, 4, 4, EnumCreatureType.AMBIENT, BiomeGenBase.getBiome(0));

        if (event.getSide().isClient()) {
            //1IDで複数モデルを登録するなら、上のメソッドで登録した登録名を指定する。
            ModelLoader.setCustomModelResourceLocation(cube, 0, new ModelResourceLocation(MODID + ":" + "cube", "inventory"));
        }

        GameRegistry.register(fullCube, new ResourceLocation(MODID, "fullCube"));
        EntityRegistry.registerModEntity(EntityFullCube.class, "entityFullCube", 0, this, trackingRange, updateFrequency, sendVelocityUpdates, 2243405, 7375001);
    }
}
