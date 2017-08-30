package me.devnatan.gameapi.player;

import java.util.UUID;

import me.devnatan.gameapi.game.Game;

public class Player implements PlayerInfo {
	
	private final UUID uuid;
	private Game game;
	private boolean playing;
	private int kills;
	private int deaths;
	private int assists;
	private int bombsPlanted;
	private int bombsDefused;
	
	public Player(UUID uuid) {
		this.uuid = uuid;
		this.playing = false;
		this.kills = 0;
		this.deaths = 0;
		this.assists = 0;
		this.bombsPlanted = 0;
		this.bombsDefused = 0;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public boolean isPlaying() {
		return playing;
	}
	
	@Override
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	@Override
	public int getKills() {
		return kills;
	}

	@Override
	public void setKills(int kills) {
		this.kills = kills;
	}

	@Override
	public int getDeaths() {
		return deaths;
	}

	@Override
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	@Override
	public int getAssists() {
		return assists;
	}

	@Override
	public void setAssists(int assists) {
		this.assists = assists;
	}

	@Override
	public int getBombsPlanted() {
		return bombsPlanted;
	}

	@Override
	public void setBombsPlanted(int bombsPlanted) {
		this.bombsPlanted = bombsPlanted;
	}

	@Override
	public int getBombsDefused() {
		return this.bombsDefused;
	}

	@Override
	public void setBombsDefused(int bombsDefused) {
		this.bombsDefused = bombsDefused;
	}
	
}
