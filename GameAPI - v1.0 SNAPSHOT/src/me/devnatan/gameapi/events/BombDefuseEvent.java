package me.devnatan.gameapi.events;

import me.devnatan.gameapi.bomb.Bomb;
import me.devnatan.gameapi.player.Player;

public class BombDefuseEvent extends BombEvent {

	private final Player player;
	
	public BombDefuseEvent(Bomb bomb, Player player) {
		super(bomb);
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

}
