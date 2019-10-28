package me.kevin.manager;

import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;

public class data {

    public static ArrayList<Player> build = new ArrayList<Player>();

    public static String prefix = "§7[§6KBFFA§7] ";
    public static String noperms = prefix + "§4Dazu hast du keine Rechte";

    public static String getPrefix() {
        return prefix;
    }

    public static String getNoperms() {
        return noperms;
    }
}
