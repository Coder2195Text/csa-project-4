package mod.coder2195.america.datagen;

import java.util.concurrent.CompletableFuture;

import mod.coder2195.america.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

  public static final TagKey<Item> GUN_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("america:guns"));

  public ModItemTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
    super(output, completableFuture);

  }

  @Override
  protected void configure(WrapperLookup arg) {
    getOrCreateTagBuilder(GUN_ITEMS).add(ModItems.AR15);
    getOrCreateTagBuilder(ItemTags.MUSIC_DISCS).add(ModItems.ANTHEM_DISC);
    getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS).add(ModItems.ANTHEM_DISC);
  }

}
