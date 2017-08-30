package me.devnatan.gameapi.events;

import me.devnatan.gameapi.bomb.Bomb;

public class BombHeartBeatEvent extends BombEvent {
	
	private int remain;
	
	public BombHeartBeatEvent(Bomb bomb, int remain) {
		super(bomb);
		this.remain = remain;
	}

	public int getRemain() {
		return remain;
	}

}
