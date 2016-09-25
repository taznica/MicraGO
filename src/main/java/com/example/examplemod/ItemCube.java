package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemCube extends Item {
    public ItemCube () {
        super();
        setCreativeTab(ExampleMod.tabGo);
        setUnlocalizedName(ExampleMod.MODID + "_monstercube");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (!playerIn.capabilities.isCreativeMode) {
            --itemStackIn.stackSize;
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            EntityCube cube = new EntityCube(worldIn, playerIn);
            worldIn.spawnEntityInWorld(cube);
            cube.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        }

        return ActionResult.newResult(EnumActionResult.PASS, itemStackIn);

//        playerIn.addStat(StatList.getObjectUseStats(this));
//        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
