package me.lortseam.sneaktweak.config;

import lombok.Getter;
import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntries;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.sneaktweak.SneakTweak;

@ConfigEntries
public final class Settings extends Config implements ConfigContainer {

    @Getter
    private static boolean smoothingEnabled = true;
    @ConfigEntry.BoundedInteger(min = 25, max = 300)
    @ConfigEntry.Slider
    private static int speedPercentage = 100;

    public Settings() {
        super(SneakTweak.MOD_ID);
    }

    public static float getSpeedModifier() {
        return speedPercentage / 100f;
    }

}
