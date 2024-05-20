package mod.coder2195.america.item.custom;

import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;

public class Shotgun extends Gun {
  public int AMMO_CAPACITY = 6;
  public double RELOAD_TIME = 2.5;
  public SoundEvent FIRE_SOUND = ModSounds.SHOTGUN_FIRE;
  public SoundEvent RELOAD_SOUND = ModSounds.SHOTGUN_RELOAD;
  public Item AMMO = ModItems.SHOTGUN_CARTRIDGE;

}
