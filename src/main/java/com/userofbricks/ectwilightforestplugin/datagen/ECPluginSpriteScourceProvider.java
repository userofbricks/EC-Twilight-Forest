package com.userofbricks.ectwilightforestplugin.datagen;

import com.userofbricks.expanded_combat.ExpandedCombat;
import com.userofbricks.expanded_combat.client.sprites.PalettedFolderPermutations;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SpriteSourceProvider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.modLoc;


@OnlyIn(Dist.CLIENT)
public class ECPluginSpriteScourceProvider extends SpriteSourceProvider {
    public ECPluginSpriteScourceProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
        super(output, lookupProvider, ExpandedCombat.MODID, fileHelper);
    }

    @Override
    protected void gather() {
        Map<String, ResourceLocation> weaponPermutations = new HashMap<>();
        weaponPermutations.put("ironwood", modLoc( "item/color_palettes/ironwood"));
        weaponPermutations.put("steeleaf", modLoc( "item/color_palettes/steeleaf"));
        weaponPermutations.put("knight_metal", modLoc( "item/color_palettes/knight_metal"));

        atlas(BLOCKS_ATLAS).addSource(new PalettedFolderPermutations(
                Arrays.asList(
                        modLoc("item/battle_staff"),
                        modLoc("item/broad_sword"),
                        modLoc("item/claymore"),
                        modLoc("item/cutlass"),
                        modLoc("item/dagger"),
                        modLoc("item/dancer_s_sword"),
                        modLoc("item/glaive"),
                        modLoc("item/katana"),
                        modLoc("item/scythe"),
                        modLoc("item/sickle"),
                        modLoc("item/spear"),
                        modLoc("item_large/battle_staff"),
                        modLoc("item_large/broad_sword"),
                        modLoc("item_large/claymore"),
                        modLoc("item_large/dancer_s_sword"),
                        modLoc("item_large/glaive"),
                        modLoc("item_large/katana"),
                        modLoc("item_large/scythe"),
                        modLoc("item_large/spear"),
                        modLoc("item/bow"),
                        modLoc("item/crossbow")
                ),
                modLoc( "item/color_palettes/template"),
                true,
                weaponPermutations))
                /*.addSource(new ReversedPalettedPermutations(
                        Arrays.asList(
                                modLoc("item/bow/pulling_0"),
                                modLoc("item/bow/pulling_1"),
                                modLoc("item/bow/pulling_2"),
                                modLoc("item/crossbow/pulling_0"),
                                modLoc("item/crossbow/pulling_1"),
                                modLoc("item/crossbow/pulling_2"),
                                modLoc("item/crossbow/arrow"),
                                modLoc("item/crossbow/firework")
                        ),
                        modLoc("item/color_palettes/template"),
                        false,
                        weaponPermutations))*/
        ;

    }
}
