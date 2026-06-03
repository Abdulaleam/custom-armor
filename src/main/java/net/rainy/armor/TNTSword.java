package net.rainy.armor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;

public class TNTSword extends SwordItem {


        public TNTSword(Settings settings) {
                super(ToolMaterials.IRON, settings);
        }

        @Override
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

                target.getWorld().createExplosion(
                        attacker, target.getX(), target.getY(), target.getZ(),
                        4.0F, false, net.minecraft.world.World.ExplosionSourceType.TNT
                );

                return super.postHit(stack, target, attacker);
        }
}