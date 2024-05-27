package mod.coder2195.america.entity;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.entity.custom.BulletEntity;
import mod.coder2195.america.entity.custom.GrenadeEntity;
import mod.coder2195.america.entity.custom.M1A2Entity;
import mod.coder2195.america.entity.custom.SmokeGrenadeEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

  public static final EntityType<BulletEntity> BULLET = Registry.register(Registries.ENTITY_TYPE,
      new Identifier(AmericaMod.MOD_ID, "bullet"),
      FabricEntityTypeBuilder.<BulletEntity>create(SpawnGroup.MISC, BulletEntity::new)
          .dimensions(EntityDimensions.fixed(0.125f, 0.125f)).build());

  public static final EntityType<SmokeGrenadeEntity> SMOKE_GRENADE = Registry.register(Registries.ENTITY_TYPE,
      new Identifier(AmericaMod.MOD_ID, "smoke_grenade"),
      FabricEntityTypeBuilder.<SmokeGrenadeEntity>create(SpawnGroup.MISC, SmokeGrenadeEntity::new)
          .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

  public static final EntityType<GrenadeEntity> GRENADE = Registry.register(Registries.ENTITY_TYPE,
      new Identifier(AmericaMod.MOD_ID, "grenade"),
      FabricEntityTypeBuilder.<GrenadeEntity>create(SpawnGroup.MISC, GrenadeEntity::new)
          .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

  public static final EntityType<M1A2Entity> M1A2 = Registry.register(Registries.ENTITY_TYPE,
      new Identifier(AmericaMod.MOD_ID, "m1a2"),
      FabricEntityTypeBuilder.<M1A2Entity>create(SpawnGroup.MISC, M1A2Entity::new)
          .dimensions(EntityDimensions.fixed(4f, 2.5f)).build());

  public static void registerEntities() {
    AmericaMod.LOGGER.info("Registering mod entities for " + AmericaMod.MOD_ID + "...");

    FabricDefaultAttributeRegistry.register(M1A2, M1A2Entity.createM1A2Attributes());
  }
}
