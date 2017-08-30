package me.devnatan.gameapi.game;

import java.util.HashSet;
import java.util.Set;

public class GameManager {
	
	private static final Set<Game> games = new HashSet<Game>();
	
	public Set<Game> getGames() {
		return games;
	}

}
