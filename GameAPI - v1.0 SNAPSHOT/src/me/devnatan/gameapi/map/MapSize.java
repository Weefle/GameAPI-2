package me.devnatan.gameapi.map;

public enum MapSize {
	
	VERY_SMALL("very_small", 0, 0, 30), SMALL("small", 1, 30, 50), MEDIUM("medium", 2, 50, 70), BIG("big", 3, 70, 100), VERY_BIG("very_big", 4, 100, -1), INCALCULABLE("incalculable", 5, -1, -1);
	
	private final String name;
	private final int size;
	private final int minimum;
	private final int maximum;
	
	private MapSize(String name, int size, int minimum, int maximum) {
		this.name = name;
		this.size = size;
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getMinimum() {
		return minimum;
	}
	
	public int getMaximum() {
		return maximum;
	}

	public static MapSize getByName(String name) {
		for(MapSize ms : values()) {
			if(ms.getName().equals(name)) return ms;
		} return null;
	}
	
	public static MapSize getByMinMax(int minimum, int maximum) {
		for(MapSize ms : values()) {
			if(ms.getMinimum() == minimum && ms.getMaximum() == maximum) return ms;
		} return null;
	}
	
}
