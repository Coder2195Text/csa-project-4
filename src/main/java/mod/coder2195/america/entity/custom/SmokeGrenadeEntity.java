package mod.coder2195.america.entity.custom;

import mod.coder2195.america.entity.ModEntities;
import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import mod.coder2195.america.utils.TaskQueue;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SmokeGrenadeEntity extends ThrownItemEntity {
  @Override
  protected Item getDefaultItem() {
    return ModItems.SMOKE_GRENADE;
  }

  public SmokeGrenadeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
    super(entityType, world);
  }

  public SmokeGrenadeEntity(World world, LivingEntity owner) {
    super(ModEntities.SMOKE_GRENADE, owner, world); // null will be changed later
  }

  public SmokeGrenadeEntity(World world, double x, double y, double z) {
    super(ModEntities.SMOKE_GRENADE, x, y, z, world); // null will be changed later
  }

  public void detonate() {

    // Detonate the smoke grenade
    World world = this.getWorld();
    Vec3d pos = this.getPos();
    BlockPos blockPos = new BlockPos((int) pos.x, (int)  pos.y, (int) pos.z);
    if (world.isClient) return;

    if (world instanceof ServerWorld server) {
      world.playSound(null, blockPos, ModSounds.SMOKE_GRENADE_DETONATE, SoundCategory.PLAYERS, 1f, 1f);
      for (int t = 0; t < 20; t++) {
        TaskQueue.queue(
            () -> {
              if (world.isClient) return;
              for (int i = 0; i < 75; i++) {
                double r = 3.5 * Math.sqrt(Math.random());
                double theta = Math.random() * 2 * Math.PI;
                double x = r * Math.cos(theta);
                double z = r * Math.sin(theta);
                Vec3d newPos = new Vec3d(pos.x + x, pos.y + Math.random() * 4-1, pos.z +z);
                server.spawnParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, newPos.getX(), newPos.getY(), newPos.getZ(), 1, 0, 0, 0, 0);
              }
            }, t * 8);
      }
      kill();
    }

  }

  @Override
  protected void onEntityHit(EntityHitResult entityHitResult) {
    if (this.getWorld().isClient) return;
    detonate();
  }

  @Override
  protected void onBlockHit(BlockHitResult blockHitResult) {
    if (this.getWorld().isClient) return;
    detonate();
  }
}
