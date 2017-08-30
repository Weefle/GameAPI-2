package me.devnatan.gameapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.devnatan.gameapi.bomb.Bomb;

public class BombEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	private final Bomb bomb;
	
	protected BombEvent(Bomb bomb) {
		this.bomb = bomb;
	}
	
	public Bomb getBomb() {
		return bomb;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}

}
