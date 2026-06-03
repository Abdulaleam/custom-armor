package net.rainy.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rainy.armor.custom.ModArmorItem;
import net.rainy.armor.custom.ModArmorMaterials;
import net.rainy.armor.custom.SlimeArmorItem;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CustomArmor.MOD_ID, name), item);
    }
    public static final Item TNT_HELMET = registerItem("tnt_helmet",
            new ModArmorItem(ModArmorMaterials.tnt, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item TNT_CHESTPLATE = registerItem("tnt_chestplate",
            new ModArmorItem(ModArmorMaterials.tnt, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item TNT_LEGGINGS = registerItem("tnt_leggings",
            new ArmorItem(ModArmorMaterials.tnt, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item TNT_BOOTS = registerItem("tnt_boots",
            new ArmorItem(ModArmorMaterials.tnt, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item TNT_SWORD = Registry.register(
            Registries.ITEM, Identifier.of("custom-armor", "tnt_sword"),
            new TNTSword(new Item.Settings())
    );
    public static final Item SLIME_HELMET = registerItem("slime_helmet",
            new SlimeArmorItem(ModArmorMaterials.slime, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item SLIME_CHESTPLATE = registerItem("slime_chestplate",
            new SlimeArmorItem(ModArmorMaterials.slime, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item SLIME_LEGGINGS = registerItem("slime_leggings",
            new ArmorItem(ModArmorMaterials.slime, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item SLIME_BOOTS = registerItem("slime_boots",
            new ArmorItem(ModArmorMaterials.slime, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(SlimeArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item SlIME_SLING = Registry.register(
            Registries.ITEM, Identifier.of("custom-armor", "slime_sling"),
            new SlimeSlingItem(new Item.Settings())
    );
    public static void registerModItems() {
        CustomArmor.LOGGER.info("Registering Modded items and armor  for " + CustomArmor.MOD_ID);
}}
