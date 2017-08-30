package me.devnatan.gameapi;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.plugin.Plugin;

import me.devnatan.gameapi.game.GameManager;
import me.devnatan.gameapi.map.MapManager;
import me.devnatan.gameapi.room.RoomManager;

public abstract class GamePlugin {
	
	private static final Set<GamePlugin> plugins =
			new HashSet<GamePlugin>();
	
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

	public void register() {
		GamePlugin.register(this);
	}
	
	public static void register(GamePlugin gamePlugin) {
		plugins.add(gamePlugin);
	}
	
	public static Set<GamePlugin> getPlugins() {
		return plugins;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public abstract MapManager getMapManager();
	
	public abstract RoomManager getRoomManager();
	
	public abstract GameManager getGameManager();
	
}
