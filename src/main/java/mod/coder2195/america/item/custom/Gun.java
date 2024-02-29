package mod.coder2195.america.item.custom;

import mod.coder2195.america.entity.custom.BulletEntity;
import mod.coder2195.america.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
  public float DAMAGE = 6;
  public float SPEED = 30;
  public int DEFAULT_MAX_USE_TIME = 0;
  public int FIRE_DELAY = 5;
  public float VARIANCE = 1f;

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
      player.sendMessage(Text.of("Ammo: " + (ammo)), true);
      return;
    }
  }

  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

    ItemStack item = user.getStackInHand(hand);
    NbtCompound tag = item.getOrCreateNbt();
    long lastFire = tag.getLong("lastFire");
    long reloadTime = tag.getLong("reloadTime");
    long currentTime = world.getTime();
    int ammo = tag.getInt("ammo");

    if (!world.isClient) {
      if (currentTime - lastFire < FIRE_DELAY || (ammo <= 0 && !user.isCreative()) || currentTime - reloadTime < RELOAD_TIME * 20) {
        return TypedActionResult.fail(item);
      }
      world.playSound(
          null,
          user.getBlockPos(),
          FIRE_SOUND,
          SoundCategory.PLAYERS,
          1f,
          1f);

      BulletEntity bulletEntity = new BulletEntity(world, user, DAMAGE, SPEED);
      

      bulletEntity.setVelocity(user, user.getPitch() + (float) (Math.random() - 0.5) * VARIANCE,
          user.getYaw() + (float) (Math.random() - 0.5) * VARIANCE, 0.0F, SPEED, 0.0F);
      world.spawnEntity(bulletEntity);
      tag.putLong("lastFire", currentTime);
      if (!user.isCreative()) {
        tag.putInt("ammo", ammo - 1);
      }
    }
    return TypedActionResult.success(user.getStackInHand(hand), false);

  }
}
