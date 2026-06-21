package net.rainy.armor.custom;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import net.rainy.armor.effect.ModEffects;

import java.util.List;
import java.util.Map;

public class OakArmorItem extends ArmorItem {

    private static final Map<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>>()
                    .put(ModArmorMaterials.oak,
                            List.of(
                                    new StatusEffectInstance(ModEffects.OAKY, 400, 2, false, false))).build();


    public OakArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (world.isClient()) {
            super.inventoryTick(stack, world, entity, slot, selected);
            return;
        }

        if (entity instanceof PlayerEntity player) {

            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);}
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {

        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry
                : MATERIAL_TO_EFFECT_MAP.entrySet()) {

            if (hasCorrectArmorOn(entry.getKey(), player)) {
                addStatusEffectForMaterial(player, entry.getValue());
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player,
                                            List<StatusEffectInstance> effects) {

        for (StatusEffectInstance instance : effects) {

            player.addStatusEffect(new StatusEffectInstance(
                    instance.getEffectType(),
                    220, // refresh timer (keeps it active)
                    instance.getAmplifier(),
                    true,
                    false,
                    false
            ));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {

        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chest = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !boots.isEmpty()
                && !leggings.isEmpty()
                && !chest.isEmpty()
                && !helmet.isEmpty();
    }

    private boolean hasCorrectArmorOn(RegistryEntry<ArmorMaterial> material,
                                      PlayerEntity player) {

        for (ItemStack stack : player.getInventory().armor) {
            if (!(stack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem chest = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();

        return helmet.getMaterial() == material
                && chest.getMaterial() == material
                && leggings.getMaterial() == material
                && boots.getMaterial() == material;
    }
}