package me.kevin.main;

import me.kevin.commands.BuildCommand;
import me.kevin.commands.Kbffa;
import me.kevin.listener.Buildlistener;
import me.kevin.listener.Deathlistener;
import me.kevin.listener.Joinlistener;
import me.kevin.listener.Protectlistener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class KnockbackFFA extends JavaPlugin implements Listener {
    public static File file = new File("plugins//Knockbackffa//locations.yml");

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aKBFFA wurde \n §agestartet gecodet von: §b" + getDescription().getAuthors() + "\n §aVersion§7: §b" + getDescription().getVersion());
        registerCommand();
        registerListener();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§4KBFFA wurde gestoppt");
    }

    public void registerCommand() {

        getCommand("kbffa").setExecutor(new Kbffa());
        getCommand("build").setExecutor(new BuildCommand());
    }

    public void registerListener() {

        this.getServer().getPluginManager().registerEvents( this, this);
        Bukkit.getPluginManager().registerEvents(this, this);

        Bukkit.getPluginManager().registerEvents(new Joinlistener(), this);
        Bukkit.getPluginManager().registerEvents(new Deathlistener(), this);
        Bukkit.getPluginManager().registerEvents(new Buildlistener(), this);
        Bukkit.getPluginManager().registerEvents(new Protectlistener(), this);

    }
}
