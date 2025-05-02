package com.userofbricks.ectwilightforestplugin.util;

import com.userofbricks.ectwilightforestplugin.config.ECTFConfig;
import com.userofbricks.ectwilightforestplugin.item.ECPluginItems;
import com.userofbricks.expanded_combat.config.ECConfig;
import me.shedaniel.autoconfig.annotation.Config;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.MODID;

public class LangStrings extends com.userofbricks.expanded_combat.datagen.LangStrings {
    public static final String FIERY_WEAPON_TOOLTIP = "tooltip.expanded_combat.fiery.weapon";
    public static final String KNIGHTMETAL_ARMORED_WEAPON_TOOLTIP = "tooltip.expanded_combat.knightly.weapon_armored";
    public static final String KNIGHTMETAL_UNARMORED_WEAPON_TOOLTIP = "tooltip.expanded_combat.knightly.weapon_unarmored";

    private static final Supplier<String> configLangStartGetter = () -> "text.autoconfig." + ECTFConfig.class.getAnnotation(Config.class).name();

    public LangStrings(PackOutput output) {
        super(output, MODID);
    }

    @Override
    protected void addTranslations() {
        for (DeferredHolder<Item, ? extends Item> deferredItem : ECPluginItems.ITEMS.getEntries()) {
            String locationName = deferredItem.getId().getPath();
            String name = locationToName(locationName);
            addItem(deferredItem, name);
        }
        List<String> alreadyAddedStrings = new ArrayList<>();

        add(FIERY_WEAPON_TOOLTIP, "Burns targets");
        add(KNIGHTMETAL_ARMORED_WEAPON_TOOLTIP, "Extra damage to armored targets");
        add(KNIGHTMETAL_UNARMORED_WEAPON_TOOLTIP, "Extra damage to unarmored targets");

        //Config
        String configLangStart = configLangStartGetter.get();
        add(configLangStart + ".title", "EC L_Ender's Cataclysm Settings");
        Arrays.stream(ECConfig.class.getDeclaredFields()).collect(
                        Collectors.groupingBy((field) -> getOrCreateCategoryForField(field, alreadyAddedStrings, configLangStart), LinkedHashMap::new, Collectors.toList()))
                .forEach((key, value) -> value.forEach((field) -> ifNotExcludedRegisterLangs(field, configLangStart, alreadyAddedStrings)));
    }
}
