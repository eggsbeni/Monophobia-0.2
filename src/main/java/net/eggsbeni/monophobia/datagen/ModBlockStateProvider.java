package net.eggsbeni.monophobia.datagen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MonophobiaMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //Opaque Blocks Set
        blockWithItem(ModBlocks.OPAQUE_BLOCK);
        blockWithItem(ModBlocks.RAW_OPAQUE_BLOCK);

        //Opaque Ore Set
        blockWithItem(ModBlocks.OPAQUE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_OPAQUE_ORE);

        //Invasive Rock Set
        blockWithItem(ModBlocks.INVASIVE_ROCK);
        stairsBlock(((StairBlock) ModBlocks.INVASIVE_ROCK_STAIRS.get()), blockTexture(ModBlocks.INVASIVE_ROCK.get()));
        blockItem(ModBlocks.INVASIVE_ROCK_STAIRS); //creates the texture for the item you hold in your hand
        slabBlock(((SlabBlock) ModBlocks.INVASIVE_ROCK_SLAB.get()), blockTexture(ModBlocks.INVASIVE_ROCK.get()), blockTexture(ModBlocks.INVASIVE_ROCK.get()));
        blockItem(ModBlocks.INVASIVE_ROCK_SLAB); //creates the texture for the item you hold in your hand
        wallBlock(((WallBlock) ModBlocks.INVASIVE_ROCK_WALL.get()), blockTexture(ModBlocks.INVASIVE_ROCK.get()));



        //Invasive Stone Set
        blockWithItem(ModBlocks.INVASIVE_STONE);
        stairsBlock(((StairBlock) ModBlocks.INVASIVE_STONE_STAIRS.get()), blockTexture(ModBlocks.INVASIVE_STONE.get()));
        blockItem(ModBlocks.INVASIVE_STONE_STAIRS); //creates the texture for the item you hold in your hand
        slabBlock(((SlabBlock) ModBlocks.INVASIVE_STONE_SLAB.get()), blockTexture(ModBlocks.INVASIVE_STONE.get()), blockTexture(ModBlocks.INVASIVE_STONE.get()));
        blockItem(ModBlocks.INVASIVE_STONE_SLAB); //creates the texture for the item you hold in your hand
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.INVASIVE_STONE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.INVASIVE_STONE.get()));
        blockItem(ModBlocks.INVASIVE_STONE_PRESSURE_PLATE); //creates the texture for the item you hold in your hand
        buttonBlock(((ButtonBlock) ModBlocks.INVASIVE_STONE_BUTTON.get()), blockTexture(ModBlocks.INVASIVE_STONE.get()));

        //Invasive Brick Set
        blockWithItem(ModBlocks.INVASIVE_BRICK);
        stairsBlock(((StairBlock) ModBlocks.INVASIVE_BRICK_STAIRS.get()), blockTexture(ModBlocks.INVASIVE_BRICK.get()));
        blockItem(ModBlocks.INVASIVE_BRICK_STAIRS); //creates the texture for the item you hold in your hand
        slabBlock(((SlabBlock) ModBlocks.INVASIVE_BRICK_SLAB.get()), blockTexture(ModBlocks.INVASIVE_BRICK.get()), blockTexture(ModBlocks.INVASIVE_BRICK.get()));
        blockItem(ModBlocks.INVASIVE_BRICK_SLAB); //creates the texture for the item you hold in your hand
        wallBlock(((WallBlock) ModBlocks.INVASIVE_BRICK_WALL.get()), blockTexture(ModBlocks.INVASIVE_BRICK.get()));

        //Invasive Smoothstone Set
        blockWithItem(ModBlocks.SOLIDIFIED_INVASIVE_STONE);
        slabBlock(((SlabBlock) ModBlocks.SOLIDIFIED_INVASIVE_STONE_SLAB.get()), blockTexture(ModBlocks.SOLIDIFIED_INVASIVE_STONE.get()), blockTexture(ModBlocks.SOLIDIFIED_INVASIVE_STONE.get()));
        blockItem(ModBlocks.SOLIDIFIED_INVASIVE_STONE_SLAB); //creates the texture for the item you hold in your hand

    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("monophobia:block/" + deferredBlock.getId().getPath()));
    }
}
