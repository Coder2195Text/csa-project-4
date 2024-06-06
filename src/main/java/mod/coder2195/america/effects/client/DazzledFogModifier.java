package mod.coder2195.america.effects.client;

import mod.coder2195.america.effects.ModStatusEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class DazzledFogModifier implements BackgroundRenderer.StatusEffectFogModifier {
  @Override
  public StatusEffect getStatusEffect() {
    return ModStatusEffects.DAZZLED;
  }

  @Override
  public void applyStartEndModifier(BackgroundRenderer.FogData fogData, LivingEntity entity, StatusEffectInstance effect, float viewDistance, float tickDelta) {
    if (!effect.getFactorCalculationData().isEmpty()) {
      float f = MathHelper.lerp(((StatusEffectInstance.FactorCalculationData)effect.getFactorCalculationData().get()).lerp(entity, tickDelta), viewDistance, 15.0F);
      fogData.fogStart = fogData.fogType == BackgroundRenderer.FogType.FOG_SKY ? 0.0F : f * 0.75F;
      fogData.fogEnd = f;
    }
  }

  @Override
  public float applyColorModifier(LivingEntity entity, StatusEffectInstance effect, float f, float tickDelta) {
    return 10.0F;
  }
}
