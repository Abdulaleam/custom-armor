package net.rainy.armor.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.rainy.armor.CustomArmor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> EXPLOSION =
            register("explosion", new ExplosionEffect());

    private static RegistryEntry<StatusEffect> register(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(CustomArmor.MOD_ID, name), effect



        );}


    public static void registerEffects() {
        CustomArmor.LOGGER.info("Registering Customized  Mod Effects such as explosion and cactus damage  for " + CustomArmor.MOD_ID);
    }
}