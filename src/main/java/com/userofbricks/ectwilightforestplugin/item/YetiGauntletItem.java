package com.userofbricks.ectwilightforestplugin.item;

import com.userofbricks.expanded_combat.api.material.Material;
import com.userofbricks.expanded_combat.item.GauntletItem;
import net.minecraft.world.item.Item;

public class YetiGauntletItem extends GauntletItem {
    public YetiGauntletItem(Item.Properties properties, Material yeti) {
        super(properties, yeti);
    }

    public double getAdditionalDamageAfterEnchantments(double totalBaseDamage) {
        return totalBaseDamage/2;
    }
}
