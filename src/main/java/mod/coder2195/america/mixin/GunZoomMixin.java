package mod.coder2195.america.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import mod.coder2195.america.event.KeyEventHandler;
import mod.coder2195.america.item.custom.Gun;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

@Mixin(PlayerEntity.class)
public abstract class GunZoomMixin {
    @Inject(method = "isUsingSpyglass()Z", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<Boolean> ci) {
        if (((PlayerEntity) (Object) this).getStackInHand(Hand.MAIN_HAND).getItem() instanceof Gun gun && gun.SCOPED) {
            ci.setReturnValue(KeyEventHandler.isZooming);
        }
    }
}
