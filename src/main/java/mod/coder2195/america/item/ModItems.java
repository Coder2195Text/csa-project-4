package mod.coder2195.america.item;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.blocks.ModBlocks;
import mod.coder2195.america.item.custom.Gun;
import mod.coder2195.america.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
  public static final Item BULLET = registerItem("bullet", new Item(new FabricItemSettings()));
  public static final Item ANTHEM_DISC = registerItem("music_disc_anthem",
      new MusicDiscItem(7, ModSounds.ANTHEM, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 78));
  public static final Item BURGER = registerItem("burger",
      new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(9).saturationModifier(10.0f).build())));
  public static final Item AR15 = registerItem("ar15", new Gun() {
  });
  public static final Item M24 = registerItem("m24", new Gun() {
    static {
      AMMO_CAPACITY = 1;
      RELOAD_TIME = 2.5;
      FIRE_SOUND = ModSounds.ASSAULT_RIFLE_FIRE;
      DAMAGE = 24;
      SPEED = 30;
      DEFAULT_MAX_USE_TIME = 0;
      FIRE_DELAY = 0;
      VARIANCE = 0f;
    }

  });

  private static void addToFood(FabricItemGroupEntries entries) {
    entries.add(BURGER);
  }

  private static void addToTools(FabricItemGroupEntries entries) {
    entries.add(ANTHEM_DISC);
  }

  private static void addToFunctional(FabricItemGroupEntries entries) {
    entries.add(ModBlocks.AMERICAN_DREAM_BLOCK.asItem());
  }

  public static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM,
        new Identifier(AmericaMod.MOD_ID, name), item);
  }

  public static void registerModItems() {
    AmericaMod.LOGGER.info("Registering mod items for " + AmericaMod.MOD_ID + "...");

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addToTools);
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addToFood);
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addToFunctional);

  }
}
