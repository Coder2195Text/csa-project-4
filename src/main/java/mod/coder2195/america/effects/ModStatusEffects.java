package mod.coder2195.america.effects;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.effects.status.DazzledStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
  public static final StatusEffect DAZZLED = new DazzledStatusEffect();

  public static void registerStatusEffects() {
    // Register the status effects
    AmericaMod.LOGGER.info("Registering status effects...");
    Registry.register(Registries.STATUS_EFFECT, new Identifier(
        AmericaMod.MOD_ID, "dazzled"
    ), DAZZLED);
  }
}
