package me.devnatan.gameapi.gson;

import java.lang.reflect.Type;

import net.minecraft.util.com.google.gson.GsonBuilder;
import net.minecraft.util.com.google.gson.reflect.TypeToken;

public class Gson_1_7_R4 implements Gson {
	
	@Override
	public <T> Type getType(T param) {
		return new TypeToken<T>() { }.getType();
	}
	
	@Override
	public String getVersion() {
		return "Gson 1.7_R4";
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
	
	private net.minecraft.util.com.google.gson.Gson getGson() {
		GsonBuilder a = new GsonBuilder();
		net.minecraft.util.com.google.gson.Gson b = a.create();
		
		return b;
	}

}