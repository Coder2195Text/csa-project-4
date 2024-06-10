package mod.coder2195.america.entity.custom;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.effects.ModDamageTypes;
import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.vehicle.VehicleInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class M1A2Entity extends MobEntity implements RideableInventory, VehicleInventory {
  public static TrackedData<Float> HEAD_YAW;
  public static TrackedData<Float> PITCH;
  public static TrackedData<Float> BODY_YAW;

  public boolean movingUp = false;
  public boolean movingDown = false;
  public boolean movingLeft = false;
  public boolean movingRight = false;
  private int fireTicks = 0;
  private int cannonTicks = 0;
  protected SimpleInventory inventory = new SimpleInventory(27);


  @Nullable
  private Identifier lootTableId;

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

  public void setHeadPitch(float pitch) {
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

      if (!world.isClient && fireTicks <= 0) {

        fireTicks = 15;
        world.playSound(this, this.getBlockPos(), ModSounds.TANK_MACHINE_GUN, SoundCategory.PLAYERS, 1, 1);
      }
      return false;
    }
    else if (isInvulnerableTo(source)) return false;

    return super.damage(source, amount);
  }

  @Override
  public boolean isInvulnerableTo(DamageSource source) {
    // turn into list
    RegistryKey<DamageType>[] types = new RegistryKey[]{DamageTypes.MOB_PROJECTILE, DamageTypes.ARROW, ModDamageTypes.BULLET, ModDamageTypes.SNIPER_BULLET, DamageTypes.CACTUS, DamageTypes.STING, DamageTypes.THORNS, DamageTypes.SWEET_BERRY_BUSH};
    for (RegistryKey<DamageType> type : types) {
      if (source.isOf(type)) return true;
    }
    return false;
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
    setHeadPitch(MathHelper.clamp(passenger.getPitch(), -30, 5));
  }

  @Override
  public void tick() {
    World world = getWorld();

    if (!world.isClient) {
      if (cannonTicks > 0) {
        cannonTicks--;
      }
      addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 3, true, false));
      if (!hasPassengers()) {
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

      boolean creative = getControllingPassenger() instanceof PlayerEntity player && player.getAbilities().creativeMode;


      if (!inventory.containsAny(Set.of(ModItems.BULLET)) && !creative) {
        fireTicks = 0;
      }
      if (fireTicks > 0) {

        for (int i=0; i<inventory.size(); i++) {
          if (creative) break;
          ItemStack stack = inventory.getStack(i);
          if (stack.getItem() == ModItems.BULLET) {
            inventory.getStack(i).decrement(1);
            break;
          }
        }

        fireTicks--;
        var shooter = this.getControllingPassenger();

        Vec3d pos = getPos()
            .add(0, 27.0 / 16, 0)
            .add(new Vec3d(0, 0, 0.5).rotateY(-getBodyYaw() * 0.017453292F))
            .add(new Vec3d(0, 0, 20.0 / 16).rotateY(-getHeadYaw() * 0.017453292F))
            .add(new Vec3d(-3.5 / 16, 0, 9.0 / 16).rotateX(-getPitch() * 0.017453292F).rotateY(-getHeadYaw() * 0.017453292F));


        var bullet = new BulletEntity(world, pos.x, pos.y, pos.z, new ItemStack(ModItems.BULLET));
        if (world instanceof ServerWorld server) {
          server.spawnParticles(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 1, 0, 0, 0, 0);
        }
        bullet.setOwner(shooter);

        bullet.setVelocity(shooter, getPitch(),
            getHeadYaw(), 0.0F, 15f, 3f);
        bullet.setBaseSpeed(15);
        world.spawnEntity(bullet);
      }

    } else {
      // TODO: idk

    }

    setAir(300);

    Entity passenger = getControllingPassenger();
    onPassengerLookAround(passenger);


    super.tick();

    if (world.isClient) {
      setHeadYaw(getHeadYaw());
      setBodyYaw(getBodyYaw());
    }

  }

  @Override
  public ActionResult interactMob(PlayerEntity player, Hand hand) {
    World world = getWorld();
    boolean client = world.isClient;
    ActionResult result = hasPassenger(player) || couldAcceptPassenger() ? ActionResult.SUCCESS : ActionResult.FAIL;
    if (client) return result;
    if (!result.isAccepted()) return result;


    if (hasPassenger(player)) {
      if (cannonTicks <= 0 && (inventory.containsAny(Set.of(ModItems.TANK_SHELL)) || player.getAbilities().creativeMode)) {
        cannonTicks = 150;

        if (!player.getAbilities().creativeMode) {
          for (int i=0; i<inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);
            if (stack.getItem() == ModItems.TANK_SHELL) {
              inventory.getStack(i).decrement(1);
              break;
            }
          }
        }

        Vec3d pos = getPos()
            .add(0, 27.0 / 16, 0)
            .add(new Vec3d(0, 0, 0.5).rotateY(-getBodyYaw() * 0.017453292F))
            .add(new Vec3d(0, 0, 20.0 / 16).rotateY(-getHeadYaw() * 0.017453292F))
            .add(new Vec3d(1.0/16, 0, 45.0 / 16).rotateX(-getPitch() * 0.017453292F).rotateY(-getHeadYaw() * 0.017453292F));

        if (world instanceof ServerWorld server) {
          server.spawnParticles(ParticleTypes.EXPLOSION, pos.x, pos.y, pos.z, 1, 0, 0, 0, 0);
          TankShellEntity shell = new TankShellEntity(world, pos.x, pos.y, pos.z, new ItemStack(ModItems.TANK_SHELL));
          shell.setOwner(player);
          shell.setVelocity(player, getPitch(), getHeadYaw(), 0.0F, 15f, 0.1f);

          world.spawnEntity(shell);
        }

        for (var p : world.getPlayers()) {
          if (p instanceof ServerPlayerEntity serverPlayer) {
            float distance = serverPlayer.distanceTo(this);
            if (distance < 100)
              serverPlayer.networkHandler.sendPacket(new PlaySoundS2CPacket(Registries.SOUND_EVENT.getEntry(ModSounds.TANK_CANNON), SoundCategory.PLAYERS, getX(), getY(), getZ(), 1 - distance / 100, 1, world.getRandom().nextLong()));
          }
        }
      }
    }
    else player.startRiding(this);


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
    nbt.put("Inventory", this.inventory.toNbtList());
  }

  @Override
  public void readCustomDataFromNbt(NbtCompound nbt) {
    super.readCustomDataFromNbt(nbt);

    if (nbt.contains("HeadYaw"))
      setTurretYaw(nbt.getFloat("HeadYaw"));
    if (nbt.contains("Pitch"))
      setHeadPitch(nbt.getFloat("Pitch"));

    if (nbt.contains("BodyYaw"))
      setTankYaw(nbt.getFloat("BodyYaw"));

    NbtList list = nbt.getList("Inventory", NbtCompound.COMPOUND_TYPE);
    this.inventory.readNbtList(list);
  }

  @Override
  public void openInventory(PlayerEntity player) {
    World world = getWorld();
    player.openHandledScreen(this);
    if (world.isClient) return;
    this.emitGameEvent(GameEvent.CONTAINER_OPEN, player);
    AmericaMod.LOGGER.info("Opening inventory");
  }

  @Override
  @Nullable
  public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    if (this.lootTableId == null || !playerEntity.isSpectator()) {
      this.generateInventoryLoot(playerInventory.player);
      return GenericContainerScreenHandler.createGeneric9x3(i, playerInventory, this);
    }
    return null;
  }

  @Override
  protected void dropInventory() {
    super.dropInventory();
    if (inventory == null) return;
    for (int i = 0; i < inventory.size(); i++) {
      ItemStack stack = inventory.getStack(i);
      if (!stack.isEmpty()) {
        dropStack(stack);
      }
    }

  }

  @Override
  public void setLootTableId(@Nullable Identifier lootTableId) {
    this.lootTableId = lootTableId;
  }

  @Override
  public void setLootTableSeed(long lootTableSeed) {
    this.lootTableSeed = lootTableSeed;
  }

  @Override
  public DefaultedList<ItemStack> getInventory() {
    return null;
  }

  @Override
  public void resetInventory() {
    this.inventory.clear();
  }

  @Override
  public int size() {
    return 27;
  }

  @Override
  public ItemStack getStack(int slot) {
    return this.inventory.getStack(slot);
  }

  @Override
  public ItemStack removeStack(int slot, int amount) {
    return this.inventory.removeStack(slot, amount);
  }

  @Override
  public ItemStack removeStack(int slot) {
    return this.inventory.removeStack(slot);
  }

  @Override
  public void setStack(int slot, ItemStack stack) {
    this.inventory.setStack(slot, stack);
  }

  @Override
  public void markDirty() {

  }

  @Override
  public boolean canPlayerUse(PlayerEntity player) {
    return this.hasPassenger(player);
  }

  @Override
  public void clear() {
    clearInventory();
  }
}
