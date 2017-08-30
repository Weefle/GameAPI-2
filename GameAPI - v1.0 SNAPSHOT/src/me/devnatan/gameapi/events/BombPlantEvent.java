package me.devnatan.gameapi.events;

import me.devnatan.gameapi.bomb.Bomb;
import me.devnatan.gameapi.player.Player;

public class BombPlantEvent extends BombEvent {

	private final Player player;
	
	public BombPlantEvent(Bomb bomb, Player player) {
		super(bomb);
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

}
