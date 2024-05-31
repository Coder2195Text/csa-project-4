package mod.coder2195.america.event;

import mod.coder2195.america.entity.custom.M1A2Entity;
import net.minecraft.network.PacketByteBuf;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

import mod.coder2195.america.networking.ModMessages;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;

public class KeyEventHandler {
  public static final String KEY_CATEGORY_AMERICA = "key.categories.america";
  public static final String KEY_RELOAD = "key.america.reload";
  public static final String KEY_ZOOM = "key.america.zoom";

  public static KeyBinding reloadKey;
  public static boolean justReloaded = false;

  public static KeyBinding zoomKey;
  public static boolean isZooming = false;

  public static boolean isMovingForward = false;
  public static boolean isMovingBackward = false;
  public static boolean isMovingLeft = false;
  public static boolean isMovingRight = false;
  @Nullable
  public static Entity vehicle = null;


  public static void registerKeyInputs() {
    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      if (!reloadKey.isPressed()) {
        justReloaded = false;
        return;
      }

      if (justReloaded) {
        return;
      }

      justReloaded = true;

      ClientPlayNetworking.send(ModMessages.RELOADING_ID, PacketByteBufs.create());
    });

    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      isZooming = zoomKey.isPressed();

      if (client.player == null) return;

      boolean forward = client.options.forwardKey.isPressed();
      boolean backward = client.options.backKey.isPressed();
      boolean left = client.options.leftKey.isPressed();
      boolean right = client.options.rightKey.isPressed();
      int moving = 0;

      if (client.player.getVehicle() instanceof Entity && !client.player.getVehicle().equals(vehicle)) {
        vehicle = client.player.getVehicle();
        moving++;
      } else {
        vehicle = null;
      }

      if (forward != isMovingForward) {
        isMovingForward = forward;
        moving++;
      }
      if (backward != isMovingBackward) {
        isMovingBackward = backward;
        moving++;
      }
      if (left != isMovingLeft) {
        isMovingLeft = left;
        moving++;
      }
      if (right != isMovingRight) {
        isMovingRight = right;
        moving++;
      }

      if (moving == 0) return;
      if (vehicle instanceof M1A2Entity tank) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBoolean(isMovingForward);
        buf.writeBoolean(isMovingBackward);
        buf.writeBoolean(isMovingLeft);
        buf.writeBoolean(isMovingRight);

        ClientPlayNetworking.send(ModMessages.MOVE_TANK_ID, buf);
      }
    });

    // add minecraft default movemne

  }

  public static void register() {
    reloadKey = KeyBindingHelper
        .registerKeyBinding(new KeyBinding(KEY_RELOAD, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_AMERICA));
    zoomKey = KeyBindingHelper
        .registerKeyBinding(new KeyBinding(KEY_ZOOM, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_AMERICA));


    registerKeyInputs();
  }
}
