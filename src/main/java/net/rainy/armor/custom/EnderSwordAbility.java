package net.rainy.armor.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.concurrent.ConcurrentHashMap;

public class EnderSwordAbility extends SwordItem {

    private static final ConcurrentHashMap<java.util.UUID, LivingEntity> LINKED = new ConcurrentHashMap<>();

    public EnderSwordAbility(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (attacker.getWorld().isClient()) return super.postHit(stack, target, attacker);
        if (!(attacker instanceof PlayerEntity player)) return super.postHit(stack, target, attacker);

        ServerWorld world = (ServerWorld) attacker.getWorld();

        if (player.isSneaking()) {
            LINKED.put(player.getUuid(), target);
               world.playSound(null, target.getBlockPos(), SoundEvents.ENTITY_GENERIC_EXPLODE.value(), SoundCategory.PLAYERS, 1f, 1f);

            return super.postHit(stack, target, attacker);
        }

        Vec3d dir = target.getPos().subtract(player.getPos()).normalize();

        double x = player.getX() + dir.x * 2;
        double y = player.getY();
        double z = player.getZ() + dir.z * 2;

        player.requestTeleport(x, y, z);


        world.playSound(null, target.getBlockPos(), SoundEvents.ENTITY_GENERIC_EXPLODE.value(), SoundCategory.PLAYERS, 1f, 1f);
          return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient())

            return TypedActionResult.pass(user.getStackInHand(hand));
        if (!(world instanceof ServerWorld serverWorld))

            return TypedActionResult.pass(user.getStackInHand(hand));

        LivingEntity target = LINKED.remove(user.getUuid());
        if (target == null || !target.isAlive()) {

            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        Vec3d dir = user.getRotationVec(1.0F).normalize();
        Vec3d launch = dir.multiply(6.5);
        target.setVelocity(launch.x, launch.y * 0.5, launch.z);
               target.velocityModified = true;

        serverWorld.playSound(null, target.getBlockPos(), SoundEvents.ENTITY_GENERIC_EXPLODE.value(), SoundCategory.PLAYERS, 1f, 1f);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}