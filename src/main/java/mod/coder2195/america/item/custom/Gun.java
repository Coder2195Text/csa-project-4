package mod.coder2195.america.item.custom;

import mod.coder2195.america.entity.custom.BulletEntity;
import mod.coder2195.america.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public abstract class Gun extends Item {
  public static final int AMMO_CAPACITY = 30;
  public static final double RELOAD_TIME = 2.5;
  public static final SoundEvent FIRE_SOUND = ModSounds.ASSAULT_RIFLE_FIRE;
  public static final float DAMAGE = 6;
  public static final float SPEED = 30;
  public static final int DEFAULT_MAX_USE_TIME = 0;
  public static final int FIRE_DELAY = 5;
  public static final float VARIANCE = 1f;

  public Gun() {
    super(new FabricItemSettings().maxDamage(AMMO_CAPACITY + 1));
  }

  public Gun(Settings settings) {
    super(settings);
  }

  @Override
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.BOW;
  }

  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

    ItemStack item = user.getStackInHand(hand);

    if (item.getDamage() >= AMMO_CAPACITY && !user.getAbilities().creativeMode) {
      return TypedActionResult.fail(item);
    }

    item.damage(1, user, (e) -> {
    });
    if (!world.isClient) {
      user.getItemCooldownManager().set(this, FIRE_DELAY);
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
    }

    return TypedActionResult.success(user.getStackInHand(hand), false);
  }
}
