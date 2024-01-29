package mod.coder2195.america.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
  public static final TagKey<Item> GUN_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("america:guns"));
}
