package com.userofbricks.ectwilightforestplugin.item;

import com.tterrag.registrate.providers.ProviderType;
import com.userofbricks.ectwilightforestplugin.plugins.TwilightForestPlugin;
import com.userofbricks.expanded_combat.item.ECItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import twilightforest.init.TFBlocks;
import twilightforest.init.TFItems;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.REGISTRATE;
import static com.userofbricks.expanded_combat.item.ECItemTags.bindForgeStorageBlock;
import static com.userofbricks.expanded_combat.item.ECItemTags.bindForgeSword;

public class ECTFItemTags {

    public static final TagKey<Item> IRONWOOD_SWORD = bindForgeSword("ironwood");
    public static final TagKey<Item> FIERY_SWORD = bindForgeSword("fiery");
    public static final TagKey<Item> STEELEAF_SWORD = bindForgeSword("steeleaf");
    public static final TagKey<Item> KNIGHT_METAL_SWORD = bindForgeSword("knight_metal");

    public static void loadTags() {
        REGISTRATE.get().addDataGenerator(ProviderType.ITEM_TAGS, tagsProvider -> {
            tagsProvider.addTag(ECItemTags.SHIELDS).add(TFItems.KNIGHTMETAL_SHIELD.get());
            tagsProvider.addTag(IRONWOOD_SWORD).add(TFItems.IRONWOOD_SWORD.get());
            tagsProvider.addTag(FIERY_SWORD).add(TFItems.FIERY_SWORD.get());
            tagsProvider.addTag(STEELEAF_SWORD).add(TFItems.STEELEAF_SWORD.get());
            tagsProvider.addTag(KNIGHT_METAL_SWORD).add(TFItems.KNIGHTMETAL_SWORD.get());

            tagsProvider.addTag(bindForgeStorageBlock(TwilightForestPlugin.FIERY.getLocationName().getPath())).add(BlockItem.byBlock(TFBlocks.FIERY_BLOCK.get()));
            tagsProvider.addTag(bindForgeStorageBlock(TwilightForestPlugin.IRONWOOD.getLocationName().getPath())).add(BlockItem.byBlock(TFBlocks.IRONWOOD_BLOCK.get()));
            tagsProvider.addTag(bindForgeStorageBlock(TwilightForestPlugin.STEELEAF.getLocationName().getPath())).add(BlockItem.byBlock(TFBlocks.STEELEAF_BLOCK.get()));
            tagsProvider.addTag(bindForgeStorageBlock(TwilightForestPlugin.KNIGHTMETAL.getLocationName().getPath())).add(BlockItem.byBlock(TFBlocks.KNIGHTMETAL_BLOCK.get()));
        });
    }
}
