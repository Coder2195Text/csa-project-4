package mod.coder2195.america.item.custom;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.entity.custom.BulletEntity;
import mod.coder2195.america.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtElement;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AR15 extends Item {
  public static final int AMMO_CAPACITY = 30;
  public static final double RELOAD_TIME = 2.5;
  public static final SoundEvent FIRE_SOUND = ModSounds.ASSAULT_RIFLE_FIRE;
  public static final float DAMAGE = 6;
  public static final float SPEED = 30;
  public static final int DEFAULT_MAX_USE_TIME = 0;

  public AR15() {
    super(new FabricItemSettings().maxDamage(AMMO_CAPACITY + 1));
  }

  public AR15(Settings settings) {
    super(settings);
  }

  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

    ItemStack item = user.getStackInHand(hand);

    if (item.getDamage() >= AMMO_CAPACITY) {
      return TypedActionResult.fail(item);
    }

    item.damage(1, user, (e) -> {
    });
    if (!world.isClient) {
      user.getItemCooldownManager().set(this, 15);
      world.playSound(
          null,
          user.getBlockPos(),
          FIRE_SOUND,
          SoundCategory.PLAYERS,
          1f,
          1f);

      BulletEntity bulletEntity = new BulletEntity(world, user, DAMAGE, SPEED);

      bulletEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, SPEED, 0.0F);
      world.spawnEntity(bulletEntity);
    }

    return TypedActionResult.success(user.getStackInHand(hand), false);
  }
}
