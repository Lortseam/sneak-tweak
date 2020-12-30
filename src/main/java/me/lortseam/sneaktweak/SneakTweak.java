package me.lortseam.sneaktweak;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.lortseam.completeconfig.ConfigBuilder;
import me.lortseam.completeconfig.ConfigHandler;
import me.lortseam.completeconfig.api.ConfigOwner;

public class SneakTweak implements ConfigOwner, ModMenuApi {

    private static ConfigHandler configHandler;

    @Override
    public void onInitializeClientConfig(ConfigBuilder builder) {
        configHandler = builder.add(Config.getInstance()).finish();
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parentScreen -> configHandler.buildScreen(parentScreen);
    }

}
