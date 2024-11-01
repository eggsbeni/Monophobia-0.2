package net.eggsbeni.monophobia.datagen;

import net.eggsbeni.monophobia.block.ModBlocks;
import net.eggsbeni.monophobia.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {

        //Opaque Set
        dropSelf(ModBlocks.RAW_OPAQUE_BLOCK.get());
        dropSelf(ModBlocks.OPAQUE_BLOCK.get());
        this.add(ModBlocks.OPAQUE_ORE.get(),
                block -> createOreDrop(ModBlocks.OPAQUE_ORE.get(), ModItems.RAW_OPAQUE.get()));
        this.add(ModBlocks.DEEPSLATE_OPAQUE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_OPAQUE_ORE.get(), ModItems.RAW_OPAQUE.get()));
        //Invasive Rock Set
        dropSelf(ModBlocks.INVASIVE_ROCK.get());
        dropSelf(ModBlocks.INVASIVE_ROCK_STAIRS.get());
        this.add(ModBlocks.INVASIVE_ROCK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.INVASIVE_ROCK_SLAB.get()));
        //Invasive Stone Set
        dropSelf(ModBlocks.INVASIVE_STONE.get());
        //Invasive Brick Set
        dropSelf(ModBlocks.INVASIVE_BRICK.get());
        //Invasive Smooth Set
        dropSelf(ModBlocks.SOLIDIFIED_INVASIVE_STONE.get());


    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
