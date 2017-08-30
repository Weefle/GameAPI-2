package me.devnatan.gameapi.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.devnatan.gameapi.game.GameUtils;

public class MapManager {

	private static final List<Map> maps = new ArrayList<Map>();
	
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
	
	public static final void load() {
		maps.add(GameUtils.makeMap("Viuva Negra", "Um mapa ai do crossfire", MapSize.BIG));
	}
	
}
