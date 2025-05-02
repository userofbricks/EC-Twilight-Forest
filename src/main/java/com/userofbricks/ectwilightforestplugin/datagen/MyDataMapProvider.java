package com.userofbricks.ectwilightforestplugin.datagen;

import com.userofbricks.ectwilightforestplugin.plugins.TwilightForestPlugin;
import com.userofbricks.expanded_combat.init.DataMaps;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import twilightforest.init.TFItems;

import java.util.concurrent.CompletableFuture;

public class MyDataMapProvider extends DataMapProvider {
    public MyDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(DataMaps.SHIELD_INGREDIENT_MAP)
                .add(TFItems.FIERY_INGOT, TwilightForestPlugin.FIERY, false)
                .add(TFItems.NAGA_SCALE, TwilightForestPlugin.NAGASCALE, false)
                .add(TFItems.IRONWOOD_INGOT, TwilightForestPlugin.IRONWOOD, false)
                .add(TFItems.STEELEAF_INGOT, TwilightForestPlugin.STEELEAF, false)
                .add(TFItems.KNIGHTMETAL_INGOT, TwilightForestPlugin.KNIGHTMETAL, false);
    }
}
