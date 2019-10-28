package me.kevin.commands;

import me.kevin.manager.data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {

        Player p = (Player)cs;

        if(cmd.getName().equalsIgnoreCase("build")) {
            if(p.hasPermission("kbffa.build")) {

                if(data.build.contains(p)) {
                    data.build.remove(p);
                    p.sendMessage(data.getPrefix() + "§7Du bist nun nicht mehr im §bBau-Modus");
                } else {
                    data.build.add(p);
                    p.sendMessage(data.getPrefix() + "§7Du bist nun im §bBau-Modus");
                }

            } else {
                p.sendMessage(data.getNoperms());
            }
        }

        return false;
    }
}
