package net.eggsbeni.monophobia.datagen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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

    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
