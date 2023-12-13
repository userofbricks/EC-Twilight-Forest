package com.userofbricks.ectwilightforestplugin.plugins;

import com.userofbricks.ectwilightforestplugin.item.TFHammerWeaponItem;
import com.userofbricks.ectwilightforestplugin.item.TFKatanaItem;
import com.userofbricks.ectwilightforestplugin.item.TFWeaponItem;
import com.userofbricks.expanded_combat.api.material.Material;
import com.userofbricks.expanded_combat.api.material.MaterialBuilder;
import com.userofbricks.expanded_combat.api.registry.ECPlugin;
import com.userofbricks.expanded_combat.api.registry.IExpandedCombatPlugin;
import com.userofbricks.expanded_combat.api.registry.RegistrationHandler;
import com.userofbricks.expanded_combat.api.registry.ShieldToMaterials;
import com.userofbricks.expanded_combat.item.ECHammerWeaponItem;
import com.userofbricks.expanded_combat.item.ECKatanaItem;
import com.userofbricks.expanded_combat.item.ECWeaponItem;
import com.userofbricks.expanded_combat.plugins.VanillaECPlugin;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

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
        return new ResourceLocation(MODID, "twilight_forest");
    }

    @Override
    public void registerMaterials(RegistrationHandler registrationHandler) {
        IRONWOOD =    registrationHandler.registerMaterial(new MaterialBuilder(REGISTRATE, "Ironwood", CONFIG.ironwood).gauntlet().shield()
                .weaponBuilder(VanillaECPlugin.BATTLE_STAFF, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.BROAD_SWORD, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.CLAYMORE, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.CUTLASS, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.DAGGER, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.DANCERS_SWORD, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.FLAIL, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.GLAIVE, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.GREAT_HAMMER, null, (m, w, p) -> new TFHammerWeaponItem(m, p)).build()
                .weaponBuilder(VanillaECPlugin.KATANA, null, (m, w, p) -> new TFKatanaItem(m, p)).build()
                .weaponBuilder(VanillaECPlugin.MACE, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.SCYTHE, null, TFWeaponItem.HasPotion::new).build()
                .weaponBuilder(VanillaECPlugin.SICKLE, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.SPEAR, null, TFWeaponItem::new).build()
        );
        FIERY =       registrationHandler.registerMaterial(new MaterialBuilder(REGISTRATE, "Fiery", CONFIG.fiery).gauntlet().shield()
                .weaponBuilder(VanillaECPlugin.BATTLE_STAFF, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.BROAD_SWORD, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.CLAYMORE, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.CUTLASS, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.DAGGER, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.DANCERS_SWORD, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.FLAIL, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.GLAIVE, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.GREAT_HAMMER, null, (m, w, p) -> new TFHammerWeaponItem(m, p)).build()
                .weaponBuilder(VanillaECPlugin.KATANA, null, (m, w, p) -> new TFKatanaItem(m, p)).build()
                .weaponBuilder(VanillaECPlugin.MACE, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.SCYTHE, null, TFWeaponItem.HasPotion::new).build()
                .weaponBuilder(VanillaECPlugin.SICKLE, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.SPEAR, null, TFWeaponItem::new).build()
        );
        STEELEAF =    registrationHandler.registerMaterial(new MaterialBuilder(REGISTRATE, "Steeleaf", CONFIG.steeleaf).gauntlet().shield()
                .weaponBuilder(VanillaECPlugin.BATTLE_STAFF, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.BROAD_SWORD, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.CLAYMORE, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.CUTLASS, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.DAGGER, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.DANCERS_SWORD, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.FLAIL, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.GLAIVE, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.GREAT_HAMMER, null, (m, w, p) -> new TFHammerWeaponItem(m, p)).build()
                .weaponBuilder(VanillaECPlugin.KATANA, null, (m, w, p) -> new TFKatanaItem(m, p)).build()
                .weaponBuilder(VanillaECPlugin.MACE, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.SCYTHE, null, TFWeaponItem.HasPotion::new).build()
                .weaponBuilder(VanillaECPlugin.SICKLE, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.SPEAR, null, TFWeaponItem::new).build()
        );
        KNIGHTMETAL = registrationHandler.registerMaterial(new MaterialBuilder(REGISTRATE, "Knight Metal", CONFIG.knightmetal).gauntlet().shield()
                .weaponBuilder(VanillaECPlugin.BATTLE_STAFF, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.BROAD_SWORD, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.CLAYMORE, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.CUTLASS, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.DAGGER, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.DANCERS_SWORD, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.FLAIL, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.GLAIVE, null, TFWeaponItem.Dyeable::new).build()
                .weaponBuilder(VanillaECPlugin.GREAT_HAMMER, null, (m, w, p) -> new TFHammerWeaponItem(m, p)).build()
                .weaponBuilder(VanillaECPlugin.KATANA, null, (m, w, p) -> new TFKatanaItem(m, p)).build()
                .weaponBuilder(VanillaECPlugin.MACE, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.SCYTHE, null, TFWeaponItem.HasPotion::new).build()
                .weaponBuilder(VanillaECPlugin.SICKLE, null, TFWeaponItem::new).build()
                .weaponBuilder(VanillaECPlugin.SPEAR, null, TFWeaponItem::new).build()
        );
        NAGASCALE =   registrationHandler.registerMaterial(new MaterialBuilder(REGISTRATE, "Naga Scale", CONFIG.nagaScale).gauntlet().shield().setAdditionalDamageAfterEnchantments(damage -> (damage/2f)*3f));
        YETI =        registrationHandler.registerMaterial(new MaterialBuilder(REGISTRATE, "Yeti", CONFIG.yeti).gauntlet().setAdditionalDamageAfterEnchantments(damage -> damage/2f));
        ARCTIC =      registrationHandler.registerMaterial(new MaterialBuilder(REGISTRATE, "Arctic", CONFIG.arctic).gauntlet());
    }

    @Override
    public void registerShieldToMaterials(RegistrationHandler.ShieldMaterialRegisterator registrationHandler) {
        registrationHandler.registerShieldToMaterials(new ShieldToMaterials(() -> ForgeRegistries.ITEMS.getValue(new ResourceLocation("twilightforest:knightmetal_shield")), KNIGHTMETAL, KNIGHTMETAL, KNIGHTMETAL, KNIGHTMETAL, KNIGHTMETAL));
    }
}