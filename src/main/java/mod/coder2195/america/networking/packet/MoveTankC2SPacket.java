package mod.coder2195.america.networking.packet;

import mod.coder2195.america.entity.custom.M1A2Entity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class MoveTankC2SPacket {
  /**
   * Move tank, arrange packetbuf as up down left right
   *
   * @param server
   * @param player
   * @param handler
   * @param buf
   * @param responseSender
   */
  public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                             PacketByteBuf buf, PacketSender responseSender) {
    if (player.getVehicle() instanceof M1A2Entity tank) {
      boolean up = buf.readBoolean();
      boolean down = buf.readBoolean();
      boolean left = buf.readBoolean();
      boolean right = buf.readBoolean();

      tank.movingUp = up;
      tank.movingDown = down;
      tank.movingLeft = left;
      tank.movingRight = right;
    }



  }
}
