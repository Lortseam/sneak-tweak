package me.lortseam.sneaktweak.config;

import lombok.Getter;
import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntries;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.sneaktweak.SneakTweak;
import net.minecraft.client.MinecraftClient;

@ConfigEntries(includeAll = true)
public final class ModConfig extends Config implements ConfigContainer {

    @Getter
    private static boolean smoothingEnabled = true;
    @ConfigEntry.BoundedInteger(min = 25, max = 300)
    @ConfigEntry.Slider
    private static int speedPercentage = 100;
    private static SneakingEyeHeightType sneakingEyeHeightPreset = SneakingEyeHeightType.DEFAULT;
    @ConfigEntry.BoundedFloat(min = 0, max = 1.8f)
    private static float customSneakingEyeHeight = 1.27f;
    private static boolean modifyThirdPersonSneakingEyeHeight = false;

    public ModConfig() {
        super(SneakTweak.MOD_ID);
    }

    public static float getSpeedModifier() {
        return speedPercentage / 100f;
    }

    public static float modifySneakingEyeHeight(float height) {
        if (MinecraftClient.getInstance().options.getPerspective().isFirstPerson() || modifyThirdPersonSneakingEyeHeight) {
            height = switch (sneakingEyeHeightPreset) {
                case DEFAULT -> height;
                case PRE_1_14 -> 1.42f;
                case PRE_1_9 -> 1.54f;
                case CUSTOM -> customSneakingEyeHeight;
            };
        }
        return height;
    }

    private enum SneakingEyeHeightType {

        DEFAULT,
        PRE_1_14,
        PRE_1_9,
        CUSTOM

    }

}
