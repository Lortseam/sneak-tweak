package me.lortseam.sneaktweak.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.lortseam.completeconfig.ConfigHandler;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigEntryContainer;
import me.lortseam.sneaktweak.SneakTweak;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Config implements ConfigEntryContainer {

    @Getter(AccessLevel.PACKAGE)
    @ConfigEntry.Ignore
    private static ConfigHandler handler;
    @Getter
    private static boolean smoothingEnabled = true;
    @ConfigEntry.BoundedInteger(min = 25, max = 300)
    private static int speedPercentage = 100;

    public static void register() {
        handler = me.lortseam.completeconfig.data.Config.builder(SneakTweak.MOD_ID)
                .add(new Config())
                .build();
    }

    public static float getSpeedModifier() {
        return speedPercentage / 100f;
    }

    @Override
    public boolean isConfigPOJO() {
        return true;
    }

}
