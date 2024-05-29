package mod.coder2195.america.entity.custom;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class M1A2Entity extends MobEntity {
  public Float oldBodyYaw;
    public Float oldHeadYaw;
    public Float oldPitch;

    private int gunFireTicks = 0;



  public M1A2Entity(EntityType<? extends MobEntity> entityType, World world) {
    super(entityType, world);
  }


  public static DefaultAttributeContainer.Builder createM1A2Attributes() {
    return MobEntity.createMobAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25).add(EntityAttributes.GENERIC_ARMOR, 20)
        .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 10).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 10);
  }

  @Override
  public boolean hurtByWater() {
    return false;
  }

  @Override
  public boolean canFreeze() {
    return false;
  }

  @Override
  public boolean isFireImmune() {
    return true;
  }

  @Override
  public boolean isPushable() {
    return false;
  }


  @Override
  public boolean damage(DamageSource source, float amount) {
   
    if (this.hasPassenger(source.getAttacker())) {
      World world = getWorld();
      if (!world.isClient) {
        gunFireTicks=15;
      }
      return false;
    }
    return super.damage(source, amount);
  }

  @Nullable
  @Override
  public LivingEntity getControllingPassenger() {
    for (Entity entity : this.getPassengerList()) {
      if (entity instanceof LivingEntity) {
        return (LivingEntity) entity;
      }
    }
    return null;
  }

  @Override
  public Vec3d getPassengerRidingPos(Entity passenger) {
    Vec3d pos = super.getPassengerRidingPos(passenger).add(0,-1.4,0);
    float yaw = this.getBodyYaw();
    pos = pos.add(new Vec3d(0, 0, 0.5).rotateY(-yaw * 0.017453292F));
    yaw = this.getHeadYaw();
    pos = pos.add(new Vec3d(0, 0, -0.5).rotateY(-yaw * 0.017453292F));
    return pos;
  }


  @Override
  public void onPassengerLookAround(Entity passenger) {
    if (!this.hasPassengers()) return;
    this.setHeadYaw(passenger.getHeadYaw());
    setPitch(MathHelper.clamp(passenger.getPitch(), -30, 5));

    oldPitch = this.getPitch();
    oldHeadYaw = this.getHeadYaw();
  }

  @Override
  public void tick() {
    World world = getWorld();
    if (!world.isClient) {
      if (gunFireTicks > 0) {
        gunFireTicks--;

        Vec3d firePos = getPos();
        // update firePos to the barrel of the gun
        BulletEntity bullet = new BulletEntity(world, firePos.x, firePos.y, firePos.z, ItemStack.EMPTY);
        // update rotation
      }

    }
    if (oldPitch == null) oldPitch = this.getPitch();
    if (oldHeadYaw == null) oldHeadYaw = this.getHeadYaw();
    if (oldBodyYaw == null) oldBodyYaw = this.getBodyYaw();
    setAir(300);
    super.tick();
    Entity passenger = getControllingPassenger();
    if (passenger != null) {
    }
    onPassengerLookAround(getControllingPassenger());
    setHeadYaw(oldHeadYaw);
    setPitch(oldPitch);
    setBodyYaw(oldBodyYaw);

    oldPitch = null;
    oldHeadYaw = null;
    oldBodyYaw = null;
  }


  @Override
  public ActionResult interactMob(PlayerEntity player, Hand hand) {
    World world = getWorld();
    boolean client = world.isClient;
    ActionResult result = hasPassenger(player) || couldAcceptPassenger() ? ActionResult.SUCCESS : ActionResult.FAIL;
    if (client) return result;
    if (!result.isAccepted()) return result;

    if (hasPassenger(player)) {
      player.sendMessage(Text.of("FIRE"));
    }
      player.startRiding(this);


    return result;
  }

  @Override
  protected boolean couldAcceptPassenger() {
    return getPassengerList().isEmpty();
  }

  @Override
  public Text getStyledDisplayName() {
    return super.getStyledDisplayName();
  }

  @Override
  public boolean cannotBeSilenced() {
    return super.cannotBeSilenced();
  }

  @Override
  public void writeCustomDataToNbt(NbtCompound nbt) {
    super.writeCustomDataToNbt(nbt);

    nbt.putFloat("HeadYaw", getHeadYaw());
    nbt.putFloat("Pitch", getPitch());
    nbt.putFloat("BodyYaw", getBodyYaw());
  }

  @Override
  public void readCustomDataFromNbt(NbtCompound nbt) {
    super.readCustomDataFromNbt(nbt);

    oldPitch = nbt.getFloat("Pitch");
    oldHeadYaw = nbt.getFloat("HeadYaw");
    oldBodyYaw = nbt.getFloat("BodyYaw");
  }
}
