package net.rainy.armor.effect;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TreeMinerEffect extends StatusEffect {

    public TreeMinerEffect(StatusEffectCategory category, int color) {
        super(category, color);}

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        return true;
    }

    public static void breakTree(World world, BlockPos startPos) {
        if (world.isClient)
        {return;}

        BlockState startState = world.getBlockState(startPos);

        if (!startState.isIn(BlockTags.LOGS))
        {return;}

        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();

        queue.add(startPos);
        visited.add(startPos);

        while (!queue.isEmpty()) {
            BlockPos pos = queue.poll();
            BlockState state = world.getBlockState(pos);

            if (!state.isIn(BlockTags.LOGS))
            {continue;}

            world.breakBlock(pos, true);

            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -1; z <= 1; z++) {
                        BlockPos nextPos = pos.add(x, y, z);

                        if (!visited.contains(nextPos)) {
                            BlockState nextState = world.getBlockState(nextPos);

                            if (nextState.isIn(BlockTags.LOGS)) {
                                visited.add(nextPos);
                                queue.add(nextPos);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}