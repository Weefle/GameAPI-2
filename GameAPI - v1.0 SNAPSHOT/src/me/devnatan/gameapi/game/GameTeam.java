package me.devnatan.gameapi.game;

import me.devnatan.gameapi.bomb.BombToucher;

public enum GameTeam {
	
	PLANTER(Game._PLANTER, BombToucher.PLANTER),
	DEFUSER(Game._DEFUSER, BombToucher.DEFUSER);
	
	private final String name;
	private final BombToucher toucher;
	
	private GameTeam(String name, BombToucher toucher) {
		this.name = name;
		this.toucher = toucher;
	}
	
	public String getName() {
		return name;
	}
	
	public BombToucher getToucher() {
		return toucher;
	}
	
	public static GameTeam getByName(String name) {
		for(GameTeam gt : values()) {
			if(gt.getName().equalsIgnoreCase(name)) return gt;
		} return null;
	}
	
	public static GameTeam getByToucher(BombToucher toucher) {
		for(GameTeam gt : values()) {
			if(gt.getToucher().name().equals(toucher.name())) return gt;
		} return null;
	}

}
