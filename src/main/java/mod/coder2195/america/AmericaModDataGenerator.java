package mod.coder2195.america;

import mod.coder2195.america.datagen.ModAdvancementProvider;
import mod.coder2195.america.datagen.ModBlockTagProvider;
import mod.coder2195.america.datagen.ModDamageTagProvider;
import mod.coder2195.america.datagen.ModDamageTypeProvider;
import mod.coder2195.america.datagen.ModItemTagProvider;
import mod.coder2195.america.datagen.ModLootTableProvider;
import mod.coder2195.america.datagen.ModModelProvider;
import mod.coder2195.america.datagen.ModRecipeProvider;
import mod.coder2195.effects.ModDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class AmericaModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModDamageTypeProvider::new);
		pack.addProvider(ModDamageTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModAdvancementProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.DAMAGE_TYPE, ModDamageTypes::init);
	}
}
