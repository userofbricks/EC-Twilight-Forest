package com.userofbricks.ectwilightforestplugin;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.userofbricks.ectwilightforestplugin.config.ECTFConfig;
import com.userofbricks.ectwilightforestplugin.item.ECTFItemTags;
import com.userofbricks.ectwilightforestplugin.util.LangStrings;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
@Mod(ECTwilightForestPlugin.MODID)
public class ECTwilightForestPlugin {
    public static final String MODID = "ec_tf_plugin";
    public static final NonNullSupplier<Registrate> REGISTRATE = NonNullSupplier.lazy(() -> Registrate.create(MODID));
    public static ECTFConfig CONFIG;
    public ECTwilightForestPlugin() {
        LangStrings.registerLang();
        ECTFItemTags.loadTags();
        MinecraftForge.EVENT_BUS.register(this);
    }
}