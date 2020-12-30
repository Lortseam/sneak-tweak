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
    private boolean animationEnabled = true;
    @ConfigEntry.Bounded.Integer(min = 10, max = 300)
    private int animationSpeedPercentage = 100;
    //TODO: Add bounce option

    public float getSpeedModifier() {
        return animationEnabled ? animationSpeedPercentage / 100f : 1;
    }

    @Override
    public boolean isConfigPOJO() {
        return true;
    }

}
