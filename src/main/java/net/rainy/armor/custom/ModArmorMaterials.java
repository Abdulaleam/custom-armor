package net.rainy.armor.custom;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.rainy.armor.CustomArmor;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;
// adding the materials class
public class ModArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> tnt = registerArmorMaterial("tnt",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 4);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 3);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(Items.TNT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(CustomArmor.MOD_ID, "tnt"))), 0,0));
    public static final RegistryEntry<ArmorMaterial> slime = registerArmorMaterial("slime",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 1);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 1);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(Items.TNT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(CustomArmor.MOD_ID, "slime"))), 0,0));
    public static final RegistryEntry<ArmorMaterial> ice = registerArmorMaterial("ice",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS,3);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 5);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(Items.PACKED_ICE),
                    List.of(new ArmorMaterial.Layer(Identifier.of(CustomArmor.MOD_ID, "ice"))), 0,0));
    public static final RegistryEntry<ArmorMaterial> bedrock = registerArmorMaterial("bedrock",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS,100);
                map.put(ArmorItem.Type.LEGGINGS, 100);
                map.put(ArmorItem.Type.CHESTPLATE,100);
                map.put(ArmorItem.Type.HELMET, 100);
                map.put(ArmorItem.Type.BODY, 100);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(Items.PACKED_ICE),
                    List.of(new ArmorMaterial.Layer(Identifier.of(CustomArmor.MOD_ID, "bedrock"))), 0,0));





    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(CustomArmor.MOD_ID, name), material.get());
    }
}
