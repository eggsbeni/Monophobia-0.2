package net.eggsbeni.monophobia.datagen;

import net.eggsbeni.monophobia.MonophobiaMod;
import net.eggsbeni.monophobia.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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


    }
}
