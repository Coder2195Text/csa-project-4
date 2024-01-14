package mod.coder2195.america.item;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
  public static final Item BULLET = registerItem("bullet", new Item(new FabricItemSettings()));
  public static final Item ANTHEM_DISC = registerItem("anthem_disc",
      new MusicDiscItem(7, ModSounds.ANTHEM, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 78));

  private static void addToCombat(FabricItemGroupEntries entries) {
    entries.add(BULLET);
  }

  private static void addToTools(FabricItemGroupEntries entries) {
    entries.add(ANTHEM_DISC);
  }

  public static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM,
        new Identifier(AmericaMod.MOD_ID, name), item);
  }

  public static void registerModItems() {
    AmericaMod.LOGGER.info("Registering mod items for " + AmericaMod.MOD_ID + "...");

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addToCombat);
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addToTools);
  }
}
