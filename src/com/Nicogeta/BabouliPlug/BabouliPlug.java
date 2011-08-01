package com.Nicogeta.BabouliPlug;

import java.util.logging.Logger;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BabouliPlug extends JavaPlugin {

	private Logger log = Logger.getLogger("Minecraft");
	private final BabouliPlugPlayerListener playerListener = new BabouliPlugPlayerListener(this);
	private final BabouliPlugEntityListener entityListener = new BabouliPlugEntityListener(this);

	public int bossId;
	public World world;
	public Player player;

	private PluginDescriptionFile info;

	public void onEnable() {
		info = getDescription();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DEATH, entityListener, Priority.Normal, this);
		log.info(info.getName()+ info.getVersion() + " ENABLED (by Nicogeta)");
	}

	public void onDisable() {
		log.info(info.getName() + " DISABLED");
	}



}