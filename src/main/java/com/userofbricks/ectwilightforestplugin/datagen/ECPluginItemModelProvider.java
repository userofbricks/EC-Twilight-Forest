package com.userofbricks.ectwilightforestplugin.datagen;

import com.userofbricks.ectwilightforestplugin.item.ECPluginItems;
import com.userofbricks.ectwilightforestplugin.plugins.TwilightForestPlugin;
import com.userofbricks.expanded_combat.api.material.Material;
import com.userofbricks.expanded_combat.datagen.models.ECItemModelProvider;
import com.userofbricks.expanded_combat.datagen.models.WeaponItemModelBuilder;
import com.userofbricks.expanded_combat.init.ECBasePlugin;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.MODID;


public class ECPluginItemModelProvider extends ECItemModelProvider {
    public ECPluginItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, MODID, helper);
    }
    @Override
    protected void registerModels() {
        generateGauntletModel(ECPluginItems.IRONWOOD_GAUNTLET.getId(), ECPluginItems.IRONWOOD_GAUNTLET.get().material, false);
        generateGauntletModel(ECPluginItems.FIERY_GAUNTLET.getId(), ECPluginItems.FIERY_GAUNTLET.get().material, false);
        generateGauntletModel(ECPluginItems.STEELEAF_GAUNTLET.getId(), ECPluginItems.STEELEAF_GAUNTLET.get().material, false);
        generateGauntletModel(ECPluginItems.KNIGHTMETAL_GAUNTLET.getId(), ECPluginItems.KNIGHTMETAL_GAUNTLET.get().material, false);
        generateGauntletModel(ECPluginItems.NAGASCALE_GAUNTLET.getId(), ECPluginItems.NAGASCALE_GAUNTLET.get().material, false);
        generateGauntletModel(ECPluginItems.YETI_GAUNTLET.getId(), ECPluginItems.YETI_GAUNTLET.get().material, false);
        generateGauntletModel(ECPluginItems.ARCTIC_GAUNTLET.getId(), ECPluginItems.ARCTIC_GAUNTLET.get().material, false);
        standardWeaponModelsFor(TwilightForestPlugin.IRONWOOD, "ironwood");
        standardWeaponModelsFor(TwilightForestPlugin.FIERY, "fiery");
        standardWeaponModelsFor(TwilightForestPlugin.STEELEAF, "steeleaf");
        standardWeaponModelsFor(TwilightForestPlugin.KNIGHTMETAL, "knight_metal");
    }

    protected void standardWeaponModelsFor(Material materialReference, String materialItemName) {
        ResourceLocation materialLocation = materialReference.id();
        new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_battle_staff"), materialReference, ECBasePlugin.BATTLE_STAFF, this)
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasLargeModel().setDyeableOrPotionDippable().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_broad_sword"), materialReference, ECBasePlugin.BROAD_SWORD, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasLargeModel().setDyeableOrPotionDippable().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_claymore"), materialReference, ECBasePlugin.CLAYMORE, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasLargeModel().setDyeableOrPotionDippable().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_cutlass"), materialReference, ECBasePlugin.CUTLASS, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasCustomTransformsOrModel().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_dagger"), materialReference, ECBasePlugin.DAGGER, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasCustomTransformsOrModel().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_dancer_s_sword"), materialReference, ECBasePlugin.DANCERS_SWORD, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasLargeModel().setDyeableOrPotionDippable().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_flail"), materialReference, ECBasePlugin.FLAIL, this))
              .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasCustomTransformsOrModel().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_glaive"), materialReference, ECBasePlugin.GLAIVE, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasLargeModel().setDyeableOrPotionDippable().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_great_hammer"), materialReference, ECBasePlugin.GREAT_HAMMER, this))
              .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasCustomTransformsOrModel().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_katana"), materialReference, ECBasePlugin.KATANA, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasLargeModel().setHasArrowBlockingWeaponOverrides().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_mace"), materialReference, ECBasePlugin.MACE, this))
              .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasCustomTransformsOrModel().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_scythe"), materialReference, ECBasePlugin.SCYTHE, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasLargeModel().setDyeableOrPotionDippable().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_sickle"), materialReference, ECBasePlugin.SICKLE, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasCustomTransformsOrModel().generateWeaponModelAndStandardOverrides();
        (new WeaponItemModelBuilder(ResourceLocation.fromNamespaceAndPath(materialLocation.getNamespace(), materialItemName + "_spear"), materialReference, ECBasePlugin.SPEAR, this))
                .setDyeTextureFunction("dye").setHandleTextureFunction("handle").setHasLargeModel().generateWeaponModelAndStandardOverrides();
    }
}
