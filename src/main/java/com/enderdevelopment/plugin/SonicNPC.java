package com.enderdevelopment.plugin;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SonicNPC implements Listener {

    private final Main plugin;

    public SonicNPC(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!plugin.getSonicPlayers().contains(player.getUniqueId())) {
            spawnSonicNPC(player.getLocation());
        }
    }

    private void spawnSonicNPC(Location location) {
        Villager sonicNPC = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        sonicNPC.setCustomName("Sonic NPC");
        sonicNPC.setCustomNameVisible(true);
        sonicNPC.setAI(false);
        sonicNPC.setInvulnerable(true);
    }
}