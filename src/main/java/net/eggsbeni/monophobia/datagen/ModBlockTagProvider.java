package net.eggsbeni.monophobia.datagen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MonophobiaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                //opaque set
                .add(ModBlocks.OPAQUE_BLOCK.get())
                .add(ModBlocks.RAW_OPAQUE_BLOCK.get())
                .add(ModBlocks.OPAQUE_ORE.get())
                .add(ModBlocks.DEEPSLATE_OPAQUE_ORE.get())
                //invasive rock set
                .add(ModBlocks.INVASIVE_ROCK.get())
                .add(ModBlocks.INVASIVE_ROCK_STAIRS.get())
                .add(ModBlocks.INVASIVE_ROCK_SLAB.get())
                //invasive stone set
                .add(ModBlocks.INVASIVE_STONE.get())
                .add(ModBlocks.INVASIVE_STONE_STAIRS.get())
                .add(ModBlocks.INVASIVE_STONE_SLAB.get())
                //invasive brick set
                .add(ModBlocks.INVASIVE_BRICK.get())
                .add(ModBlocks.INVASIVE_STONE_STAIRS.get())
                .add(ModBlocks.INVASIVE_STONE_SLAB.get())
                //invasive smoothstone set
                .add(ModBlocks.SOLIDIFIED_INVASIVE_STONE.get())
                .add(ModBlocks.SOLIDIFIED_INVASIVE_STONE_SLAB.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                //opaque set
                .add(ModBlocks.RAW_OPAQUE_BLOCK.get())
                .add(ModBlocks.OPAQUE_ORE.get())
                .add(ModBlocks.DEEPSLATE_OPAQUE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                //opaque set
                .add(ModBlocks.OPAQUE_BLOCK.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.INVASIVE_BRICK_WALL.get())
                .add(ModBlocks.INVASIVE_ROCK_WALL.get());
    }
}
