package me.lortseam.sneaktweak.config;

import lombok.Getter;
import lombok.experimental.Accessors;
import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntries;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.sneaktweak.SneakTweak;

@ConfigEntries(includeAll = true)
public final class ModConfig extends Config implements ConfigContainer {

    @Getter
    private static boolean smoothingEnabled = true;
    @ConfigEntry.BoundedInteger(min = 25, max = 300)
    @ConfigEntry.Slider
    private static int speedPercentage = 100;
    @Accessors(fluent = true)
    @Getter
    private static boolean increaseSneakingHeight = false;

    public ModConfig() {
        super(SneakTweak.MOD_ID);
    }

    public static float getSpeedModifier() {
        return speedPercentage / 100f;
    }

}
