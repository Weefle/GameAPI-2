package me.devnatan.gameapi.bomb;

import org.bukkit.Bukkit;

import me.devnatan.gameapi.GameAPI;
import me.devnatan.gameapi.events.BombHeartBeatEvent;

public class BombTimer implements Runnable {

	private final Bomb bomb;
	private int elapsed = -1;
	private int time = -1;
	private int taskId = -1;
	
	public BombTimer(Bomb bomb) {
		this.bomb = bomb;
		this.elapsed = 0;
		this.time = Bomb.getDefaultExplodeTime();
	}
	
	public Bomb getBomb() {
		return bomb;
	}
	
	public int getElapsed() {
		return elapsed;
	}
	
	public void setElapsed(int elapsed) {
		this.elapsed = elapsed;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@SuppressWarnings("deprecation")
	public void start() {
		if(taskId == -1) {
			taskId = Bukkit.getScheduler().scheduleAsyncRepeatingTask(GameAPI.getPlugin(GameAPI.class), this, 20L * time, 20L * time);
		}
	}
	
	public void stop() {
		if(taskId != -1) {
			Bukkit.getScheduler().cancelTask(taskId);
			taskId = -1;
		}
		
		elapsed = -1;
		time = -1;
	}
	
	@Override
	public void run() {
		elapsed++;
		Bukkit.getPluginManager().callEvent(new BombHeartBeatEvent(bomb, time - elapsed));
		
		if(elapsed >= time) {
			stop();
		}
	}
	
}
