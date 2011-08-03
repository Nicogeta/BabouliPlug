package com.Nicogeta.BabouliPlug;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.material.Door;
import org.bukkit.material.Wool;

public class BabouliPlugEntityListener extends EntityListener{
	final BabouliPlug plugin;

	public BabouliPlugEntityListener(BabouliPlug instance) {
		plugin = instance;
	}

	public void onEntityDeath(EntityDeathEvent event) {
		int entityWhoDiedId = event.getEntity().getEntityId();
		if(plugin.bossId == entityWhoDiedId) {
			final World theWorld = plugin.world;
			String pName = plugin.player.getName();

			plugin.treasureEntryDoorBlockTop = plugin.world.getBlockAt(new Location(plugin.world, 14, 102, 412));
			plugin.treasureEntryDoorBlockDown = plugin.world.getBlockAt(new Location(plugin.world, 14, 101, 412));

			System.out.println("INFO: boss died, it works !");
			plugin.player.sendMessage(ChatColor.RED +"INFO: " + ChatColor.GREEN + "GG " + pName + " !");
			plugin.woolBlock.setType(Material.WOOL);
			Wool woolData = (Wool)plugin.woolBlock.getState().getData();
			woolData.setColor(DyeColor.BLACK);
			plugin.woolBlock.setData(woolData.getData());
			plugin.tpState = true;

			plugin.treasureEntryDoorDataTop = (Door)plugin.treasureEntryDoorBlockTop.getState().getData();
			plugin.treasureEntryDoorDataDown = (Door)plugin.treasureEntryDoorBlockDown.getState().getData();
			plugin.treasureEntryDoorDataTop.setOpen(true);
			plugin.treasureEntryDoorDataDown.setOpen(true);
			plugin.treasureEntryDoorBlockTop.setData(plugin.treasureEntryDoorDataTop.getData());
			plugin.treasureEntryDoorBlockDown.setData(plugin.treasureEntryDoorDataDown.getData());

			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
				public void run() {
					extinguishMethod(theWorld);
				}
			}, 100);		
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
