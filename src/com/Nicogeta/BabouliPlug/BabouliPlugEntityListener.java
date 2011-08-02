package com.Nicogeta.BabouliPlug;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
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
			System.out.println("INFO: boss died, it works !");
			plugin.player.sendMessage(ChatColor.RED +"INFO: " + ChatColor.GREEN + "GG " + pName + " !");
			extinguishMethod(theWorld);
		}
	}

	public void extinguishMethod(World theWorld) {
		int x = 32;
		int y = 111;
		int z = 394;

		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 39; j++) {
				for(int k = 0; k < 48; k++) {
					Block blockToCheck = theWorld.getBlockAt(x -  k, y - i, z + j);
					if(blockToCheck.getType() == Material.FIRE) {
						blockToCheck.setType(Material.AIR);
					}
				}
			}
		}
	}
}
