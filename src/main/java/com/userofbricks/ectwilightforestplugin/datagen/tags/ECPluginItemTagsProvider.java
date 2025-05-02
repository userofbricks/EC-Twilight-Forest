package com.userofbricks.ectwilightforestplugin.datagen.tags;

import com.userofbricks.ectwilightforestplugin.item.ECPluginItems;
import com.userofbricks.expanded_combat.init.ECTags;
import com.userofbricks.expanded_combat.item.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.MODID;
import static com.userofbricks.expanded_combat.init.ECBasePlugin.*;

public class ECPluginItemTagsProvider extends ItemTagsProvider {
    public ECPluginItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture, ExistingFileHelper helper) {
        super(output, provider, tagLookupCompletableFuture, MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        for (DeferredHolder<Item, ? extends Item> deferredItem : ECPluginItems.ITEMS.getEntries()) {
            if (deferredItem.get() instanceof ECArrowItem item) {
                tag(ItemTags.ARROWS).add(item);
            }
            if (deferredItem.get() instanceof ECBowItem item) {
                tag(Tags.Items.TOOLS_BOW).add(item);
                tag(ItemTags.BOW_ENCHANTABLE).add(item);
                tag(ItemTags.DURABILITY_ENCHANTABLE).add(item);
            }
            if (deferredItem.get() instanceof ECCrossBowItem item) {
                tag(Tags.Items.TOOLS_CROSSBOW).add(item);
                tag(ItemTags.CROSSBOW_ENCHANTABLE).add(item);
                tag(ItemTags.DURABILITY_ENCHANTABLE).add(item);
            }
            if (deferredItem.get() instanceof GauntletItem item) {
                tag(ECTags.GAUNTLETS).add(item);
                tag(ItemTags.TRIMMABLE_ARMOR).add(item);
                tag(ECTags.GAUNTLET_ENCHANTABLE).add(item);
                tag(ECTags.AGILITY_ENCHANTABLE).add(item);
                tag(ItemTags.DURABILITY_ENCHANTABLE).add(item);
                tag(ItemTags.ARMOR_ENCHANTABLE).add(item);
            }
            if (deferredItem.get() instanceof QuiverItem item) {
                tag(ECTags.QUIVERS).add(item);
            }
            if (deferredItem.get() instanceof ECWeaponItem item) {
                tag(ItemTags.SWORDS).add(item);
                tag(ItemTags.DURABILITY_ENCHANTABLE).add(item);
            }
            if (deferredItem.get() instanceof PotionWeaponItem item) {
                tag(ECTags.POTION_WEAPONS).add(item);
            }
            if (deferredItem.get() instanceof ECWeaponItem item && (
                    item.weapon.id() == BATTLE_STAFF.id()
                            || item.weapon.id() == BROAD_SWORD.id()
                            || item.weapon.id() == CLAYMORE.id()
                            || item.weapon.id() == DANCERS_SWORD.id()
                            || item.weapon.id() == GLAIVE.id()
            )) {
                tag(ItemTags.DYEABLE).add(item);
            }
            if (deferredItem.get() instanceof ArrowBlockWeaponItem item) {
                tag(ECTags.BLOCKING_ENCHANTABLE).add(item);
            }
            if (deferredItem.get() instanceof SlamWeaponItem item) {
                tag(ECTags.GROUND_SLAM).add(item);
            }
        }
    }
}
