package me.devnatan.gameapi;

import org.bukkit.plugin.Plugin;

import me.devnatan.gameapi.game.GameManager;
import me.devnatan.gameapi.map.MapManager;
import me.devnatan.gameapi.room.RoomManager;

public abstract class GamePlugin {
	
	private final String name;
	private final Plugin plugin;
	
	protected MapManager mapManager;
	protected RoomManager roomManager;
	protected GameManager gameManager;
	
	public GamePlugin(String name, Plugin plugin) {
		this.name = name;
		this.plugin = plugin;
		
		this.mapManager = new MapManager();
		this.roomManager = new RoomManager();
		this.gameManager = new GameManager();
	}
	
	public String getName() {
		return name;
	}
	
	public Plugin getPlugin() {
		return plugin;
	}
	
	public abstract MapManager getMapManager();
	
	public abstract RoomManager getRoomManager();
	
	public abstract GameManager getGameManager();

}
