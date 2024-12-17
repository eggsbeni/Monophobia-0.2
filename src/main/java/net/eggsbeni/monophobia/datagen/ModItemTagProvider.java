package net.eggsbeni.monophobia.datagen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.ModBlocks;
import net.eggsbeni.monophobia.item.ModItems;
import net.eggsbeni.monophobia.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, MonophobiaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.OPAQUE_HELMET.get())
                .add(ModItems.OPAQUE_CHESTPLATE.get())
                .add(ModItems.OPAQUE_LEGGINGS.get())
                .add(ModItems.OPAQUE_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.OPAQUE_INGOT.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.MONO_SMITHING_TEMPLATE.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SECLUDED_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_SECLUDED_LOG.get().asItem())
                .add(ModBlocks.SECLUDED_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_SECLUDED_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.SECLUDED_PLANKS.get().asItem());


    }
}
