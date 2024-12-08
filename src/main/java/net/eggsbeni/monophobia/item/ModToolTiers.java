package net.eggsbeni.monophobia.item;

import net.eggsbeni.monophobia.util.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    //makes the tool tier for the opaque set
    public static final Tier OPAQUE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_OPAQUE_TOOL, 200, 6.0f, 2.0f, 16, () -> Ingredient.of(ModItems.OPAQUE_INGOT.get()));

}
