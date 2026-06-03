package net.rainy.armor.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.rainy.armor.CustomArmor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> EXPLOSION = registerStatusEffect("explosion",
            new ExplosionEffect(StatusEffectCategory.BENEFICIAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(CustomArmor.MOD_ID, "explosion"), -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(CustomArmor.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        CustomArmor.LOGGER.info("Registering Mod Effects for " + CustomArmor.MOD_ID);
    }
}