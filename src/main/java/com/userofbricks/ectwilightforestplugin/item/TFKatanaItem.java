package com.userofbricks.ectwilightforestplugin.item;

import com.userofbricks.ectwilightforestplugin.item.materials.plugins.TwilightForestPlugin;
import com.userofbricks.ectwilightforestplugin.util.LangStrings;
import com.userofbricks.expanded_combat.item.ECKatanaItem;
import com.userofbricks.expanded_combat.item.materials.Material;
import com.userofbricks.expanded_combat.item.materials.WeaponMaterial;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class TFKatanaItem extends ECKatanaItem {
    public TFKatanaItem(Material material, WeaponMaterial weapon, Properties properties) {
        super(material, weapon, properties);
    }
    @Override
    public boolean hurtEnemy(@NotNull ItemStack weapon, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        boolean result = super.hurtEnemy(weapon, target, attacker);
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

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@NotNull ItemStack stack, Level world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        if (this.getMaterial() == TwilightForestPlugin.FIERY) {
            list.add(Component.translatable(LangStrings.FIERY_WEAPON_TOOLTIP));
        } else if (this.getMaterial() == TwilightForestPlugin.KNIGHTMETAL) {
            if (this.getWeapon().isBlockWeapon()) list.add(Component.translatable(LangStrings.KNIGHTMETAL_UNARMORED_WEAPON_TOOLTIP));
            else list.add(Component.translatable(LangStrings.KNIGHTMETAL_ARMORED_WEAPON_TOOLTIP));
        }
    }
}
