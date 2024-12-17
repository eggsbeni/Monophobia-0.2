package net.eggsbeni.monophobia.worldgen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

//This is step 2, go to ModConfiguredFeatures for more details regarding worldgen

public class ModPlacedFeatures {

    //registers the secluded_placed key so we can pass it in below
    public static final ResourceKey<PlacedFeature> SECLUDED_PLACED_KEY = registerKey("secluded_placed");

    public static final ResourceKey<PlacedFeature> OPAQUE_ORE_PLACED_KEY = registerKey("opaque_ore_placed_key");

    //this looks at the Configured Feature class for a reference/context and is also where the features are built
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ? >> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //in the case of the secluded tree, we created the tree itself in modconfigured features, what we do here is allow it to generate in the world
        //we start by creating the key for this step
        register(context, SECLUDED_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SECLUDED_KEY),
                //this is saying that we want the thing to be placed like a tree (treePlacement)
                //the count extra method means that we spawn 3 of them (3) with a 10% chance (0.1f) of spawing 2 more (2) [make sure the chance thing maths out to not be infinitely repeating or the thing breaks]
                //including the modblocks.secluded_sapling.get allows us to say that the trees can generate only where the sapling block would survive
                //this way we prevent the tree from spawning on top of other trees or blocks that wouldn't work
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,0.1f, 2),
                        ModBlocks.SECLUDED_SAPLING.get()));

        register(context, OPAQUE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OPAQUE_ORE_KEY),
                ModOrePlacements.commonOrePlacement(25,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))));



    }


    //helper methods

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
