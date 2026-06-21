package net.rainy.armor;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup TNT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CustomArmor.MOD_ID, "custom_armor_tnt"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.TNT))
                    .displayName(Text.translatable("itemgroup.armor.tnt"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TNT_SWORD);
                        entries.add(ModItems.TNT_HELMET);
                        entries.add(ModItems.TNT_CHESTPLATE);
                        entries.add(ModItems.TNT_LEGGINGS);
                        entries.add(ModItems.TNT_BOOTS);

                    }).build());
    public static final ItemGroup SLIME_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CustomArmor.MOD_ID, "custom_armor_slime"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.SLIME_BALL))
                    .displayName(Text.translatable("itemgroup.armor.slime"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SlIME_SLING);
                        entries.add(ModItems.SLIME_HELMET);
                        entries.add(ModItems.SLIME_CHESTPLATE);
                        entries.add(ModItems.SLIME_LEGGINGS);
                        entries.add(ModItems.SLIME_BOOTS);



                    }).build());
    public static final ItemGroup FROST = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CustomArmor.MOD_ID, "custom_armor_ice"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.SNOWBALL))
                    .displayName(Text.translatable("itemgroup.armor.ice"))
                    .entries((displayContext, entries) -> {
                        entries.add(Items.TRIDENT);
                        entries.add(ModItems.ICE_LEGGINGS);
                        entries.add(ModItems.ICE_HELMET);
                        entries.add(ModItems.ICE_CHESTPLATE);
                        entries.add(ModItems.ICE_BOOTS);


                    }).build());
    public static final ItemGroup BEDROCK = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CustomArmor.MOD_ID, "custom_armor_bedrock"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.BEDROCK))
                    .displayName(Text.translatable("itemgroup.armor.bedrock"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BEDROCK_SWORD);
                        entries.add(ModItems.BEDROCK_HELMET);
                        entries.add(ModItems.BEDROCK_CHESTPLATE);
                        entries.add(ModItems.BEDROCK_LEGGINGS);
                        entries.add(ModItems.BEDROCK_BOOTS);


                    }).build());


    public static final ItemGroup PEARL = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CustomArmor.MOD_ID, "custom_armor_pearl"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.ENDER_PEARL))
                    .displayName(Text.translatable("itemgroup.armor.pearl"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PEARL_SWORD);
                        entries.add(ModItems.PEARL_HELMET);
                        entries.add(ModItems.PEARL_CHESTPLATE);
                        entries.add(ModItems.PEARL_LEGGINGS);
                        entries.add(ModItems.PEARL_BOOTS);


                    }).build());
    public static final ItemGroup OAK = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CustomArmor.MOD_ID, "custom_armor_oak"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.OAK_LOG))
                    .displayName(Text.translatable("itemgroup.armor.oak"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.OAK_HELMET);
                        entries.add(ModItems.OAK_CHESTPLATE);
                        entries.add(ModItems.OAK_LEGGINGS);
                        entries.add(ModItems.OAK_BOOTS);


                    }).build());

    public static void registerItemGroups(){
        CustomArmor.LOGGER.info("registergingg groupss :) for " + CustomArmor.MOD_ID);
    }


}



