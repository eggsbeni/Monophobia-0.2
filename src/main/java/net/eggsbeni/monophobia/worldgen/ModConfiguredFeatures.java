package net.eggsbeni.monophobia.worldgen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    //This is the start of the 3 world gen classes, they have a specific order:
    //Configured Features -> Placed Features -> Biome Modifier
    //To explain what each does:
    //Configured Feature - how does my tree look like (the tree is the feature we are configuring)
    //Placed Features -> how is the tree going to be placed in the world (how many will be there, where might they be placed, ect...)
    //Biome Modifier - in what biome should these placed features be put in (what biome does stuff spawn in)

    //registers the secluded key, for some reason each step requires a key to be created for that step
    public static final ResourceKey<ConfiguredFeature<?, ?>> SECLUDED_KEY = registerKey("secluded");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OPAQUE_ORE_KEY = registerKey("opaque_ore");

    //register method calls for the configuration (heres where we set up all the details of the generated stuff)
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        //creates the idea of what the secluded tree looks like
        //but this can be a plug and play for any tree we want to make
        //we register the generated object as a tree, and use the treeconfigurationbuilder
        register(context, SECLUDED_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                //selects the secluded log as its base
                BlockStateProvider.simple(ModBlocks.SECLUDED_LOG.get()),
                //creates the trunk of the tree with different possible heights that are random in game
                //this tree is specifically a straittrunkplacer right now but there are other kinds of trunks to look at
                new DarkOakTrunkPlacer(10, 3, 2),
                //selects the secluded leaf as the leaf of the tree
                BlockStateProvider.simple(ModBlocks.SECLUDED_LEAVES.get()),
                //creates the leaves of the tree in a blob shape, with multiple possible patterns
                //there are other placement patterns other than blob, so look at those too
                new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(5), 5),
                //this determines how close together other things can spawn from it
                new TwoLayersFeatureSize(1, 0, 2)).build());

        RuleTest stoneRelpaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> opaqueOres = List.of(
                OreConfiguration.target(stoneRelpaceables, ModBlocks.OPAQUE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_OPAQUE_ORE.get().defaultBlockState()));

        register(context, OPAQUE_ORE_KEY, Feature.ORE, new OreConfiguration(opaqueOres, 8));

    }

    //helper methods

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

//     public static final TrunkPlacerType<StraightTrunkPlacer> STRAIGHT_TRUNK_PLACER;
//    public static final TrunkPlacerType<ForkingTrunkPlacer> FORKING_TRUNK_PLACER;
//    public static final TrunkPlacerType<GiantTrunkPlacer> GIANT_TRUNK_PLACER;
//    public static final TrunkPlacerType<MegaJungleTrunkPlacer> MEGA_JUNGLE_TRUNK_PLACER;
//    public static final TrunkPlacerType<DarkOakTrunkPlacer> DARK_OAK_TRUNK_PLACER;
//    public static final TrunkPlacerType<FancyTrunkPlacer> FANCY_TRUNK_PLACER;
//    public static final TrunkPlacerType<BendingTrunkPlacer> BENDING_TRUNK_PLACER;
//    public static final TrunkPlacerType<UpwardsBranchingTrunkPlacer> UPWARDS_BRANCHING_TRUNK_PLACER;
//    public static final TrunkPlacerType<CherryTrunkPlacer> CHERRY_TRUNK_PLACER;

//blob bush fancy are the bush types