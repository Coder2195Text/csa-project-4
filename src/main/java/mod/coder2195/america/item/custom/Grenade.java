package mod.coder2195.america.item.custom;

import mod.coder2195.america.AmericaMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Grenade extends Item {
  public Class<? extends ThrownItemEntity> GRENADE;

  public Grenade(Settings settings) {
    super(settings);
  }

  public Grenade() {
    super(new Item.Settings().maxCount(16));
  }

  @Override
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.SPEAR;
  }

  public int getMaxUseTime(ItemStack stack) {
    return 72000;
  }

  public void onStoppedUsing(ItemStack itemStack, World world, LivingEntity user, int remainingUseTicks) {
    if (world.isClient) return;


    float ticks = getMaxUseTime(itemStack) - remainingUseTicks;

    float speed = MathHelper.clamp(ticks / 20.0F, 0.0F, 2.0F) * 1F;

    world.playSound(null, user.getX(), user.getY(), user.getZ(),
        // replace with chucking sound when i get one
        SoundEvents.ENTITY_SNOWBALL_THROW,
        // replace with chucking sound when i get one
        SoundCategory.NEUTRAL, 0.5F, 1F);


    ThrownItemEntity grenade;
    try {
      grenade = GRENADE.getConstructor(World.class, LivingEntity.class).newInstance(world, user);
    } catch (Exception e) {
      AmericaMod.LOGGER.error("Failed to create grenade entity", e);
      return;
    }
    grenade.setItem(itemStack);
    grenade.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, speed, 0F);
    world.spawnEntity(grenade);


    if (user instanceof PlayerEntity player) {
      player.incrementStat(Stats.USED.getOrCreateStat(this));
      if (player.getAbilities().creativeMode) return;
    }

    itemStack.decrement(1);
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack itemStack = user.getStackInHand(hand);
    user.setCurrentHand(hand);
    return TypedActionResult.consume(itemStack);
  }
}
