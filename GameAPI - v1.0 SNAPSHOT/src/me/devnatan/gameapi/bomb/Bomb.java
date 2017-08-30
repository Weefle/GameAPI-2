package me.devnatan.gameapi.bomb;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import me.devnatan.gameapi.game.Game;
import me.devnatan.gameapi.player.Player;

public class Bomb {

	private Game game;
	private Location location;
	private BombToucher toucher;
	private BombState state;
	private Player current;
	private final BombTimer timer = new BombTimer(this);
	private final List<ItemStack> blocks = Arrays.asList(new ItemStack(Material.WOOL, 1, (short) 14));
	
	private static Sound _SOUND = Sound.ENDERDRAGON_HIT;
	private static int _TIME = 30;
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public BombToucher getToucher() {
		return toucher;
	}
	
	public void setToucher(BombToucher toucher) {
		this.toucher = toucher;
	}
	
	public BombState getState() {
		return state;
	}
	
	public void setState(BombState state) {
		this.state = state;
	}
	
	public Player getCurrent() {
		return current;
	}
	
	public void setCurrent(Player current) {
		this.current = current;
	}
	
	public BombTimer getTimer() {
		return timer;
	}
	
	public List<ItemStack> getBlocks() {
		return blocks;
	}
	
	public static Sound getDefaultSound() {
		return _SOUND;
	}
	
	public static int getDefaultExplodeTime() {
		return _TIME;
	}
	
	public static void setDefaultSound(Sound sound) {
		_SOUND = sound;
	}
	
	public static void setDefaultExplodeTime(int explodeTime) {
		_TIME = explodeTime;
	}

}
