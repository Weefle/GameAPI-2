package me.devnatan.gameapi.gson;

import java.lang.reflect.Type;

import org.bukkit.craftbukkit.libs.com.google.gson.GsonBuilder;
import org.bukkit.craftbukkit.libs.com.google.gson.reflect.TypeToken;

public class Gson_1_8_R1 implements Gson {
	
	@Override
	public <T> Type getType(T param) {
		return new TypeToken<T>() { }.getType();
	}
	
	@Override
	public String getVersion() {
		return "Gson 1.8_R1";
	}
	
	@Override
	public String toJson(Object param) {
		return getGson().toJson(param);
	}

	@Override
	public String toJson(Object paramA, Type paramB) {
		return getGson().toJson(paramA, paramB);
	}

	@Override
	public <T> T fromJson(String paramA, Type paramB) {
		return getGson().fromJson(paramA, paramB);
	}
	
	private org.bukkit.craftbukkit.libs.com.google.gson.Gson getGson() {
		GsonBuilder a = new GsonBuilder();
		org.bukkit.craftbukkit.libs.com.google.gson.Gson b = a.create();
		
		return b;
	}

}