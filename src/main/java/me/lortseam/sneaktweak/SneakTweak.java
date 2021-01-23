package me.lortseam.sneaktweak;

import me.lortseam.sneaktweak.config.Config;
import net.fabricmc.api.ClientModInitializer;

public class SneakTweak implements ClientModInitializer {

    public static final String MOD_ID = "sneaktweak";

    @Override
    public void onInitializeClient() {
        Config.register();
    }

}
