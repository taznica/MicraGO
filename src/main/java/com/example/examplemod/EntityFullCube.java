package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFullCube extends EntityThrowable {
    public EntityFullCube(World worldIn) {
        super(worldIn);
    }

    public EntityFullCube(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityFullCube(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    protected void onImpact(RayTraceResult result) {
//        if(worldObj.isRemote){
//            return;
//        }

        if (result.entityHit != null) {
            return;
        }

        if(result.typeOfHit == RayTraceResult.Type.BLOCK){
            Entity entity = EntityCube.target;
            entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            this.worldObj.spawnEntityInWorld(entity);
        }


        for (int j = 0; j < 8; ++j) {
            this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}
