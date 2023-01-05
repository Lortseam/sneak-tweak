package me.lortseam.sneaktweak.mixin;

import me.lortseam.sneaktweak.config.ModConfig;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin {

    @Shadow private float cameraY;
    @Shadow private Entity focusedEntity;
    @Unique private EntityPose[] lastPoses = new EntityPose[2];

    @Inject(method = "updateEyeHeight", at = @At(value = "HEAD"))
    public void sneaktweak$storePose(CallbackInfo ci) {
        if (this.focusedEntity != null) {
            var pose = focusedEntity.getPose();
            if (pose != lastPoses[0]) {
                lastPoses[1] = lastPoses[0];
                lastPoses[0] = pose;
            }
        }
    }

    @Inject(method = "updateEyeHeight", at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/Camera;cameraY:F", ordinal = 0))
    public void sneaktweak$modifyCameraY(CallbackInfo ci) {
        if (!ModConfig.isSmoothingEnabled() && isValidPose()) {
            cameraY = focusedEntity.getStandingEyeHeight();
        }
    }

    @ModifyConstant(method = "updateEyeHeight", constant = @Constant(floatValue = 0.5f))
    public float sneaktweak$modifyCameraYSpeed(float modifier) {
        if (!isValidPose()) return modifier;
        return ModConfig.isSmoothingEnabled() ? modifier * ModConfig.getSpeedModifier() : 0;
    }

    @Unique
    private boolean isValidPose() {
        return lastPoses[1] == EntityPose.STANDING && lastPoses[0] == EntityPose.CROUCHING
                || lastPoses[1] == EntityPose.CROUCHING && lastPoses[0] == EntityPose.STANDING;
    }

}
