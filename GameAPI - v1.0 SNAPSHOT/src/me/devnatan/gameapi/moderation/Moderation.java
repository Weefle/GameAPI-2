package me.devnatan.gameapi.moderation;

public interface Moderation {
	
	/**
	 * If has permission to vote to kick a player.
	 * @return
	 */
	public boolean kick();
	
	/**
	 * If has permission to kick a player without voting.
	 * @return
	 */
	public boolean instantKick();
	
	/**
	 * If has permisison to set the room map.
	 * @return
	 */
	public boolean setMap();
	
	/**
	 * If has permisison to change the room map as random.
	 * @return
	 */
	public boolean setRandomMap();
	
	/**
	 * If has permission to change the name of the room.
	 * @return
	 */
	public boolean setName();
	
	/**
	 * If has permission to change the room moderator.
	 * @return
	 */
	public boolean setModerator();
	
	/**
	 * If has permission to change the room length.
	 * @return
	 */
	public boolean setLength();

}
