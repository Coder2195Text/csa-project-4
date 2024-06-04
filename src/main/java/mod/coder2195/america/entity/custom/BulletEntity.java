package mod.coder2195.america.entity.custom;

import mod.coder2195.america.entity.ModEntities;
import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import mod.coder2195.america.effects.ModDamageTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BulletEntity extends PersistentProjectileEntity {
  private final static ItemStack DEFAULT_STACK = new ItemStack(ModItems.BULLET);
  private float damage = 8;
  private boolean despawn = false;
  private Vec3d before = this.getPos();

  @Override
  public boolean isSilent() {
    // used to enforce the dist
    return true;
  }

  @Override
  protected SoundEvent getHitSound() {
    return ModSounds.BULLET_HIT;
  }


  @Override
  protected void onBlockHit(BlockHitResult blockHitResult) {

    spawnParticles(blockHitResult.getPos());

    if (despawn) {
      this.discard();
      return;
    }

    super.onBlockHit(blockHitResult);

    World world = this.getWorld();

    if (world.isClient) return;


  world.playSound(null, blockHitResult.getBlockPos(), ModSounds.BULLET_HIT, SoundCategory.BLOCKS, 3f, 1f);

  }

  public BulletEntity(EntityType<? extends BulletEntity> entityType, World world) {
    super(entityType, world, DEFAULT_STACK);
  }

  public BulletEntity(World world, double x, double y, double z, ItemStack stack) {
    super(ModEntities.BULLET, x, y, z, world, stack);
    before = this.getPos();
  }

  public BulletEntity(World world, LivingEntity owner, ItemStack stack) {
    super(ModEntities.BULLET, owner, world, stack);
    before = this.getPos();
  }

  public BulletEntity(World world, LivingEntity owner, float damage, float speed) {
    super(ModEntities.BULLET, owner, world, DEFAULT_STACK);
    this.damage = damage;
    this.speed = speed;
  }

  public BulletEntity(World world, LivingEntity owner, float damage, float speed, boolean despawn) {
    this(world, owner, damage, speed);
    this.despawn = despawn;
  }

  public void spawnParticles(Vec3d after) {
    World world = this.getWorld();
    if (!world.isClient && !this.inGround && world instanceof ServerWorld server) {
      double distance = before.distanceTo(after);
      for (double i = 0; i < distance; i += 1) {
        double progress = i / distance;
        server.spawnParticles(ParticleTypes.CRIT, before.x + (after.x - before.x) * progress,
            before.y + (after.y - before.y) * progress, before.z + (after.z - before.z) * progress, 1, 0, 0, 0, 0);
      }
    }
  }

  @Override
  public void tick() {


    Vec3d after = this.getPos();
    spawnParticles(after);

    super.tick();

    before = after;
  }

  @Override
  protected void onEntityHit(EntityHitResult entityHitResult) {
    World world = this.getWorld();
    if (world.isClient) return;
    Entity entity = entityHitResult.getEntity();

    Entity owner = this.getOwner();

    DamageSource damageSource;
    if (owner == null) {
      damageSource = ModDamageTypes.of(getWorld(), ModDamageTypes.BULLET);
    } else {
      damageSource = ModDamageTypes.of(getWorld(),
          owner.distanceTo(entity) > 48 ? ModDamageTypes.SNIPER_BULLET : ModDamageTypes.BULLET, owner);



      if (owner instanceof LivingEntity livingEntity) {
        livingEntity.onAttacking(entity);
      }
      if (owner instanceof ServerPlayerEntity player) {
        Vec3d pos = player.getPos();
        player.networkHandler.sendPacket(new PlaySoundS2CPacket(Registries.SOUND_EVENT.getEntry(ModSounds.BULLET_SUCCESS), SoundCategory.PLAYERS, pos.x, pos.y, pos.z , 1, 1, world.getRandom().nextLong()));
      }
    }


    spawnParticles(entityHitResult.getPos());

    this.discard();
  }

  @Override
  public void writeCustomDataToNbt(NbtCompound nbt) {
    super.writeCustomDataToNbt(nbt);
    nbt.putFloat("damage", damage);
    nbt.putBoolean("despawn", despawn);
    nbt.putDouble("beforeX", before.x);
    nbt.putDouble("beforeY", before.y);
    nbt.putDouble("beforeZ", before.z);
  }

  @Override
  public void readCustomDataFromNbt(NbtCompound nbt) {
    super.readCustomDataFromNbt(nbt);
    if (nbt.contains("damage", NbtCompound.FLOAT_TYPE))
      damage = nbt.getFloat("damage");

    despawn = nbt.getBoolean("despawn");
    before = new Vec3d(nbt.getDouble("beforeX"), nbt.getDouble("beforeY"), nbt.getDouble("beforeZ"));
  }
}
