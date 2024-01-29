package mod.coder2195.america.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import mod.coder2195.america.item.ModItemTags;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel.ArmPose;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

@Mixin(PlayerEntityRenderer.class)
public class GunPoseMixin {
	@Inject(at = @At("HEAD"), method = "getArmPose", cancellable = true)
	private static void injected(AbstractClientPlayerEntity player,
			Hand hand, CallbackInfoReturnable<ArmPose> cir) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (itemStack.isIn(ModItemTags.GUN_ITEMS)) {
			cir.setReturnValue(ArmPose.BOW_AND_ARROW);
		}
	}
}