package com.userofbricks.ectwilightforestplugin.datagen;

import com.userofbricks.ectwilightforestplugin.datagen.tags.ECPluginBlockTagsProvider;
import com.userofbricks.ectwilightforestplugin.datagen.tags.ECPluginItemTagsProvider;
import com.userofbricks.ectwilightforestplugin.util.LangStrings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new LangStrings(output));
        generator.addProvider(event.includeClient(), new ECPluginSpriteScourceProvider(output, provider, helper));
        generator.addProvider(event.includeClient(), new ECPluginItemModelProvider(output, helper));
        generator.addProvider(event.includeClient(), new MyDataMapProvider(output, provider));
        generator.addProvider(event.includeServer(), new ECPluginRecipeProvider(output, provider));
        ECPluginBlockTagsProvider blockTagsProvider = new ECPluginBlockTagsProvider(output, provider, helper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ECPluginItemTagsProvider(output, provider, blockTagsProvider.contentsGetter(), helper));
    }
}
