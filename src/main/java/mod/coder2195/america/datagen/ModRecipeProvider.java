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

	}

}
