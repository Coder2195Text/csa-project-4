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
  }

  @Override
  public void generate(RecipeExporter exporter) {
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BULLET, 9).pattern("G#W")
        .input('#', Items.COPPER_INGOT).input('W', Items.IRON_INGOT).input('G', Items.GUNPOWDER)
        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
        .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
        .offerTo(exporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BURGER, 1).pattern("B").pattern("F").pattern("B")
        .input('B', Items.BREAD).input('F', Items.COOKED_BEEF)
        .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
        .criterion(hasItem(Items.COOKED_BEEF), conditionsFromItem(Items.COOKED_BEEF))
        .offerTo(exporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHOTGUN_SHELL, 4).pattern("WG#").pattern("WG#")
        .input('#', Items.COPPER_INGOT).input('W', Items.IRON_INGOT).input('G', Items.GUNPOWDER)
        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.GOLD_INGOT))
        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
        .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
        .offerTo(exporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SMOKE_GRENADE, 1)
        .pattern(" LN").pattern("IMI").pattern("IMI")
        .input('L', Items.LEVER).input('N', Items.IRON_NUGGET).input('I', Items.IRON_INGOT).input('M', Items.INK_SAC)
        .criterion(hasItem(Items.LEVER), conditionsFromItem(Items.LEVER))
        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
        .criterion(hasItem(Items.INK_SAC), conditionsFromItem(Items.INK_SAC))
        .offerTo(exporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GRENADE, 1)
        .pattern(" LN").pattern("IMI").pattern("IMI")
        .input('L', Items.LEVER).input('N', Items.IRON_NUGGET).input('I', Items.IRON_INGOT).input('M', Items.GUNPOWDER)
        .criterion(hasItem(Items.LEVER), conditionsFromItem(Items.LEVER))
        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
        .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
        .offerTo(exporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.INCENDIARY_GRENADE, 1)
        .pattern(" LN").pattern("IMI").pattern("IMI")
        .input('L', Items.LEVER).input('N', Items.IRON_NUGGET).input('I', Items.IRON_INGOT).input('M', Items.LAVA_BUCKET)
        .criterion(hasItem(Items.LEVER), conditionsFromItem(Items.LEVER))
        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
        .criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET))
        .offerTo(exporter);


    // glowstone for flashbang
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FLASHBANG, 1)
        .pattern(" LN").pattern("IMI").pattern("IMI")
        .input('L', Items.LEVER).input('N', Items.IRON_NUGGET).input('I', Items.IRON_INGOT).input('M', Items.GLOWSTONE_DUST)
        .criterion(hasItem(Items.LEVER), conditionsFromItem(Items.LEVER))
        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
        .criterion(hasItem(Items.GLOWSTONE), conditionsFromItem(Items.GLOWSTONE))
        .offerTo(exporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TANK_SHELL, 1)
        .pattern(" I ")
        .pattern("IGI")
        .pattern("IGI")
        .input('I', Items.IRON_INGOT).input('G', Items.GUNPOWDER)
        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
        .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
        .offerTo(exporter);
  }
}
