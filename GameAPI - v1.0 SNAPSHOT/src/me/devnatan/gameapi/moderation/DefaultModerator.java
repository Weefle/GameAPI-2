package me.devnatan.gameapi.moderation;

import java.util.UUID;

public class DefaultModerator extends Moderator {

	public DefaultModerator(UUID uuid) {
		super(uuid);
	}
	
	@Override
	public String getPrefix() {
		return "M";
	}

	@Override
	public boolean kick() {
		return true;
	}

	@Override
	public boolean instantKick() {
		return false;
	}

	@Override
	public boolean setMap() {
		return true;
	}

	@Override
	public boolean setRandomMap() {
		return true;
	}

	@Override
	public boolean setName() {
		return false;
	}

	@Override
	public boolean setModerator() {
		return true;
	}

	@Override
	public boolean setLength() {
		return false;
	}

}
