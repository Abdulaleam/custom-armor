package net.rainy.armor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.rainy.armor.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TNT_CHESTPLATE)
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', Items.TNT)

                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.TNT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TNT_HELMET)
                .pattern("RRR")
                .pattern("R R")
                .input('R', Items.TNT)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.TNT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TNT_LEGGINGS)
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .input('R', Items.TNT)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.TNT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TNT_BOOTS)
                .pattern("R R")
                .pattern("R R")
                .input('R', Items.TNT)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.TNT))
                .offerTo(exporter);


    }
}
