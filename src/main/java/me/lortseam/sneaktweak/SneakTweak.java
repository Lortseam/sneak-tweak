package me.lortseam.sneaktweak;

import lombok.Getter;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.sneaktweak.config.Settings;
import net.fabricmc.api.ClientModInitializer;

public class SneakTweak implements ClientModInitializer {

    public static final String MOD_ID = "sneaktweak";
    @Getter
    private static Config config;

    @Override
    public void onInitializeClient() {
        config = Config.builder(MOD_ID)
                .add(new Settings())
                .build();
    }

}
