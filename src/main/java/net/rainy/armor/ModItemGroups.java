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



    public static void registerItemGroups() {
        CustomArmor.LOGGER.info("Registering Item Groups for " + CustomArmor.MOD_ID);
    }
}



