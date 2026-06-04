package net.rainy.armor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Items;
import net.rainy.armor.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TNT_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TNT_LEGGINGS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TNT_CHESTPLATE));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TNT_BOOTS));
        itemModelGenerator.register(ModItems.TNT_SWORD, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SLIME_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SLIME_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SLIME_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SLIME_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ICE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ICE_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ICE_LEGGINGS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ICE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BEDROCK_HELMET));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BEDROCK_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BEDROCK_LEGGINGS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BEDROCK_BOOTS));
        itemModelGenerator.register(ModItems.BEDROCK_SWORD, Models.HANDHELD);







    }
}
