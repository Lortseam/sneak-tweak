package me.lortseam.sneaktweak.mixin;

import me.lortseam.sneaktweak.Config;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin {

    @Shadow private float cameraY;

    @Shadow private Entity focusedEntity;

    @Inject(method = "updateEyeHeight", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/client/render/Camera;cameraY:F", ordinal = 1), cancellable = true)
    public void onCameraYModify(CallbackInfo ci) {
        if (!Config.getInstance().isAnimationEnabled()) {
            cameraY = focusedEntity.getStandingEyeHeight();
            ci.cancel();
        }
    }

    @ModifyConstant(method = "updateEyeHeight", constant = @Constant(floatValue = 0.5f))
    public float modifyCameraYSpeed(float modifier) {
        return modifier * Config.getInstance().getSpeedModifier();
    }

}
