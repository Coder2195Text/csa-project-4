package mod.coder2195.america.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import mod.coder2195.america.effects.ModStatusEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(GameRenderer.class)
public abstract class DazzledEffectMixin {

  public int getDazzledStrength(LivingEntity entity, float tickDelta) {
    // strength from 00 to ff
    StatusEffectInstance statusEffectInstance = entity.getStatusEffect(ModStatusEffects.DAZZLED);
    return Math.round(MathHelper.clamp((!statusEffectInstance.isDurationBelow(200) ? 1.0F : 0.8F + MathHelper.sin(((float) statusEffectInstance.getDuration() - tickDelta) * 3.1415927F * 0.2F) * 0.2F) * 0xff, 0, 0xff));
  }

  @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiler/Profiler;swap(Ljava/lang/String;)V", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILHARD)
  private void injected(float tickDelta, long startTime, boolean tick, CallbackInfo ci, @Local DrawContext drawContext) {
    MinecraftClient client = MinecraftClient.getInstance();
    if (client.player != null && client.player.hasStatusEffect(ModStatusEffects.DAZZLED)) {
      int color = getDazzledStrength(client.player, tickDelta) << 24 | 0xFFFFFF;
      drawContext.fill(0, 0, client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight(), color);
    }
  }
}
