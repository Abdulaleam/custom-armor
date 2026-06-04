package net.rainy.armor.effect;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FrostyEffect extends StatusEffect {

    public FrostyEffect(StatusEffectCategory category, int color) {
        super(category, color);}
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.isSneaking())
        {return true;}
        World world = entity.getWorld();
        if (world.isClient)
        {return true;}

        if (entity.isSprinting()) {
            BlockPos centerPos = entity.getBlockPos();
            int radius = 3;
            int radiusSq = radius * radius;
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    if ((x * x) + (z * z) <= radiusSq) {
                        for (int y = -3; y <= -1; y++) {
                            BlockPos targetPos = centerPos.add(x, y, z);
                            world.setBlockState(targetPos, Blocks.PACKED_ICE.getDefaultState());
                        }
                    }
                }}}
        return true;
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}