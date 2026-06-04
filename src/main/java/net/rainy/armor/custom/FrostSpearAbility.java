package net.rainy.armor.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FrostSpearAbility extends TridentEntity {

    public FrostSpearAbility(EntityType<? extends TridentEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        World world = this.getWorld();
        world.addParticle(ParticleTypes.SNOWFLAKE, this.getX(), this.getY(), this.getZ(), 0.0, 0.02, 0.0);
        if (!world.isClient) {
            BlockPos centerPos = this.getBlockPos();
            int radius = 8;
            int radiusSq = radius * radius;

            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {

                        if ((x * x) + (y * y) + (z * z) <= radiusSq) {
                            BlockPos targetPos = centerPos.add(x, y, z);
                            BlockState state = world.getBlockState(targetPos);

                            if (!state.isAir() && !state.isOf(Blocks.PACKED_ICE)) {
                                world.setBlockState(targetPos, Blocks.PACKED_ICE.getDefaultState());
                            }
                        }
                    }
                }}
        }}
}