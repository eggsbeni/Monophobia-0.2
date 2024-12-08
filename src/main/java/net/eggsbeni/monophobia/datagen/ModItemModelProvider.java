package net.eggsbeni.monophobia.datagen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.block.ModBlocks;
import net.eggsbeni.monophobia.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MonophobiaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Opaque Ore Related
        basicItem(ModItems.RAW_OPAQUE.get());
        basicItem(ModItems.OPAQUE_INGOT.get());

        //Crystal Item Related
        basicItem(ModItems.CRYSTAL_GROWTH_SHARD.get());

        //Food Item Related
        basicItem(ModItems.VOLATILE_FRUIT.get());

        //invasive button
        buttonItem(ModBlocks.INVASIVE_STONE_BUTTON, ModBlocks.INVASIVE_STONE);

        //invasive wall
        wallItem(ModBlocks.INVASIVE_ROCK_WALL, ModBlocks.INVASIVE_ROCK);
        wallItem(ModBlocks.INVASIVE_BRICK_WALL, ModBlocks.INVASIVE_BRICK);

        //invasive fence

        //opaque tools
        handheldItem(ModItems.OPAQUE_SWORD);
        handheldItem(ModItems.OPAQUE_PICKAXE);
        handheldItem(ModItems.OPAQUE_SHOVEL);
        handheldItem(ModItems.OPAQUE_AXE);
        handheldItem(ModItems.OPAQUE_HOE);


    }

    // custom helper method for buttons because for some reason they need a blockstate model and an item model??
    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID, "item/" + item.getId().getPath()));
    }


}
