package mod.coder2195.america.entity.custom;

import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class M1A2Entity extends MobEntity {
  public static TrackedData<Float> HEAD_YAW;
  public static TrackedData<Float> PITCH;
  public static TrackedData<Float> BODY_YAW;

  public boolean movingUp = false;
  public boolean movingDown = false;
  public boolean movingLeft = false;
  public boolean movingRight = false;
  private int fireTicks = 0;

  @Override
  public float getPitch() {
    return dataTracker.get(PITCH);
  }

  @Override
  public int getMaxHeadRotation() {
    return 360;
  }

  @Override
  public float getHeadYaw() {
    return dataTracker.get(HEAD_YAW);
  }

  public float getBodyYaw() {
    return dataTracker.get(BODY_YAW);
  }

  @Override
  public float getYaw() {
    return getBodyYaw();
  }

  public void setTankPitch(float pitch) {
    dataTracker.set(PITCH, pitch);
  }

  public void setTurretYaw(float headYaw) {
    dataTracker.set(HEAD_YAW, headYaw);
  }

  public void setTankYaw(float bodyYaw) {
    dataTracker.set(BODY_YAW, bodyYaw);
  }


  static {
    HEAD_YAW = DataTracker.registerData(M1A2Entity.class, TrackedDataHandlerRegistry.FLOAT);
    PITCH = DataTracker.registerData(M1A2Entity.class, TrackedDataHandlerRegistry.FLOAT);
    BODY_YAW = DataTracker.registerData(M1A2Entity.class, TrackedDataHandlerRegistry.FLOAT);
  }

  @Override
  protected void initDataTracker() {
    super.initDataTracker();
    dataTracker.startTracking(HEAD_YAW, 0.0F);
    dataTracker.startTracking(PITCH, 0.0F);
    dataTracker.startTracking(BODY_YAW, 0.0F);
  }

  public boolean isLogicalSideForUpdatingMovement() {
    World world = getWorld();
    return !world.isClient;
  }

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
    World world = getWorld();
    if (this.hasPassenger(source.getAttacker())) {

      if (!world.isClient) {

        //fire and set fire ticks
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
    Vec3d pos = super.getPassengerRidingPos(passenger).add(0, -1.4, 0);
    float yaw = this.getBodyYaw();
    pos = pos.add(new Vec3d(0, 0, 0.5).rotateY(-yaw * 0.017453292F));
    yaw = this.getHeadYaw();
    pos = pos.add(new Vec3d(0, 0, -0.5).rotateY(-yaw * 0.017453292F));
    return pos;
  }


  @Override
  public void onPassengerLookAround(Entity passenger) {
    if (!this.hasPassengers()) return;
    this.setTurretYaw(passenger.getHeadYaw());
    setTankPitch(MathHelper.clamp(passenger.getPitch(), -30, 5));
  }

  @Override
  public void tick() {
    World world = getWorld();
    if (!world.isClient) {
      if (hasPassengers()) {
        movingUp = movingDown = movingLeft = movingRight = false;
      }
      float water = isInFluid() ? .3f : 1;
      if (movingLeft ^ movingRight) {
        setTankYaw(getBodyYaw() + (movingLeft ? -1 : 1) * 2 * water);
      }

      if (movingUp ^ movingDown) {
        double multiplier = water * (movingUp ? 1 : -1);
        move(MovementType.SELF, new Vec3d(0, 0, .4 * multiplier).rotateY(-getBodyYaw() * 0.017453292F)); // convert to radians
      }

    }

    setAir(300);
    super.tick();
    setBodyYaw(getBodyYaw());
    setHeadYaw(getHeadYaw());

    Entity passenger = getControllingPassenger();
    onPassengerLookAround(getControllingPassenger());
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

    if (nbt.contains("HeadYaw"))
      setTurretYaw(nbt.getFloat("HeadYaw"));
    if (nbt.contains("Pitch"))
      setTankPitch(nbt.getFloat("Pitch"));

    if (nbt.contains("BodyYaw"))
      setTankYaw(nbt.getFloat("BodyYaw"));
  }
}
