package net.eggsbeni.monophobia.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

public class ModFoodProperties {
    public static final FoodProperties VOLATILE_FRUIT = new FoodProperties.Builder().nutrition(5).saturationModifier(3)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300), 0.45f).build();
}
