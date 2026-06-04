package net.rainy.armor.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

public class BedrockSwordAblity extends SwordItem {

    private static final Identifier FLIP_MODIFIER_ID = Identifier.of("armor", "bedrock_flip");

    public BedrockSwordAblity(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial,settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.getWorld().isClient()) {

            EntityAttributeInstance scaleAttribute = target.getAttributeInstance(EntityAttributes.GENERIC_SCALE);

            boolean hasLevitation = target.hasStatusEffect(StatusEffects.LEVITATION);

            if (!attacker.isSneaking()) {
                     target.setCustomName(net.minecraft.text.Text.literal("Dinnerbone"));
                target.setCustomNameVisible(false);
                if (hasLevitation) {
                    target.removeStatusEffect(StatusEffects.LEVITATION);

                } else {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 999999, 1, false, false));
                }
            }

            else {

                if (scaleAttribute != null && !scaleAttribute.hasModifier(FLIP_MODIFIER_ID)) {
                     EntityAttributeModifier smallModifier = new EntityAttributeModifier(FLIP_MODIFIER_ID, -0.5D,
                            EntityAttributeModifier.Operation.ADD_VALUE
                    );

                    scaleAttribute.addTemporaryModifier(smallModifier);
                }
                target.setCustomName(net.minecraft.text.Text.literal("Dinnerbone"));
                   target.setCustomNameVisible(false);
            }
        }

        return super.postHit(stack, target, attacker);
    }
}