package com.userofbricks.ectwilightforestplugin.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.MODID;


public class ECPluginBlockTagsProvider extends BlockTagsProvider {
    public ECPluginBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {}
}
