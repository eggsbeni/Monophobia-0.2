package net.eggsbeni.monophobia.item;

// Reminder: Import statements bring in specific classes, methods, or fields from Minecraft or the mod API for use here.
import net.eggsbeni.monophobia.MonophobiaMod; // Imports the MonophobiaMod class, which is the main class of your mod.
import net.eggsbeni.monophobia.item.custom.FuelItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus; // Imports IEventBus, used to manage events in the modding framework.
import net.neoforged.neoforge.registries.DeferredItem; // Imports DeferredItem, for creating and registering items.
import net.neoforged.neoforge.registries.DeferredRegister; // Imports DeferredRegister, for deferred item registration.

// Defines the class ModItems, which contains all custom items for this mod.
public class ModItems {
    // Declares a constant (final) variable named ITEMS, of type DeferredRegister.Items.
    // DeferredRegister.Items is a special type provided by the modding API to manage and register items.
    //Reminder: "public static final" means this variable is accessible throughout the program, has a single instance,
    // and its value is unchangeable after it’s set.
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MonophobiaMod.MOD_ID);

    // Declares a constant variable named OPAQUE_INGOT of type DeferredItem<Item>.
    // DeferredItem is a type that represents an item that will be registered later.
    // Item specifies that this DeferredItem is specifically for Minecraft Item objects.
    public static final DeferredItem<Item> OPAQUE_INGOT =
            // Calls the registerSimpleItem method on ITEMS to register a new item with the name "opaque_ingot".
            ITEMS.registerSimpleItem("opaque_ingot");

    // Declares another constant (final) variable named RAW_OPAQUE of type DeferredItem<Item>.
    public static final DeferredItem<Item> RAW_OPAQUE =
            // Calls the registerItem method on ITEMS to register an item named "raw_opaque".
            // The second argument, Item::new, uses a method reference to create a new Item object.
            // The third argument is an Item.Properties object, setting additional properties for this item.
            ITEMS.registerItem("raw_opaque", Item::new, new Item.Properties());

    public static final DeferredItem<Item> VOLATILE_FRUIT =
            ITEMS.registerItem("volatile_fruit", Item::new, new Item.Properties().food(ModFoodProperties.VOLATILE_FRUIT));

    public static final DeferredItem<Item> CRYSTAL_GROWTH_SHARD =
            ITEMS.registerItem("crystal_growth_shard", properties -> new FuelItem(properties, 1500),new Item.Properties());

    //opaque toolset

    public static final DeferredItem<Item> OPAQUE_SWORD = ITEMS.register("opaque_sword",
            () -> new SwordItem(ModToolTiers.OPAQUE,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.OPAQUE, 3, -2.4f ))));
    public static final DeferredItem<Item> OPAQUE_PICKAXE = ITEMS.register("opaque_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OPAQUE,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.OPAQUE, 1, -2.8f ))));
    public static final DeferredItem<Item> OPAQUE_SHOVEL = ITEMS.register("opaque_shovel",
            () -> new ShovelItem(ModToolTiers.OPAQUE,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.OPAQUE, 1.5f, -3.0f ))));
    public static final DeferredItem<Item> OPAQUE_AXE = ITEMS.register("opaque_axe",
            () -> new AxeItem(ModToolTiers.OPAQUE,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.OPAQUE, 6, -3.2f ))));
    public static final DeferredItem<Item> OPAQUE_HOE = ITEMS.register("opaque_hoe",
            () -> new HoeItem(ModToolTiers.OPAQUE,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.OPAQUE, 0, -3.0f ))));

    // Declares a method named register, with a parameter named eventBus of type IEventBus.
    // This method registers all items in the ITEMS registry, linking them to Minecraft’s event system.
    public static void register(IEventBus eventBus) {
        // Calls the register() method on ITEMS, passing in the eventBus to actually register the items.
        ITEMS.register(eventBus);

    }
}