    package net.rainy.armor.effect;

    import net.minecraft.entity.LivingEntity;
    import net.minecraft.entity.effect.StatusEffect;
    import net.minecraft.entity.effect.StatusEffectCategory;
    import net.minecraft.util.math.Vec3d;

    public class SlimeyEffect extends StatusEffect {

        public SlimeyEffect(StatusEffectCategory category, int color) {
            super(category, color);
        }

        // credits to SameDifferent for inspiration , i changed his idea abit , Thank you

        @Override
        public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

            if (entity.horizontalCollision) {

                Vec3d velocity = entity.getVelocity();
                Vec3d climbVec = new Vec3d(
                        velocity.x, 0.2D + (amplifier * 0.05D), velocity.z);
                entity.setVelocity(climbVec.multiply(0.96D));

                entity.velocityModified = true;

                return true;
            }

            return true;
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }