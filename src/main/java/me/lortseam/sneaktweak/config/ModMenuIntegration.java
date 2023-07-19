package me.lortseam.sneaktweak.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.lortseam.completeconfig.gui.yacl.YaclScreenBuilder;
import me.lortseam.sneaktweak.SneakTweak;

public class ModMenuIntegration implements ModMenuApi {

    private static final YaclScreenBuilder configScreenBuilder = new YaclScreenBuilder();

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> configScreenBuilder.build(parent, SneakTweak.getConfig());
    }

}
