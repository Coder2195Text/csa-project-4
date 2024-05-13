package mod.coder2195.effects;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import mod.coder2195.america.AmericaMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageScaling;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {
  private static final Map<RegistryKey<DamageType>, DamageType> DAMAGE_TYPES = new HashMap<>();

  public static final RegistryKey<DamageType> BULLET = register(new DamageType("bullet", DamageScaling.NEVER, 0.1f));
  public static final RegistryKey<DamageType> SNIPER_BULLET = register(
      new DamageType("sniper", DamageScaling.NEVER, 0.1f));

  public static DamageSource of(World world, RegistryKey<DamageType> key) {
    return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
  }

  public static DamageSource of(World world, RegistryKey<DamageType> key, @Nullable Entity attacker) {
    return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key), attacker);
  }

  public static RegistryKey<DamageType> register(DamageType source) {
    RegistryKey<DamageType> type = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
        new Identifier(AmericaMod.MOD_ID, source.msgId()));
    DAMAGE_TYPES.put(type, source);
    return type;
  }

  public static void init(Registerable<DamageType> registerable) {
    registerable.register(BULLET, DAMAGE_TYPES.get(BULLET));
    registerable.register(SNIPER_BULLET, DAMAGE_TYPES.get(SNIPER_BULLET));
  }

  public static Collection<DamageType> sources() {
    return DAMAGE_TYPES.values();
  }
}
