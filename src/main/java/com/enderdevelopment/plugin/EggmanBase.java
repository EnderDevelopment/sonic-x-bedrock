package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EggmanBase implements Listener {
    private final JavaPlugin plugin;
    private final NamespacedKey eggmanBaseKey;

    public EggmanBase(JavaPlugin plugin) {
        this.plugin = plugin;
        this.eggmanBaseKey = new NamespacedKey(plugin, "eggman_base");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getName().equals("EggmanBase")) {
            player.getPersistentDataContainer().set(eggmanBaseKey, org.bukkit.persistence.PersistentDataType.BYTE, (byte) 1);
            player.sendMessage("You have found Eggman's base!");
        }
    }
}