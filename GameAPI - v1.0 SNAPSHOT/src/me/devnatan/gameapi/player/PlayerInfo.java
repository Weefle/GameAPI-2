package me.devnatan.gameapi.player;

import java.util.HashMap;
import java.util.Map;

import me.devnatan.gameapi.GameAPI;

public interface PlayerInfo {
	
	/**
	 * If is in game or not.
	 * @return boolean
	 */
	public boolean isPlaying();
	
	/**
	 * Set to is playing.
	 * @param is playing
	 */
	public void setPlaying(boolean playing);

	/**
	 * Get total amount of kills.
	 * @return int
	 */
	public int getKills();
	
	/**
	 * Set the total amount of kills.
	 * @param paramKills = amount of kills
	 */
	public void setKills(int paramKills);
	
	/**
	 * Get total amount of deaths.
	 * @return int
	 */
	public int getDeaths();	
	
	/**
	 * Set the total amount of deaths.
	 * @param paramDeaths = amount of deaths
	 */
	public void setDeaths(int paramDeaths);
	
	/**
	 * Get total amount of assistances.
	 * @return int
	 */
	public int getAssists();
	
	/**
	 * Set the total amount of assistances.
	 * @param paramAssists = amount of assistances
	 */
	public void setAssists(int paramAssists);
	
	/**
	 * Get total amount of bombs planted.
	 * @return int
	 */
	public int getBombsPlanted();
	
	/**
	 * Set the total amount of bombs planted.
	 * @param paramBombsPlanted = amount of bombs planted
	 */
	public void setBombsPlanted(int paramBombsPlanted);
	
	/**
	 * Get total amount of bombs defused.
	 * @return int
	 */
	public int getBombsDefused();
	
	/**
	 * Set the total amount of bombs defused.
	 * @param paramBombsDefused = amount of bombs defused
	 */
	public void setBombsDefused(int paramBombsDefused);
	
	/**
	 * Get the kills / deaths.
	 * @return double
	 */
	public default double getRatio() {
		return (getKills() + getDeaths()) / 2;
	}
	
	/**
	 * Get the (kills + deaths + assists) and divide all.
	 * @return double
	 */
	public default double getAssistsRatio() {
		return (getKills() + getDeaths() + getAssists()) / 3;
	}
	
	/**
	 * Get the (kills + deaths + assists + bombsPlanted + bombsDefused) and divide all.
	 * @return double
	 */
	public default double getFullRatio() {
		return (getKills() + getDeaths() + getAssists() + getBombsPlanted() + getBombsDefused()) / 5;
	}
	
	/**
	 * Serialize the class content as map, using a HashMap.
	 * @return Serialized HashMap
	 */
	public default Map<String, Object> infoSerialize() {
		Map<String, Object> a = new HashMap<String, Object>();
		
		a.put("playing", isPlaying());
		a.put("bombs_planted", getBombsPlanted());
		a.put("bombs_defused", getBombsDefused());
		a.put("kills", getKills());
		a.put("deaths", getDeaths());
		a.put("ratio", getRatio());
		a.put("assists_ratio", getAssistsRatio());
		a.put("full_ratio", getFullRatio());
		
		return a;
	}
	
	/**
	 * Serialize the class content as json, using Google Gson.
	 * @return JSON String
	 */
	public default String jsonSerialize() {
		return GameAPI._GSON.toJson(infoSerialize(), GameAPI._GSON.getType(new HashMap<String, Object>()));
	}

}
