package mod.coder2195.america.event;

import org.lwjgl.glfw.GLFW;

import mod.coder2195.america.networking.ModMessages;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;

public class KeyEventHandler {
  public static final String KEY_CATEGORY_AMERICA = "key.categories.america";
  public static final String KEY_RELOAD = "key.america.reload";

  public static KeyBinding reloadKey;

  public static void registerKeyInputs() {
    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      if (!reloadKey.isPressed())
        return;

      ClientPlayNetworking.send(ModMessages.RELOADING_ID, PacketByteBufs.create());
    });
  }

  public static void register() {
    reloadKey = KeyBindingHelper
        .registerKeyBinding(new KeyBinding(KEY_RELOAD, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_AMERICA));

    registerKeyInputs();
  }
}
