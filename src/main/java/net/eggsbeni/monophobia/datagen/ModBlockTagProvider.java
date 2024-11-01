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
                .add(ModBlocks.OPAQUE_BLOCK.get())
                .add(ModBlocks.RAW_OPAQUE_BLOCK.get())
                .add(ModBlocks.OPAQUE_ORE.get())
                .add(ModBlocks.DEEPSLATE_OPAQUE_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RAW_OPAQUE_BLOCK.get())
                .add(ModBlocks.OPAQUE_ORE.get())
                .add(ModBlocks.DEEPSLATE_OPAQUE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.OPAQUE_BLOCK.get());
    }
}
