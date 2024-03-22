package com.example.examplemod.client.proxy;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.core.CommonProxy;

public class ClientProxy extends CommonProxy {

	public static ClientProxy instance;

	public void init(ExampleMod mod) {
		instance = this;
	}

	public static ClientProxy getInstance() {
		return instance;
	}

	public static void setInstance(ClientProxy instance) {
		ClientProxy.instance = instance;
	}
}
