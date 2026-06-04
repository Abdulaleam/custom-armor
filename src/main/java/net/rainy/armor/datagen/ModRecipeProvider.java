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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TNT_SWORD)
                .pattern("R")
                .pattern("R")
                .pattern("F")
                .input('R', Items.TNT)
                .input('F', Items.STICK)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.TNT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SlIME_SLING)
                .pattern("RF ")
                .pattern("R F")
                .pattern("RF ")
                .input('R', Items.SLIME_BALL)
                .input('F', Items.STICK)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLIME_CHESTPLATE)
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', Items.SLIME_BALL)

                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLIME_LEGGINGS)
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .input('R', Items.SLIME_BALL)

                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLIME_BOOTS)
                .pattern("R R")
                .pattern("R R")
                .input('R', Items.SLIME_BALL)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_HELMET)
                .pattern("RRR")
                .pattern("R R")
                .input('R', Items.SNOWBALL)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.SNOWBALL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_CHESTPLATE)
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', Items.SNOWBALL)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.SNOWBALL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_LEGGINGS)
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .input('R', Items.SNOWBALL)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.SNOWBALL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_BOOTS)
                .pattern("R R")
                .pattern("R R")
                .input('R', Items.SNOWBALL)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.SNOWBALL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLIME_HELMET)
                .pattern("RRR")
                .pattern("R R")
                .input('R', Items.SLIME_BALL)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BEDROCK)
                .pattern("RF")
                .input('F', Items.COBBLESTONE)
                .input('R', Items.WHITE_BED)
                .input('R', Items.ORANGE_BED)
                .input('R', Items.MAGENTA_BED)
                .input('R', Items.LIGHT_BLUE_BED)
                .input('R', Items.YELLOW_BED)
                .input('R', Items.LIME_BED)
                .input('R', Items.PINK_BED)
                .input('R', Items.GRAY_BED)
                .input('R', Items.LIGHT_GRAY_BED)
                .input('R', Items.CYAN_BED)
                .input('R', Items.PURPLE_BED)
                .input('R', Items.BLUE_BED)
                .input('R', Items.BROWN_BED)
                .input('R', Items.GREEN_BED)
                .input('R', Items.RED_BED)
                .input('R', Items.WHITE_BED)
                .input('R', Items.ORANGE_BED)
                .input('R', Items.MAGENTA_BED)
                .input('R', Items.LIGHT_BLUE_BED)
                .input('R', Items.YELLOW_BED)
                .input('R', Items.LIME_BED)
                .input('R', Items.PINK_BED)
                .input('R', Items.GRAY_BED)
                .input('R', Items.LIGHT_GRAY_BED)
                .input('R', Items.CYAN_BED)
                .input('R', Items.PURPLE_BED)
                .input('R', Items.BLUE_BED)
                .input('R', Items.BROWN_BED)
                .input('R', Items.GREEN_BED)
                .input('R', Items.RED_BED)
                .input('R', Items.BLACK_BED)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEDROCK_HELMET)
                .pattern("RRR")
                .pattern("R R")
                .input('R', Items.BEDROCK)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEDROCK_CHESTPLATE)
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', Items.BEDROCK)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEDROCK_LEGGINGS)
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .input('R', Items.BEDROCK)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEDROCK_BOOTS)
                .pattern("R R")
                .pattern("R R")
                .input('R', Items.BEDROCK)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);







    }
}
