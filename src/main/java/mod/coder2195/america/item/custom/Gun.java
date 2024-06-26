package mod.coder2195.america.item.custom;

import mod.coder2195.america.entity.custom.BulletEntity;
import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public abstract class Gun extends Item {
  public int AMMO_CAPACITY = 30;
  public double RELOAD_TIME = 2.5;
  public SoundEvent FIRE_SOUND = ModSounds.ASSAULT_RIFLE_FIRE;
  public SoundEvent RELOAD_SOUND = ModSounds.ASSAULT_RIFLE_RELOAD;
  public float DAMAGE = 6;
  public float SPEED = 30;
  public int DEFAULT_MAX_USE_TIME = 0;
  public Item AMMO = ModItems.BULLET;
  public int FIRE_DELAY = 5;
  public boolean SCOPED = false;
  public float ZOOM_FOV = 0.75f;
  public float VARIANCE = 3f;

  public Gun() {
    super(new FabricItemSettings().maxCount(1));
  }

  public Gun(Settings settings) {
    super(settings);
  }

  @Override
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.BOW;
  }

  @Override
  public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
    NbtCompound tag = stack.getOrCreateNbt();
    long reloadTime = tag.getLong("reloadTime");

    int ammo = AMMO_CAPACITY;

    if (tag.contains("ammo")) {
      ammo = tag.getInt("ammo");
    } else if (!world.isClient) {
      tag.putInt("ammo", AMMO_CAPACITY);
    }

    if (world.isClient && selected && entity instanceof PlayerEntity player) {
      if (reloadTime + (int) (RELOAD_TIME * 20) > world.getTime())
        player.sendMessage(Text.of("Reloading..."), true);
      else
        player.sendMessage(Text.of("Ammo: " + (ammo)), true);

    }
  }

  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

    ItemStack item = user.getStackInHand(hand);
    NbtCompound tag = item.getOrCreateNbt();
    long lastFire = tag.getLong("lastFire");
    long reloadTime = tag.getLong("reloadTime");
    long currentTime = world.getTime();
    int ammo = tag.getInt("ammo");

    if (currentTime - lastFire < FIRE_DELAY || (ammo <= 0 && !user.isCreative())
        || currentTime - reloadTime < RELOAD_TIME * 20) {
      return TypedActionResult.fail(item);
    }

    if (!world.isClient) {
      world.playSound(
          null,
          user.getBlockPos(),
          FIRE_SOUND,
          SoundCategory.PLAYERS,
          1f,
          1f);

      action(world, user, hand);

      tag.putLong("lastFire", currentTime);
      if (!user.isCreative()) {
        tag.putInt("ammo", ammo - 1);
      }
    }
    return TypedActionResult.success(user.getStackInHand(hand), false);
  }

  public void action(World world, PlayerEntity user, Hand hand) {

    BulletEntity bulletEntity = new BulletEntity(world, user, DAMAGE, SPEED);
    bulletEntity.setBaseSpeed(SPEED);

    bulletEntity.setVelocity(user, user.getPitch(),
        user.getYaw(), 0.0F, SPEED, VARIANCE);
    world.spawnEntity(bulletEntity);

  }
}
