package me.devnatan.gameapi.game;

import java.util.Random;

import org.apache.commons.lang.Validate;
import org.bukkit.Location;

import com.google.common.collect.Lists;

import me.devnatan.gameapi.bomb.Bomb;
import me.devnatan.gameapi.bomb.BombState;
import me.devnatan.gameapi.map.Map;
import me.devnatan.gameapi.map.MapSize;
import me.devnatan.gameapi.moderation.Moderator;
import me.devnatan.gameapi.player.Player;
import me.devnatan.gameapi.room.Room;
import me.devnatan.gameapi.room.Room.State;
import me.devnatan.gameapi.utils.Cuboid;

/**
 * Game handling class for easy implementation.
 * 
 * @version = 1.0
 * @author DevNatan
 * @since 27/08/2017 20:16
 *
 */
public class GameUtils {
	
	//
	//
	// <----------------- ROOMS ----------------->
	// Utilities facilitated for rooms management.
	//
	//

	/**
	 * Make it easy to create a game room.
	 * @param arg0 = room's name
	 * @param arg1 = room's length
	 * @return Room
	 */
	public static Room makeRoom(String arg0, int arg1) {
		Validate.notNull(arg0, "Room's name cannot be null!");
		if(arg1 < 2) throw new IllegalArgumentException("Room's length cannot be < 2!");
	
		Room r = new Room();
		
		r.setId(Room.nextId());
		r.setName(arg0);
		r.setLength(arg1);
		r.setState(State.LOBBY);
		r.getTeams().put(GameTeam.PLANTER, Lists.newArrayList());
		r.getTeams().put(GameTeam.DEFUSER, Lists.newArrayList());
		
		return r;
	}
	
	/**
	 * Make it easy to create a game room.
	 * @param arg0 = room's name
	 * @param arg1 = room's length
	 * @param arg2 = room's map
	 * @return
	 */
	public static Room makeRoom(String arg0, int arg1, Map arg2) {
		Validate.notNull(arg0, "Room's name cannot be null!");
		if(arg1 < 2) throw new IllegalArgumentException("Room's length cannot be < 2!");
		Validate.notNull(arg2, "Map cannot be null!");
		
		Room r = new Room();
		
		r.setId(Room.nextId());
		r.setName(arg0);
		r.setLength(arg1);
		r.setMap(arg2);
		r.setState(State.LOBBY);
		r.getTeams().put(GameTeam.PLANTER, Lists.newArrayList());
		r.getTeams().put(GameTeam.DEFUSER, Lists.newArrayList());
		
		return r;
	}
	
	/**
	 * Make it easy to create a game room.
	 * @param arg0 = room's name
	 * @param arg1 = room's length
	 * @param arg2 = room's moderator
	 * @return
	 */
	public static Room makeRoom(String arg0, int arg1, Moderator arg2) {
		Validate.notNull(arg0, "Room's name cannot be null!");
		if(arg1 < 2) throw new IllegalArgumentException("Room's length cannot be < 2!");
		Validate.notNull(arg2, "Moderator cannot be null!");
		
		Room r = new Room();
		
		r.setId(Room.nextId());
		r.setName(arg0);
		r.setLength(arg1);
		r.setModerator(arg2);
		r.setState(State.LOBBY);
		r.getTeams().put(GameTeam.PLANTER, Lists.newArrayList());
		r.getTeams().put(GameTeam.DEFUSER, Lists.newArrayList());
		
		return r;
	}
	
	/**
	 * Make it easy to create a game room.
	 * @param arg0 = room's name
	 * @param arg1 = room's length
	 * @param arg2 = room's map
	 * @param arg3 = room's moderator
	 * @return
	 */
	public static Room makeRoom(String arg0, int arg1, Map arg2, Moderator arg3) {
		Validate.notNull(arg0, "Room's name cannot be null!");
		if(arg1 < 2) throw new IllegalArgumentException("Room's length cannot be < 2!");
		Validate.notNull(arg2, "Map cannot be null!");
		Validate.notNull(arg3, "Moderator cannot be null!");
		
		Room r = new Room();
		
		r.setId(Room.nextId());
		r.setName(arg0);
		r.setLength(arg1);
		r.setMap(arg2);
		r.setModerator(arg3);
		r.setState(State.LOBBY);
		r.getTeams().put(GameTeam.PLANTER, Lists.newArrayList());
		r.getTeams().put(GameTeam.DEFUSER, Lists.newArrayList());
		
		return r;
	}
	
	/**
	 * Check has enough space to join in the room.
	 * @param arg0 = the room.
	 * @return true | false
	 */
	public static boolean hasSpace(Room arg0) {
		Validate.notNull(arg0, "Room cannot be null!");
		return arg0.getLength() != arg0.getPlayers().size();
	}
	
	/**
	 * Check has enough space to join in the room.
	 * @param arg0 = the room.
	 * @return true | false
	 */
	public static boolean hasSpace(Room arg0, int arg1) {
		Validate.notNull(arg0, "Room cannot be null!");
		return arg0.getLength() != (arg0.getPlayers().size() - arg1);
	}
	
	/**
	 * Automatically select the room team, according to their quantity.
	 * @param arg0 = the room.
	 * @return GameTeam
	 */
	public static GameTeam autoSwitchTeam(Room arg0) {
		Validate.notNull(arg0, "Room cannot be null!");
		
		int ps = arg0.getTeams().get(GameTeam.PLANTER).size();
		int ds = arg0.getTeams().get(GameTeam.DEFUSER).size();
		
		if(ps == ds) return GameTeam.values()[new Random().nextInt(GameTeam.values().length)];
		return (ps > ds ? GameTeam.DEFUSER : GameTeam.PLANTER);
	}
	
	//
	//
	// <----------------- MAPS ----------------->
	// Utilities facilitated for mapss.
	//
	//
	
	/**
	 * Makes it easy to create a map.
	 * @param arg0 = map's name
	 * @param arg1 = map's description
	 * @return Map
	 */
	public static Map makeMap(String arg0, String arg1) {
		Validate.notNull(arg0, "Map's name cannot be null!");
		Validate.notNull(arg1, "Map's description cannot be null!");
		
		Map map = new Map();
		
		map.setName(arg0);
		map.setDescription(arg1);
		
		return map;
	}
	
	/**
	 * Makes it easy to create a map.
	 * @param arg0 = map's name
	 * @param arg1 = map's description
	 * @param arg2 = map's size
	 * @return Map
	 */
	public static Map makeMap(String arg0, String arg1, MapSize arg2) {
		Validate.notNull(arg0, "Map's name cannot be null!");
		Validate.notNull(arg1, "Map's description cannot be null!");
		Validate.notNull(arg2, "MapSize cannot be null!");
		
		Map map = new Map();
		
		map.setName(arg0);
		map.setDescription(arg1);
		map.setSize(arg2);
		
		return map;
	}
	
	/**
	 * Makes it easy to create a map.
	 * @param arg0 = map's name
	 * @param arg1 = map's description
	 * @param arg2 = map's size
	 * @param arg3 = map's cube
	 * @return Map
	 */
	public static Map makeMap(String arg0, String arg1, MapSize arg2, Cuboid arg3) {
		Validate.notNull(arg0, "Map's name cannot be null!");
		Validate.notNull(arg1, "Map's description cannot be null!");
		Validate.notNull(arg2, "MapSize cannot be null!");
		Validate.notNull(arg3, "Cuboid cannot be null!");
		
		Map map = new Map();
		
		map.setName(arg0);
		map.setDescription(arg1);
		map.setSize(arg2);
		map.setCuboid(arg3);
		
		return map;
	}
	
	/**
	 * Makes it easy to create a map.
	 * Map size is calculated automatically from the {@code GameUtils#calculate(Cuboid)} method, using the cube size.
	 * @param arg0 = map's name
	 * @param arg1 = map's description
	 * @param arg2 = map's cube
	 * @return Map
	 */
	public static Map makeMap(String arg0, String arg1, Cuboid arg2) {
		Validate.notNull(arg0, "Map's name cannot be null!");
		Validate.notNull(arg1, "Map's description cannot be null!");
		Validate.notNull(arg2, "Cuboid cannot be null!");
		
		Map map = new Map();
		
		map.setName(arg0);
		map.setDescription(arg1);
		map.setCuboid(arg2);
		map.setSize(calculate(arg2.getLowerLocation(), arg2.getUpperLocation()));
		
		return map;
	}
	
	/**
	 * Calculate the size of the map using the locations of a cube.
	 * @param cuboid = the cube
	 * @return MapSize
	 */
	public static MapSize calculate(Cuboid cuboid) {
		Validate.notNull(cuboid, "Cuboid cannot be null!");
		Validate.notNull(cuboid.getLowerLocation(), "Cuboid's lower location cannot be null!");
		Validate.notNull(cuboid.getUpperLocation(), "Cuboid's upper location cannot be null!");
		
		return calculate(cuboid.getLowerLocation(), cuboid.getUpperLocation());
	}
	
	/**
	 * Calculate the size of the map from one location to another.
	 * @param arg0 = lower location
	 * @param arg1 = upper location
	 * @return MapSize
	 */
	public static MapSize calculate(Location arg0, Location arg1) {
		Validate.notNull(arg0, "Lower location cannot be null!");
		Validate.notNull(arg1, "Upper location cannot be null!");
		
		double d = arg0.distanceSquared(arg1);
		
		if(d <= 30)
			return MapSize.VERY_SMALL;
		else if(d > 30 && d <= 50)
			return MapSize.SMALL;
		else if(d > 50 && d <= 70)
			return MapSize.MEDIUM;
		else if(d > 70 && d <= 100)
			return MapSize.BIG;
		else if(d > 100)
			return MapSize.VERY_BIG;
		
		return MapSize.INCALCULABLE;
	}
	
	//
	//
	// <----------------- BOMBS ----------------->
	// Utilities facilitated for bombs.
	//
	//
	
	/**
	 * Plant a bomb and start your timer.
	 * Note: the {@code BombPlantEvent} event not fire using this method.
	 * @param bomb = the bomb
	 */
	public static void plant(Bomb bomb) {
		Validate.notNull(bomb, "Bomb cannot be null!");
		Validate.notNull(bomb.getGame(), "Bomb cannot be null!");
		
		bomb.setState(BombState.PLANTED);
		bomb.getTimer().setElapsed(0);
		bomb.getTimer().start();
	}
	
	/**
	 * Plant the bomb a game and start your timer.
	 * Note: the {@code BombPlantEvent} event not fire using this method.
	 * @param game = the game
	 */
	public static void plant(Game game) {
		Validate.notNull(game, "Game cannot be null!");
		Validate.notNull(game.getBomb(), "Bomb cannot be null!");
		Validate.notNull(game.getBomb().getLocation(), "Bomb Location cannot be null!");
		
		game.getBomb().setState(BombState.PLANTED);
		game.getBomb().getTimer().setElapsed(0);
		game.getBomb().getTimer().start();
	}
	
	/**
	 * Defines the location of the bomb, plant this bomb at the set location of a game, and start its timer.
	 * Note: the {@code BombPlantEvent} event not fire using this method.
	 * @param game = the game
	 * @param location = the location
	 */
	public static void plantAt(Game game, Location location) {
		Validate.notNull(game, "Game cannot be null!");
		Validate.notNull(location, "Location cannot be null!");
		
		game.getBomb().setState(BombState.PLANTED);
		game.getBomb().setLocation(location);
		game.getBomb().getTimer().setElapsed(0);
		game.getBomb().getTimer().start();
	}

	
	/**
	 * Defines the location of the bomb, defines the time of destruction, plant this bomb at the set location of a game, and starts its timer.
	 * Note: the {@code BombPlantEvent} event not fire using this method.
	 * @param game = the game
	 * @param location = the location
	 * @param time = the time to explode
	 */
	public static void plantAt(Game game, Location location, int time) {
		Validate.notNull(game, "Game cannot be null!");
		Validate.notNull(location, "Location cannot be null!");
		if(time < 0) throw new NumberFormatException("Time cannot be negative!");
		
		game.getBomb().setLocation(location);
		game.getBomb().setState(BombState.PLANTED);
		game.getBomb().getTimer().setElapsed(0);
		game.getBomb().getTimer().setTime(time);
		game.getBomb().getTimer().start();
	}
	
	/**
	 * Defuse the bomb and define the system as an undefined player.
	 * Note: the {@code BombDefuseEvent} event not fire using this method.
	 * @param bomb = the bomb
	 */
	public static void defuse(Bomb bomb) {
		Validate.notNull(bomb, "Bomb cannot be null!");
		Validate.notNull(bomb.getGame(), "Game cannot be null!");
		
		bomb.setState(BombState.DEFUSED);
		bomb.getTimer().stop();
	}
	
	/**
	 * Defuse a game's bomb and define player as defuser.
	 * Note: the {@code BombDefuseEvent} event not fire using this method.
	 * @param bomb = the bomb
	 * @param defuser = the player
	 */
	public static void defuse(Bomb bomb, Player defuser) {
		Validate.notNull(bomb, "Bomb cannot be null!");
		Validate.notNull(bomb.getGame(), "Game cannot be null!");
		Validate.notNull(defuser, "Defuser cannot be null!");
		
		bomb.setCurrent(defuser);
		bomb.setState(BombState.DEFUSED);
		bomb.getTimer().stop();
	}
	
	/**
	 * Defuse a game's bomb and define the system as an undefined player.
	 * Note: the {@code BombDefuseEvent} event not fire using this method.
	 * @param game = the game
	 */
	public static void defuseBomb(Game game) {
		Validate.notNull(game, "Game cannot be null!");
		Validate.notNull(game.getBomb(), "Bomb cannot be null!");
		
		game.getBomb().setState(BombState.DEFUSED);
		game.getBomb().getTimer().stop();
	}
	
	/**
	 * Defuse a game's bomb and define the player as defuser.
	 * Note: the {@code BombDefuseEvent} event not fire using this method.
	 * @param game = the game
	 * @param defuser = the player
	 */
	public static void defuseBomb(Game game, Player defuser) {
		Validate.notNull(game, "Game cannot be null!");
		Validate.notNull(game.getBomb(), "Bomb cannot be null!");
		Validate.notNull(defuser, "Defuser cannot be null!");
		
		game.getBomb().setCurrent(defuser);
		game.getBomb().setState(BombState.DEFUSED);
		game.getBomb().getTimer().stop();
	}
	
	//
	//
	// <----------------- Players ----------------->
	// Utilities facilitated for handling the class "tk.nyeyes.projetos.nysed.game.player.Player"
	//
	//
	
	/**
	 * Forcing the player to enter a match, security requirements are required.
	 * @param arg0 = the player
	 * @param arg1 = the room
	 * @return true = Requirements met.  |  false = Unmet requirements.
	 */
	public static boolean joinPlayer(Player arg0, Room arg1) {
		Validate.notNull(arg0, "Player cannot be null!");
		Validate.notNull(arg1, "Room cannot be null!");
		
		if(arg0.isPlaying()) return false;
		if(arg1.getPlayers().contains(arg0)) return false;
		
		arg1.getPlayers().add(arg0);
		arg1.getTeams().get(GameUtils.autoSwitchTeam(arg1)).add(arg0);
		arg1.setLength(arg1.getLength() + 1);
		
		return true;
	}
	
	/**
	 * Forcing the player to enter a match, security requirements are required.
	 * @param arg0 = the player
	 * @param arg1 = the room
	 * @param arg2 = the team
	 * @return true = Requirements met.  |  false = Unmet requirements.
	 */
	public static boolean joinPlayer(Player arg0, Room arg1, GameTeam arg2) {
		Validate.notNull(arg0, "Player cannot be null!");
		Validate.notNull(arg1, "Room cannot be null!");
		Validate.notNull(arg2, "GameTeam cannot be null!");
		
		if(arg0.isPlaying()) return false;
		if(arg1.getPlayers().contains(arg0)) return false;
		
		arg1.getPlayers().add(arg0);
		arg1.getTeams().get(arg2).add(arg0);
		
		return true;
	}
	
}
