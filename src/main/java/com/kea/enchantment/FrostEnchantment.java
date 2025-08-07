package com.kea.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FrostEnchantment extends Enchantment {
    public FrostEnchantment() {
        super(Enchantment.Rarity.UNCOMMON,EnchantmentTarget.WEAPON,new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 10 + 15 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity){
            ((LivingEntity)target).
                    addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,80+40*(level-1),level-1));
        }
        super.onTargetDamaged(user, target, level);
    }
}
