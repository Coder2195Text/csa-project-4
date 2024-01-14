package mod.coder2195.america.datagen;

import mod.coder2195.america.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

public class ModRecipeProvider extends FabricRecipeProvider {

  public ModRecipeProvider(FabricDataOutput output) {
    super(output);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void generate(RecipeExporter exporter) {
    // TODO Auto-generated method stub
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BULLET, 9).pattern("G#W")
        .input('#', Items.COPPER_INGOT).input('W', Items.IRON_INGOT).input('G', Items.GUNPOWDER)
        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
        .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
        .offerTo(exporter, "bullet");
  }

}
