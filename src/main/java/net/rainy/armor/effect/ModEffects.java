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

public class ModEffects {
    public static final RegistryEntry<StatusEffect> EXPLOSION = registerStatusEffect("explosion",
            new ExplosionEffect(StatusEffectCategory.BENEFICIAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(CustomArmor.MOD_ID, "explosion"), +0.1f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> SLIMEY = registerStatusEffect("slimey",
            new SlimeyEffect(StatusEffectCategory.BENEFICIAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(CustomArmor.MOD_ID, "slimey"), -0.15f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    // its slime , so i think its fair i decrease speed? pretty fair yes
    public static final RegistryEntry<StatusEffect> FROSTY = registerStatusEffect("frosty",
            new FrostyEffect(StatusEffectCategory.BENEFICIAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(CustomArmor.MOD_ID, "frosty"), +0.05f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> BEDROCK = registerStatusEffect("bedrock",
            new BedrockEffect(StatusEffectCategory.BENEFICIAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(CustomArmor.MOD_ID, "bedrock"), +0.05f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_SCALE,
                            Identifier.of(CustomArmor.MOD_ID, "bedrock_size"), -0.8f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(CustomArmor.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        CustomArmor.LOGGER.info("Registering Mod Effects such as EXPLOSION and slimeee for " + CustomArmor.MOD_ID);
    }
}