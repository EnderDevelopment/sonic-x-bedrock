package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Main extends JavaPlugin {
    private final Set<UUID> sonicPlayers = new HashSet<>();

    public Set<UUID> getSonicPlayers() {
        return sonicPlayers;
    }
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MobiusDimension(this), this);
        getServer().getPluginManager().registerEvents(new EggmanBase(this), this);
        getServer().getPluginManager().registerEvents(new SonicAbilities(this), this);
        getServer().getPluginManager().registerEvents(new SonicNPC(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}