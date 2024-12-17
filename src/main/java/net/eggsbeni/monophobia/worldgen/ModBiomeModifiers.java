package net.eggsbeni.monophobia.worldgen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

// this is step 3, go read Configured Features for more info on worldgen

public class ModBiomeModifiers {

    //creates the key for this step
    public static final ResourceKey<BiomeModifier> ADD_TREE_SECLUDED = registerKey("add_tree_secluded");

    public static final ResourceKey<BiomeModifier> ADD_OPAQUE_ORE = registerKey("add_opaque_ore");

    //places the features in the world
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        //This class looks at the ModPlacedFeatures class for a reference
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);


        //This class also references the biomes that are in the game, so it can add features to them
        var biomes = context.lookup(Registries.BIOME);

        // places the secluded tree in a biome
        context.register(ADD_TREE_SECLUDED, new BiomeModifiers.AddFeaturesBiomeModifier(
                //picks the biome it spawns in
                //if you wanted multiple biomes, you could chang the line below to the following:
                //HolderSet.direct(biomes.getOrThrow(Biomes.___), biomes.getOrThrow(Biomes.____)), with blanks being the biome you want [you can repeat this for as many biomes as you want, just add new biomes.getOrThrow(),]
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SECLUDED_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //opaque ore
        context.register(ADD_OPAQUE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OPAQUE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));


    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID, name));
    }
}