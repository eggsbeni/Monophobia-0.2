package net.eggsbeni.monophobia.item;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.checkerframework.checker.units.qual.A;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, MonophobiaMod.MOD_ID);

    public static final Holder<ArmorMaterial> OPAQUE =
           ARMOR_MATERIALS.register("opaque", () -> new ArmorMaterial(
                   Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                       map.put(ArmorItem.Type.BOOTS, 2);
                       map.put(ArmorItem.Type.LEGGINGS, 5);
                       map.put(ArmorItem.Type.CHESTPLATE,6);
                       map.put(ArmorItem.Type.HELMET, 3);
                       map.put(ArmorItem.Type.BODY, 5);
                   }), 20, SoundEvents.ARMOR_EQUIP_CHAIN, () -> Ingredient.of(ModItems.OPAQUE_INGOT.get()),
                   List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MonophobiaMod.MOD_ID, "opaque"))),
                   0, 0));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}
