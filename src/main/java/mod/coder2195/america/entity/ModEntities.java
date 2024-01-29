package mod.coder2195.america.entity;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.entity.custom.BulletEntity;
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

  public static void registerEntities() {
    AmericaMod.LOGGER.info("Registering mod entities for " + AmericaMod.MOD_ID + "...");
  }
}
