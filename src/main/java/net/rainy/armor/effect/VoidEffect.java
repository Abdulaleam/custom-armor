package net.rainy.armor.effect;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class VoidEffect extends StatusEffect {

    private final Random random = new Random();
    private int lastHurtTime = -1;

    // track players that currently have effect
    private static final Set<UUID> VOID_PLAYERS = new HashSet<>();

    public VoidEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    // register interaction ONCE
    public static void register() {
        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {

            if (world.isClient()) return ActionResult.PASS;

            if (!VOID_PLAYERS.contains(player.getUuid())) return ActionResult.PASS;

            if (!player.isSneaking()) return ActionResult.PASS;
            if (!player.getMainHandStack().isEmpty()) return ActionResult.PASS;

            BlockHitResult result = hit;
            var pos = result.getBlockPos();

            if (world.isAir(pos)) return ActionResult.PASS;

            world.setBlockState(pos, Blocks.AIR.getDefaultState());

            world.playSound(
                    null,
                    pos,
                    SoundEvents.BLOCK_PORTAL_TRIGGER,
                    SoundCategory.BLOCKS,
                    0.8f,
                    0.6f
            );

            return ActionResult.SUCCESS;
        });
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (entity.getWorld().isClient()) return true;

        ServerWorld world = (ServerWorld) entity.getWorld();

        VOID_PLAYERS.add(entity.getUuid());

        if (entity.age % 80 == 0) {

            entity.setAbsorptionAmount(entity.getAbsorptionAmount() + 4 + amplifier * 2);
            Box box = entity.getBoundingBox().expand(5.0);

            for (LivingEntity target : world.getEntitiesByClass(LivingEntity.class, box, e -> e != entity)) {
                target.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(StatusEffects.SLOWNESS, 60, 1));

                target.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(StatusEffects.DARKNESS, 40, 0));}

            world.spawnParticles(
                    ParticleTypes.PORTAL,
                    entity.getX(), entity.getY() + 1, entity.getZ(),
                    40, 1.0, 1.0, 1.0, 0.2
            );
        }

        if (entity.hurtTime > 0 && entity.hurtTime != lastHurtTime) {
            lastHurtTime = entity.hurtTime;
            double x = entity.getX() + (random.nextDouble() - 0.5) * 6;
            double y = entity.getY();
            double z = entity.getZ() + (random.nextDouble() - 0.5) * 6;

            entity.requestTeleport(x, y, z);

            world.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1f, 1.2f);
        }

        Box hitBox = entity.getBoundingBox().expand(4.0);
        for (LivingEntity target : world.getEntitiesByClass(LivingEntity.class, hitBox, e -> e != entity)) {
            Vec3d direction = entity.getPos().subtract(target.getPos()).normalize();
            target.setVelocity(direction.x * 0.6, 0.2, direction.z * 0.6);
            target.velocityModified = true;
        }

        return true;
    }
}