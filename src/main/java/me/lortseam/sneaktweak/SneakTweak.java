package me.lortseam.sneaktweak;

import me.lortseam.completeconfig.gui.ConfigScreenBuilder;
import me.lortseam.completeconfig.gui.cloth.ClothConfigScreenBuilder;
import me.lortseam.sneaktweak.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;

public class SneakTweak implements ClientModInitializer {

    public static final String MOD_ID = "sneaktweak";

    @Override
    public void onInitializeClient() {
        new ModConfig().load();
        if (FabricLoader.getInstance().isModLoaded("cloth-config")) {
            ConfigScreenBuilder.setMain(MOD_ID, new ClothConfigScreenBuilder());
        }
        ClientTickEvents.END_WORLD_TICK.register(world -> {
            if (ModConfig.increaseSneakingHeight()) {
                MinecraftClient.getInstance().player.calculateDimensions();
            }
        });
    }

}
