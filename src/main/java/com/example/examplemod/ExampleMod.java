package com.example.examplemod;

import com.example.examplemod.client.proxy.ClientProxy;
import com.example.examplemod.core.CommonProxy;
import com.example.examplemod.server.proxy.ServerProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "example", version = "0.1", acceptableRemoteVersions = "*")
public class ExampleMod
{
	@Instance("example")
	public static ExampleMod instance;

	public static final String MODID = "example";

	public static final String VERSION = "0.1";
	
	@SidedProxy(clientSide = "com.example.examplemod.client.proxy.ClientProxy", serverSide = "com.example.examplemod.server.proxy.ServerProxy")
	public static CommonProxy proxy;

	public static Side side;

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.onInit(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.onPostInit(e);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
	}

	public static ExampleMod getInstance() {
		if (instance == null)
			instance = new ExampleMod();
		return instance;
	}

	public static void setInstance(ExampleMod instance) {
		ExampleMod.instance = instance;
	}

	public static ServerProxy getServer() {
		return (ServerProxy) proxy;
	}

	public static ClientProxy getClient() {
		return (ClientProxy) proxy;
	}
}
