package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemCube extends Item {
    public ItemCube () {
        super();
        setCreativeTab(ExampleMod.tabGo);
        setUnlocalizedName(ExampleMod.MODID + "_monstercube");
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World worldIn, EntityPlayer playerIn) {
        if (!playerIn.capabilities.isCreativeMode) {
            --itemStack.stackSize;
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            EntityCube cube = new EntityCube(worldIn, playerIn);
            worldIn.spawnEntityInWorld(cube);
        }

        return itemStack;
    }
}
