package plugin.stefthedev.classicpvp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.items.ItemManager;
import plugin.stefthedev.classicpvp.managers.items.SettingsManager;
import plugin.stefthedev.classicpvp.utilities.Message;
import plugin.stefthedev.classicpvp.utilities.Kit;

public class InventoryListener implements Listener {

    private Main plugin;
    private SettingsManager settingsManager;
    private ItemManager itemManager;

    public InventoryListener(Main plugin) {
        this.plugin = plugin;
        this.settingsManager = plugin.getSettingsManager();
        this.itemManager = plugin.getItemManager();
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null) return;
        if(event.getInventory().getTitle().equalsIgnoreCase(plugin.getPreviewMenu().getName())) {
            event.setCancelled(true);
            player.closeInventory();
            plugin.getKitMenu().open(player);
            return;
        }
        if (event.getInventory().getTitle().equalsIgnoreCase(plugin.getKitMenu().getName())) {
            event.setCancelled(true);
            for(Kit kit : plugin.getKitManager().getList()) {
                if (kit.getIcon().getSlot() == event.getSlot()) {
                    if (event.isLeftClick()) {
                        player.sendMessage(Message.PREFIX.getMessage() + Message.KIT_PLAYER.getMessage()
                                .replace("{kit}", kit.getKey()));
                        player.getInventory().clear();
                        player.closeInventory();
                        kit.getItems().forEach(item -> player.getInventory().setItem(item.getSlot(), item.build()));
                        if(settingsManager.getElement("soup").isEnabled()) {
                            plugin.getItemManager().fillSoup(player);
                        }
                        if (plugin.getLocationManager().randomLocation() != null) {
                            player.teleport(plugin.getLocationManager().randomLocation());
                        }
                        break;
                    }
                    if (event.isRightClick()) {
                        player.closeInventory();
                        plugin.getPreviewMenu().open(player, kit.getKey());
                        break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        ItemStack itemStack = event.getCurrentItem();
        if(itemStack == null || itemStack.getItemMeta() == null) {
            return;
        }
        if(itemStack.isSimilar(itemManager.getKits().build())) {
            event.setCancelled(true);
            return;
        }
        if(itemStack.isSimilar(itemManager.getLeave().build())) {
            event.setCancelled(true);
        }
    }
}
