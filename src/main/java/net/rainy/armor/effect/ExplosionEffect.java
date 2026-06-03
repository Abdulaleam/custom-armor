package net.rainy.armor.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ExplosionEffect extends StatusEffect {

    public ExplosionEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xFF6600);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.addStatusEffect(
                new StatusEffectInstance(
                        StatusEffects.RESISTANCE,
                        5,
                        89,
                        false,
                        false,
                        false
                )
        );

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}