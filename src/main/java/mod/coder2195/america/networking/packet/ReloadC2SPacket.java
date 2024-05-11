package mod.coder2195.america.networking.packet;

import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.item.custom.Gun;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;

public class ReloadC2SPacket {
  public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
      PacketByteBuf buf, PacketSender responseSender) {
    PlayerInventory inventory = player.getInventory();

    ItemStack item = inventory.getMainHandStack();

    if (item.getItem() instanceof Gun gun) {
      NbtCompound tag = item.getOrCreateNbt();
      if (!tag.contains("ammo")) {
        return;
      }

      int capacity = gun.AMMO_CAPACITY;
      long reloadTime = tag.getLong("reloadTime");
      long currentTime = player.getWorld().getTime();
      int ammo = tag.getInt("ammo");

      // early return for if the gun is already full, reloading, or out of bullets,
      // respectively
      if (ammo == capacity || currentTime - reloadTime < gun.RELOAD_TIME * 20 || inventory.count(ModItems.BULLET) == 0)
        return;

      int target = capacity - ammo;

      player.getWorld().playSound(
          null,
          player.getBlockPos(),
          gun.RELOAD_SOUND,
          SoundCategory.PLAYERS,
          1f,
          1f);
      for (int i = 0; i < inventory.size(); i++) {
        ItemStack stack = inventory.getStack(i);
        if (stack.getItem() == ModItems.BULLET) {
          if (stack.getCount() > target) {
            stack.decrement(target);
            ammo = capacity;
            tag.putInt("ammo", ammo);
            tag.putLong("reloadTime", currentTime);
            return;
          } else {
            target -= stack.getCount();
            ammo += stack.getCount();
            inventory.removeStack(i);
            tag.putInt("ammo", ammo);
            tag.putLong("reloadTime", currentTime);
          }
        }
      }

    }

  }

}
