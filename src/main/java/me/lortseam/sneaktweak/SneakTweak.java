package me.lortseam.sneaktweak;

import lombok.Getter;
import me.lortseam.sneaktweak.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class SneakTweak implements ClientModInitializer {

    public static final String MOD_ID = "sneaktweak";

    @Getter
    private static final ModConfig config = new ModConfig();

    @Override
    public void onInitializeClient() {
        config.load();
        ClientTickEvents.END_WORLD_TICK.register(world -> {
            if (ModConfig.increaseSneakingHeight()) {
                MinecraftClient.getInstance().player.calculateDimensions();
            }
        });
    }

}
