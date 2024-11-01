package net.eggsbeni.monophobia.datagen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
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

        //Invasive Stone Set
        blockWithItem(ModBlocks.INVASIVE_STONE);

        //Invasive Brick Set
        blockWithItem(ModBlocks.INVASIVE_BRICK);

        //Invasive Smoothstone Set
        blockWithItem(ModBlocks.SOLIDIFIED_INVASIVE_STONE);

    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("monophobia:block/" + deferredBlock.getId().getPath()));
    }
}
