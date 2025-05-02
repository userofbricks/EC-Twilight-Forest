package com.userofbricks.ectwilightforestplugin.plugins;

import com.userofbricks.ectwilightforestplugin.config.ECTFConfig;
import com.userofbricks.expanded_combat.api.material.Material;
import com.userofbricks.expanded_combat.api.registry.ECPlugin;
import com.userofbricks.expanded_combat.api.registry.IExpandedCombatPlugin;
import com.userofbricks.expanded_combat.api.registry.RegistrationHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import twilightforest.init.TFItems;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.*;


@ECPlugin
public class TwilightForestPlugin  implements IExpandedCombatPlugin {
    public static Material IRONWOOD;
    public static Material FIERY;
    public static Material STEELEAF;
    public static Material KNIGHTMETAL;
    public static Material NAGASCALE;
    public static Material YETI;
    public static Material ARCTIC;
    @Override
    public ResourceLocation getPluginUid() {
        return modLoc("twilight_forest");
    }

    @Override
    public void registerMaterials(RegistrationHandler registrationHandler) {
        AutoConfig.register(ECTFConfig.class, Toml4jConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ECTFConfig.class).getConfig();

        IRONWOOD = registrationHandler.registerMaterial("Ironwood", modLoc("ironwood"), CONFIG.ironwood,
                () -> Ingredient.of(TFItems.IRONWOOD_INGOT), () -> Ingredient.of(TFItems.IRONWOOD_INGOT)); //gauntlet, shield, TF weapons
        FIERY = registrationHandler.registerMaterial("Fiery", modLoc("fiery"), CONFIG.fiery,
                () -> Ingredient.of(TFItems.FIERY_INGOT), () -> Ingredient.of(TFItems.FIERY_INGOT)); //gauntlet, shield, TF weapons
        STEELEAF = registrationHandler.registerMaterial("Steeleaf", modLoc("steeleaf"), CONFIG.steeleaf,
                () -> Ingredient.of(TFItems.STEELEAF_INGOT), () -> Ingredient.of(TFItems.STEELEAF_INGOT)); //gauntlet, shield, TF weapons
        KNIGHTMETAL = registrationHandler.registerMaterial("Knight Metal", modLoc("knight_metal"), CONFIG.knightmetal,
                () -> Ingredient.of(TFItems.KNIGHTMETAL_INGOT), () -> Ingredient.of(TFItems.KNIGHTMETAL_INGOT)); //gauntlet, shield, TF weapons

        NAGASCALE = registrationHandler.registerMaterial("Naga Scale", modLoc("naga_scale"), CONFIG.nagaScale,
                () -> Ingredient.of(TFItems.NAGA_SCALE), () -> Ingredient.of(TFItems.NAGA_SCALE)); //gauntlet, shield, .setAdditionalDamageAfterEnchantments(damage -> (damage/2f)*3f)
        YETI = registrationHandler.registerMaterial("Yeti", modLoc("yeti"), CONFIG.yeti,
                () -> Ingredient.of(TFItems.ALPHA_YETI_FUR), () -> Ingredient.of(TFItems.ALPHA_YETI_FUR)); //gauntlet, .setAdditionalDamageAfterEnchantments(damage -> (damage/2f))
        ARCTIC = registrationHandler.registerMaterial("Arctic", modLoc("arctic"), CONFIG.yeti,
                () -> Ingredient.of(TFItems.ARCTIC_FUR), () -> Ingredient.of(TFItems.ARCTIC_FUR)); //gauntlet
    }

    /*@Override
    public void registerShieldToMaterials(RegistrationHandler.ShieldMaterialRegisterator registrationHandler) {
        registrationHandler.registerShieldToMaterials(new ShieldToMaterials(() -> ForgeRegistries.ITEMS.getValue(new ResourceLocation("twilightforest:knightmetal_shield")), KNIGHTMETAL, KNIGHTMETAL, KNIGHTMETAL, KNIGHTMETAL, KNIGHTMETAL));
    }*/
}