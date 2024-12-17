package net.eggsbeni.monophobia.item;

// Reminder: Import statements bring in specific classes, methods, or fields from other parts of Minecraft or the mod API.
import net.eggsbeni.monophobia.MonophobiaMod; // Imports the MonophobiaMod class (the main class of your mod).
import net.eggsbeni.monophobia.block.ModBlocks;
import net.minecraft.core.registries.Registries; // Imports Registries, a class that manages game elements.
import net.minecraft.network.chat.Component; // Imports Component, which represents text (like item names).
import net.minecraft.resources.ResourceLocation; // Imports ResourceLocation, specifies locations for resources.
import net.minecraft.world.item.CreativeModeTab; // Imports CreativeModeTab, representing tabs in Creative Mode.
import net.minecraft.world.item.ItemStack; // Imports ItemStack, which is a stack of items (useful for icons).
import net.minecraft.world.item.Items; // Imports Items, giving access to standard Minecraft items.
import net.neoforged.bus.api.IEventBus; // Imports IEventBus, which manages events in the modding API.
import net.neoforged.neoforge.registries.DeferredRegister; // Imports DeferredRegister, which registers items later.

import java.util.function.Supplier; // Imports Supplier, a functional interface that supplies items when needed.

// Defines the class ModCreativeModeTabs, containing Creative Mode tabs for items and blocks in the mod.
public class ModCreativeModeTabs {
    // Declares a constant (final) variable of type DeferredRegister, named CREATIVE_MODE_TABS.
    // DeferredRegister<CreativeModeTab> is a generic type that registers CreativeModeTab objects.
    // Reminder: "public static final" means this variable is accessible across other classes, only one instance exists,
    // and it cannot be changed after initialization.
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            // Calls the create method of DeferredRegister, passing the registry and the mod ID.
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MonophobiaMod.MOD_ID);

    // Declares a constant (final) variable of type Supplier<CreativeModeTab>, named MONOPHOBIA_ITEMS_TAB.
    // Reminder: Supplier is an interface that generates or "supplies" a CreativeModeTab object when needed.
    public static final Supplier<CreativeModeTab> MONOPHOBIA_ITEMS_TAB =
            // Calls the register method on CREATIVE_MODE_TABS to create a new Creative Mode tab.
            CREATIVE_MODE_TABS.register("monophobia_items_tab", () ->
                    // Defines the new tab with CreativeModeTab.builder(), a method to set up properties.
                    CreativeModeTab.builder()
                            // Sets the title for the tab using the title() method.
                            // Component.translatable() allows translation of text ("itemGroup.monophobia.monophobia_items_tab").
                            .title(Component.translatable("itemGroup.monophobia.monophobia_items_tab"))
                            // Sets an icon for the tab using the icon() method.
                            // Creates a new ItemStack (a stack of items) with ModItems.OPAQUE_INGOT as the icon item.
                            .icon(() -> new ItemStack(ModItems.OPAQUE_INGOT.get()))
                            // Defines which items will display in the tab using displayItems().
                            // basically this is the list of things that will appear in the tab
                            .displayItems((pParameters, pOutput) -> {
                                // Uses pOutput.accept() to add ModItems.ITEM_NAME to the tab.
                                // Opaque Items
                                pOutput.accept(ModItems.OPAQUE_INGOT);
                                pOutput.accept(ModItems.RAW_OPAQUE);
                                // Food Items
                                pOutput.accept(ModItems.VOLATILE_FRUIT);
                                // Fuel Items
                                pOutput.accept(ModItems.CRYSTAL_GROWTH_SHARD);
                                //opaque tools
                                pOutput.accept(ModItems.OPAQUE_SWORD);
                                pOutput.accept(ModItems.OPAQUE_PICKAXE);
                                pOutput.accept(ModItems.OPAQUE_SHOVEL);
                                pOutput.accept(ModItems.OPAQUE_AXE);
                                pOutput.accept(ModItems.OPAQUE_HOE);
                                //opaque armor
                                pOutput.accept(ModItems.OPAQUE_HELMET);
                                pOutput.accept(ModItems.OPAQUE_CHESTPLATE);
                                pOutput.accept(ModItems.OPAQUE_LEGGINGS);
                                pOutput.accept(ModItems.OPAQUE_BOOTS);
                                //opaque armor trim
                                pOutput.accept(ModItems.MONO_SMITHING_TEMPLATE);
                            })
                            // Finalizes the creation of the tab with build(), which completes the setup.
                            .build());

    // Declares another constant (final) variable of type Supplier<CreativeModeTab>, named MONOPHOBIA_BLOCKS_TAB.
    public static final Supplier<CreativeModeTab> MONOPHOBIA_BLOCKS_TAB =
            // Registers another Creative Mode tab, using "monophobia_blocks_tab" as its name.
            CREATIVE_MODE_TABS.register("monophobia_blocks_tab", () ->
                    CreativeModeTab.builder()
                            // Sets the title for this tab to a translatable component (text that can be translated).
                            .title(Component.translatable("itemGroup.monophobia.monophobia_blocks_tab"))
                            // Sets the tab icon to a new ItemStack containing ModItems.RAW_OPAQUE.
                            .icon(() -> new ItemStack(ModBlocks.OPAQUE_BLOCK.get()))
                            // Uses withTabsBefore() to place this tab before the items tab in the menu.
                            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID, "monophobia_items_tab"))
                            // Defines items for this tab using displayItems().
                            // basically this is the list of things that will appear in the tab
                            .displayItems((pParameters, pOutput) -> {
                                //adds things the same way as the item tab above
                                // Opaque Blocks
                                pOutput.accept(ModBlocks.OPAQUE_BLOCK);
                                pOutput.accept(ModBlocks.RAW_OPAQUE_BLOCK);
                                pOutput.accept(ModBlocks.OPAQUE_ORE);
                                pOutput.accept(ModBlocks.DEEPSLATE_OPAQUE_ORE);
                                // Invasive Rock Blocks
                                pOutput.accept(ModBlocks.INVASIVE_ROCK);
                                pOutput.accept(ModBlocks.INVASIVE_ROCK_STAIRS);
                                pOutput.accept(ModBlocks.INVASIVE_ROCK_SLAB);
                                pOutput.accept(ModBlocks.INVASIVE_ROCK_WALL);
                                // Invasive Stone Blocks
                                pOutput.accept(ModBlocks.INVASIVE_STONE);
                                pOutput.accept(ModBlocks.INVASIVE_STONE_STAIRS);
                                pOutput.accept(ModBlocks.INVASIVE_STONE_SLAB);
                                pOutput.accept(ModBlocks.INVASIVE_STONE_PRESSURE_PLATE);
                                pOutput.accept(ModBlocks.INVASIVE_STONE_BUTTON);
                                // Invasive Brick Blocks
                                pOutput.accept(ModBlocks.INVASIVE_BRICK);
                                pOutput.accept(ModBlocks.INVASIVE_BRICK_STAIRS);
                                pOutput.accept(ModBlocks.INVASIVE_BRICK_SLAB);
                                pOutput.accept(ModBlocks.INVASIVE_BRICK_WALL);
                                // Invasive Smooth Blocks
                                pOutput.accept(ModBlocks.SOLIDIFIED_INVASIVE_STONE);
                                pOutput.accept(ModBlocks.SOLIDIFIED_INVASIVE_STONE_SLAB);
                                // Secluded Wood Blocks
                                pOutput.accept(ModBlocks.SECLUDED_LOG);
                                pOutput.accept(ModBlocks.STRIPPED_SECLUDED_LOG);
                                pOutput.accept(ModBlocks.SECLUDED_WOOD);
                                pOutput.accept(ModBlocks.STRIPPED_SECLUDED_WOOD);
                                pOutput.accept(ModBlocks.SECLUDED_PLANKS);
                                pOutput.accept(ModBlocks.SECLUDED_LEAVES);
                                pOutput.accept(ModBlocks.SECLUDED_SAPLING);
                                // Secluded Grass Block
                                pOutput.accept(ModBlocks.SECLUDED_GRASS_BLOCK);
                            })
                            // Completes the tab creation.
                            .build());

    // Declares a method named register, with a parameter named eventbus of type IEventBus.
    // The register method will be called to register all custom Creative Mode tabs for the mod.
    public static void register(IEventBus eventbus) {
        // Calls the register() method on CREATIVE_MODE_TABS to register tabs on the provided eventbus.
        CREATIVE_MODE_TABS.register(eventbus);
    }
}