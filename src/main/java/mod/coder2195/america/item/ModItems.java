package mod.coder2195.america.item;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.blocks.ModBlocks;
import mod.coder2195.america.item.custom.Gun;
import mod.coder2195.america.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
  // m24
  public static final Item M24 = registerItem("m24", new Gun() {
    {
      AMMO_CAPACITY = 1;
      RELOAD_TIME = 4;
      FIRE_SOUND = ModSounds.SNIPER_FIRE;
      RELOAD_SOUND = ModSounds.SNIPER_RELOAD;
      DAMAGE = 24;
      SPEED = 30;

      FIRE_DELAY = 30;
      VARIANCE = 0f;
      SCOPED = true;
      ZOOM_FOV = 0.1f;
    }
  });

  // implement ak47 + communist badge
  public static final Item AK47 = registerItem("ak47", new Gun() {
    {
      DAMAGE = 5f;
      SPEED = 20;

      FIRE_DELAY = 4;
      VARIANCE = 2f;
    }
  });

  public static final Item M4A1 = registerItem("m4a1", new Gun() {
    {
      DAMAGE = 5.5f;
      SPEED = 24;

      FIRE_DELAY = 5;
      VARIANCE = 2.5f;
    }
  });

  public static final Item MINIGUN = registerItem("minigun", new Gun() {
    {
      DAMAGE = 3f;
      SPEED = 15;
      AMMO_CAPACITY = 300;
      ZOOM_FOV = 0.1f;

      FIRE_DELAY = 0;
      VARIANCE = 6f;
    }
  });

  public static final Item[] GUNS = new Item[] { ModItems.AR15, ModItems.M24, ModItems.AK47, ModItems.M4A1,
      ModItems.MINIGUN };

  public static final Item COMMUNIST_BADGE = registerItem("communist_badge", new Item(new FabricItemSettings()));
  public static final Item AMERICAN_BADGE = registerItem("american_badge", new Item(new FabricItemSettings()));

  private static void addToFood(FabricItemGroupEntries entries) {
    entries.add(BURGER);
  }

  private static void addToTools(FabricItemGroupEntries entries) {
    entries.add(ANTHEM_DISC);
  }

  private static void addToFunctional(FabricItemGroupEntries entries) {
    entries.add(ModBlocks.AMERICAN_DREAM_BLOCK.asItem());
  }

  private static void addToIngrediants(FabricItemGroupEntries entries) {
    entries.add(ModItems.COMMUNIST_BADGE);
    entries.add(ModItems.AMERICAN_BADGE);
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
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addToIngrediants);
  }
}
