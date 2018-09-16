package plugin.stefthedev.classicpvp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.items.SettingsManager;

public class EntityListener implements Listener {

    private SettingsManager settingsManager;

    public EntityListener(Main plugin) {
        this.settingsManager = plugin.getSettingsManager();
    }

    @EventHandler
    public void onFall(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            if(event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if(!(settingsManager.getElement("fall").isEnabled())) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onHunger(EntityRegainHealthEvent event) {
        if(event.getEntity() instanceof  Player) {
            if(settingsManager.getElement("hunger").isEnabled()) {
                return;
            }
            Player player = (Player) event.getEntity();
            player.setFoodLevel(20);
        }
    }
}
