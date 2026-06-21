package net.rainy.armor.effect;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rainy.armor.effect.ModEffects;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TreeMinerEffect extends StatusEffect {

    private static final int MAX_LOGS = 300; // Prevents server lag on massive trees

    public TreeMinerEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    // Call this in your main ModInitializer class!
    public static void registerEvents() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            if (world.isClient())
                return true;

            if (!player.hasStatusEffect(ModEffects.OAKY))
                return true;

            if (!state.isIn(BlockTags.LOGS))
                return true;

            breakTree(world, pos);
            return true;     });
    }

    public static void breakTree(World world, BlockPos startPos) {
        Set<BlockPos> visitedLogs = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();
        queue.add(startPos);
        visitedLogs.add(startPos);
        while (!queue.isEmpty() && visitedLogs.size() < MAX_LOGS) {
            BlockPos pos = queue.poll();
            BlockState state = world.getBlockState(pos);

            if (!state.isIn(BlockTags.LOGS)) continue;
            world.breakBlock(pos, true);
            for (int x = -2; x <= 2; x++) {
            for (int y = -2; y <= 2; y++) {
               for (int z = -2; z <= 2; z++) {
               if (x == 0 && y == 0 && z == 0) continue;
               BlockPos next = pos.add(x, y, z);
                      BlockState nextState = world.getBlockState(next);
                  if (nextState.isIn(BlockTags.LOGS) && !visitedLogs.contains(next)) {
                            visitedLogs.add(next);
                            queue.add(next);}
                        else if (nextState.isIn(BlockTags.LEAVES)) {
                            world.breakBlock(next, true);
                  }}}
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}