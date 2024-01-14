package mod.coder2195.america.item;

import mod.coder2195.america.AmericaMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
  public static final Item BULLET = registerItem("bullet", new Bullet());
  public static final Item ANTHEM_DISC = registerItem("anthem_disc", new AnthemDisc());

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
