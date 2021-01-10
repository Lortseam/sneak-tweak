package me.lortseam.sneaktweak;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.lortseam.completeconfig.api.ConfigCategory;
import me.lortseam.completeconfig.api.ConfigEntry;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Config{

    public static final Animation ANIMATION = new Animation();

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Animation implements ConfigCategory {

        @Getter
        private boolean smoothingEnabled = true;
        @ConfigEntry.Bounded.Integer(min = 50, max = 300)
        private int speedPercentage = 100;

        public float getSpeedModifier() {
            return speedPercentage / 100f;
        }

        //TODO: Remove in v2.0
        @Override
        public String getConfigCategoryID() {
            return "config";
        }

        @Override
        public boolean isConfigPOJO() {
            return true;
        }

    }

}
