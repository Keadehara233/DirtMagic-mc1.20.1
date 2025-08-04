package com.kea;

import com.kea.block.ModBlocks;
import com.kea.blockentity.ModBlockEntities;
import com.kea.entity.ModEntities;
import com.kea.item.ModItemGroups;
import com.kea.item.ModItems;
import com.kea.recipe.ModRecipes;
import com.kea.screen.ModScreenHandlers;
import com.kea.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirtMagic implements ModInitializer {
	public static final String MOD_ID = "dirtmagic";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerItems();
		ModItemGroups.registerGroups();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();

		ModWorldGeneration.generateModWorldGen();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		LOGGER.info("DirtMagic Mod Has Successfully Loaded.");
	}
}