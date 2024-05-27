package mod.coder2195.america.entity.custom;

import mod.coder2195.america.entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class M1A2Entity extends AnimalEntity {
  @Nullable
  public Float bodyYaw;



  public M1A2Entity(EntityType<? extends AnimalEntity> entityType, World world) {
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


  @Nullable
  @Override
  public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
    return ModEntities.M1A2.create(world);

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
    if (!this.hasPassenger(passenger)) return;
    this.headYaw = passenger.getHeadYaw();
    setPitch(MathHelper.clamp(passenger.getPitch(), -30, 0));
  }

  @Override
  public void tick() {
    setAir(300);
    super.tick();
    if (getWorld().isClient) return;
    move(MovementType.SELF, new Vec3d(0, 0, 1));
  }



  @Override
  public ActionResult interactMob(PlayerEntity player, Hand hand) {
    boolean client = getWorld().isClient;
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
}
