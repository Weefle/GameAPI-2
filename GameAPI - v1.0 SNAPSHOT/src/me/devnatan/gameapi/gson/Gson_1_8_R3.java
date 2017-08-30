package me.devnatan.gameapi.gson;

import java.lang.reflect.Type;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class Gson_1_8_R3 implements me.devnatan.gameapi.gson.Gson {
	
	@Override
	public <T> Type getType(T param) {
		return new TypeToken<T>() { }.getType();
	}
	
	@Override
	public String getVersion() {
		return "Gson 1.8_R3";
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
	
	private Gson getGson() {
		GsonBuilder a = new GsonBuilder();
		Gson b = a.create();
		
		return b;
	}

}