package mod.coder2195.america.sound;

import mod.coder2195.america.AmericaMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
  public static final SoundEvent ANTHEM = registerSoundEvent("anthem");

  public static SoundEvent registerSoundEvent(String name) {
    Identifier id = new Identifier(AmericaMod.MOD_ID, name);
    return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
  }

  public static void registerModSounds() {
    AmericaMod.LOGGER.info("Registering mod sounds for " + AmericaMod.MOD_ID + "...");
  }
}
