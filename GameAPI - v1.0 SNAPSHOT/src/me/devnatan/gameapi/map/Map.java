package me.devnatan.gameapi.map;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import me.devnatan.gameapi.GameAPI;
import me.devnatan.gameapi.bomb.BombToucher;
import me.devnatan.gameapi.utils.Cuboid;

public class Map implements ConfigurationSerializable {

	private String name;
	private String description;
	private MapSize size;
	private final java.util.Map<BombToucher, Location> spawnPoints =
			new HashMap<BombToucher, Location>();
	private Cuboid cuboid;
	
	public Map() { }
	
	public Map(String name) {
		this.name = name;
	}
	
	public Map(String name, MapSize size) {
		this.name = name;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public MapSize getSize() {
		return size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(MapSize size) {
		this.size = size;
	}
	
	public java.util.Map<BombToucher, Location> getSpawnPoints() {
		return spawnPoints;
	}
	
	public Cuboid getCuboid() {
		return cuboid;
	}
	
	public void setCuboid(Cuboid cuboid) {
		this.cuboid = cuboid;
	}

	@Override
	public java.util.Map<String, Object> serialize() {
		java.util.Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", name);
		map.put("description", description);
		map.put("size", size);
		map.put("spawnPoints", GameAPI._GSON.toJson(spawnPoints, GameAPI._GSON.getType(spawnPoints)));
		map.put("cuboid", cuboid.serialize());
		
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public static Map deserialize(java.util.Map<String, Object> map) {
		Map m = new Map();
		
		m.setName((String) map.get("name"));
		m.setDescription((String) map.get("description"));
		m.setSize(MapSize.getByName((String) map.get("size")));
		
		Type t = GameAPI._GSON.getType(new HashMap<String, Object>());
		java.util.Map<String, Object> ma = GameAPI._GSON.fromJson((String) map.get("spawnPoints"), t);
		
		for(Entry<String, Object> e : ma.entrySet()) {
			m.getSpawnPoints().put(BombToucher.valueOf(e.getKey()), (Location) e.getValue());
		}
		
		m.setCuboid(Cuboid.deserialize((java.util.Map<String, Object>) map.get("cuboid")));
		
		return m;
	}
	
	@Override
	public String toString() {
		return "Map " + serialize();
	}

}
