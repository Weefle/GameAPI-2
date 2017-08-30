package me.devnatan.gameapi.gson;

import java.lang.reflect.Type;

public interface Gson {
	
	/**
	 * Return the {@link java.lang.reflect.Type} object type.
	 * @param param = an object
	 * @return Type
	 */
	public <T> Type getType(T param);
	
	/**
	 * Get the version of you are using.
	 * @return gson version.
	 */
	public String getVersion();
	
	/**
	 * Serialize that object as json string.
	 * @param param = an object
	 * @return serialized json string
	 */
	public String toJson(Object param);
	
	
	/**
	 * Serialize that object as json string, according your type.
	 * @param paramA = an object
	 * @param paramB = object type
	 * @return serialized json string
	 */
	public String toJson(Object paramA, Type paramB);
	
	/**
	 * Returns a object type from the json string.
	 * @param paramA = an object
	 * @param paramB = object type
	 * @return Object
	 */
	public <T> T fromJson(String paramA, Type paramB);

	
	/**
	 * Get the gson availables versions.
	 * @return available versions.
	 */
	public static String versions() {
		StringBuilder stringBuilder = new StringBuilder();
		String[] versions = new String[] { 
				"1.8_R1",
				"1.8_R3" };
		
		for(int i = 0; i < versions.length; i++) {
			if(versions.length > 1 && i == versions.length - 1) {
				stringBuilder.append(versions[i]);
			} else if(i < versions.length) {
				stringBuilder.append(versions[i]).append(", ");
			}
		}
		
		return stringBuilder.toString().trim();
	}
	
}
