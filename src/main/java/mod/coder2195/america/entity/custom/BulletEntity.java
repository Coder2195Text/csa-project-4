package mod.coder2195.america.entity.custom;

import mod.coder2195.america.entity.ModEntities;
import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import mod.coder2195.effects.ModDamageTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BulletEntity extends PersistentProjectileEntity {
  private static ItemStack DEFAULT_STACK = new ItemStack(ModItems.BULLET);
  private float damage = 8;
  private boolean despawn = false;
  private Vec3d before = this.getPos();


  @Override
  protected SoundEvent getHitSound() {
    return ModSounds.BULLET_HIT;
  }

  @Override
  protected void onBlockHit(BlockHitResult blockHitResult) {
    if (despawn) {
      this.discardParticles();
      return;
    }

    super.onBlockHit(blockHitResult);

    setSound(ModSounds.BULLET_HIT);
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
    if (this.getWorld().isClient() && !this.inGround) {
      for (int i = 0; i < 10; ++i) {
        double progress = i / 10.0;
        this.getWorld().addParticle(ParticleTypes.CRIT, before.x + (after.x - before.x) * progress,
            before.y + (after.y - before.y) * progress, before.z + (after.z - before.z) * progress, 0, 0, 0);
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
    }
    

    entity.damage(damageSource, damage);
    
    this.discardParticles();
  }

  public void discardParticles() {
    if (this.getWorld().isClient()) {
      for (int i = 0; i < 10; ++i) {
        this.getWorld().addParticle(ParticleTypes.CRIT, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
      }
    }

    discard();
  }

  @Override
  public void writeCustomDataToNbt(NbtCompound nbt) {
    super.writeCustomDataToNbt(nbt);
    nbt.putFloat("damage", damage);
    nbt.putBoolean("despawn", despawn);
  }

  @Override
  public void readCustomDataFromNbt(NbtCompound nbt) {
    super.readCustomDataFromNbt(nbt);
    if (nbt.contains(ID_KEY, NbtCompound.FLOAT_TYPE))
      damage = nbt.getFloat("damage");

    despawn = nbt.getBoolean("despawn");
  }
}
