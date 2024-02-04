package mod.coder2195.america;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mod.coder2195.america.blocks.ModBlocks;
import mod.coder2195.america.entity.ModEntities;
import mod.coder2195.america.item.ModItemGroups;
import mod.coder2195.america.item.ModItems;
import mod.coder2195.america.sound.ModSounds;
import mod.coder2195.america.networking.ModMessages;

public class AmericaMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "america";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModSounds.registerModSounds();
		ModBlocks.registerModBlocks();
		ModEntities.registerEntities();

		ModMessages.registerC2SPackets();
	}
}