package plugin.stefthedev.classicpvp.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import plugin.stefthedev.classicpvp.Main;
import plugin.stefthedev.classicpvp.managers.items.SettingsManager;

public class BlockListener implements Listener {

    private SettingsManager settingsManager;

    public BlockListener(Main plugin) {
        this.settingsManager = plugin.getSettingsManager();
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(!(settingsManager.getElement("block-break").isEnabled())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if(!(settingsManager.getElement("block-place").isEnabled())) {
            event.setCancelled(true);
        }
    }
}
