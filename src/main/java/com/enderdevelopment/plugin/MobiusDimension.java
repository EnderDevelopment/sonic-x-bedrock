package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class MobiusDimension implements Listener {
    private final JavaPlugin plugin;
    private final NamespacedKey reviveTotemKey;
    private final NamespacedKey eggmanBaseKey;

    public MobiusDimension(JavaPlugin plugin) {
        this.plugin = plugin;
        this.reviveTotemKey = new NamespacedKey(plugin, "revive_totem");
        this.eggmanBaseKey = new NamespacedKey(plugin, "eggman_base");

        // Register the revive totem recipe
        registerReviveTotemRecipe();
    }

    private void registerReviveTotemRecipe() {
        ItemStack reviveTotem = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = reviveTotem.getItemMeta();
        meta.setDisplayName("Revive Totem");
        reviveTotem.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(reviveTotemKey, reviveTotem);
        recipe.shape("O  ", "O D", "D  ");
        recipe.setIngredient('O', Material.OAK_LOG);
        recipe.setIngredient('D', Material.DIRT);
        Bukkit.addRecipe(recipe);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block != null && block.getType() == Material.OAK_LOG) {
                Player player = event.getPlayer();
                Block[] surroundingBlocks = {
                    block.getRelative(1, 0, 0),
                    block.getRelative(-1, 0, 0),
                    block.getRelative(0, 0, 1),
                    block.getRelative(0, 0, -1)
                };
                boolean hasFourOakLogs = true;
                for (Block surroundingBlock : surroundingBlocks) {
                    if (surroundingBlock.getType() != Material.OAK_LOG) {
                        hasFourOakLogs = false;
                        break;
                    }
                }
                if (hasFourOakLogs) {
                    player.sendMessage("You have activated the Mobius dimension!");
                    // Logic to teleport player to Mobius dimension
                }
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getName().equals("Mobius")) {
            // Logic to handle player movement in Mobius dimension
        }
    }

    @EventHandler
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.getInventory().contains(Material.TOTEM_OF_UNDYING)) {
            player.sendMessage("You have been revived as a Sonic character!");
            // Logic to transform player into Sonic character
        } else if (player.getPersistentDataContainer().has(eggmanBaseKey, org.bukkit.persistence.PersistentDataType.BYTE)) {
            player.sendMessage("You have been transformed into Metal Sonic!");
            // Logic to transform player into Metal Sonic
        }
    }
}