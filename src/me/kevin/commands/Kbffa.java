package me.kevin.commands;

import me.kevin.manager.data;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Kbffa implements CommandExecutor {
    public static File file = new File("plugins/KBFFA/locations.yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {

        if (cmd.getName().equalsIgnoreCase("kbffa")) {
            Player p = (Player) cs;


            if (p.hasPermission("kbffa.setup")) {

            if (args.length == 0) {
                p.sendMessage(data.getPrefix() + "§7Bitte Benutze: §a/kbffa <setspawn, setdeathhigh, sethithigh>");
            } else {
                if (args[0].equalsIgnoreCase("setspawn")) {

                    cfg.set(".SpawnX", p.getLocation().getX());
                    cfg.set(".SpawnY", p.getLocation().getY());
                    cfg.set(".SpawnZ", p.getLocation().getZ());

                    p.sendMessage(data.getPrefix() + "§7Du hast den Spawn gesetzt");

                    try {
                        cfg.save(file);
                    } catch (Exception e) {
                        System.out.println("§4DER FEHLER: " + e);
                    }

                } else if (args[0].equalsIgnoreCase("setdeathhigh")) {
                    cfg.set(".DeathY", p.getLocation().getY());

                    try {
                        cfg.save(file);
                    } catch (Exception e) {
                        System.out.println("§4DER FEHLER: " + e);
                    }

                } else if (args[0].equalsIgnoreCase("sethithigh")) {

                    cfg.set(".HitY", p.getLocation().getY());

                    try {
                        cfg.save(file);
                    } catch (Exception e) {
                        System.out.println("§4DER FEHLER: " + e);
                    }

                } else if (args[0].equalsIgnoreCase("spawn")) {

                    World world = p.getWorld();
                    double x = cfg.getDouble(".SpawnX");
                    double y = cfg.getDouble(".SpawnY");
                    double z = cfg.getDouble(".SpawnZ");
                    Location loc = new Location(world, x, y, z);
                    p.teleport(loc);

                }
            }

                return false;
            }
        }
        return false;
    }
}




