package plugin.stefthedev.classicpvp.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.items.ItemManager;
import plugin.stefthedev.classicpvp.managers.items.LocationManager;
import plugin.stefthedev.classicpvp.managers.items.SettingsManager;
import plugin.stefthedev.classicpvp.utilities.Chat;
import plugin.stefthedev.classicpvp.utilities.Message;

public class PlayerListener implements Listener{

    private Main plugin;
    private SettingsManager settingsManager;
    private LocationManager locationManager;
    private ItemManager itemManager;

    public PlayerListener(Main plugin) {
        this.plugin = plugin;
        this.settingsManager = plugin.getSettingsManager();
        this.locationManager = plugin.getLocationManager();
        this.itemManager = plugin.getItemManager();
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if(locationManager.getLocation() == null)  {
            player.sendMessage(Message.PREFIX.getMessage() + Message.SPAWN_FALSE.getMessage());
            return;
        }
        plugin.runAsync(() -> {
            player.getInventory().setItem(itemManager.getLeave().getSlot(), itemManager.getLeave().build());
            player.getInventory().setItem(itemManager.getKits().getSlot(), itemManager.getKits().build());
            player.teleport(locationManager.getLocation());
        });
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(settingsManager.getElement("clear-join-inventory").isEnabled()) {
            player.getInventory().clear();
        }
        player.getInventory().setItem(itemManager.getLeave().getSlot(), itemManager.getLeave().build());
        player.getInventory().setItem(itemManager.getKits().getSlot(), itemManager.getKits().build());
        if(locationManager.getLocation() == null) {
            player.sendMessage(Message.PREFIX.getMessage() + Message.LOBBY_FALSE.getMessage());
        } else {
            player.teleport(locationManager.getLocation());
        }
    }

    @EventHandler
    public void onJoinItem(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getItem() == null || event.getItem().getItemMeta() == null) {
            return;
        }
        if(player.getItemInHand().isSimilar(itemManager.getSoup().build())) {
            event.setCancelled(true);
            if (player.getHealth() < 16.0D) {
                player.setHealth(player.getHealth() + 4.0D);
                player.getInventory().setItemInHand(null);
            }
        }
        if(event.getItem().isSimilar(itemManager.getKits().build())) {
            event.setCancelled(true);
            plugin.getKitMenu().open(player);
            return;
        }
        if(event.getItem().isSimilar(itemManager.getLeave().build())) {
            event.setCancelled(true);
            player.kickPlayer(Chat.color(Message.PREFIX.getMessage() + Message.KICK_PLAYER.getDefault()));
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if(!settingsManager.getElement("item-drop").isEnabled()) {
            event.getDrops().clear();
        }
        Player killer = event.getEntity().getKiller();
        if(killer != null) {
            event.setDeathMessage(null);
            killer.sendMessage(Message.PREFIX.getMessage() + Message.KILL_PLAYER.getMessage()
                    .replace("{player}", player.getName())
            );
            player.sendMessage(Message.PREFIX.getMessage() + Message.DEATH_PLAYER.getMessage()
                    .replace("{player}", killer.getName())
            );
        }
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if(player.getItemInHand().isSimilar(itemManager.getSoup().build())) {
            event.setCancelled(true);
        }
        if(event.getItem().getItemStack().isSimilar(itemManager.getKits().build())) {
            event.setCancelled(true);
        }
        if(event.getItem().getItemStack().isSimilar(itemManager.getLeave().build())) {
            event.setCancelled(true);
        }
        if(!settingsManager.getElement("item-pickup").isEnabled()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if(player.getItemInHand().isSimilar(itemManager.getSoup().build())) {
            event.setCancelled(true);
        }
        if(event.getItemDrop().getItemStack().isSimilar(itemManager.getKits().build())) {
            event.setCancelled(true);
        }
        if(event.getItemDrop().getItemStack().isSimilar(itemManager.getLeave().build())) {
            event.setCancelled(true);
        }
        if(!settingsManager.getElement("item-drop").isEnabled()) {
            event.setCancelled(true);
        }
    }

    private FileConfiguration config() {
        return plugin.getConfig();
    }
}
