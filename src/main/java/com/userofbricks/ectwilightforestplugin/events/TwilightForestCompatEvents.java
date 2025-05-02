package com.userofbricks.ectwilightforestplugin.events;

import com.userofbricks.ectwilightforestplugin.plugins.TwilightForestPlugin;
import com.userofbricks.expanded_combat.ExpandedCombat;
import com.userofbricks.expanded_combat.item.ECWeaponItem;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = ExpandedCombat.MODID)
public class TwilightForestCompatEvents {
    private static final int KNIGHTMETAL_BONUS_DAMAGE = 2;

    @SubscribeEvent
    public static void fieryToolSetFire(LivingIncomingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity living &&
                (living.getMainHandItem().getItem() instanceof ECWeaponItem weaponItem && weaponItem.getMaterial() == TwilightForestPlugin.FIERY) &&
                !event.getEntity().fireImmune()) {
            event.getEntity().igniteForSeconds(1);
        }
    }

    @SubscribeEvent
    public static void onKnightmetalToolDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();

        DamageContainer container = event.getContainer();
        if (!target.level().isClientSide() && container.getSource().getDirectEntity() instanceof LivingEntity living) {
            ItemStack weapon = living.getMainHandItem();

            if (!weapon.isEmpty()) {
                if (target.getArmorValue() > 0 && weapon.getItem() instanceof ECWeaponItem weaponItem && weaponItem.getMaterial() == TwilightForestPlugin.KNIGHTMETAL) {
                    if (target.getArmorCoverPercentage() > 0) {
                        int moreBonus = (int) (KNIGHTMETAL_BONUS_DAMAGE * target.getArmorCoverPercentage());
                        container.setNewDamage(container.getOriginalDamage() + moreBonus);
                    } else {
                        container.setNewDamage(container.getOriginalDamage() + KNIGHTMETAL_BONUS_DAMAGE);
                    }
                    // enchantment attack sparkles
                    ((ServerLevel) target.level()).getChunkSource().broadcastAndSend(target, new ClientboundAnimatePacket(target, 5));
                }
            }
        }
    }
}
