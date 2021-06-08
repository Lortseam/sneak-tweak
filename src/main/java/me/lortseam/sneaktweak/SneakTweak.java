package me.lortseam.sneaktweak;

import me.lortseam.completeconfig.gui.ConfigScreenBuilder;
import me.lortseam.completeconfig.gui.cloth.ClothConfigScreenBuilder;
import me.lortseam.sneaktweak.config.Settings;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class SneakTweak implements ClientModInitializer {

    public static final String MOD_ID = "sneaktweak";

    @Override
    public void onInitializeClient() {
        new Settings().load();
        if (FabricLoader.getInstance().isModLoaded("cloth-config2")) {
            ConfigScreenBuilder.setMain(MOD_ID, new ClothConfigScreenBuilder());
        }
    }

}
