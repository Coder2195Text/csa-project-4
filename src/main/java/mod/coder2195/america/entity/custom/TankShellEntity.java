package mod.coder2195.america.entity.custom;

import mod.coder2195.america.effects.ModDamageTypes;
import mod.coder2195.america.entity.ModEntities;
import mod.coder2195.america.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TankShellEntity extends PersistentProjectileEntity {
  private final static ItemStack DEFAULT_STACK = new ItemStack(ModItems.TANK_SHELL);

  public void explode(Vec3d position) {
    World world = this.getWorld();
    if (world.isClient) return;
    world.createExplosion(this, position.x, position.y, position.z,  6f, false, World.ExplosionSourceType.MOB);
    this.discard();
  }

  @Override
  protected void onBlockHit(BlockHitResult blockHitResult) {

    super.onBlockHit(blockHitResult);

    World world = this.getWorld();

    if (world.isClient) return;

    explode(blockHitResult.getBlockPos().toCenterPos());

  }

  public TankShellEntity(EntityType<? extends TankShellEntity> entityType, World world) {
    super(entityType, world, DEFAULT_STACK);
  }

  public TankShellEntity(World world, double x, double y, double z, ItemStack stack) {
    super(ModEntities.TANK_SHELL, x, y, z, world, stack);

  }

  public TankShellEntity(World world, LivingEntity owner, ItemStack stack) {
    super(ModEntities.TANK_SHELL, owner, world, stack);
  }

  public TankShellEntity(World world, LivingEntity owner, float speed) {
    super(ModEntities.TANK_SHELL, owner, world, DEFAULT_STACK);
    this.speed = speed;
  }


  @Override
  protected void onEntityHit(EntityHitResult entityHitResult) {
    World world = this.getWorld();
    if (world.isClient) return;
    Entity entity = entityHitResult.getEntity();

    Entity owner = this.getOwner();
    double speed = this.getVelocity().length();

    DamageSource damageSource;
    if (owner == null) {
      damageSource = ModDamageTypes.of(getWorld(), ModDamageTypes.TANK_SHELL);
    } else {
      damageSource = ModDamageTypes.of(getWorld(),
          ModDamageTypes.TANK_SHELL, owner);
    }

    entity.damage(damageSource, (float) (getVelocity().length() * 2.5f));

    explode(entity.getPos());

   this.discard();
  }

}
