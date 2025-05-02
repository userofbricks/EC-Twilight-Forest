package com.userofbricks.ectwilightforestplugin.item;

import com.userofbricks.expanded_combat.ExpandedCombat;
import com.userofbricks.expanded_combat.api.material.Material;
import com.userofbricks.expanded_combat.init.ECBasePlugin;
import com.userofbricks.expanded_combat.init.ECCreativeTabs;
import com.userofbricks.expanded_combat.init.ECItems;
import com.userofbricks.expanded_combat.item.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.MODID;
import static com.userofbricks.ectwilightforestplugin.plugins.TwilightForestPlugin.*;
import static com.userofbricks.expanded_combat.ExpandedCombat.CONFIG;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ECPluginItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final List<DeferredItem<? extends ECWeaponItem>> IRONWOOD_WEAPONS = weaponsFor(IRONWOOD, "ironwood");
    public static final List<DeferredItem<? extends ECWeaponItem>> FIERY_WEAPONS = weaponsFor(FIERY, "fiery");
    public static final List<DeferredItem<? extends ECWeaponItem>> STEELEAF_WEAPONS = weaponsFor(STEELEAF, "steeleaf");
    public static final List<DeferredItem<? extends ECWeaponItem>> KNIGHTMETAL_WEAPONS = weaponsFor(KNIGHTMETAL, "knight_metal");

    public static final DeferredItem<? extends GauntletItem> IRONWOOD_GAUNTLET = ITEMS.registerItem("ironwood_gauntlet",
            properties -> new GauntletItem(properties, IRONWOOD));
    public static final DeferredItem<? extends GauntletItem> FIERY_GAUNTLET = ITEMS.registerItem("fiery_gauntlet",
            properties -> new GauntletItem(properties, FIERY));
    public static final DeferredItem<? extends GauntletItem> STEELEAF_GAUNTLET = ITEMS.registerItem("steeleaf_gauntlet",
            properties -> new GauntletItem(properties, STEELEAF));
    public static final DeferredItem<? extends GauntletItem> KNIGHTMETAL_GAUNTLET = ITEMS.registerItem("knight_metal_gauntlet",
            properties -> new GauntletItem(properties, KNIGHTMETAL));
    public static final DeferredItem<? extends NagaGauntletItem> NAGASCALE_GAUNTLET = ITEMS.registerItem("naga_scale_gauntlet",
            properties -> new NagaGauntletItem(properties, NAGASCALE));
    public static final DeferredItem<? extends YetiGauntletItem> YETI_GAUNTLET = ITEMS.registerItem("yeti_gauntlet",
            properties -> new YetiGauntletItem(properties, YETI));
    public static final DeferredItem<? extends GauntletItem> ARCTIC_GAUNTLET = ITEMS.registerItem("arctic_gauntlet",
            properties -> new GauntletItem(properties, ARCTIC));


    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void ModifyVanillaCreativeTabs(BuildCreativeModeTabContentsEvent event){
        ResourceKey<CreativeModeTab> tab = event.getTabKey();
        List<? extends DeferredItem<? extends Item>> itemList = ITEMS.getEntries().stream().map(itemDeferredHolder -> (DeferredItem<? extends Item>)itemDeferredHolder).toList();

        boolean isCombat = tab == CreativeModeTabs.COMBAT;
        boolean isECTab = tab == ECCreativeTabs.EC_GROUP.getKey();

        if (!isECTab && !isCombat) return;

        for (DeferredItem<? extends Item> deferredItem : itemList) {
            ItemStack itemBefore = null;
            if (CONFIG.enableGauntlets && deferredItem.get() instanceof GauntletItem)
                itemBefore = isCombat ? new ItemStack(Items.TURTLE_HELMET) : new ItemStack(ECItems.BRAWLERS_GAUNTLETS.get());
            if (CONFIG.enableBows && deferredItem.get() instanceof ECBowItem)
                itemBefore = isCombat ? new ItemStack(Items.BOW) : new ItemStack(ECItems.NETHERITE_BOW.get());
            if (CONFIG.enableCrossbows && deferredItem.get() instanceof ECCrossBowItem)
                itemBefore = isCombat ? new ItemStack(Items.CROSSBOW) : new ItemStack(ECItems.NETHERITE_CROSS_BOW.get());
            if (CONFIG.enableQuivers && deferredItem.get() instanceof QuiverItem)
                itemBefore = new ItemStack(ECItems.NETHERITE_QUIVER.get());
            if (CONFIG.enableWeapons && deferredItem.get() instanceof ECWeaponItem)
                event.accept(deferredItem);
            if (itemBefore != null)
                event.insertAfter(itemBefore, new ItemStack(deferredItem.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private static List<DeferredItem<? extends ECWeaponItem>> weaponsFor(Material materialReference, String materialItemName) {
        List<DeferredItem<? extends ECWeaponItem>> weaponMap = new ArrayList<>();
        weaponMap.add(ITEMS.registerItem(materialItemName + "_battle_staff", (properties) -> new TFWeaponItem(materialReference, ECBasePlugin.BATTLE_STAFF, properties)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_broad_sword", (properties) -> new TFSlamWeaponItem(materialReference, ECBasePlugin.BROAD_SWORD, properties, 0)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_claymore", (properties) -> new TFSlamWeaponItem(materialReference, ECBasePlugin.CLAYMORE, properties, 0)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_cutlass", (properties) -> new TFWeaponItem(materialReference, ECBasePlugin.CUTLASS, properties)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_dagger", (properties) -> new TFWeaponItem(materialReference, ECBasePlugin.DAGGER, properties)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_dancer_s_sword", (properties) -> new TFWeaponItem(materialReference, ECBasePlugin.DANCERS_SWORD, properties)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_flail", (properties) -> new TFWeaponItem(materialReference, ECBasePlugin.FLAIL, properties)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_glaive", (properties) -> new TFWeaponItem(materialReference, ECBasePlugin.GLAIVE, properties)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_great_hammer", (properties) -> new TFSlamWeaponItem(materialReference, ECBasePlugin.GREAT_HAMMER, properties, ExpandedCombat.CONFIG.enchantmentLevels.baseHammerSlamLevel)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_katana", (properties) -> new TFArrowBlockWeaponItem(materialReference, ECBasePlugin.KATANA, properties, 2)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_mace", (properties) -> new TFWeaponItem(materialReference, ECBasePlugin.MACE, properties)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_scythe", (properties) -> new TFPotionWeaponItem(materialReference, ECBasePlugin.SCYTHE, properties)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_sickle", (properties) -> new TFWeaponItem(materialReference, ECBasePlugin.SICKLE, properties)));
        weaponMap.add(ITEMS.registerItem(materialItemName + "_spear", (properties) -> new TFWeaponItem(materialReference, ECBasePlugin.SPEAR, properties)));
        return weaponMap;
    }
}
