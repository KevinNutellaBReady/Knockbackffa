package me.kevin.listener;

import me.kevin.commands.Kbffa;
import me.kevin.manager.ItemManager;
import me.kevin.manager.data;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Deathlistener implements Listener {

    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(Kbffa.file);
    double x = cfg.getDouble(".SpawnX");
    double y = cfg.getDouble(".SpawnY");
    double z = cfg.getDouble(".SpawnZ");

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player p = (Player) event.getEntity();

        event.setDeathMessage(null);

        if(p.getKiller() != null) {
            p.getServer().broadcastMessage(data.getPrefix() + "§7Der Spieler §b" + p.getName() + " §7wurde von + §b" + p.getKiller());
        } else if(p.getKiller() == null) {
            p.getServer().broadcastMessage(data.getPrefix() + "§7Der Spieler §b" + p.getName() + " §7ist gestorben");
        }

        p.setHealth(20);
        p.setMaxHealth(20);
        p.setFoodLevel(20);

        p.getInventory().clear();
        p.getInventory().setItem(0, new ItemManager("§6Knockback-Stick", Material.STICK, (byte) 0, 1, Enchantment.KNOCKBACK).build());
        p.getInventory().setItem(1, new ItemManager("§bAngel", Material.FISHING_ROD, (byte) 0, 1, Enchantment.DURABILITY).build());
        p.getInventory().setItem(8, new ItemManager("§cSpiel Verlassen", Material.SLIME_BALL, (byte) 0, 1, Enchantment.DURABILITY).build());

        World world = p.getWorld();
        Location loc = new Location(world, x, y, z);
        p.teleport(loc);


    }

}
