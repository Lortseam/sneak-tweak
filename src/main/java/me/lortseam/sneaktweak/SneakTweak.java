package me.lortseam.sneaktweak;

import me.lortseam.completeconfig.data.Config;
import me.lortseam.sneaktweak.config.Settings;
import net.fabricmc.api.ClientModInitializer;

public class SneakTweak implements ClientModInitializer {

    public static final String MOD_ID = "sneaktweak";

    @Override
    public void onInitializeClient() {
        Config.builder(MOD_ID)
                .add(new Settings())
                .build();
    }

}
