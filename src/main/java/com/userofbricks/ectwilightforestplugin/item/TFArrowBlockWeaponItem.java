package com.userofbricks.ectwilightforestplugin.item;

import com.userofbricks.ectwilightforestplugin.plugins.TwilightForestPlugin;
import com.userofbricks.ectwilightforestplugin.util.LangStrings;
import com.userofbricks.expanded_combat.api.material.Material;
import com.userofbricks.expanded_combat.api.weapon_type.WeaponType;
import com.userofbricks.expanded_combat.item.ArrowBlockWeaponItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class TFArrowBlockWeaponItem extends ArrowBlockWeaponItem {
    public TFArrowBlockWeaponItem(Material material, WeaponType weaponType, Properties properties, int baseBlockCount) {
        super(material, weaponType, properties, baseBlockCount);
    }
    @Override
    public boolean hurtEnemy(@NotNull ItemStack weapon, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        boolean result = super.hurtEnemy(weapon, target, attacker);
        if (getMaterial() != TwilightForestPlugin.FIERY)
            return result;
        if (result && !target.level().isClientSide && !target.fireImmune()) {
            target.setRemainingFireTicks(15);
        } else {
            Random random = new Random();
            for (int var1 = 0; var1 < 20; ++var1) {
                double px = target.getX() + random.nextFloat() * target.getBbWidth() * 2.0F - target.getBbWidth();
                double py = target.getY() + random.nextFloat() * target.getBbHeight();
                double pz = target.getZ() + random.nextFloat() * target.getBbWidth() * 2.0F - target.getBbWidth();
                target.level().addParticle(ParticleTypes.FLAME, px, py, pz, 0.02, 0.02, 0.02);
            }
        }
        return result;
    }

    @net.neoforged.api.distmarker.OnlyIn(net.neoforged.api.distmarker.Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        if (this.getMaterial() == TwilightForestPlugin.FIERY) {
            list.add(Component.translatable(LangStrings.FIERY_WEAPON_TOOLTIP));
        } else if (this.getMaterial() == TwilightForestPlugin.KNIGHTMETAL) {
            if (this.getWeapon().isBlockWeapon()) list.add(Component.translatable(LangStrings.KNIGHTMETAL_UNARMORED_WEAPON_TOOLTIP));
            else list.add(Component.translatable(LangStrings.KNIGHTMETAL_ARMORED_WEAPON_TOOLTIP));
        }
    }
}
