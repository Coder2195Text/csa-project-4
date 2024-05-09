package mod.coder2195.america.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import mod.coder2195.america.event.KeyEventHandler;
import mod.coder2195.america.item.ModItemTags;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class GunZoomFOVMixin {

	@Inject(method = "isUsingSpyglass()Z", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<Boolean> ci) {
        if (((PlayerEntity)(Object) this).getStackInHand(Hand.MAIN_HAND).isIn(ModItemTags.GUN_ITEMS)) {
            ci.setReturnValue(KeyEventHandler.isZooming);
        }
    }
}

