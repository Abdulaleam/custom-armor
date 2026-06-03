package net.rainy.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SlimeSlingItem extends Item {

    public SlimeSlingItem(Settings settings) {
        super(settings);
    }

    // THIS SHIT WORKSSSS HOLYYYYYYYYYYYYYYYYYYYYYY 2H
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity player)) return;

        int timeUsed = this.getMaxUseTime(stack, user) - remainingUseTicks;

        float power = timeUsed / 10f;
        power = (power * power + power * 2f) / 2f;
        power *= 4f;

        if (power > 2f) power = 4f;

        Vec3d look = player.getRotationVec(1.0f).normalize();

        player.addVelocity(-look.x * power, -look.y * power / 3f, -look.z * power
        );

        player.velocityModified = true;
        player.playSound(SoundEvents.ENTITY_SLIME_JUMP_SMALL, 1f, 1f);
        player.fallDistance = 0;

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.isClient) return;
        if (!(entity instanceof PlayerEntity player)) return;


        if (!selected || !player.isSneaking()) return;

        if (!player.isOnGround())  {

            world.createExplosion(
                    player,
                    player.getX(), player.getY(), player.getZ(), 4.0f,
                    World.ExplosionSourceType.MOB
            );

            player.fallDistance = 0;
        }
    }
}