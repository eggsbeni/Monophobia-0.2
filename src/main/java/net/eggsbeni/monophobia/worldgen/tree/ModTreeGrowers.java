package net.eggsbeni.monophobia.worldgen.tree;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {

    //creates the tree grower for the secluded trees
    public static final TreeGrower SECLUDED = new TreeGrower(MonophobiaMod.MOD_ID + ":secluded",
            Optional.empty(), Optional.of(ModConfiguredFeatures.SECLUDED_KEY), Optional.empty());
}
