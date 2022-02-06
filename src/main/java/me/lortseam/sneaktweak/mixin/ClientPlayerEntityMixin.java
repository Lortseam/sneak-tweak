package me.lortseam.sneaktweak.mixin;

import com.mojang.authlib.GameProfile;
import me.lortseam.sneaktweak.config.Settings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {

    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    @Override
    public float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        if (Settings.increaseSneakingHeight() && pose == EntityPose.CROUCHING && MinecraftClient.getInstance().options.getPerspective().isFirstPerson() && wouldPoseNotCollide(EntityPose.STANDING)) {
            return 1.42f;
        }
        return super.getActiveEyeHeight(pose, dimensions);
    }

}
