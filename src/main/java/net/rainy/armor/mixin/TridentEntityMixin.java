package net.rainy.armor.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TridentEntity.class)
public abstract class TridentEntityMixin extends PersistentProjectileEntity {
    @Unique private boolean hasExploded = false;
    @Unique private int blocksPierced = 0;
    @Unique private BlockPos lastBoredPos = null;

    protected TridentEntityMixin(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTridentTick(CallbackInfo ci) {
        World world = this.getWorld();

        world.addParticle(ParticleTypes.GLOW, this.getX(), this.getY() + 0.2, this.getZ(), 0.0, 0.02, 0.0);

        Entity owner = this.getOwner();
        if (owner != null && owner.isAlive() && owner.getWorld() == world) {
            Vec3d start = owner.getPos().add(0, 1.2, 0);
            Vec3d end = this.getPos();
            double distance = start.distanceTo(end);
            int particleCount = (int) (distance * 2);

            for (int i = 0; i <= particleCount; i++) {
                double t = (double) i / particleCount;
                double pX = start.x + (end.x - start.x) * t;
                double pY = start.y + (end.y - start.y) * t;
                double pZ = start.z + (end.z - start.z) * t;
                world.addParticle(ParticleTypes.INSTANT_EFFECT, pX, pY, pZ, 0, 0, 0);
            }}
        if (!world.isClient) {
            BlockPos centerPos = this.getBlockPos();

            if (!this.inGround && this.getVelocity().lengthSquared() > 0.1) {
                if (blocksPierced < 10 && !centerPos.equals(lastBoredPos)) {
                    int radius = 6;
                    int radiusSq = radius * radius;
                    int innerRadiusSq = (radius - 1) * (radius - 1);
                    boolean hitSolidBlockThisTick = false;

                    for (int x = -radius; x <= radius; x++) {
                        for (int y = -radius; y <= radius; y++) {
                            for (int z = -radius; z <= radius; z++) {
                                int distanceSq = (x * x) + (y * y) + (z * z);
                                if (distanceSq <= radiusSq) {
                         BlockPos targetPos = centerPos.add(x, y, z);
                           BlockState state = world.getBlockState(targetPos);
                              if (state.getHardness(world, targetPos) < 0)
                                  continue;
                               if (distanceSq <= innerRadiusSq) {
                                    if (!state.isAir()) {

                                 if (!state.isOf(Blocks.PACKED_ICE)) {

                                  hitSolidBlockThisTick = true;
                                     }
                                            world.setBlockState(targetPos, Blocks.AIR.getDefaultState(), 2);}
                                    } else {
                                        if (!state.isAir() && !state.isOf(Blocks.PACKED_ICE)) {
                                        world.setBlockState(targetPos, Blocks.PACKED_ICE.getDefaultState(), 2);}
                               }}
                            }}
                    }
                    if (hitSolidBlockThisTick) {blocksPierced++;}
                    lastBoredPos = centerPos;
                }}
            if ((this.inGround || this.getVelocity().lengthSquared() < 0.01) && !hasExploded) {
             world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 3.0f, true, World.ExplosionSourceType.BLOCK);
             hasExploded = true;
            }
        }
    }
}