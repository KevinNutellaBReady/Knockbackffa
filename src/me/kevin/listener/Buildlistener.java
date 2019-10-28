package me.kevin.listener;

import me.kevin.manager.data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Buildlistener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();

        if(data.build.contains(p)) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player p = event.getPlayer();

        if(data.build.contains(p)) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event) {
        Player p = event.getPlayer();

        if(data.build.contains(p)) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player p = event.getPlayer();

        if(data.build.contains(p)) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }
}
