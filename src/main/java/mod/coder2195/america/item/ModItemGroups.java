package mod.coder2195.america.item;

import mod.coder2195.america.AmericaMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
  public static ItemGroup AMERICA_WEAPONS = Registry.register(Registries.ITEM_GROUP,
      new Identifier(AmericaMod.MOD_ID, "america_weapons"),
      FabricItemGroup
          .builder()
          .displayName(Text.translatable("itemgroup.america_weapons"))
          .icon(() -> new ItemStack(ModItems.BULLET)).entries((display, entries) -> {
            entries.add(ModItems.BULLET);
            entries.add(ModItems.SHOTGUN_SHELL);
            for (Item gun : ModItems.GUNS) {
              entries.add(gun);
            }
            entries.add(ModItems.SMOKE_GRENADE);
            entries.add(ModItems.GRENADE);
          }).build());

  public static void registerItemGroups() {

    AmericaMod.LOGGER.info("Registering item groups for " + AmericaMod.MOD_ID);
  }
}
