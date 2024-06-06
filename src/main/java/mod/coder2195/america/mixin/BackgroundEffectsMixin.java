package mod.coder2195.america.mixin;

import mod.coder2195.america.effects.client.DazzledFogModifier;
import net.minecraft.client.render.BackgroundRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(BackgroundRenderer.class)
public abstract class BackgroundEffectsMixin {
  @Shadow
  @Final
  private static List<BackgroundRenderer.StatusEffectFogModifier> FOG_MODIFIERS;
  @Inject(method = "<clinit>", at = @At("TAIL"))
  private static void injected(CallbackInfo ci) {
    FOG_MODIFIERS.add(new DazzledFogModifier());
  }
}
