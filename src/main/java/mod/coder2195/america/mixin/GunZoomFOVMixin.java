package mod.coder2195.america.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import mod.coder2195.america.event.KeyEventHandler;
import mod.coder2195.america.item.ModItemTags;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class GunZoomFOVMixin {

    @Inject(method = "getFovMultiplier()F", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;getActiveItem()Lnet/minecraft/item/ItemStack;", shift = At.Shift.AFTER), cancellable = true)
    private void injected(CallbackInfoReturnable<Float> ci) {
        if (((PlayerEntity) (Object) this).getStackInHand(Hand.MAIN_HAND).isIn(ModItemTags.GUN_ITEMS)
                && KeyEventHandler.isZooming) {
            ci.setReturnValue(0.1F);
        }
    }
}
