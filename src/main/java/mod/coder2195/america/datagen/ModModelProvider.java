package mod.coder2195.america.datagen;

import mod.coder2195.america.blocks.ModBlocks;
import mod.coder2195.america.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

  public ModModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMERICAN_DREAM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_IRON);
  }

  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.BULLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.ANTHEM_DISC, Models.GENERATED);
    itemModelGenerator.register(ModItems.BURGER, Models.GENERATED);
    itemModelGenerator.register(ModItems.COMMUNIST_BADGE, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICAN_BADGE, Models.GENERATED);
    itemModelGenerator.register(ModItems.SHOTGUN_CARTRIDGE, Models.GENERATED);

  }

}
