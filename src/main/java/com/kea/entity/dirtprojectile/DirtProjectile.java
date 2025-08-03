package com.kea.entity.dirtprojectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class DirtProjectile extends PersistentProjectileEntity {
    public DirtProjectile(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected ItemStack asItemStack() {
        return ItemStack.EMPTY;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient){
            this.getWorld().addParticle(ParticleTypes.FLAME,
                    this.getX(),this.getY(),this.getZ(),0.0,0.0,0.0);
        }
        if (this.age > 100){
            this.discard();
        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.setNoGravity(true);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!this.getWorld().isClient && entityHitResult.getEntity() instanceof LivingEntity){
            LivingEntity target = (LivingEntity) entityHitResult.getEntity();
            target.damage(this.getDamageSources().magic(),5.0f);
            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.getWorld().isClient){
            this.discard();
        }
    }
}
