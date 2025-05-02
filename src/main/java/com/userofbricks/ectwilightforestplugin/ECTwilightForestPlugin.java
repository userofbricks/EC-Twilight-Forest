package com.userofbricks.ectwilightforestplugin;

import com.userofbricks.ectwilightforestplugin.config.ECTFConfig;
import com.userofbricks.ectwilightforestplugin.item.ECPluginItems;
import com.userofbricks.expanded_combat.item.GauntletItem;
import com.userofbricks.expanded_combat.item.QuiverItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod(ECTwilightForestPlugin.MODID)
public class ECTwilightForestPlugin {
    public static final String MODID = "ec_tf_plugin";
    public static final String TwilightForestMOD_ID = "twilightforest";
    public static ECTFConfig CONFIG;
    public ECTwilightForestPlugin(IEventBus bus, ModContainer modContainer) {
        ECPluginItems.ITEMS.register(bus);
        bus.addListener(this::clientSetup);
    }

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        for (DeferredItem<? extends Item> registryEntry: ECPluginItems.ITEMS.getEntries().stream().map(itemDeferredHolder -> (DeferredItem<? extends Item>)itemDeferredHolder).toList())
        {
            if (registryEntry.get() instanceof GauntletItem gauntletItem)
                CuriosRendererRegistry.register(gauntletItem, gauntletItem.getGauntletRenderer());
            else if (registryEntry.get() instanceof QuiverItem quiverItem)
                CuriosRendererRegistry.register(quiverItem, quiverItem.getQuiverRenderer());
        }
    }
}