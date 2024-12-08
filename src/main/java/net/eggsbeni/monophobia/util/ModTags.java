package net.eggsbeni.monophobia.util;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    //creates tags that blocks can be sorted into
    public static class Blocks {

        //this is the tag that checks if a block is too strong for the opaque tool to mine
        public static final TagKey<Block> INCORRECT_FOR_OPAQUE_TOOL = createTag("incorrect_for_opaque_tool");
        //this is the tag that checks if the block needs the opaque toolset or better in order to break it
        public static final TagKey<Block> NEEDS_OPAQUE_TOOL = createTag("needs_opaque_tool");

        //runs the code that will actually create the tags
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID, name));
        }


    }

    //creates tags that items can be sorted into
    public static class Items {


        //runs the code that will actually create the tags
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID, name));
        }
    }
}
