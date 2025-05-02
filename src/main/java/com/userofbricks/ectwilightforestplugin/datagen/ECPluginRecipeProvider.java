package com.userofbricks.ectwilightforestplugin.datagen;

import com.userofbricks.ectwilightforestplugin.item.ECPluginItems;
import com.userofbricks.expanded_combat.api.material.Material;
import com.userofbricks.expanded_combat.api.weapon_type.WeaponType;
import com.userofbricks.expanded_combat.datagen.recipes.MaterialRecipeProvider;
import com.userofbricks.expanded_combat.init.ECBasePlugin;
import com.userofbricks.expanded_combat.item.ECWeaponItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;
import twilightforest.init.TFBlocks;
import twilightforest.init.TFItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.userofbricks.ectwilightforestplugin.item.ECPluginItems.*;
import static com.userofbricks.ectwilightforestplugin.plugins.TwilightForestPlugin.*;
import static com.userofbricks.expanded_combat.init.ECItems.NETHERITE_WEAPONS;

public class ECPluginRecipeProvider extends MaterialRecipeProvider {
    private final Map<Material, ItemLike> materialSwords = new HashMap<>();
    private final Map<Material, ItemLike> materialBlocks = new HashMap<>();
    private final Map<Material, Ingredient> materialIngredients = new HashMap<>();

    private final Map<WeaponType, ItemLike> netheriteWeapons = new HashMap<>();
    public ECPluginRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
        for (DeferredItem<? extends ECWeaponItem> weapon : NETHERITE_WEAPONS)
            netheriteWeapons.put(weapon.get().weapon, weapon);

        materialSwords.put(IRONWOOD, TFItems.IRONWOOD_SWORD);
        materialSwords.put(FIERY, TFItems.FIERY_SWORD);
        materialSwords.put(STEELEAF, TFItems.STEELEAF_SWORD);
        materialSwords.put(KNIGHTMETAL, TFItems.KNIGHTMETAL_SWORD);

        materialBlocks.put(IRONWOOD, TFBlocks.IRONWOOD_BLOCK);
        materialBlocks.put(FIERY, TFBlocks.FIERY_BLOCK);
        materialBlocks.put(STEELEAF, TFBlocks.STEELEAF_BLOCK);
        materialBlocks.put(KNIGHTMETAL, TFBlocks.KNIGHTMETAL_BLOCK);

        materialIngredients.put(IRONWOOD, Ingredient.of(TFItems.IRONWOOD_INGOT));
        materialIngredients.put(FIERY, Ingredient.of(TFItems.FIERY_INGOT));
        materialIngredients.put(STEELEAF, Ingredient.of(TFItems.STEELEAF_INGOT));
        materialIngredients.put(KNIGHTMETAL, Ingredient.of(TFItems.KNIGHTMETAL_INGOT));
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ArrayList<DeferredItem<? extends ECWeaponItem>> weapons = new ArrayList<>();
        weapons.addAll(IRONWOOD_WEAPONS);
        weapons.addAll(FIERY_WEAPONS);
        weapons.addAll(STEELEAF_WEAPONS);
        weapons.addAll(KNIGHTMETAL_WEAPONS);
        for (DeferredItem<? extends ECWeaponItem> weaponItem : weapons)
            buildWeaponRecipe(recipeOutput, weaponItem.get());

        gauntlet(recipeOutput, ECPluginItems.IRONWOOD_GAUNTLET, Ingredient.of(TFItems.IRONWOOD_INGOT));
        gauntlet(recipeOutput, ECPluginItems.FIERY_GAUNTLET, Ingredient.of(TFItems.FIERY_INGOT));
        gauntlet(recipeOutput, ECPluginItems.STEELEAF_GAUNTLET, Ingredient.of(TFItems.STEELEAF_INGOT));
        gauntlet(recipeOutput, ECPluginItems.KNIGHTMETAL_GAUNTLET, Ingredient.of(TFItems.KNIGHTMETAL_INGOT));
        gauntlet(recipeOutput, ECPluginItems.NAGASCALE_GAUNTLET, Ingredient.of(TFItems.NAGA_SCALE));
        gauntlet(recipeOutput, ECPluginItems.YETI_GAUNTLET, Ingredient.of(TFItems.ALPHA_YETI_FUR));
        gauntlet(recipeOutput, ECPluginItems.ARCTIC_GAUNTLET, Ingredient.of(TFItems.ARCTIC_FUR));
    }

    private void buildWeaponRecipe(RecipeOutput pRecipeOutput, ECWeaponItem weaponItem) {
        WeaponType weaponType = weaponItem.weapon;
        Ingredient material = materialIngredients.get(weaponItem.material);
        ItemLike sword = materialSwords.get(weaponItem.material);
        ItemLike block = materialBlocks.get(weaponItem.material);

        if (weaponType == ECBasePlugin.FLAIL) flail(pRecipeOutput, weaponItem, block);
        else if (weaponType == ECBasePlugin.GREAT_HAMMER) greatHammer(pRecipeOutput, weaponItem, block);
        else if (weaponType == ECBasePlugin.MACE) mace(pRecipeOutput, weaponItem, block);
        else if (weaponType == ECBasePlugin.BATTLE_STAFF) battleStaff(pRecipeOutput, weaponItem, material);
        else if (weaponType == ECBasePlugin.BROAD_SWORD) broadSword(pRecipeOutput, weaponItem, sword, material);
        else if (weaponType == ECBasePlugin.CLAYMORE) claymore(pRecipeOutput, weaponItem, sword, material);
        else if (weaponType == ECBasePlugin.CUTLASS) cutlass(pRecipeOutput, weaponItem, material);
        else if (weaponType == ECBasePlugin.DAGGER) dagger(pRecipeOutput, weaponItem, material);
        else if (weaponType == ECBasePlugin.DANCERS_SWORD) dancersSword(pRecipeOutput, weaponItem, sword);
        else if (weaponType == ECBasePlugin.GLAIVE) glaive(pRecipeOutput, weaponItem, sword);
        else if (weaponType == ECBasePlugin.KATANA) katana(pRecipeOutput, weaponItem, sword, material);
        else if (weaponType == ECBasePlugin.SCYTHE) scythe(pRecipeOutput, weaponItem, sword, material);
        else if (weaponType == ECBasePlugin.SICKLE) sickle(pRecipeOutput, weaponItem, material);
        else if (weaponType == ECBasePlugin.SPEAR) spear(pRecipeOutput, weaponItem, sword);
    }
}
