package mod.coder2195.america.item;

import mod.coder2195.america.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.Rarity;

public class AnthemDisc extends MusicDiscItem {
  public AnthemDisc() {
    super(7, ModSounds.ANTHEM, new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON), 78);
  }
}
