package me.devnatan.gameapi.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapManager {

	private final List<Map> maps = new ArrayList<Map>();
	
	public List<Map> getMaps() {
		return maps;
	}
	
	public Map getMap(String name) {
		for(Map m : maps) {
			if(m.getName().equalsIgnoreCase(name)) return m;
		} return null;
	}
	
	public Map random() {
		return maps.get(new Random().nextInt(maps.size()));
	}
	
}
