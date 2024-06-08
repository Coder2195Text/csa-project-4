package mod.coder2195.america.entity.custom;

import mod.coder2195.america.entity.ModEntities;
import mod.coder2195.america.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class GrenadeEntity extends ThrownItemEntity {
  @Override
  protected Item getDefaultItem() {
    return ModItems.GRENADE;
  }

  public GrenadeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
    super(entityType, world);
  }

  public GrenadeEntity(World world, LivingEntity owner) {
    super(ModEntities.GRENADE, owner, world); // null will be changed later
  }

  public GrenadeEntity(World world, double x, double y, double z) {
    super(ModEntities.GRENADE, x, y, z, world); // null will be changed later
  }

  public void detonate() {
    // Detonate the grenade4

    World world = this.getWorld();
    if (world.isClient) return;
    world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 4.0F, false, World.ExplosionSourceType.MOB);
    kill();
  }


  @Override
  protected void onEntityHit(EntityHitResult entityHitResult) {
    World world = this.getWorld();
    if (world.isClient) return;
    detonate();
  }

  @Override
  protected void onBlockHit(BlockHitResult blockHitResult) {
    World world = this.getWorld();
    if (world.isClient) return;
    detonate();
  }

}
