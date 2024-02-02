package mod.coder2195.america.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import mod.coder2195.america.item.ModItemTags;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel.ArmPose;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

@Mixin(MinecraftClient.class)
public class CooldownMixin {
  @Shadow
  @Nullable
  public ClientPlayerEntity player;

  @ModifyConstant(method = "doItemUse()V", constant = @Constant(intValue = 4))
  private int injected(int value) {
    ItemStack stack = player.getStackInHand(Hand.MAIN_HAND);
    if (stack.isIn(ModItemTags.GUN_ITEMS)) {
			return 0;
		}
    return value;
  }
}
