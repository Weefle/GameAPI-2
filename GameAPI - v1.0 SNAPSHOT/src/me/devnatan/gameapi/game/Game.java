package me.devnatan.gameapi.game;

import me.devnatan.gameapi.bomb.Bomb;
import me.devnatan.gameapi.room.Room;

public class Game extends Room {

	private Bomb bomb;
	
	public static String _PLANTER = "Terrorists";
	public static String _DEFUSER = "Police";
	
	public Game() {
		this.bomb = new Bomb();
		bomb.setGame(this);
	}
	
	public Bomb getBomb() {
		return bomb;
	}
	
	public void setBomb(Bomb bomb) {
		this.bomb = bomb;
	}
	
	@Override
	public Room.State getState() {
		return Room.State.RUNNING;
	}
	
}
