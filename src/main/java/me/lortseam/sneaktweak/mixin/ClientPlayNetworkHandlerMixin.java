package me.lortseam.sneaktweak.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.network.packet.s2c.play.EntityTrackerUpdateS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin {

    @Shadow private ClientWorld world;

    @Shadow private MinecraftClient client;

    @Redirect(method = "onEntityTrackerUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/packet/s2c/play/EntityTrackerUpdateS2CPacket;getTrackedValues()Ljava/util/List;", ordinal = 1))
    public List<DataTracker.Entry<?>> sneaktweak$modifyTrackedValues(EntityTrackerUpdateS2CPacket packet) {
        if (world.getEntityById(packet.id()).equals(client.player)) {
            packet.getTrackedValues().removeIf(entry -> entry.getData().getType().equals(TrackedDataHandlerRegistry.ENTITY_POSE));
        }
        return packet.getTrackedValues();
    }

}
