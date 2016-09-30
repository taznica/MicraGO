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

public class ItemFullCube extends Item {
    public ItemFullCube () {
        super();
        setCreativeTab(ExampleMod.tabGo);
        setUnlocalizedName(ExampleMod.MODID + "_monsterfullcube");
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

        if (!playerIn.capabilities.isCreativeMode) {
            --itemStackIn.stackSize;
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote) {
            EntityFullCube fullCube = new EntityFullCube(worldIn, playerIn);
            worldIn.spawnEntityInWorld(fullCube);
            fullCube.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        }

        return ActionResult.newResult(EnumActionResult.PASS, itemStackIn);
    }

    public int getMetadata(int damage)
    {
        return damage;
    }

//    public ItemColored setSubtypeNames(String[] names)
//    {
//        this.subtypeNames = names;
//        return this;
//    }
//
//    public String getUnlocalizedName(ItemStack stack)
//    {
//        if (this.subtypeNames == null)
//        {
//            return super.getUnlocalizedName(stack);
//        }
//        else
//        {
//            int i = stack.getMetadata();
//            return i >= 0 && i < this.subtypeNames.length ? super.getUnlocalizedName(stack) + "." + this.subtypeNames[i] : super.getUnlocalizedName(stack);
//        }
//    }
}
