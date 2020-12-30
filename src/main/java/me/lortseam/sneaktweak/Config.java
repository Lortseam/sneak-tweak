package me.lortseam.sneaktweak;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.lortseam.completeconfig.api.ConfigCategory;
import me.lortseam.completeconfig.api.ConfigEntry;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Config implements ConfigCategory {

    @Getter
    private static final Config instance = new Config();

    @Getter
    private boolean smoothingEnabled = true;
    @ConfigEntry.Bounded.Integer(min = 50, max = 300)
    private int speedPercentage = 100;

    public float getSpeedModifier() {
        return speedPercentage / 100f;
    }

    @Override
    public boolean isConfigPOJO() {
        return true;
    }

}
