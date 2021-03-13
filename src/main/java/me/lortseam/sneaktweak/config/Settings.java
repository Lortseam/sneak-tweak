package me.lortseam.sneaktweak.config;

import lombok.Getter;
import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntries;
import me.lortseam.completeconfig.api.ConfigEntry;

@ConfigEntries
public final class Settings implements ConfigContainer {

    @Getter
    private static boolean smoothingEnabled = true;
    @ConfigEntry.BoundedInteger(min = 25, max = 300)
    private static int speedPercentage = 100;

    public static float getSpeedModifier() {
        return speedPercentage / 100f;
    }

}
