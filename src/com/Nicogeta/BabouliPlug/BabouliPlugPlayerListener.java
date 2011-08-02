package com.Nicogeta.BabouliPlug;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

//@SuppressWarnings("unused")

public class BabouliPlugPlayerListener extends PlayerListener {
	final BabouliPlug plugin;


	public BabouliPlugPlayerListener(BabouliPlug instance) {
		plugin = instance;
	}

	public void onPlayerMove (PlayerMoveEvent event) {
		plugin.player = event.getPlayer();
		plugin.world = plugin.player.getWorld();
		Location loc = event.getPlayer().getLocation();
		final Entity boss;
		plugin.woolBlock = plugin.world.getBlockAt(new Location(plugin.world, 11, 107, 413));

		/* Téléportations escaliers au Premier Etage */
		Location pos1a = new Location(plugin.world, -3, 72, 416);
		Location pos1b = new Location(plugin.world, 4, 72, 400);
		Location pos1c = new Location(plugin.world, 13, 72, 400);
		Location pos1d = new Location(plugin.world, 25, 72, 416);

		/* Téléportations escaliers au Deuxième Etage */
		Location pos2a = new Location(plugin.world, -2, 88, 415);
		Location pos2b = new Location(plugin.world, 5, 88, 401);
		Location pos2c = new Location(plugin.world, 14, 88, 402);
		Location pos2d = new Location(plugin.world, 26, 88, 415);
		Location pos2e = new Location(plugin.world, 15, 88, 424);

		/* Téléportations escaliers au Troisième Etage */
		Location pos3a = new Location(plugin.world, 16, 101, 423);
		Location pos3b = new Location(plugin.world, 11, 103, 415);

		/* Téléportations escaliers sur le toit */
		Location pos4a = new Location(plugin.world, 11, 108, 413);

		/* Téléportations joueurs qui tombent du Premier Etage */
		Location pos5a = new Location(plugin.world, 3, 72, 428);

		/* Téléportations joueurs qui tombent du Deuxième Etage */
		/* Téléportations sur les pistons */
		Location pos6a = new Location(plugin.world, -9, 75, 423);
		Location pos6b = new Location(plugin.world, -9, 75, 425);
		Location pos6c = new Location(plugin.world, -9, 75, 408);
		Location pos6d = new Location(plugin.world, -9, 75, 409);
		Location pos6e = new Location(plugin.world, -9, 75, 410);
		Location pos6f = new Location(plugin.world, -1, 75, 408);
		Location pos6g = new Location(plugin.world, -1, 75, 409);
		Location pos6h = new Location(plugin.world, -1, 75, 410);
		Location pos6i = new Location(plugin.world, -4, 75, 407);
		Location pos6j = new Location(plugin.world, -4, 75, 409);
		Location pos6k = new Location(plugin.world, -4, 75, 410);
		Location pos6l = new Location(plugin.world, -5, 75, 407);
		Location pos6m = new Location(plugin.world, -5, 75, 409);
		Location pos6n = new Location(plugin.world, -5, 75, 410);
		Location pos6o = new Location(plugin.world, 6, 75, 412);
		Location pos6p = new Location(plugin.world, 9, 75, 416);
		Location pos6q = new Location(plugin.world, 10, 75, 416);
		Location pos6r = new Location(plugin.world, 12, 75, 414);
		Location pos6s = new Location(plugin.world, 13, 75, 414);
		Location pos6t = new Location(plugin.world, 14, 75, 414);
		Location pos6u = new Location(plugin.world, 15, 75, 415);
		Location pos6v = new Location(plugin.world, -6, 75, 411);
		Location pos6w = new Location(plugin.world, -6, 75, 412);

		/* Téléportations sur le sol */
		Location pos7a = new Location(plugin.world, -2, 72, 423);
		Location pos7b = new Location(plugin.world, -2, 72, 425);
		Location pos7c = new Location(plugin.world, -5, 72, 422);
		Location pos7d = new Location(plugin.world, -5, 72, 426);
		Location pos7e = new Location(plugin.world, -3, 72, 411);
		Location pos7f = new Location(plugin.world, -3, 72, 412);
		Location pos7g = new Location(plugin.world, 2, 72, 409);
		Location pos7h = new Location(plugin.world, 2, 72, 410);
		Location pos7i = new Location(plugin.world, 3, 72, 423);
		Location pos7j = new Location(plugin.world, 4, 72, 423);
		Location pos7k = new Location(plugin.world, 5, 72, 423);
		Location pos7l = new Location(plugin.world, 6, 72, 423);
		Location pos7m = new Location(plugin.world, 12, 72, 411);
		Location pos7n = new Location(plugin.world, 13, 72, 411);
		Location pos7o = new Location(plugin.world, 14, 72, 411);
		Location pos7p = new Location(plugin.world, 15, 72, 411);
		Location pos7q = new Location(plugin.world, 15, 72, 410);
		Location pos7r = new Location(plugin.world, 15, 72, 409);

		/* Téléportations sur mur d'enceinte interieur */
		Location pos8a = new Location(plugin.world, 26, 77, 418);

		/* Endroit de pop des mobs */
		Location pop = new Location(plugin.world, -3, 80, 475);

		/* Boss final */
		Location bossA = new Location(plugin.world, 8, 114, 412);


		/* Récuperation et ajustement de la localisation du joueur */
		double x = loc.getBlockX() + 0.5;
		double y = loc.getBlockY();
		double z = loc.getBlockZ() + 0.5;

		if(y == 72) {						//Premier étage						
			if(x == -3.5 && z == 414.5) {			
				plugin.player.teleport(pos2a);				//pos2a
			} else if (x == 4.5 && z == 398.5) { 	
				plugin.player.teleport(pos2b);				//pos2b
			} else if (x == 13.5 && z == 398.5) { 
				plugin.player.teleport(pos2c);				//pos2c
			} else if (x == 24.5 && z == 414.5) { 	
				plugin.player.teleport(pos2d);				//pos2d
			} else if (x == 0.5) {
				if (z == 412.5 || z == 410.5 || z == 409.5 || z == 407.5) {
					plugin.player.teleport(pos5a);
				}
			} else if (x == 1.5) {
				if (z == 416.5 || z == 417.5) {
					plugin.player.teleport(pos5a);
				}
			} else if (x == 2.5) {
				if (z == 407.5 || z == 409.5 || z == 410.5 || z == 412.5) {
					plugin.player.teleport(pos5a);
				}
			} else if (x == 3.5) {
				if (z == 407.5 || z == 409.5 || z == 410.5 || z == 412.5) {
					plugin.player.teleport(pos5a);
				}
			} else if (x == 4.5) {
				if (z == 407.5 || z ==  409.5 || z ==  410.5 || z ==  412.5) {
					plugin.player.teleport(pos5a);
				}
			} else if (x == 5.5) {
				if (z == 407.5 || z == 409.5 || z == 410.5 || z == 412.5) {
					plugin.player.teleport(pos5a);
				}
			} else if (x == 7.5) {
				if (z == 407.5 || z == 409.5 || z == 410.5) {
					plugin.player.teleport(pos5a);
				}
			}
		} else if (y == 88) {				//Deuxième étage
			if(x == -2.5 && z == 413.5) {			
				plugin.player.teleport(pos1a);				//pos1a
			} else if (x == 5.5 && z == 399.5) {	
				plugin.player.teleport(pos1b);				//pos1b
			} else if (x == 12.5 && z == 400.5) {
				plugin.player.teleport(pos1c);				//pos1c
			} else if (x == 15.5 && z == 421.5) {
				plugin.player.teleport(pos3a);				//pos3a
			} else if (x == 27.5 && z == 415.5) {
				plugin.player.teleport(pos1d);				//pos1d
			} else if (x == -8.5) {  //Black Wool	X == -8
				if (z == 423.5) {
					plugin.player.teleport(pos6a);		//1
				} else if (z == 425.5) {
					plugin.player.teleport(pos6b);		//2
				} else if (z == 408.5) {
					plugin.player.teleport(pos6c);		//3
				} else if (z == 409.5) {
					plugin.player.teleport(pos6d);		//4
				} else if (z == 410.5) {
					plugin.player.teleport(pos6e);		//5
				}
			} else if (x == -1.5) {					//X == -1
				if (z == 408.5) {
					plugin.player.teleport(pos6f);		//6
				} else if (z == 409.5) {
					plugin.player.teleport(pos6g);		//7
				} else if (z == 410.5) {
					plugin.player.teleport(pos6h);		//8
				}
			} else if (x == -4.5) {					//X == -4
				if (z == 407.5) {
					plugin.player.teleport(pos6i);		//9
				} else if (z == 409.5) {
					plugin.player.teleport(pos6j);		//10
				} else if (z == 410.5) {
					plugin.player.teleport(pos6k);		//11
				}
			} else if (x == -5.5) {					//X == -5
				if (z == 407.5) {
					plugin.player.teleport(pos6l);		//12
				} else if (z == 409.5) {
					plugin.player.teleport(pos6m);		//13
				}else if (z == 422.5) {
					plugin.player.teleport(pos7c);		//26
				} else if (z == 427.5) {
					plugin.player.teleport(pos7d);		//27
				} else if (z == 410.5) {
					plugin.player.teleport(pos6n);		//14
				}
			} else if (x == 6.5) {					//X == 6
				if (z == 412.5) {
					plugin.player.teleport(pos6o);		//15
				} else if (z == 423.5) {
					plugin.player.teleport(pos7l);		//35
				}
			} else if (x == 9.5) {					//X == 9
				if (z == 416.5) {
					plugin.player.teleport(pos6p);		//16
				}
			} else if (x == 10.5) {					//X == 10
				if (z == 416.5) {
					plugin.player.teleport(pos6q);		//17
				}
			} else if (x == 12.5) {					//X == 12
				if (z == 414.5) {
					plugin.player.teleport(pos6r);		//18
				} else if (z == 411.5) {
					plugin.player.teleport(pos7m);		//36
				}
			} else if (x == 13.5) {					//X == 13
				if (z == 414.5) {
					plugin.player.teleport(pos6s);		//19
				} else if (z == 411.5) {
					plugin.player.teleport(pos7n);		//37
				}
			} else if (x == 14.5) {					//X == 14
				if (z == 414.5) {
					plugin.player.teleport(pos6t);		//20
				} else if (z == 411.5) {
					plugin.player.teleport(pos7o);		//38
				}
			} else if (x == -6.5) {					//X == -6
				if (z == 411.5) {
					plugin.player.teleport(pos6v);		//22
				} else if (z == 412.5) {
					plugin.player.teleport(pos6w);		//23
				}
			} else if (x == -2.5) {					//X == -2
				if (z == 423.5) {
					plugin.player.teleport(pos7a);		//24
				} else if (z == 425.5) {
					plugin.player.teleport(pos7b);		//25
				}			
			} else if (x == -3.5) {					//X == -3
				if (z == 411.5) {
					plugin.player.teleport(pos7e);		//28
				}else if (z == 412.5) {
					plugin.player.teleport(pos7f);		//29
				}
			} else if (x == 2.5) {					//X == 2
				if (z == 409.5) {
					plugin.player.teleport(pos7g);		//30
				} else if (z == 410.5) {
					plugin.player.teleport(pos7h);		//31
				}
			} else if (x == 3.5) {					//X == 3
				if (z == 423.5) {
					plugin.player.teleport(pos7i);		//32
				}
			} else if (x == 4.5) {					//X == 4
				if (z == 423.5) {
					plugin.player.teleport(pos7j);		//33
				}
			} else if (x == 5.5) {					//X == 5
				if (z == 423.5) {
					plugin.player.teleport(pos7k);		//34
				}
			} else if (x == 15.5) {					//X == 15
				if (z == 411.5) {
					plugin.player.teleport(pos7p);		//39
				} else if (z == 410.5) {
					plugin.player.teleport(pos7q);		//40
				} else if (z == 409.5) {
					plugin.player.teleport(pos7r);		//41
				} else if (z == 415.5) {
					plugin.player.teleport(pos6u);		//21
				}
			} else if (x == 26.5) {					//X == 26
				if(z == 418.5) {
					plugin.player.teleport(pos8a);		//42
				}
			}
		} else if (y == 101) {				//Troisième étage
			if (x == 16.5 && z == 421.5) {
				plugin.player.teleport(pos2e);
			}
		} else if (y == 103) {				//Troisième étage pour aller sur le Toit
			if (x == 11.5 && z == 413.5) {
				plugin.woolBlock.setType(Material.WOOD);
				plugin.tpState = false;
				plugin.player.teleport(pos4a);
				boss = plugin.world.spawnCreature(pop, CreatureType.GHAST);
				plugin.bossId = boss.getEntityId();
				System.out.println("entityId du boss: " + plugin.bossId);
				boss.teleport(bossA);
				plugin.player.sendMessage(ChatColor.RED + "BOSS: MOUAAHHAHAHAHAHAHAHAH !");
				plugin.player.playEffect(pos4a, Effect.DOOR_TOGGLE, 1);
				Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, 
						new Runnable() {
					public void run() {
						bossTeleportations(boss, plugin.world);
					}
				}, 0, 30);
			}
		} else if (y == 108) {
			if(x == 11.5 && z == 413.5) {
				if(plugin.tpState == true) {
					plugin.player.teleport(pos3b);
					plugin.woolBlock.setType(Material.WOOD);
				} else {
					plugin.player.sendMessage("Nope, la téléportation marchera pas ! tpState: false");
				}
				plugin.player.sendMessage("Tu marches sur la wool, mais c'est tout !");
			}
		}
	}

	public void bossTeleportations(Entity boss, World world) {

		/* Téléportations autour du joueur */
		Location bossTpAngleA = new Location(world, 42, 124, 430);
		Location bossTpAngleB = new Location(world, -10, 120, 399);
		Location bossTpAngleC = new Location(world, 30, 115, 397);
		Location bossTpAngleD = new Location(world, -10, 110, 428);
		Location bossTpA = new Location(world, -3, 119, 423);
		Location bossTpB = new Location(world, 18, 124, 400);
		Location bossTpC = new Location(world, 9, 124, 427);

		/* Divers */
		Random rUn = new Random();
		Random rDeux = new Random();
		Random rTrois = new Random();
		int valChoix, valAutres, valAngles;
		valChoix = 1 + rUn.nextInt(2 - 1);			  //choix sol ou ciel
		valAngles = 1 + rDeux.nextInt(4 - 1);	 	  //choix quel coin
		valAutres = 1 + rTrois.nextInt(3 - 1);  	  //choix quel coin ciel

		if(valChoix == 1) {
			switch(valAngles) {
			case 1:
				boss.teleport(bossTpAngleA);
				break;
			case 2:
				boss.teleport(bossTpAngleB);
				break;
			case 3:
				boss.teleport(bossTpAngleC);
				break;
			case 4:
				boss.teleport(bossTpAngleD);
			}
		} else if (valChoix == 2) {
			switch(valAutres) {
			case 1:
				boss.teleport(bossTpA);
				break;
			case 2:
				boss.teleport(bossTpB);
				break;
			case 3:
				boss.teleport(bossTpC);
			}
		}
	} 
}
