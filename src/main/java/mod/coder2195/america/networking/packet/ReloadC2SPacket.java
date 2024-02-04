package mod.coder2195.america.networking.packet;

import mod.coder2195.america.item.custom.Gun;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class ReloadC2SPacket {
  public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
      PacketByteBuf buf, PacketSender responseSender) {
    PlayerInventory inventory = player.getInventory();

    ItemStack item = player.getActiveItem();
    if (item.getItem() instanceof Gun gun) {

    }

  }

}
