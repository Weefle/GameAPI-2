package me.devnatan.gameapi.bomb;

public enum BombToucher {
	
	PLANTER("Planter", "Planting..."), DEFUSER("Defuser", "Defusing...");
	
	private final String name;
	private final String message;
	
	private BombToucher(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
