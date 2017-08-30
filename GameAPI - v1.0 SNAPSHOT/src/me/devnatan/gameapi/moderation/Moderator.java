package me.devnatan.gameapi.moderation;

import java.util.UUID;

import me.devnatan.gameapi.player.Player;

public abstract class Moderator extends Player implements Moderation {

	public Moderator(UUID uuid) {
		super(uuid);
	}

	public abstract String getPrefix();

}