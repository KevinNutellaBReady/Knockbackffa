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
import org.bukkit.event.player.PlayerJoinEvent;

public class Joinlistener implements Listener {
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(Kbffa.file);
    double x = cfg.getDouble(".SpawnX");
    double y = cfg.getDouble(".SpawnY");
    double z = cfg.getDouble(".SpawnZ");

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player p = event.getPlayer();

        World world = p.getWorld();
        Location loc = new Location(world, x, y, z);
        p.teleport(loc);

        // event.setJoinMessage("§7[§a+] §7" + p.getDisplayName());

        event.setJoinMessage(null);

        p.getInventory().clear();
        p.getInventory().setItem(0, new ItemManager("§6Knockback-Stick", Material.STICK, (byte) 0, 1, Enchantment.KNOCKBACK).build());
        p.getInventory().setItem(1, new ItemManager("§bAngel", Material.FISHING_ROD, (byte) 0, 1, Enchantment.DURABILITY).build());
        p.getInventory().setItem(8, new ItemManager("§cSpiel Verlassen", Material.SLIME_BALL, (byte) 0, 1, Enchantment.DURABILITY).build());

    }

}
