package net.rainy.armor.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class EnderSwordAbility extends SwordItem {

    private final Random random = new Random();

    public EnderSwordAbility(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.getWorld().isClient()) {
            Vec3d targetPos = target.getPos();
            Vec3d attackerPos = attacker.getPos();
            boolean sneaking = attacker.isSneaking();
            Entity atk = (Entity) attacker;
            Entity tgt = (Entity) target;
            if (sneaking) {
                double radius = 6.0;
                double x = attackerPos.x + (random.nextDouble() - 0.5) * radius;
                double y = attackerPos.y;
                double z = attackerPos.z + (random.nextDouble() - 0.5) * radius;
                atk.requestTeleport(x, y, z);
                spawnPortal(target, attackerPos);
                spawnPortal(target, new Vec3d(x, y, z));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 0));
                target.getWorld().playSound(null, target.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1f, 1f
                );

            } else {
                if (random.nextFloat() < 0.35f) {
                    atk.requestTeleport(targetPos.x, targetPos.y, targetPos.z);
                    tgt.requestTeleport(attackerPos.x, attackerPos.y, attackerPos.z);
                    spawnPortal(target, targetPos);
                    spawnPortal(target, attackerPos);

                } else {
                    double blinkRadius = 3.0;
                    double x = targetPos.x + (random.nextDouble() - 0.5) * blinkRadius;
                    double y = targetPos.y;
                    double z = targetPos.z + (random.nextDouble() - 0.5) * blinkRadius;
                    tgt.requestTeleport(x, y, z);
                    spawnPortal(target, targetPos);
                    spawnPortal(target, new Vec3d(x, y, z));
                }
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 82, 0));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 84, 1));

                target.getWorld().playSound(null, target.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1f, 1.2f
                );
            }}
        return super.postHit(stack, target, attacker);
    }
    private void spawnPortal(LivingEntity entity, Vec3d pos) {
        for (int i = 0; i < 15; i++) {
                         entity.getWorld().addParticle(
                    ParticleTypes.PORTAL, pos.x, pos.y + 1, pos.z, (random.nextDouble() - 0.5) * 0.2,
                    (random.nextDouble() - 0.5) * 0.2, (random.nextDouble() - 0.5) * 0.2
            );
        }
    }
}