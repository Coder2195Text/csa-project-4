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
  public void action(World world, PlayerEntity user, Hand hand) {
    for (int i = 0; i < PELLETS; i++) {
      BulletEntity bulletEntity = new BulletEntity(world, user, DAMAGE, SPEED, true);

      bulletEntity.setVelocity(user, user.getPitch(),
          user.getYaw(), 0.0F, SPEED, VARIANCE);
      world.spawnEntity(bulletEntity);
    }
  }

}
