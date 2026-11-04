package com.enderdevelopment.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType;

public class SonicAbilities implements Listener {

    private final Main plugin;

    public SonicAbilities(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (plugin.getSonicPlayers().contains(player.getUniqueId())) {
            if (player.isSprinting()) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 2));
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (plugin.getSonicPlayers().contains(player.getUniqueId())) {
            if (event.getAction().toString().contains("RIGHT")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20, 2));
            }
        }
    }
}