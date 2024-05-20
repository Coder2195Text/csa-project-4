package mod.coder2195.america.item.custom;

import mod.coder2195.america.entity.custom.BulletEntity;
import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Shotgun extends Gun {
  {
    AMMO_CAPACITY = 6;
    RELOAD_TIME = 2.5;
    FIRE_SOUND = ModSounds.SHOTGUN_FIRE;
    RELOAD_SOUND = ModSounds.SHOTGUN_RELOAD;
    AMMO = ModItems.SHOTGUN_CARTRIDGE;
    FIRE_DELAY = 10;
    VARIANCE = 10f;
    DAMAGE = 3;
  }

  public int PELLETS = 10;

  @Override
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
      for (int i = 0; i < PELLETS; i++) {
        world.playSound(
            null,
            user.getBlockPos(),
            FIRE_SOUND,
            SoundCategory.PLAYERS,
            1f,
            1f);

        BulletEntity bulletEntity = new BulletEntity(world, user, DAMAGE, SPEED);

        bulletEntity.setVelocity(user, user.getPitch(),
            user.getYaw(), 0.0F, SPEED, VARIANCE);
        world.spawnEntity(bulletEntity);
        tag.putLong("lastFire", currentTime);
        if (!user.isCreative()) {
          tag.putInt("ammo", ammo - 1);
        }
      }
    }
    return TypedActionResult.success(user.getStackInHand(hand), false);
  }

}
