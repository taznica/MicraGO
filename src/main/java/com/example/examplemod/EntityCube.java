package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCube extends EntityThrowable {

    public EntityCube(World worldIn) {
        super(worldIn);
    }

    public EntityCube(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityCube(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    protected void onImpact(RayTraceResult result)
    {
        if(worldObj.isRemote){
            return;
        }

        if (result.entityHit != null)
        {
            Entity target = result.entityHit;
            target.entityDropItem(new ItemStack(ExampleMod.fullCube), 1);
        }

        for (int j = 0; j < 8; ++j)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }



    /*
    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(8, (byte) 0);
    }

    @Override
    protected void onImpact(MovingObjectPosition position) {


        if (position.entityHit != null) {
            if(!worldObj.isRemote) {


//          position.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);

                Entity target = position.entityHit;
//                int id = target.getEntityId();

//                System.out.println("-=-=-=-=-=-=-=-=-=-=-=" + id + "-=-=-=-=-=-=-=-=-=-=-=");

//                ItemStack dropegg = new ItemStack(Items.spawn_egg, 1, 50);
//                target.entityDropItem(dropegg, 1);


                target.entityDropItem(new ItemStack(ExampleMod.fullball), 1);

                for (int i = 0; i < 20; ++i) {
                    this.worldObj.spawnParticle("magicCrit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
                }

                target.setDead();
            }
        }

        if (position.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY) {
            byte meta = dataWatcher.getWatchableObjectByte(8);
        }


        for (int i = 0; i < 8; ++i) {
            this.worldObj.spawnParticle("magicCrit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if(!worldObj.isRemote){
            this.setDead();
        }
    }


    public void setMeta(byte meta) {
        dataWatcher.updateObject(8, meta);
    }

    public void readEntityFromNBT(NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        if (tagCompound.hasKey("meta")) {
            dataWatcher.updateObject(8, tagCompound.getByte("meta"));
        } else {
            dataWatcher.updateObject(8, (byte) 0);
        }
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setByte("meta", dataWatcher.getWatchableObjectByte(8));
    }



    */

}

