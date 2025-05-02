package com.userofbricks.ectwilightforestplugin.config;

import com.userofbricks.expanded_combat.config.MaterialConfig;
import com.userofbricks.expanded_combat.config.gui.ConfigName;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import static com.userofbricks.ectwilightforestplugin.ECTwilightForestPlugin.MODID;
import static twilightforest.init.TFSounds.KNIGHTMETAL_EQUIP;

@Config(name = MODID)
public class ECTFConfig implements ConfigData {

    @ConfigEntry.Category("Materials") @ConfigEntry.Gui.CollapsibleObject
    @ConfigName("Naga Scale Settings")
    public MaterialConfig nagaScale = new MaterialConfig.Builder()
            .toolDurability((int)(512 * 1.05))
            .gauntletDurability((int)(512 * 1.05))
            .gauntletArmorAmount(3)
            .addedAttackDamage(2.1f)
            .armorToughness(0.5f)
            .addedShieldDurability(260)
            .baseProtectionAmmount(4)
            .afterBasePercentReduction(0.65f)
            .defenseEnchantability(15)
            .mendingBonus(0.1f)
            .shield()
            .build();

    @ConfigEntry.Category("Materials") @ConfigEntry.Gui.CollapsibleObject
    @ConfigName("Arctic Settings")
    public MaterialConfig arctic = new MaterialConfig.Builder()
            .toolDurability(131)
            .gauntletDurability(131)
            .gauntletArmorAmount(2)
            .addedAttackDamage(2)
            .armorToughness(2)
            .addedShieldDurability(130)
            .baseProtectionAmmount(3)
            .afterBasePercentReduction(0.55f)
            .defenseEnchantability(8)
            .build();

    @ConfigEntry.Category("Materials") @ConfigEntry.Gui.CollapsibleObject
    @ConfigName("Alpha Yeti Settings")
    public MaterialConfig yeti = new MaterialConfig.Builder()
            .toolDurability(512)
            .gauntletDurability(512)
            .gauntletArmorAmount(3)
            .addedAttackDamage(2.5f)
            .armorToughness(3)
            .addedShieldDurability(250)
            .baseProtectionAmmount(3.5f)
            .afterBasePercentReduction(0.65f)
            .defenseEnchantability(15)
            .build();

    @ConfigEntry.Category("Materials") @ConfigEntry.Gui.CollapsibleObject
    @ConfigName("Ironwood Settings")
    public MaterialConfig ironwood = new MaterialConfig.Builder()
            .toolDurability(512)
            .gauntletDurability(512)
            .gauntletArmorAmount(2)
            .addedAttackDamage(2f)
            .addedShieldDurability(250)
            .baseProtectionAmmount(3.5f)
            .afterBasePercentReduction(0.6f)
            .offenseEnchantability(25)
            .defenseEnchantability(15)
            .mendingBonus(1.5f)
            .shield()
            .build();

    @ConfigEntry.Category("Materials") @ConfigEntry.Gui.CollapsibleObject
    @ConfigName("Fiery Settings")
    public MaterialConfig fiery = new MaterialConfig.Builder()
            .toolDurability(1024)
            .gauntletDurability(1024)
            .gauntletArmorAmount(4)
            .addedAttackDamage(4f)
            .armorToughness(1.5)
            .addedShieldDurability(275)
            .baseProtectionAmmount(4.5f)
            .afterBasePercentReduction(0.7f)
            .offenseEnchantability(10)
            .defenseEnchantability(10)
            .flaming()
            .shield()
            .build();

    @ConfigEntry.Category("Materials") @ConfigEntry.Gui.CollapsibleObject
    @ConfigName("Steeleaf Settings")
    public MaterialConfig steeleaf = new MaterialConfig.Builder()
            .toolDurability(131)
            .gauntletDurability(131)
            .gauntletArmorAmount(3)
            .addedAttackDamage(3f)
            .addedShieldDurability(180)
            .baseProtectionAmmount(3.5f)
            .afterBasePercentReduction(0.6f)
            .offenseEnchantability(9)
            .defenseEnchantability(9)
            .shield()
            .build();

    @ConfigEntry.Category("Materials") @ConfigEntry.Gui.CollapsibleObject
    @ConfigName("Knightmetal Settings")
    public MaterialConfig knightmetal = new MaterialConfig.Builder()
            .toolDurability(512)
            .gauntletDurability(512)
            .gauntletArmorAmount(3)
            .addedAttackDamage(3f)
            .armorToughness(1)
            .addedShieldDurability(250)
            .baseProtectionAmmount(4)
            .afterBasePercentReduction(0.6f)
            .offenseEnchantability(8)
            .defenseEnchantability(8)
            .equipSound(KNIGHTMETAL_EQUIP.getId())
            .shield()
            .build();
}
