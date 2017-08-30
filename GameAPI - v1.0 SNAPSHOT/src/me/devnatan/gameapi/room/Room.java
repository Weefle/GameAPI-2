package me.devnatan.gameapi.room;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import me.devnatan.gameapi.game.GameTeam;
import me.devnatan.gameapi.map.Map;
import me.devnatan.gameapi.moderation.Moderator;
import me.devnatan.gameapi.player.Player;

public class Room {
	
	public enum State {
		
		LOBBY, RUNNING
		
	}
	
	private int id;
	private String name;
	private Map map;
	private Room.State state;
	private final Set<Player> players = new HashSet<Player>();
	private final java.util.Map<GameTeam, List<Player>> teams = new HashMap<GameTeam, List<Player>>();
	private int length;
	private Moderator moderator;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Map getMap() {
		return map;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public Room.State getState() {
		return state;
	}
	
	public void setState(Room.State state) {
		this.state = state;
	}
	
	public Set<Player> getPlayers() {
		return players;
	}
	
	public Set<Player> getPlayersInGame() {
		Set<Player> players = new HashSet<Player>();
		
		for(Player player : this.players)
			if(player.isPlaying()) players.add(player);
		
		return players;
	}
	
	public Set<Player> getPlayersOutGame() {
		Set<Player> players = new HashSet<Player>();
		
		for(Player player : this.players)
			if(!player.isPlaying()) players.add(player);
		
		return players;
	}
	
	public String getPlayersInGameNames(boolean c) {
		Set<String> set = new HashSet<String>();
		for(Player player : getPlayersInGame()) {
			String name = ChatColor.translateAlternateColorCodes('&', Bukkit.getPlayer(player.getUuid()).getName());
			
			if(c == true) {
				if(player instanceof Moderator)
					set.add("§a(" + ((Moderator) player).getPrefix() + ") §7" + name);
				else
					set.add("§7" + name);
			} else {
				if(player instanceof Moderator)
					set.add("(" + ((Moderator) player).getPrefix() + ") " + name);
				else
					set.add(name);
			}
		}
		
		return Arrays.toString(set.toArray()).replace("]", "").replace("[", "");
	}
	
	public String getPlayersOutGameNames(boolean c) {
		Set<String> set = new HashSet<String>();
		for(Player player : getPlayersOutGame()) {
			String name = ChatColor.translateAlternateColorCodes('&', Bukkit.getPlayer(player.getUuid()).getName());
			
			if(c == true) {
				if(player instanceof Moderator)
					set.add("§a(" + ((Moderator) player).getPrefix() + ") §7" + name);
				else
					set.add("§7" + name);
			} else {
				if(player instanceof Moderator)
					set.add("(" + ((Moderator) player).getPrefix() + ") " + name);
				else
					set.add(name);
			}
		}
		
		return Arrays.toString(set.toArray()).replace("]", "").replace("[", "");
	}
	
	public java.util.Map<GameTeam, List<Player>> getTeams() {
		return teams;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public Moderator getModerator() {
		return moderator;
	}
	
	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}
	
	public static int defaultLength() {
		return 16;
	}
	
	public static int nextId() {
		return new RoomManager().getRooms().size() + 1;
	}
	
	public static String randomName() {
		String[] names = new String[] {
				"You are ready?",
				"Bullets, Grenades and Bombs!"
		};
		
		return names[new Random().nextInt(names.length)];
	}

}
