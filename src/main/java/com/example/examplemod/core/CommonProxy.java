package com.example.examplemod.core;

import com.example.examplemod.core.registry.BlocksRegistry;
import com.example.examplemod.core.registry.ItemsRegistry;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	private SimpleNetworkWrapper network;

	public SimpleNetworkWrapper getNetwork() {
		return this.network;
	}

	public void onPreInit(FMLPreInitializationEvent event) {
		this.network = new SimpleNetworkWrapper("network");
		ItemsRegistry.registerItems();
		BlocksRegistry.registerBlocks();
	}

	public void onInit(FMLInitializationEvent event) {
	}

	public void onPostInit(FMLPostInitializationEvent event) {

	}

	public void onServerStarted(FMLServerStartingEvent event) {
	}

	private void registerEvent(Object object) {
		FMLCommonHandler.instance().bus().register(object);
		MinecraftForge.EVENT_BUS.register(object);
	}
}
