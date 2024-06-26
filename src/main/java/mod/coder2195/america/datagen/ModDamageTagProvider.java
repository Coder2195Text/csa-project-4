package mod.coder2195.america.datagen;

import mod.coder2195.america.effects.ModDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModDamageTagProvider extends FabricTagProvider<DamageType> {

  public ModDamageTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
    super(output, RegistryKeys.DAMAGE_TYPE, completableFuture);
  }

  public ModDamageTagProvider(FabricDataOutput output, RegistryKey<? extends Registry<DamageType>> registryKey,
      CompletableFuture<WrapperLookup> registriesFuture) {
    super(output, registryKey, registriesFuture);
  }

  @Override
  protected void configure(WrapperLookup arg) {
    getOrCreateTagBuilder(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS)
        .add(ModDamageTypes.BULLET)
        .add(ModDamageTypes.SNIPER_BULLET)
        .add(ModDamageTypes.TANK_SHELL);
    getOrCreateTagBuilder(DamageTypeTags.BYPASSES_COOLDOWN)
        .add(ModDamageTypes.BULLET)
        .add(ModDamageTypes.SNIPER_BULLET);
    getOrCreateTagBuilder(DamageTypeTags.IS_PROJECTILE)
        .add(ModDamageTypes.BULLET)
        .add(ModDamageTypes.SNIPER_BULLET)
        .add(ModDamageTypes.TANK_SHELL);

    getOrCreateTagBuilder(DamageTypeTags.IS_EXPLOSION)
        .add(ModDamageTypes.TANK_SHELL);

  }

  @Override
  public String getName() {
    return "Damage Tags";
  }

}
