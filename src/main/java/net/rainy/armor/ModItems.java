package net.rainy.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rainy.armor.custom.*;

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
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item SLIME_CHESTPLATE = registerItem("slime_chestplate",
            new SlimeArmorItem(ModArmorMaterials.slime, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item SLIME_LEGGINGS = registerItem("slime_leggings",
            new ArmorItem(ModArmorMaterials.slime, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item SLIME_BOOTS = registerItem("slime_boots",
            new ArmorItem(ModArmorMaterials.slime, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(SlimeArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item SlIME_SLING = Registry.register(
            Registries.ITEM, Identifier.of("custom-armor", "slime_sling"),
            new SlimeSlingItem(new Item.Settings()));
    public static final Item ICE_HELMET = registerItem("ice_helmet",
            new FrostArmorItem(ModArmorMaterials.ice, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item ICE_LEGGINGS = registerItem("ice_leggings",
            new FrostArmorItem(ModArmorMaterials.ice, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item ICE_CHESTPLATE = registerItem("ice_chestplate",
            new ArmorItem(ModArmorMaterials.ice, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item ICE_BOOTS = registerItem("ice_boots",
            new ArmorItem(ModArmorMaterials.ice, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item BEDROCK_HELMET = registerItem("bedrock_helmet",
            new BedrockArmorItem(ModArmorMaterials.bedrock, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item BEDROCK_LEGGINGS = registerItem("bedrock_leggings",
            new BedrockArmorItem(ModArmorMaterials.bedrock, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item BEDROCK_CHESTPLATE = registerItem("bedrock_chestplate",
            new ArmorItem(ModArmorMaterials.bedrock, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item BEDROCK_BOOTS = registerItem("bedrock_boots",
            new ArmorItem(ModArmorMaterials.bedrock, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item BEDROCK_SWORD = Registry.register(
            Registries.ITEM,
            Identifier.of("custom-armor", "bedrock_sword"),
            // Pass the material, bonus damage, speed tracker, and settings
            new BedrockSwordAblity(ToolMaterials.DIAMOND, new Item.Settings())
    );


    public static final Item PEARL_HELMET = registerItem("pearl_helmet",
            new PearlArmorItem(ModArmorMaterials.pearl, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item PEARL_LEGGINGS = registerItem("pearl_leggings",
            new PearlArmorItem(ModArmorMaterials.pearl, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item PEARL_CHESTPLATE = registerItem("pearl_chestplate",
            new ArmorItem(ModArmorMaterials.pearl, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item PEARL_BOOTS = registerItem("pearl_boots",
            new ArmorItem(ModArmorMaterials.pearl, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));



    public static final Item OAK_HELMET = registerItem("oak_helmet",
            new PearlArmorItem(ModArmorMaterials.pearl, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item OAK_LEGGINGS = registerItem("oak_leggings",
            new PearlArmorItem(ModArmorMaterials.pearl, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item OAK_CHESTPLATE = registerItem("oak_chestplate",
            new ArmorItem(ModArmorMaterials.pearl, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item OAK_BOOTS = registerItem("oak_boots",
            new ArmorItem(ModArmorMaterials.pearl, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));






    public static final Item PEARL_SWORD = Registry.register(
            Registries.ITEM,
            Identifier.of("custom-armor", "pearl_sword"),
            // Pass the material, bonus damage, speed tracker, and settings
            new EnderSwordAbility(ToolMaterials.IRON, new Item.Settings())
    );




    public static void registerModItems() {
        CustomArmor.LOGGER.info("Registering Modded items and armor  for " + CustomArmor.MOD_ID);
}}
