package mod.coder2195.america.blocks;

import mod.coder2195.america.AmericaMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

  public static final Block AMERICAN_DREAM_BLOCK = registerBlock("american_dream_block", new AmericanDreamBlock());

  public static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, new Identifier(AmericaMod.MOD_ID, name), block);
  }

  public static Item registerBlockItem(String name, Block block) {
    return Registry.register(Registries.ITEM, new Identifier(AmericaMod.MOD_ID, name),
        new BlockItem(block, new Item.Settings()));
  }

  public static void registerModBlocks() {
    AmericaMod.LOGGER.info("Registering mod blocks for " + AmericaMod.MOD_ID + "...");
  }
}
