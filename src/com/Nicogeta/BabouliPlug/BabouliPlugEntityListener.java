package com.Nicogeta.BabouliPlug;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;

public class BabouliPlugEntityListener extends EntityListener{
	final BabouliPlug plugin;

	public BabouliPlugEntityListener(BabouliPlug instance) {
		plugin = instance;
	}

	public void onEntityDeath(EntityDeathEvent event) {
		int entityWhoDiedId = event.getEntity().getEntityId();
		World theWorld = plugin.world;
		String pName = plugin.player.getName();
		if(plugin.bossId == entityWhoDiedId) {
			plugin.player.sendMessage(ChatColor.RED +"INFO: " + ChatColor.GREEN + "GG " + pName + " !");
			extenguishMethod(theWorld);
		}
	}

	public void extenguishMethod(World theWorld) {
		Material blockToCheck;
		int x = 31;
		int y = 111;
		int z = 394;

		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 39; j++) {
				for(int k = 0; k < 47; k++) {
					blockToCheck = theWorld.getBlockAt(x -  k, y, z).getType();
					if(blockToCheck == Material.AIR) {
						theWorld.getBlockAt(x - k, y, z).setType(Material.WOOL);
					}
				}
			}
		}
	}
}
