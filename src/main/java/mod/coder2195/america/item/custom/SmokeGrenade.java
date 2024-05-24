package mod.coder2195.america.item.custom;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.entity.custom.SmokeGrenadeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SmokeGrenade extends Item {
  public SmokeGrenade(Settings settings) {
    super(settings);
  }
  public SmokeGrenade() {
    super(new Item.Settings().maxCount(16));
  }

  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
    world.playSound(null, user.getX(), user.getY(), user.getZ(),
        // replace with chucking sound when i get one
        SoundEvents.ENTITY_SNOWBALL_THROW,
        // replace with chucking sound when i get one
        SoundCategory.NEUTRAL, 0.5F, 1F);
    if (!world.isClient) {
      SmokeGrenadeEntity grenade = new SmokeGrenadeEntity(world, user);
      grenade.setItem(itemStack);
      grenade.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
      world.spawnEntity(grenade);
    }

    user.incrementStat(Stats.USED.getOrCreateStat(this));
    if (!user.getAbilities().creativeMode) {
      itemStack.decrement(1); // decrements itemStack if user is not in creative mode
    }

    return TypedActionResult.success(itemStack, world.isClient());
  }
}
