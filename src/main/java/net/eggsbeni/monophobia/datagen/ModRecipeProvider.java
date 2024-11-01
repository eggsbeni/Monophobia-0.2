package net.eggsbeni.monophobia.datagen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.ModBlocks;
import net.eggsbeni.monophobia.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> OPAQUE_SMELTABLES = List.of(ModItems.RAW_OPAQUE,
                ModBlocks.OPAQUE_ORE, ModBlocks.DEEPSLATE_OPAQUE_ORE);

        List<ItemLike> INVASIVE_SMELTABLES = List.of(ModBlocks.INVASIVE_ROCK);
        List<ItemLike> SMOOTH_SMELTABLES = List.of(ModBlocks.INVASIVE_STONE);


        //Opaque Ore Crafting Set

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OPAQUE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.OPAQUE_INGOT.get())
                .unlockedBy("has_opaque_ingot", has(ModItems.OPAQUE_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_OPAQUE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.RAW_OPAQUE.get())
                .unlockedBy("has_opaque_ingot", has(ModItems.RAW_OPAQUE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OPAQUE_INGOT.get(), 9)
                .requires(ModBlocks.OPAQUE_BLOCK.get())
                .unlockedBy("has_opaque_ingot", has(ModItems.OPAQUE_INGOT.get())).save(pRecipeOutput);

        //Invasive Rock Crafting Set

        stairBuilder(ModBlocks.INVASIVE_ROCK_STAIRS.get(), Ingredient.of(ModBlocks.INVASIVE_ROCK.get())).group("invasive_rock")
                        .unlockedBy("has_invasive_stone", has(ModBlocks.INVASIVE_ROCK.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVASIVE_ROCK_SLAB.get(), ModBlocks.INVASIVE_ROCK.get());

        //Invasive Stone Crafting Set

        //Invasive Brick Crafting Set

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INVASIVE_BRICK.get())
                .pattern("   ")
                .pattern(" BB")
                .pattern(" BB")
                .define('B', ModBlocks.INVASIVE_STONE.get())
                .unlockedBy("has_invasive_stone", has(ModBlocks.INVASIVE_STONE.get())).save(pRecipeOutput);

        //Smooth Invasive Crafting Set

        //Opaque Ore Smelting Set

        oreSmelting(pRecipeOutput, OPAQUE_SMELTABLES, RecipeCategory.MISC, ModItems.OPAQUE_INGOT.get(), 0.25f, 200, "opaque_ore");
        oreBlasting(pRecipeOutput, OPAQUE_SMELTABLES, RecipeCategory.MISC, ModItems.OPAQUE_INGOT.get(), 0.25f, 100, "opaque_ore");

        //Invasive Blocks Smelting Set
        oreSmelting(pRecipeOutput, INVASIVE_SMELTABLES, RecipeCategory.MISC, ModBlocks.INVASIVE_STONE.get(), 0.1f, 200, "invasive_stone");
        oreBlasting(pRecipeOutput, INVASIVE_SMELTABLES, RecipeCategory.MISC, ModBlocks.INVASIVE_STONE.get(), 0.1f, 100, "invasive_stone");
        oreSmelting(pRecipeOutput, SMOOTH_SMELTABLES, RecipeCategory.MISC, ModBlocks.SOLIDIFIED_INVASIVE_STONE.get(), 0.1f, 200, "solidified_invasive_stone");
        oreBlasting(pRecipeOutput, SMOOTH_SMELTABLES, RecipeCategory.MISC, ModBlocks.SOLIDIFIED_INVASIVE_STONE.get(), 0.1f, 100, "solidified_invasive_stone");
    }




    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }


    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }


    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, MonophobiaMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}