package me.devnatan.gameapi;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.devnatan.gameapi.gson.Gson;
import me.devnatan.gameapi.gson.Gson_1_8_R1;
import me.devnatan.gameapi.gson.Gson_1_8_R3;

public final class GameAPI extends JavaPlugin {

	public static Gson _GSON;
	
	public void onLoad() {
		if(!hasGson()) {
			getLogger().severe("Google Gson is not supported on this version!");
			getLogger().severe("Versions availables: " + Gson.versions());
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
	}
	
	public void onEnable() {
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				if(GamePlugin.getPlugins().size() > 0)
					getLogger().info("Plugins registered: " + Arrays.toString(GamePlugin.getPlugins().toArray()).toString().replace("]", "").replace("[", ""));
			}
		});
	}
	
	private boolean hasGson() {
		String version = null;

        try {
            version = Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3];
        } catch (ArrayIndexOutOfBoundsException e) {
        	e.printStackTrace();
        }

        if(version.equals("v1_8_R1")) {
            _GSON = new Gson_1_8_R1();
        } else if(version.equals("v1_8_R3")) {
        	_GSON = new Gson_1_8_R3();
        }
        
        return (_GSON != null ? true : false);
	}
	
	
}
