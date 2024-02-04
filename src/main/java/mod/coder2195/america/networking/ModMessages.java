package mod.coder2195.america.networking;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.networking.packet.ReloadC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
  public static final Identifier RELOADING_ID = new Identifier(AmericaMod.MOD_ID, "reloading");

  public static void registerC2SPackets() {
    ServerPlayNetworking.registerGlobalReceiver(RELOADING_ID, ReloadC2SPacket::receive);
  }

  public static void registerS2CPackets() {

  }
}
