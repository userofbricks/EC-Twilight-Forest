package com.userofbricks.ectwilightforestplugin.item;

import com.userofbricks.expanded_combat.api.material.Material;
import com.userofbricks.expanded_combat.item.GauntletItem;
import net.minecraft.world.item.Item;

public class NagaGauntletItem extends GauntletItem {
    public NagaGauntletItem(Item.Properties properties, Material nagascale) {
        super(properties, nagascale);
    }

    public double getAdditionalDamageAfterEnchantments(double totalBaseDamage) {
        return (totalBaseDamage/2f)*3f;
    }
}
